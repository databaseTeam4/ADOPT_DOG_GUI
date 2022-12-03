import java.sql.*;
import java.util.ArrayList;

import DTO.*;
import oracle.jdbc.internal.OracleTypes;

class DB_Conn_Query {

	Connection con = null;
	Statement st1, st2, st3, st4, st5, st6,st7, st8, st9 = null;
	ResultSet rs1, rs2, rs3, rs4, rs5, rs6,rs7, rs8, rs9, rs10 = null;
	PreparedStatement pst = null;
	CallableStatement cst = null;

	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "DOG";
	String password = "1234";

	public void DB_Conn_Query_driver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver.");
		}
	}

	public void Oracle_Connect() {
		try {
			con = DriverManager.getConnection(url, id, password);
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			System.out.println("Connection Fail");
		}
	}

	public ArrayList<abandoned_dog> read_abandoned_dog() {
		ArrayList<abandoned_dog> arr1 = new ArrayList<abandoned_dog>();
		try {
			Oracle_Connect();
			String sql1 = "select * from 유기견";
			st1 = con.createStatement();
			rs1 = st1.executeQuery(sql1);

			while (rs1.next()) {
				arr1.add(new abandoned_dog(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
						rs1.getString(10)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st1.close();
				rs1.close();
				con.close();
				System.out.println("DB 연결 해제");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr1;
	}

	public ArrayList<abandoned_dog> read_abandoned_dog1(int key) {
		ArrayList<abandoned_dog> arr2 = new ArrayList<abandoned_dog>();
		try {
			Oracle_Connect();
			String sql2 = "select * from 유기견 where 유기견번호 = " + key;
			st2 = con.createStatement();
			rs2 = st2.executeQuery(sql2);
			while (rs2.next()) {
				arr2.add(new abandoned_dog(rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getString(4),
						rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8), rs2.getString(9),
						rs2.getString(10)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st2.close();
				rs2.close();
				con.close();
				System.out.println("DB 연결 해제");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr2;
	}

	public ArrayList<missing> missing_record_sqlrun() {
		ArrayList<missing> arr3 = new ArrayList<missing>();
		try {
			Oracle_Connect();
			String sql3 = "select * from 신고기록";
			st3 = con.createStatement();
			rs3 = st3.executeQuery(sql3);

			while (rs3.next()) {
				arr3.add(new missing(rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getDate(8),
						rs3.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st3.close();
				rs3.close();
				con.close();
				System.out.println("DB 연결 해제");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr3;
	}

	public ArrayList<missing> missing_record_sqlrun1(String key) {
		ArrayList<missing> arr4 = new ArrayList<missing>();
		try {
			Oracle_Connect();
			String sql4 = "select * from 신고기록 where 동물등록번호 = " + "'" + key + "'";
			st4 = con.createStatement();
			rs4 = st4.executeQuery(sql4);
			while (rs4.next()) {
				arr4.add(new missing(rs4.getString(1), rs4.getString(2), rs4.getString(3), rs4.getString(4),
						rs4.getString(5), rs4.getString(6), rs4.getString(7), rs4.getDate(8), rs4.getString(9)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st4.close();
				rs4.close();
				con.close();
				System.out.println("DB 연결 해제");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr4;
	}

	public ArrayList<adopt> adopt_record_sqlrun() {
		ArrayList<adopt> arr5 = new ArrayList<adopt>();
		try {
			Oracle_Connect();
			String sql5 = "select * from 입양신청";
			st5 = con.createStatement();
			rs5 = st5.executeQuery(sql5);

			while (rs5.next()) {
				arr5.add(new adopt(rs5.getString(1), rs5.getDate(2), rs5.getString(3), rs5.getString(4),
						rs5.getString(5), rs5.getString(6), rs5.getString(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st5.close();
				rs5.close();
				con.close();
				System.out.println("DB 연결 해제");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr5;
	}
	
	 //특정 지역 유기견 목록 출력 저장 프로시저 호출
	 public ArrayList<abandoned_dog> p_local_abandoned_dog(String region) { //In parameter + cursor 반환 
		 ArrayList<abandoned_dog> arr = new ArrayList<abandoned_dog>();	
		 	try { 
	    		Oracle_Connect();
	    		cst = con.prepareCall("{call P_특정지역유기견목록(?, ?)}");
	    		
	    		cst.setString(1,region); //In parameter (지역) 
	    		cst.registerOutParameter(2,  OracleTypes.CURSOR); //cursor 반환 
	    		cst.executeQuery();
	    		
	    		//테이블 받는 커서 
	    		ResultSet rs = (ResultSet)cst.getObject(2);
	    		
	    		//해당 지역 유기견 목록 출력 
	    		while(rs.next()) {
	    			arr.add(new abandoned_dog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
		                		rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10))); 
	    		}
	    		cst.close(); 
	    		con.close(); 
	    		rs.close();
	    	}catch (SQLException e) {
	    		e.printStackTrace();
	    	}
		 	return arr;
	   }
	 

	public ArrayList<protection_agency> protection_agency_sqlrun() {
		ArrayList<protection_agency> arr6 = new ArrayList<protection_agency>();
		try {
			Oracle_Connect();
			String sql6 = "select * from 보호소";
			st6 = con.createStatement();
			rs6 = st6.executeQuery(sql6);

			while (rs6.next()) {
				arr6.add(new protection_agency(rs6.getString(1), rs6.getString(2), rs6.getString(3), rs6.getString(4),
						rs6.getInt(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st6.close();
				rs6.close();
				con.close();
				System.out.println("DB 연결 해제");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr6;
	}

	public ArrayList<member> member_sqlrun() {
		ArrayList<member> arr7 = new ArrayList<member>();
		try {
			Oracle_Connect();
			String sql7 = "select * from 회원";
			st7 = con.createStatement();
			rs7 = st7.executeQuery(sql7);

			while (rs7.next()) {
				arr7.add(new member(rs7.getString(1), rs7.getString(2), rs7.getInt(3),
						rs7.getString(4),rs7.getString(5)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st7.close();
				rs7.close();
				con.close();
				System.out.println("DB 연결 해제");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr7;
	}
	
	// 새 유기견 정보 등록
	public void insert_abandoned_dog(String name, String kind, String gender, String age, String weight, String rescure_date, String discover_place, String protect_num, String protection_agegncy) {
		try {
			int dog_num = 0;
			Oracle_Connect();
			String sql1 = "select 유기견번호 from 유기견 where 유기견번호 = (select MAX(유기견번호) from 유기견)"; //유기견 번호 증가
			pst = con.prepareStatement(sql1);
			rs8 = pst.executeQuery();
			while(rs8.next()) {
				dog_num = rs8.getInt(1)+1;
			}
			String sql2 = "insert into 유기견 values(?,?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql2);
            pst.setInt(1, dog_num);
            pst.setString(2, name);
            pst.setString(3, kind);
            pst.setString(4, gender);
            pst.setString(5, age);
            pst.setString(6, weight);
            pst.setString(7, rescure_date);
            pst.setString(8, discover_place);
            pst.setString(9, protect_num);
            pst.setString(10, protection_agegncy);
            pst.executeUpdate();
		}catch (SQLException e) {
			 e.printStackTrace();
		}finally {
            try {
            	rs8.close();
                pst.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
	
	//입양 신청 프로시저
	public void p_adoption(String agency_num, String member_id , int dog_num) { //보호기관번호, 입양자아이디, 입양희망유기견번호
		try {
			Oracle_Connect();
			
			con.setAutoCommit(false);
			
			cst = con.prepareCall("{call P_입양신청(?,?,?)}");
			cst.setString(1, agency_num);
			cst.setString(2, member_id);
			cst.setInt(3, dog_num);
			cst.executeQuery();
			
			con.commit();
			con.setAutoCommit(true);
			cst.close();
			con.close();
		}catch(Throwable e) {
			if (con != null) {
				try {
					con.rollback();
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}
	
	//입양 신청 목록 출력
		 //1. 해당 말일 구하는 함수
		 public Date lastday(String date) {
			 	Oracle_Connect();
		    	Date date1 = null;
		    	try {
		    		st8 = con.createStatement();
		    		rs9 = st8.executeQuery("Select last_day('"+date+"') from dual"); //해당 월 막날 sql문 
		            while(rs9.next()){
		            	date1 = rs9.getDate(1);
		            }
		    	}catch (SQLException e) {
					e.printStackTrace();
		    	}finally {
		            try {
		            	st8.close();
		                con.close();               
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		    	}
				return date1;
		  }
		 
		 //2. 입양 목록 출력(특정 월 - 조건 추가) 
		 public ArrayList<adopt> read_adopt(String year ,String month) {
				ArrayList<adopt> arr = new ArrayList<adopt>();
				st9 = null;

				String date = year + "/" + month +"/01";  //2020/10/01 - 해당 년도, 달의 첫 날
		        Date sql2 = lastday(date);  //해당 년도, 달의 막 날 
		    
				try {
					Oracle_Connect();
			        //해당 한 달 내 입양신청 목록 sql문->Select * from 입양신청 where 입양신청일자 between TO_DATE('2022/11/01','YYYY/MM/DD') And TO_DATE('2022/11/30','YYYY/MM/DD');
		        	String sql1 = "Select * from 입양신청 where 입양신청일자 between TO_DATE('"+date+"','YYYY/MM/DD') And TO_DATE('"+sql2+"','YYYY-MM-DD')";
		        	st9 = con.createStatement();
		        	rs10 = st9.executeQuery(sql1);
		            while (rs10.next()) {	           	
		                arr.add(new adopt(rs10.getString(1), rs10.getDate(2), rs10.getString(3), rs10.getString(4), rs10.getString(5),
		                		rs10.getString(6), rs10.getString(7))); 
		            }	
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
		            try {
		            	st9.close();
		                con.close();
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
				return arr;
		 }
	
}