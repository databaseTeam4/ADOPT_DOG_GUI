
public class dog_main {

	public static void main(String[] args) {
		new DBlist();
		DB_Conn_Query dbc1 = new DB_Conn_Query();		
		if (dbc1.con == null) return;		
		dbc1.DB_Conn_Query_driver();

	}
}