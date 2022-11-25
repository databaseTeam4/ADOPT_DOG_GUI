import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

class DB_Conn_Query {
	Connection con = null;

	public DB_Conn_Query() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "dog";
		String password = "1234";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver.");
		} catch (SQLException e) {
			System.out.println("Connection Fail");
		}
	}

	public void abandoned_dog_sqlrun(DefaultTableModel model, int choice, int abandoned_dog_key) // 유기견 패널
	{
		if (choice == 0) {										// 메인 패널
			String query1 = "select * from 유기견";				// 탭에 유기견 간추린 데이터 목록
			try {
				Statement stmt1 = con.createStatement();
				ResultSet rs1 = stmt1.executeQuery(query1);
				String row1[] = new String[3];
				while (rs1.next()) {
					row1[0] = rs1.getString(1);
					row1[1] = rs1.getString(2);
					row1[2] = rs1.getString(3);
					model.addRow(row1);
				}
				stmt1.close();
				rs1.close();
				con.close();
				System.out.println("DB 연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		else { // 서브 프레임에 사용할 sql
			String query2 = "select * from 유기견 where 유기견번호 =" + abandoned_dog_key; // JTable에서 선택한 데이터의 기본키를
			try { // 읽어와서 where절에 넣음
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(query2);
				String row2[] = new String[10];
				while (rs2.next()) {
					row2[0] = rs2.getString(1);
					row2[1] = rs2.getString(2);
					row2[2] = rs2.getString(3);
					row2[3] = rs2.getString(4);
					row2[4] = rs2.getString(5);
					row2[5] = rs2.getString(6);
					row2[6] = rs2.getString(7);
					row2[7] = rs2.getString(8);
					row2[8] = rs2.getString(9);
					row2[9] = rs2.getString(10);
					model.addRow(row2);
				}
				stmt2.close();
				rs2.close();
				con.close();
				System.out.println("DB 연결 종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void missing_record_sqlrun(DefaultTableModel model, int choice, String missing_record_key) // 유기견 패널
	{
		if (choice == 0) {										// 메인 패널
			String query3 = "select * from 신고기록";				// 탭에 신고기록 간추린 데이터 목록
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

	public void adopt_request_sqlrun(DefaultTableModel model, int choice, String adopt_request_key) // 입양신청 패널
	{
		if (choice == 0) {										// 메인 패널
			String query5 = "select * from 입양신청";				// 탭에 입양신청 간추린 데이터 목록
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