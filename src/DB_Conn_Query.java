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

	public void abandoned_dog_sqlrun(DefaultTableModel model) // 유기견 패널
	{
		String query1 = "select * from 유기견";
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void missing_record_sqlrun(DefaultTableModel model) // 신고기록 패널
	{
		String query2 = "select * from 신고기록";
		try {
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(query2);
			String row2[] = new String[6];
			while (rs2.next()) {
				row2[0] = rs2.getString(1);
				row2[1] = rs2.getString(2);
				row2[2] = rs2.getString(3);
				row2[3] = rs2.getString(4);
				row2[4] = rs2.getString(5);
				row2[5] = rs2.getString(8);
				model.addRow(row2);
			}
			stmt2.close();
			rs2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void adopt_request_sqlrun(DefaultTableModel model) // 입양신청 패널
	{
		String query3 = "select * from 입양신청";
		try {
			Statement stmt3 = con.createStatement();
			ResultSet rs3 = stmt3.executeQuery(query3);
			String row3[] = new String[5];
			while (rs3.next()) {
				row3[0] = rs3.getString(1);
				row3[1] = rs3.getDate(2).toString();
				row3[2] = rs3.getString(3);
				row3[3] = rs3.getString(6);
				row3[4] = rs3.getString(7);
				model.addRow(row3);
			}
			stmt3.close();
			rs3.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}