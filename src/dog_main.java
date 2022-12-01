
public class dog_main {

	public static void main(String[] args) {
		new DBlist();
		DB_Conn_Query dbc1 = new DB_Conn_Query();		
		if (dbc1.con == null) return;		
		dbc1.DB_Conn_Query_driver();
//		DB_Conn_Query dbc2 = new DB_Conn_Query();		
//		if (dbc2.con == null) return;	
//		dbc2.missing_record_sqlrun();
//		DB_Conn_Query dbc3 = new DB_Conn_Query();		
//        if (dbc3.con == null) return;
//		dbc3.adopt_request_sqlrun(window.model5,0,"ㅇ");

	}
}