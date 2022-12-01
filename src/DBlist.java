import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
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
import DTO.adopt;
import DTO.missing;
import DTO.protection_agency;

public class DBlist {

	private JFrame frame;
	private JTable table1, table2, table3, table4, table5;

	private JScrollPane scroll1, scroll2, scroll3,scroll4,scroll5;
	private JPanel main_panel, panel, panel1, panel2, panel3,panel4;
	private JTabbedPane pane;
	private JButton Bt1, Bt2, Bt3,Bt4;
//	private JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
//	private JFrame frame;
//	private JPanel panel;
	private JTextField search_text = new JTextField();
	private JTextField[] tfArray1 = new JTextField[9];
	private JTextField[] tfArray2 = new JTextField[8];
	// private JTextField[] tfArray3 = new JTextField[7];
	private JLabel[] tLArray1 = new JLabel[9];
	private JLabel[] tLArray2 = new JLabel[8];
	// private JLabel[] tLArray3 = new JLabel[7];
	private JTextArea tA1, tA2, tA3, tA4;
	private JLabel Lb1, Lb2, Lb3, Lb4;
	private JLabel search_Lb = new JLabel();
	private DB_Conn_Query dao = new DB_Conn_Query();
	// private DB_Conn_Query dao1 = new DB_Conn_Query();
	public DefaultTableModel model1 = new DefaultTableModel();
	public DefaultTableModel model2 = new DefaultTableModel();
	public DefaultTableModel model3 = new DefaultTableModel();
	public DefaultTableModel model4 = new DefaultTableModel();
	public DefaultTableModel model5 = new DefaultTableModel();

	public DBlist() { // 생성자
		make_main_frame();

	}

	class JtableMouseEvent extends MouseAdapter {
		private JTable table;

		public JtableMouseEvent(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {	
			if (e.getClickCount() == 2) { // 클릭횟수 2번이상
				detail_page_int_key(table);
			}
		}
	}
	
	public void detail_page_int_key(JTable table) {
		int row = table.getSelectedRow();					// 테이블 값반환
		String key = (String) table.getModel().getValueAt(row, 0);
		sub_alldog_data(Integer.parseInt(key)); // 선택한 목록
	}

	class JtableMouseEvent2 extends MouseAdapter {
		private JTable table;

		public JtableMouseEvent2(JTable table) {
			this.table = table;
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2) { // 클릭횟수 2번이상
				detail_page_str_key(table);
			}
		}
	}
	
	public void detail_page_str_key(JTable table) {
		int row = table.getSelectedRow();					// 테이블 값반환
		String key = (String) table.getModel().getValueAt(row, 0);
		sub_missing_data(key); // 선택한 목록
	}

	public void main_dog_data() {
		ArrayList<abandoned_dog> output1 = new ArrayList<abandoned_dog>();
		String colName1[] = { "유기견번호", "유기견이름", "품종", "성별","보호기관번호" }; // 컬럼명을 배열에 선언
		output1 = dao.read_abandoned_dog();
		int size1 = output1.size();
		String data1[][] = new String[size1][5];

		for (int i = 0; i < output1.size(); i++) {
			String a = Integer.toString(output1.get(i).getNum());
			String b = output1.get(i).getName();
			String c = output1.get(i).getKind();
			String d = output1.get(i).getGender();
			String e = output1.get(i).getProtection_agency();
			data1[i][0] = a;
			data1[i][1] = b;
			data1[i][2] = c;
			data1[i][3] = d;
			data1[i][4] = e;

		}
		model1 = new DefaultTableModel(data1, colName1) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}

	public void main_missing_data() {
		ArrayList<missing> output2 = new ArrayList<missing>();
		String colName2[] = { "동물등록번호", "반려견 이름", "반려견 품종", "실종된 날짜", "신고자 아이디" }; // 컬럼명을 배열에 선언
		output2 = dao.missing_record_sqlrun();
		int size2 = output2.size();
		String data2[][] = new String[size2][5];
		for (int i = 0; i < output2.size(); i++) {
			String a = output2.get(i).getAnimal_num();
			String b = output2.get(i).getDog_name();
			String c = output2.get(i).getDog_kind();
			String d = output2.get(i).getMiss_date().toString();
			String e = output2.get(i).getId();
			data2[i][0] = a;
			data2[i][1] = b;
			data2[i][2] = c;
			data2[i][3] = d;
			data2[i][4] = e;

		}
		model2 = new DefaultTableModel(data2, colName2) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}
	
