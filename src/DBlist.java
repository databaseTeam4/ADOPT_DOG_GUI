import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import DTO.abandoned_dog;

public class DBlist {

	private JFrame frame;
	private JTable table1, table2, table3;

	private JScrollPane scroll1, scroll2, scroll3;
	private JPanel main_panel, panel, panel1, panel2, panel3;
	private JTabbedPane pane;
//	private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
//	private JFrame frame;
//	private JPanel panel;
	private JTextField tF1, tF2, tF3, tF4, tF5, tF6, tF7, tF8, tF9;
	private JTextArea tF10;
	private JLabel Lb1, Lb2, Lb3, Lb4, Lb5, Lb6, Lb7, Lb8, Lb9, Lb10;
	private DB_Conn_Query dao = new DB_Conn_Query();
	public DefaultTableModel model1 = new DefaultTableModel();

	public DBlist() { // 생성자
		make_main_frame();

	}

	class JtableMouseEvent extends MouseAdapter {
		private JTable table;
		public String key;
		public JtableMouseEvent(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			if (e.getClickCount() == 2) { // 클릭횟수 2번이상
				key = (String) table.getModel().getValueAt(row, 0);
				System.out.println(key);
				sub_alldog_data(Integer.parseInt(key));
		}
	}
}

	public void main_dog_data() {
		ArrayList<abandoned_dog> output = new ArrayList<abandoned_dog>();
		String colName1[] = { "유기견번호", "유기견이름", "품종" }; // 컬럼명을 배열에 선언
		output = dao.read_abandoned_dog();
		int size = output.size();
		String data[][] = new String[size][3];

		for (int i = 0; i < output.size(); i++) {
			String a = Integer.toString(output.get(i).getNum());
			String b = output.get(i).getName();
			String c = output.get(i).getKind();
			data[i][0] = a;
			data[i][1] = b;
			data[i][2] = c;

		}
		model1 = new DefaultTableModel(data, colName1) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}

	public void sub_alldog_data(int key1) {
		
		ArrayList<abandoned_dog> output = new ArrayList<abandoned_dog>();
		
		output = dao.read_abandoned_dog1(key1);

		String num = Integer.toString(output.get(0).getNum());
		String name = output.get(0).getName();
		String kind = output.get(0).getKind();
		String gender = output.get(0).getGender();
		String age = output.get(0).getAge();
		String weight = output.get(0).getWeight();
		String rescure_date = output.get(0).getRescure_date();
		String discovery_place = output.get(0).getDiscovery_place();
		String protect_num = output.get(0).getProtect_num();
		String protection_agency = output.get(0).getProtection_agency();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 911, 403);
		panel = new JPanel(); // 메인 패널 생성
		panel.setBounds(0, 0, 897, 305);
		frame.setContentPane(panel);
		panel.setLayout(null);

		tF1 = new JTextField();
		tF2 = new JTextField();
		tF3 = new JTextField();
		tF4 = new JTextField();
		tF5 = new JTextField();
		tF6 = new JTextField();
		tF7 = new JTextField();
		tF8 = new JTextField();
		tF9 = new JTextField();
		tF10 = new JTextArea();

		Lb1 = new JLabel("유기견 번호", JLabel.CENTER);
		Lb2 = new JLabel("유기견 이름", JLabel.CENTER);
		Lb3 = new JLabel("유기견 품종", JLabel.CENTER);
		Lb4 = new JLabel("성별", JLabel.CENTER);
		Lb5 = new JLabel("나이", JLabel.CENTER);
		Lb6 = new JLabel("몸무게", JLabel.CENTER);
		Lb7 = new JLabel("구조일자", JLabel.CENTER);
		Lb8 = new JLabel("보호기관번호", JLabel.CENTER);
		Lb9 = new JLabel("보호등록번호", JLabel.CENTER);
		Lb10 = new JLabel("발견장소", JLabel.CENTER);

		tF1.setBounds(124, 31, 127, 28);
		panel.add(tF1);
		tF1.setColumns(10);
		tF1.setText(num);

		tF2.setColumns(10);
		tF2.setBounds(416, 31, 127, 28);
		panel.add(tF2);
		tF2.setText(name);

		tF3.setColumns(10);
		tF3.setBounds(707, 31, 127, 28);
		panel.add(tF3);
		tF3.setText(kind);

		tF6.setColumns(10);
		tF6.setBounds(707, 107, 127, 28);
		panel.add(tF6);
		tF4.setText(gender);

		tF4.setColumns(10);
		tF4.setBounds(124, 107, 127, 28);
		panel.add(tF4);
		tF5.setText(age);

		tF5.setColumns(10);
		tF5.setBounds(416, 107, 127, 28);
		panel.add(tF5);
		tF6.setText(weight);

		tF7.setColumns(10);
		tF7.setBounds(124, 180, 127, 28);
		panel.add(tF7);
		tF7.setText(rescure_date);
		
		tF8.setColumns(10);
		tF8.setBounds(416, 180, 127, 28);
		panel.add(tF8);
		tF8.setText(protection_agency);
		
		tF9.setColumns(10);
		tF9.setBounds(707, 180, 127, 28);
		panel.add(tF9);
		tF9.setText(protect_num);
		
		tF10.setColumns(10);
		tF10.setBounds(124, 256, 710, 64);
		panel.add(tF10);
		tF10.setText(discovery_place);

