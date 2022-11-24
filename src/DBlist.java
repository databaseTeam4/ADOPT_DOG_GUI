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
    	public boolean isCellEditable(int rowIndex, int mColIndex) {		// 목록(JTable) 값 수정 못하게 하는 메소드
    		return false;
    	}
    }; //
    private String colName2[] = { "동물등록번호","반려견 이름", "반려견 품종", "실종된 날짜","신고자 ID"}; // 컬럼명을 배열에 선언
    public DefaultTableModel model2 = new DefaultTableModel(colName2, 0) {		// 목록(JTable) 값 수정 못하게 하는 메소드
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //
    private String colName3[] = { "입양신청번호", "신청일자", "유기견이름","입양자 ID"}; // 컬럼명을 배열에 선언
    public DefaultTableModel model3 = new DefaultTableModel(colName3, 0) {		// 목록(JTable) 값 수정 못하게 하는 메소드
    	public boolean isCellEditable(int rowIndex, int mColIndex) {
    		return false;
    	}
    }; //

    private JPanel make_sub_panel(JPanel panel,JTable table, JScrollPane scroll,DefaultTableModel model) {
    	panel = new JPanel(); 									// 서브 패널 생성
    	table = new JTable(model);								// 입력 받은 DB 데이터들을 JTable에 추가
		scroll = new JScrollPane(table, 						// 목록(JTable)에 스크롤 추가
	    			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,		// 스크롤 안에 테이블을 추가(스크롤 옵션을 추가) 									
	    			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 60, 590, 370);						// 위치 설정
		panel.setLayout(null);
		panel.add(scroll);										// 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		table.setBounds(12, 118, 575, 335);						// 서브 패널 위치 설정
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 목록(JTable) 하나만 선택할 수 있도록 하는 옵션
		return panel;											// 생성된 서브 패널을 반환
    }
    
    
	private void initialize() {
		frame = new JFrame(); //프레임 생성
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = new JPanel();								// 메인 패널 생성
		frame.setContentPane(main_panel);						// 패널을 컨텐트 팬처럼 사용하기 위한 메소드
		panel1 = make_sub_panel(panel1,table1,scroll1,model1);	// 유기견 목록 패널 생성
		panel2 = make_sub_panel(panel2,table2,scroll2,model2);	// 실종 신고 목록 패널 생성
		panel3 = make_sub_panel(panel3,table3,scroll3,model3);	// 입양 신청 목록 패널 생성
		frame.setResizable(false);								// 메인 GUI 크기 변경 불가
		main_panel.setLayout(null);
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setBounds(0, 0, 686, 453);
        pane.add("유기견 목록", panel1); 		 // 탭(pane) >> 각 목록 gui 창(sub_panel) 유기견 탭에 유기견 목록 패널 추가
        pane.add("실종 신고 목록", panel2);		 // 실종 신고 탭에 유기견 목록 패널 추가
        pane.add("입양 신청 목록",panel3);		// 입양 신청 탭에 입양 신청 목록 패널 추가
		frame.getContentPane().add(pane);	// 프레임 >> 컨텐트팬(메인패널) >> 탭(pane)
		frame.setVisible(true); // 보이게 하는거

	}
}

	