	public void main_adopt_data() {
		ArrayList<adopt> output3 = new ArrayList<adopt>();
		String colName3[] = { "입양신청번호", "신청 일자", "유기견 이름", "유기견 품종", "유기견 성별","보호기관번호","입양자 아이디" }; // 컬럼명을 배열에 선언
		output3 = dao.adopt_record_sqlrun();
		int size3 = output3.size();
		String data3[][] = new String[size3][7];
		for (int i = 0; i < output3.size(); i++) {
			String a = output3.get(i).getAdopt_num();
			String b = output3.get(i).getAdopt_date().toString();
			String c = output3.get(i).getAdopt_dog_name();
			String d = output3.get(i).getAdopt_dog_kind();
			String e = output3.get(i).getAdopt_dog_sex();
			String f = output3.get(i).getShelter_num();
			String g = output3.get(i).getId();
			data3[i][0] = a;
			data3[i][1] = b;
			data3[i][2] = c;
			data3[i][3] = d;
			data3[i][4] = e;
			data3[i][5] = f;
			data3[i][6] = g;

		}
		model3 = new DefaultTableModel(data3, colName3) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}
	
	public void main_protection_agency_data() {
		ArrayList<protection_agency> output4 = new ArrayList<protection_agency>();
		String colName4[] = { "보호기관번호", "보호기관명", "주소", "전화번호", "보호 중인 유기견 수"}; // 컬럼명을 배열에 선언
		output4 = dao.protection_agency_sqlrun();
		int size4 = output4.size();
		String data4[][] = new String[size4][5];
		for (int i = 0; i < output4.size(); i++) {
			String a = output4.get(i).getNum();
			String b = output4.get(i).getName();
			String c = output4.get(i).getAddress();
			String d = output4.get(i).getPhone_number();
			String e = Integer.toString(output4.get(i).getCount());
			data4[i][0] = a;
			data4[i][1] = b;
			data4[i][2] = c;
			data4[i][3] = d;
			data4[i][4] = e;

		}
		model4 = new DefaultTableModel(data4, colName4) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}
	
	public void sub_alldog_data(int key1) {

		ArrayList<abandoned_dog> output4 = new ArrayList<abandoned_dog>();

		output4 = dao.read_abandoned_dog1(key1);

		String num = Integer.toString(output4.get(0).getNum());
		String name = output4.get(0).getName();
		String kind = output4.get(0).getKind();
		String gender = output4.get(0).getGender();
		String age = output4.get(0).getAge();
		String weight = output4.get(0).getWeight();
		String rescure_date = output4.get(0).getRescure_date();
		String discovery_place = output4.get(0).getDiscovery_place();
		String protect_num = output4.get(0).getProtect_num();
		String protection_agency = output4.get(0).getProtection_agency();

		frame = new JFrame();
		frame.setBounds(100, 100, 911, 403);
		panel = new JPanel(); // 메인 패널 생성
		panel.setBounds(0, 0, 897, 305);
		frame.setContentPane(panel);
		panel.setLayout(null);

		String[] headArr1 = { "유기견번호", "유기견이름", "유기견품종", "성별", "나이", "몸무게", "구조 일자", "보호등록번호", "보호기관번호" };

		for (int i = 0; i < tLArray1.length; i++) {
			tLArray1[i] = new JLabel(headArr1[i], JLabel.CENTER);
			tLArray1[i].setBounds(0 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 100, 28);
			panel.add(tLArray1[i]);
		}

		String[] dataArr1 = { num, name, kind, gender, age, weight, rescure_date, protect_num, protection_agency };

		for (int i = 0; i < tfArray1.length; i++) {
			tfArray1[i] = new JTextField();
			tfArray1[i].setColumns(10);
			tfArray1[i].setBounds(100 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 127, 28);
			panel.add(tfArray1[i]);
			tfArray1[i].setText(dataArr1[i]);
		}

		tA1 = new JTextArea();
		tA1.setColumns(10);
		tA1.setBounds(124, 256, 710, 64);
		panel.add(tA1);
		tA1.setText(discovery_place);

		Lb1 = new JLabel("발견장소", JLabel.CENTER);
		Lb1.setBounds(12, 256, 100, 64);
		panel.add(Lb1);

		frame.setVisible(true);

	}

