import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import DTO.abandoned_dog;
import DTO.missing;

class DB_Conn_Query {

	Connection con = null;
	Statement st1, st2, st3, st4,st5,st6 = null;
	ResultSet rs1, rs2, rs3, rs4,rs5,rs6 = null;
	PreparedStatement pst = null;
	CallableStatement cst = null;

	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String id = "DOG";
	String password = "1234";

	public DB_Conn_Query() {
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
				arr1.add(new abandoned_dog(rs1.getInt(1), rs1.getString(2), rs1.getString(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st1.close();
				rs1.close();
				con.close();
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr2;
	}
	
	public void missing_record_sqlrun(DefaultTableModel model, int choice, int missing_record_key) // 유기견 패널
	{
		if (choice == 0) { // 메인 패널
			String query3 = "select * from 신고기록"; // 탭에 신고기록 간추린 데이터 목록
			try {
				Statement stmt3 = con.createStatement();
				ResultSet rs3 = stmt3.executeQuery(query3);
				String row3[] = new String[5];
				while (rs3.next()) {
					row3[0] = rs3.getString(1);
					row3[1] = rs3.getString(2);
					row3[2] = rs3.getString(3);
					row3[3] = rs3.getDate(8).toString();
					row3[4] = rs3.getString(9);
					model.addRow(row3);
				}
				stmt3.close();
				rs3.close();
				con.close();
				System.out.println("DB 연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			String query4 = "select * from 신고기록 where 동물등록번호 = " + missing_record_key;
			try {
				Statement stmt4 = con.createStatement();
				ResultSet rs4 = stmt4.executeQuery(query4);
				String row4[] = new String[9];
				while (rs4.next()) {
					row4[0] = rs4.getString(1);
					row4[1] = rs4.getString(2);
					row4[2] = rs4.getString(3);
					row4[3] = rs4.getString(4);
					row4[4] = rs4.getString(5);
					row4[5] = rs4.getString(6);
					row4[6] = rs4.getString(7);
					row4[7] = rs4.getDate(8).toString();
					row4[8] = rs4.getString(9);
					model.addRow(row4);
				}
				stmt4.close();
				rs4.close();
				con.close();
				System.out.println("DB 연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr3;
	}

	public ArrayList<missing> missing_record_sqlrun(String key) {
		ArrayList<missing> arr4 = new ArrayList<missing>();
		try {
			Oracle_Connect();
			String sql4 = "select * from 유기견 where 유기견번호 = "+ key;
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arr4;
	}

	public void adopt_request_sqlrun(DefaultTableModel model, int choice, String adopt_request_key) // 입양신청 패널
	{
		if (choice == 0) { // 메인 패널
			String query5 = "select * from 입양신청"; // 탭에 입양신청 간추린 데이터 목록
			try {
				Statement stmt5 = con.createStatement();
				ResultSet rs5 = stmt5.executeQuery(query5);
				String row5[] = new String[4];
				while (rs5.next()) {
					row5[0] = rs5.getString(1);
					row5[1] = rs5.getDate(2).toString();
					row5[2] = rs5.getString(3);
					row5[3] = rs5.getString(7);
					model.addRow(row5);
				}
				stmt5.close();
				rs5.close();
				con.close();
				System.out.println("DB 연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		else {
			String query6 = "select * from 입양신청 where 입양신청번호 = " + adopt_request_key;
			try {
				Statement stmt6 = con.createStatement();
				ResultSet rs6 = stmt6.executeQuery(query6);
				String row6[] = new String[7];
				while (rs6.next()) {
					row6[0] = rs6.getString(1);
					row6[1] = rs6.getDate(8).toString();
					row6[2] = rs6.getString(3);
					row6[3] = rs6.getString(4);
					row6[4] = rs6.getString(5);
					row6[5] = rs6.getString(6);
					row6[6] = rs6.getString(7);
					model.addRow(row6);
				}
				stmt6.close();
				rs6.close();
				con.close();
				System.out.println("DB 연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}