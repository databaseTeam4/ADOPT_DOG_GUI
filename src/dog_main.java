
public class dog_main {

	public static void main(String[] args) {
		DBlist window = new DBlist();
		
		DB_Conn_Query dbc1 = new DB_Conn_Query();		
        if (dbc1.con == null) return;
		dbc1.abandoned_dog_sqlrun(window.model1,0,1);
		DB_Conn_Query dbc2 = new DB_Conn_Query();		
        if (dbc2.con == null) return;
		dbc2.missing_record_sqlrun(window.model3,0,"ㅁ");
		DB_Conn_Query dbc3 = new DB_Conn_Query();		
        if (dbc3.con == null) return;
		dbc3.adopt_request_sqlrun(window.model5,0,"ㅇ");

	}
}