	public void sub_missing_data(String key2) {

		ArrayList<missing> output5 = new ArrayList<missing>();

		output5 = dao.missing_record_sqlrun1(key2);

		String animal_num = output5.get(0).getAnimal_num();
		String dog_name = output5.get(0).getDog_name();
		String dog_kind = output5.get(0).getDog_kind();
		String sex = output5.get(0).getSex();
		String unique = output5.get(0).getUnique();
		String miss_place = output5.get(0).getMiss_place();
		String miss_time = output5.get(0).getMiss_time();
		String miss_date = output5.get(0).getMiss_date().toString();
		String id = output5.get(0).getId();

		frame = new JFrame();
		frame.setBounds(100, 100, 911, 403);
		panel = new JPanel(); // 메인 패널 생성
		panel.setBounds(0, 0, 897, 305);
		frame.setContentPane(panel);
		panel.setLayout(null);		
		
		String[] headArr2 = { "동물등록번호", "반려견이름", "반려견품종", "성별", "실종장소", "실종된시간", "실종된날짜", "신고자 아이디" };

		for (int i = 0; i < tLArray2.length; i++) {
			tLArray2[i] = new JLabel(headArr2[i], JLabel.CENTER);
			tLArray2[i].setBounds(0 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 100, 28);
			panel.add(tLArray2[i]);
		}

		String[] dataArr2 = { animal_num, dog_name, dog_kind, sex,miss_place , miss_time, miss_date,id };

		for (int i = 0; i < tfArray2.length; i++) {
			tfArray2[i] = new JTextField();
			tfArray2[i].setColumns(10);
			tfArray2[i].setBounds(100 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 127, 28);
			panel.add(tfArray2[i]);
			tfArray2[i].setText(dataArr2[i]);
		}
		
		tA2 = new JTextArea();
		tA2.setColumns(10);
		tA2.setBounds(124, 256, 710, 64);
		panel.add(tA2);
		tA2.setText(unique);
		
		Lb2 = new JLabel("특이사항", JLabel.CENTER);
		Lb2.setBounds(12, 256, 100, 64);
		panel.add(Lb2);

		frame.setVisible(true);
	}

//	private String colName2[] = { "유기견번호", "유기견이름", "유기견품종", "성별", "나이", "몸무게", "구조일자", "발견장소", "보호등록번호", "보호기관번호" };
//	// public DefaultTableModel model2 = new DefaultTableModel(colName2, 0);// 컬럼명을
//	// 배열에 선언//
//
//	private String colName3[] = { "동물등록번호", "반려견 이름", "반려견 품종", "실종된 날짜", "신고자 아이디" }; // 컬럼명을 배열에 선언
//	public DefaultTableModel model3 = new DefaultTableModel(colName3, 0) {
//		public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable)
//																		// 값
//																		// 수정
//																		// 못하게
//																		// 하는
//																		// 메소드
//			return false;
//		}
//	};

//	private String colName4[] = { "동물등록번호", "반려견이름", "반려견품종", "성별", "특이사항", "실종장소", "실종된시간", "실종된날짜", "신고자 아이디" };
//	public DefaultTableModel model4 = new DefaultTableModel(colName4, 0);
//
//	private String colName5[] = { "입양신청번호", "신청일자", "유기견이름", "입양자 ID" }; // 컬럼명을 배열에 선언
//	public DefaultTableModel model5 = new DefaultTableModel(colName5, 0) {
//		public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable)
//																		// 값
//																		// 수정
//																		// 못하게
//																		// 하는
//																		// 메소드
//			return false;
//		}
//	}; //
//
//	private String colName6[] = { "입양신청번호", "신청일자", "유기견이름", "입양자 ID" }; // 컬럼명을 배열에 선언
//	public DefaultTableModel model6 = new DefaultTableModel(colName6, 0);

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
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = new JPanel(); // 메인 패널 생성
		frame.setContentPane(main_panel); // 패널을 컨텐트 팬처럼 사용하기 위한 메소드
//		--------------------------------------------------------------------- 메인 UI
		