		Lb1.setBounds(12, 31, 100, 28);
		panel.add(Lb1);

		Lb2.setBounds(304, 31, 100, 28);
		panel.add(Lb2);

		Lb3.setBounds(595, 31, 100, 28);
		panel.add(Lb3);

		Lb4.setBounds(12, 107, 100, 28);
		panel.add(Lb4);

		Lb5.setBounds(304, 107, 100, 28);
		panel.add(Lb5);

		Lb6.setBounds(595, 107, 100, 28);
		panel.add(Lb6);

		Lb7.setBounds(12, 180, 100, 28);
		panel.add(Lb7);

		Lb8.setBounds(304, 180, 100, 28);
		panel.add(Lb8);

		Lb9.setBounds(595, 180, 100, 28);
		panel.add(Lb9);

		Lb10.setBounds(12, 256, 100, 64);
		panel.add(Lb10);

		frame.setVisible(true);

	}

	private String colName2[] = { "유기견번호", "유기견이름", "유기견품종", "성별", "나이", "몸무게", "구조일자", "발견장소", "보호등록번호", "보호기관번호" };
	public DefaultTableModel model2 = new DefaultTableModel(colName2, 0);// 컬럼명을 배열에 선언//

	private String colName3[] = { "동물등록번호", "반려견 이름", "반려견 품종", "실종된 날짜", "신고자 아이디" }; // 컬럼명을 배열에 선언
	public DefaultTableModel model3 = new DefaultTableModel(colName3, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable)
																		// 값
																		// 수정
																		// 못하게
																		// 하는
																		// 메소드
			return false;
		}
	};

	private String colName4[] = { "동물등록번호", "반려견이름", "반려견품종", "성별", "특이사항", "실종장소", "실종된시간", "실종된날짜", "신고자 아이디" };
	public DefaultTableModel model4 = new DefaultTableModel(colName4, 0);

	private String colName5[] = { "입양신청번호", "신청일자", "유기견이름", "입양자 ID" }; // 컬럼명을 배열에 선언
	public DefaultTableModel model5 = new DefaultTableModel(colName5, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable)
																		// 값
																		// 수정
																		// 못하게
																		// 하는
																		// 메소드
			return false;
		}
	}; //

	private String colName6[] = { "입양신청번호", "신청일자", "유기견이름", "입양자 ID" }; // 컬럼명을 배열에 선언
	public DefaultTableModel model6 = new DefaultTableModel(colName6, 0);

	public JPanel make_sub_panel(JPanel panel, JTable table, JScrollPane scroll, DefaultTableModel model) {
		panel = new JPanel(); // 서브 패널 생성
		table = new JTable(model); // 입력 받은 DB 데이터들을 JTable에 추가
		scroll = new JScrollPane(table, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 60, 590, 370); // 위치 설정
		panel.setLayout(null);
		panel.add(scroll); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		table.setBounds(12, 118, 575, 335); // 서브 패널 위치 설정
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 목록(JTable) 하나만 선택할 수 있도록 하는 옵션
		
		
		return panel; // 생성된 서브 패널을 반환
	}



	private void make_main_frame() {
		frame = new JFrame(); // 프레임 생성
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = new JPanel(); // 메인 패널 생성
		frame.setContentPane(main_panel); // 패널을 컨텐트 팬처럼 사용하기 위한 메소드
		main_dog_data();
		panel1 = make_sub_panel(panel1, table1, scroll1, model1);
		panel1 = new JPanel(); // 서브 패널 생성
		table1 = new JTable(model1); // 입력 받은 DB 데이터들을 JTable에 추가
		scroll1 = new JScrollPane(table1, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(0, 60, 590, 370); // 위치 설정
		panel1.setLayout(null);
		panel1.add(scroll1); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		table1.setBounds(12, 118, 575, 335); // 서브 패널 위치 설정
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		JtableMouseEvent Click  = new JtableMouseEvent(table1);
		table1.addMouseListener(Click);

		
		panel2 = make_sub_panel(panel2, table2, scroll2, model3); // 실종 신고 목록 패널 생성
		panel3 = make_sub_panel(panel3, table3, scroll3, model5); // 입양 신청 목록 패널 생성
		frame.setResizable(false); // 메인 GUI 크기 변경 불가
		main_panel.setLayout(null);
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setBounds(0, 0, 686, 453);
		pane.add("유기견 목록", panel1); // 탭(pane) >> 각 목록 gui 창(sub_panel) 유기견 탭에 유기견 목록 패널 추가
		pane.add("실종 신고 목록", panel2); // 실종 신고 탭에 유기견 목록 패널 추가
		pane.add("입양 신청 목록", panel3); // 입양 신청 탭에 입양 신청 목록 패널 추가
		frame.getContentPane().add(pane); // 프레임 >> 컨텐트팬(메인패널) >> 탭(pane)
		frame.setVisible(true); // 보이게 하는거

	}

	private void make_sub_frame(JFrame frame, JPanel panel, JTable table, DefaultTableModel model) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 200);
		panel = new JPanel(); // 메인 패널 생성
		frame.setContentPane(main_panel);
		panel.setLayout(null);

		table = new JTable(model);
		table.setBounds(0, 0, 500, 200);
		main_panel.add(table);
	}
}
