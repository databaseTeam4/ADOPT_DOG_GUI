import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.abandoned_dog;
import DTO.adopt;
import DTO.missing;
import DTO.protection_agency;

class DB_Conn_Query {

	Connection con = null;
	Statement st1, st2, st3, st4,st5,st6 = null;
	ResultSet rs1, rs2, rs3, rs4,rs5,rs6 = null;
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
				arr1.add(new abandoned_dog(rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(10)));
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
			String sql2 = "select * from 유기견 where 유기견번호 = "+key;
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
				arr3.add(new missing(rs3.getString(1), rs3.getString(2), rs3.getString(3),rs3.getDate(8),rs3.getString(9)));
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
			String sql4 = "select * from 신고기록 where 동물등록번호 = "+"'"+ key+"'";
			st4 = con.createStatement();
			rs4 = st4.executeQuery(sql4);
			while (rs4.next()) {
				arr4.add(new missing(rs4.getString(1), rs4.getString(2), rs4.getString(3), rs4.getString(4),
						rs4.getString(5), rs4.getString(6), rs4.getString(7), rs4.getDate(8), rs4.getString(9)
						));
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
				arr5.add(new adopt(rs5.getString(1), rs5.getDate(2), rs5.getString(3),
						rs5.getString(4), rs5.getString(5), rs5.getString(6), rs5.getString(7)));
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
	
	public ArrayList<protection_agency> protection_agency_sqlrun() {
		ArrayList<protection_agency> arr6 = new ArrayList<protection_agency>();
		try {
			Oracle_Connect();
			String sql6 = "select * from 보호소";
			st6 = con.createStatement();
			rs6 = st6.executeQuery(sql6);

			while (rs6.next()) {
				arr6.add(new protection_agency(rs6.getString(1), rs6.getString(2), rs6.getString(3),
						rs6.getString(4), rs6.getInt(5)));
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
		return arr6;
	}
	
}