		main_dog_data();
		panel1 = new JPanel(); // 유기견 패널 생성
		table1 = new JTable(model1); // 입력 받은 DB 데이터들을 JTable에 추가
		scroll1 = new JScrollPane(table1, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBounds(0, 50, 600, 480); // 위치 설정
		panel1.setLayout(null);
		panel1.add(scroll1); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		JtableMouseEvent Click1 = new JtableMouseEvent(table1); // 더블클릭시 상세정보
		table1.addMouseListener(Click1); //
		
		Bt1 = new JButton("입양 신청");
		Bt2 = new JButton("상세 정보");
		
		Bt1.setBounds(630, 100, 120, 30);
		Bt2.setBounds(630, 200, 120, 30);
		
		panel1.add(Bt1);
		panel1.add(Bt2);
		
		Bt1.addActionListener(new ActionListener() {		// 입양 신청 버튼
			public void actionPerformed(ActionEvent e) {
				System.out.println("입양 신청 프로시저");
			
			}
		});
		
		Bt2.addActionListener(new ActionListener() {		//상세 정보 버튼
			public void actionPerformed(ActionEvent e) {
				detail_page_int_key(table1);
				System.out.println("상세 정보");
			
			}
		});
//		---------------------------------------------------------------------탭1
		
		main_missing_data();
		panel2 = new JPanel(); // 실종 신고 패널 생성
		table2 = new JTable(model2); // 입력 받은 DB 데이터들을 JTable에 추가
		scroll2 = new JScrollPane(table2, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setBounds(0, 50, 600, 480); // 위치 설정
		panel2.setLayout(null);
		panel2.add(scroll2); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		JtableMouseEvent2 Click2 = new JtableMouseEvent2(table2); // 더블클릭시 상세정보
		table2.addMouseListener(Click2); //
		Bt3 = new JButton("상세 정보");
		Bt3.addActionListener(new ActionListener() {		//상세 정보 버튼
			public void actionPerformed(ActionEvent e) {
				detail_page_str_key(table2);			
			}
		});
		Bt3.setBounds(630, 200, 120, 30);
		panel2.add(Bt3);
//		---------------------------------------------------------------------탭2
		
		main_adopt_data();
		panel3 = new JPanel(); // 유기견 패널 생성
		table3 = new JTable(model3); // 입력 받은 DB 데이터들을 JTable에 추가
		scroll3 = new JScrollPane(table3, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll3.setBounds(0, 50, 770, 480); // 위치 설정
		panel3.setLayout(null);
		panel3.add(scroll3); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
//		---------------------------------------------------------------------탭3
		main_protection_agency_data();
		panel4 = new JPanel(); // 유기견 패널 생성
		table4 = new JTable(model4); // 입력 받은 DB 데이터들을 JTable에 추가
		scroll4 = new JScrollPane(table4, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll4.setBounds(0, 120, 770, 400); // 위치 설정
		panel4.setLayout(null);
		panel4.add(scroll4); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		table4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		search_text.setBounds(120, 40, 400, 30);
		search_text.setColumns(10);
		String sel_str = search_text.getText();  //검색창에 입력
		Bt4 = new JButton("검색하기");
		search_Lb = new JLabel("검색하시오", JLabel.CENTER);
		search_Lb.setBounds(20, 40, 100, 30);
		Bt4.setBounds(550, 40, 120, 30);
		Bt4.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				System.out.println("검색 기능");
			
			}
		});
		panel4.add(search_text);
		panel4.add(search_Lb);
		panel4.add(Bt4);
		
		
		
		
//		panel2.add(Bt4);


		//panel2 = make_sub_panel(panel2, table2, scroll2, model3); // 실종 신고 목록 패널 생성
		//panel3 = make_sub_panel(panel3, table3, scroll3, model5); // 입양 신청 목록 패널 생성
		frame.setResizable(false); // 메인 GUI 크기 변경 불가
		main_panel.setLayout(null);
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setBounds(0, 0, 785, 590);
		pane.add("유기견 목록", panel1); // 탭(pane) >> 각 목록 gui 창(sub_panel) 유기견 탭에 유기견 목록 패널 추가
		pane.add("실종 신고 목록", panel2); // 실종 신고 탭에 유기견 목록 패널 추가
		pane.add("입양 신청 목록", panel3); // 입양 신청 탭에 입양 신청 목록 패널 추가
		pane.add("보호소 목록",panel4);
		frame.getContentPane().add(pane); // 프레임 >> 컨텐트팬(메인패널) >> 탭(pane)
		frame.setVisible(true); // 보이게 하는거

	}

//	private void make_sub_frame(JFrame frame, JPanel panel, JTable table, DefaultTableModel model) {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 600, 200);
//		panel = new JPanel(); // 메인 패널 생성
//		frame.setContentPane(main_panel);
//		panel.setLayout(null);
//
//		table = new JTable(model);
//		table.setBounds(0, 0, 500, 200);
//		main_panel.add(table);
//	}
}
