
public class dog_main {

	public static void main(String[] args) {
		DBlist window = new DBlist();
		
		DB_Conn_Query dbc = new DB_Conn_Query();		
        if (dbc.con == null) return;
		dbc.abandoned_dog_sqlrun(window.model);
		dbc.missing_record_sqlrun(window.model1);
		dbc.adopt_request_sqlrun(window.model2);

	}
}