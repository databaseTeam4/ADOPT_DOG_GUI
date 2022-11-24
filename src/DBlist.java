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
	private JTable table1,table2,table3;
	
	private JScrollPane scroll1,scroll2,scroll3;
	private JPanel main_panel,panel1,panel2,panel3;
	private JTabbedPane pane;

	public DBlist() { //생성자
		initialize();

		
	}
	
	private String colName1[] = { "회원 ID", "이름", "나이" }; // 컬럼명을 배열에 선언
    public DefaultTableModel model1 = new DefaultTableModel(colName1, 0) {
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //
    private String colName2[] = { "동물등록번호","반려견 이름", "반려견 품종", "실종된 날짜","신고자 ID"}; // 컬럼명을 배열에 선언
    public DefaultTableModel model2 = new DefaultTableModel(colName2, 0) {
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //
    private String colName3[] = { "입양신청번호", "신청일자", "유기견이름","입양자 ID"}; // 컬럼명을 배열에 선언
    public DefaultTableModel model3 = new DefaultTableModel(colName3, 0) {
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //

    private JPanel make_sub_panel(JPanel panel,JTable table, JScrollPane scroll,DefaultTableModel model) {
    	panel = new JPanel(); //패널 생성
    	table = new JTable(model);
		scroll = new JScrollPane(table, 
	    			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 									
	    			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 60, 590, 370);
		panel.setLayout(null);
		panel.add(scroll);
		table.setBounds(12, 118, 575, 335);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 하나만 선택
		return panel;
    }
    
    
	private void initialize() {
		frame = new JFrame(); //프레임 생성
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = new JPanel();
		frame.setContentPane(main_panel);
		panel1 = make_sub_panel(panel1,table1,scroll1,model1);
		panel2 = make_sub_panel(panel2,table2,scroll2,model2);
		panel3 = make_sub_panel(panel3,table3,scroll3,model3);
		frame.setResizable(false);
		main_panel.setLayout(null);
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setBounds(0, 0, 686, 453);
        pane.add("유기견 목록", panel1);  // 유기견 탭
        pane.add("실종 반려견 목록", panel2);
        pane.add("입양 신청 목록",panel3);
		frame.getContentPane().add(pane);
		frame.setVisible(true); // 보이게 하는거

	}
}

	

