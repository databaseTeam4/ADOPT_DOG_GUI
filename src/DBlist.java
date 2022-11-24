import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;



public class DBlist {

	private JFrame frame;
	private JTable table,table1,table2;
	
	private JScrollPane scroll,scroll1,scroll2;
	private JPanel panel,panel2,panel3,panel4;
	private JTabbedPane pane;

	public DBlist() { //생성자
		initialize();
		
	}
	
	private String colName1[] = { "회원 ID", "이름", "나이" }; // 컬럼명을 배열에 선언
    public DefaultTableModel model = new DefaultTableModel(colName1, 0) {
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //
    private String colName2[] = { "동물등록번호","반려견 이름", "반려견 품종", "실종된 날짜","신고자 ID"}; // 컬럼명을 배열에 선언
    public DefaultTableModel model1 = new DefaultTableModel(colName2, 0) {
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //
    private String colName3[] = { "입양신청번호", "신청일자", "유기견이름","입양자 ID"}; // 컬럼명을 배열에 선언
    public DefaultTableModel model2 = new DefaultTableModel(colName3, 0) {
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //


	private void initialize() {
		frame = new JFrame(); //프레임 생성
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel2 = new JPanel(); //패널 생성
		panel3 = new JPanel(); //패널 생성
		panel4 = new JPanel(); //패널 생성
		frame.setContentPane(panel);
		table = new JTable(model);
		table1 = new JTable(model1);
		table2 = new JTable(model2);
		scroll = new JScrollPane(table, 
	    			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 									
	    			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 60, 590, 370);
		scroll1 = new JScrollPane(table1, 
    			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 									
    			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(0, 60, 590, 370);
		scroll2 = new JScrollPane(table2, 
    			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 									
    			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setBounds(0, 60, 590, 370);
		panel2.setLayout(null);
		panel2.add(scroll);
		panel3.setLayout(null);
		panel3.add(scroll1);
		panel4.setLayout(null);
		panel4.add(scroll2);
		table.setBounds(12, 118, 575, 335); 
		frame.setResizable(false);
		panel.setLayout(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 하나만 선택
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setBounds(0, 0, 686, 453);
        pane.add("유기견 목록", panel2);  // 유기견 탭
        pane.add("실종 반려견 목록", panel3);
        pane.add("입양 신청 목록",panel4);
		frame.getContentPane().add(pane);
		frame.setVisible(true); // 보이게 하는거

	}
}
