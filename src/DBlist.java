import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

// import DBlist.JtableMouseEvent;
// import DBlist.JtableMouseEvent2;
import DTO.*;

public class DBlist {

	private JFrame main_frame,sub_missing_frame,sub_alldog_frame,
					member_frame, make_dogdata_frame;
	private JTable main_dog_table, main_missing_table, main_adopt_table,
					main_protection_agency_table, member_table;
	private JScrollPane main_dog_scroll, main_missing_scroll, main_adopt_scroll, main_protection_agency_scroll, member_scroll;
	private JPanel main_panel, main_dog_panel,main_missing_panel, main_adopt_panel, main_protection_agency_panel,
					member_panel, sub_missing_panel,sub_alldog_panel,
					make_dogdata_panel;
	private JTabbedPane pane;
	private JButton maindog_Bt1, maindog_Bt2,maindog_Bt3, maindog_Bt4, main_missing_Bt1,main_missing_Bt2, member_Bt, make_dogdata_Bt, adopt_Bt;
	private JTextField  sub_missing_tF, dog_search_text , adopt_search_text1, adopt_search_text2 ;
	private JTextField[] sub_alldog_tfArray = new JTextField[9];
	private JTextField[] sub_missing_tfArray2 = new JTextField[7];
	private JTextField[] make_dogdata_tfArray3 = new JTextField[7];
	private JLabel[] sub_alldog_tLArray = new JLabel[9];
	private JLabel[] sub_missing_tLArray2 = new JLabel[7];
	private JLabel[] make_dogdata_tLArray3 = new JLabel[7];
	private JTextArea sub_alldog_tA, sub_missing_tA, make_dogdata_tA;
	private JLabel sub_alldog_Lb, sub_missing_Lb2, make_dogdata_Lb, sub_missing_Lb1, dog_search_Lb, adopt_search_Lb;
	public DefaultTableModel main_dog_model, main_search_dog_model,main_missing_model, main_adopt_model, main_protection_agency_model, member_model, main_search_adopt_model;
	public String in_name, in_kind, in_gender, in_age, in_weight, in_rescure_date, in_protect_num,
			in_protection_agency,in_discovery_place;
	private DB_Conn_Query dao = new DB_Conn_Query();
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
		int row = table.getSelectedRow(); // 테이블 값반환
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
		int row = table.getSelectedRow(); // 테이블 값반환
		String key = (String) table.getModel().getValueAt(row, 0);
		sub_missing_data(key); // 선택한 목록
	}

	public void main_dog_data() {
		ArrayList<dog_join_protect> main_dog_output = new ArrayList<dog_join_protect>();
		String main_dog_colName[] = { "유기견번호", "유기견이름", "품종", "성별", "보호기관번호","보호기관명","지역" }; // 컬럼명을 배열에 선언
		main_dog_output = dao.read_abandoned_dog();
		int main_dog_size = main_dog_output.size();
		String main_dog_data[][] = new String[main_dog_size][7];

		for (int i = 0; i < main_dog_output.size(); i++) {
			String main_dog_num = Integer.toString(main_dog_output.get(i).getNum());
			String main_dog_name = main_dog_output.get(i).getName();
			String main_dog_kind = main_dog_output.get(i).getKind();
			String main_dog_gender = main_dog_output.get(i).getGender();
			String main_dog_protect_agency = main_dog_output.get(i).getProtect_agency();
			String main_dog_protect_name = main_dog_output.get(i).getProtect_name();
			String main_dog_protect_address = main_dog_output.get(i).getAddress();
			main_dog_data[i][0] = main_dog_num;
			main_dog_data[i][1] = main_dog_name;
			main_dog_data[i][2] = main_dog_kind;
			main_dog_data[i][3] = main_dog_gender;
			main_dog_data[i][4] = main_dog_protect_agency;
			main_dog_data[i][5] = main_dog_protect_name;
			main_dog_data[i][6] = main_dog_protect_address;

		}
		main_dog_model = new DefaultTableModel(main_dog_data, main_dog_colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}
	
	public void main_dog_search_data(String local) {												// 내용 추가
		ArrayList<dog_join_protect> main_dog_output = new ArrayList<dog_join_protect>();
		String main_dog_colName[] = { "유기견번호", "유기견이름", "품종", "성별", "보호기관번호","보호기관명","지역" }; // 컬럼명을 배열에 선언
		main_dog_output = dao.p_local_abandoned_dog(local);
		int main_dog_size = main_dog_output.size();
		String main_dog_data[][] = new String[main_dog_size][7];

		for (int i = 0; i < main_dog_output.size(); i++) {
			String main_dog_num = Integer.toString(main_dog_output.get(i).getNum());
			String main_dog_name = main_dog_output.get(i).getName();
			String main_dog_kind = main_dog_output.get(i).getKind();
			String main_dog_gender = main_dog_output.get(i).getGender();
			String main_dog_protect_agency = main_dog_output.get(i).getProtect_agency();
			String main_dog_protect_name = main_dog_output.get(i).getProtect_name();
			String main_dog_protect_address = main_dog_output.get(i).getAddress();
			main_dog_data[i][0] = main_dog_num;
			main_dog_data[i][1] = main_dog_name;
			main_dog_data[i][2] = main_dog_kind;
			main_dog_data[i][3] = main_dog_gender;
			main_dog_data[i][4] = main_dog_protect_agency;
			main_dog_data[i][5] = main_dog_protect_name;
			main_dog_data[i][6] = main_dog_protect_address;
		}
		main_search_dog_model = new DefaultTableModel(main_dog_data, main_dog_colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}

	public void main_missing_data() {
		ArrayList<missing> main_missing_output = new ArrayList<missing>();
		String main_missing_colName[] = { "동물등록번호", "반려견 이름", "반려견 품종", "실종된 날짜", "신고자 아이디" }; // 컬럼명을 배열에 선언
		main_missing_output = dao.missing_record_sqlrun();
		int main_missing_size = main_missing_output.size();
		String main_missing_data[][] = new String[main_missing_size][5];
		for (int i = 0; i < main_missing_output.size(); i++) {
			String animal_num_data = main_missing_output.get(i).getAnimal_num();
			String dog_name_data = main_missing_output.get(i).getDog_name();
			String dog_kind_data = main_missing_output.get(i).getDog_kind();
			String miss_date_data = main_missing_output.get(i).getMiss_date().toString();
			String missing_id_data = main_missing_output.get(i).getId();
			main_missing_data[i][0] = animal_num_data;
			main_missing_data[i][1] = dog_name_data;
			main_missing_data[i][2] = dog_kind_data;
			main_missing_data[i][3] = miss_date_data;
			main_missing_data[i][4] = missing_id_data;

		}
		main_missing_model = new DefaultTableModel(main_missing_data, main_missing_colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}

	public void main_adopt_data() {
		ArrayList<adopt> main_adopt_output = new ArrayList<adopt>();
		String main_adopt_colName[] = { "입양신청번호", "신청 일자", "유기견 이름", "유기견 품종", "유기견 성별", "보호기관번호", "입양자 아이디" }; // 컬럼명을 배열에 선언
		main_adopt_output = dao.adopt_record_sqlrun();
		int main_adopt_size = main_adopt_output.size();
		String main_adopt_data[][] = new String[main_adopt_size][7];
		for (int i = 0; i < main_adopt_output.size(); i++) {
			String adopt_num_data = main_adopt_output.get(i).getAdopt_num();
			String adopt_date_data = main_adopt_output.get(i).getAdopt_date().toString();
			String adopt_dog_name_data = main_adopt_output.get(i).getAdopt_dog_name();
			String adopt_dog_kind_data = main_adopt_output.get(i).getAdopt_dog_kind();
			String adopt_dog_sex_data = main_adopt_output.get(i).getAdopt_dog_sex();
			String shelter_num_data = main_adopt_output.get(i).getShelter_num();
			String adopt_id_data = main_adopt_output.get(i).getId();
			main_adopt_data[i][0] = adopt_num_data;
			main_adopt_data[i][1] = adopt_date_data;
			main_adopt_data[i][2] = adopt_dog_name_data;
			main_adopt_data[i][3] = adopt_dog_kind_data;
			main_adopt_data[i][4] = adopt_dog_sex_data;
			main_adopt_data[i][5] = shelter_num_data;
			main_adopt_data[i][6] = adopt_id_data;

		}
		main_adopt_model = new DefaultTableModel(main_adopt_data, main_adopt_colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}

	public void main_adopt_search_data(String year, String month) {
		ArrayList<adopt> main_adopt_output = new ArrayList<adopt>();
		String main_adopt_colName[] = { "입양신청번호", "신청 일자", "유기견 이름", "유기견 품종", "유기견 성별", "보호기관번호", "입양자 아이디" }; // 컬럼명을 배열에 선언
		main_adopt_output = dao.read_adopt(year, month);
		int main_adopt_size = main_adopt_output.size();
		String main_adopt_data[][] = new String[main_adopt_size][7];
		for (int i = 0; i < main_adopt_output.size(); i++) {
			String adopt_num_data = main_adopt_output.get(i).getAdopt_num();
			String adopt_date_data = main_adopt_output.get(i).getAdopt_date().toString();
			String adopt_dog_name_data = main_adopt_output.get(i).getAdopt_dog_name();
			String adopt_dog_kind_data = main_adopt_output.get(i).getAdopt_dog_kind();
			String adopt_dog_sex_data = main_adopt_output.get(i).getAdopt_dog_sex();
			String shelter_num_data = main_adopt_output.get(i).getShelter_num();
			String adopt_id_data = main_adopt_output.get(i).getId();
			main_adopt_data[i][0] = adopt_num_data;
			main_adopt_data[i][1] = adopt_date_data;
			main_adopt_data[i][2] = adopt_dog_name_data;
			main_adopt_data[i][3] = adopt_dog_kind_data;
			main_adopt_data[i][4] = adopt_dog_sex_data;
			main_adopt_data[i][5] = shelter_num_data;
			main_adopt_data[i][6] = adopt_id_data;

		}
		main_search_adopt_model = new DefaultTableModel(main_adopt_data, main_adopt_colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}
	
	public void main_protection_agency_data() {
		ArrayList<protection_agency> main_protection_agency_output = new ArrayList<protection_agency>();
		String main_protection_agency_colName[] = { "보호기관번호", "보호기관명", "주소", "전화번호", "보호 중인 유기견 수" }; // 컬럼명을 배열에 선언
		main_protection_agency_output = dao.protection_agency_sqlrun();
		int main_protection_agency_size = main_protection_agency_output.size();
		String main_protection_agency_data[][] = new String[main_protection_agency_size][5];
		for (int i = 0; i < main_protection_agency_output.size(); i++) {
			String protect_num = main_protection_agency_output.get(i).getNum();
			String protect_name = main_protection_agency_output.get(i).getName();
			String protect_address = main_protection_agency_output.get(i).getAddress();
			String protect_phone_number = main_protection_agency_output.get(i).getPhone_number();
			String protect_count = Integer.toString(main_protection_agency_output.get(i).getCount());
			main_protection_agency_data[i][0] = protect_num;
			main_protection_agency_data[i][1] = protect_name;
			main_protection_agency_data[i][2] = protect_address;
			main_protection_agency_data[i][3] = protect_phone_number;
			main_protection_agency_data[i][4] = protect_count;

		}
		main_protection_agency_model = new DefaultTableModel(main_protection_agency_data, main_protection_agency_colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}

	public void member_data() {
		ArrayList<member> member_output = new ArrayList<member>();
		String member_colName[] = { "회원 아이디", "이름", "나이", "전화번호", "주소" }; // 컬럼명을 배열에 선언
		member_output = dao.member_sqlrun();
		int member_size = member_output.size();
		String member_data[][] = new String[member_size][5];
		for (int i = 0; i < member_output.size(); i++) {
			String member_id = member_output.get(i).getId();
			String member_name = member_output.get(i).getName();
			String member_age = Integer.toString(member_output.get(i).getAge());
			String member_phonenum = member_output.get(i).getPhoneNum();
			String member_address = member_output.get(i).getAddress();
			member_data[i][0] = member_id;
			member_data[i][1] = member_name;
			member_data[i][2] = member_age;
			member_data[i][3] = member_phonenum;
			member_data[i][4] = member_address;

		}
		member_model = new DefaultTableModel(member_data, member_colName) {
			public boolean isCellEditable(int rowIndex, int mColIndex) { // 목록(JTable) 값 수정 못하게 하는 메소드
				return false;
			}
		};
	}

	public void sub_alldog_data(int key1) {

		ArrayList<abandoned_dog> sub_alldog_output = new ArrayList<abandoned_dog>();

		sub_alldog_output = dao.read_abandoned_dog1(key1);

		String num = Integer.toString(sub_alldog_output.get(0).getNum());
		String name = sub_alldog_output.get(0).getName();
		String kind = sub_alldog_output.get(0).getKind();
		String gender = sub_alldog_output.get(0).getGender();
		String age = sub_alldog_output.get(0).getAge();
		String weight = sub_alldog_output.get(0).getWeight();
		String rescure_date = sub_alldog_output.get(0).getRescure_date();
		String discovery_place = sub_alldog_output.get(0).getDiscovery_place();
		String protect_num = sub_alldog_output.get(0).getProtect_num();
		String protection_agency = sub_alldog_output.get(0).getProtection_agency();

		sub_alldog_frame = new JFrame();
		sub_alldog_frame.setBounds(100, 100, 911, 403);
		sub_alldog_panel = new JPanel(); // 메인 패널 생성
		sub_alldog_panel.setBounds(0, 0, 897, 305);
		sub_alldog_frame.setContentPane(sub_alldog_panel);
		sub_alldog_panel.setLayout(null);

		String[] sub_alldog_headArr1 = { "유기견번호", "유기견이름", "유기견품종", "성별", "나이", "몸무게", "구조 일자", "보호등록번호", "보호기관번호" };

		for (int i = 0; i < sub_alldog_tLArray.length; i++) {
			sub_alldog_tLArray[i] = new JLabel(sub_alldog_headArr1[i], JLabel.CENTER);
			sub_alldog_tLArray[i].setBounds(0 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 100, 28);
			sub_alldog_panel.add(sub_alldog_tLArray[i]);
		}

		String[] sub_alldog_dataArr1 = { num, name, kind, gender, age, weight, rescure_date, protect_num, protection_agency };

		for (int i = 0; i < sub_alldog_tfArray.length; i++) {
			sub_alldog_tfArray[i] = new JTextField();
			sub_alldog_tfArray[i].setColumns(10);
			sub_alldog_tfArray[i].setBounds(100 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 127, 28);
			sub_alldog_panel.add(sub_alldog_tfArray[i]);
			sub_alldog_tfArray[i].setText(sub_alldog_dataArr1[i]);
		}

		sub_alldog_tA = new JTextArea();
		sub_alldog_tA.setColumns(10);
		sub_alldog_tA.setBounds(124, 256, 710, 64);
		sub_alldog_panel.add(sub_alldog_tA);
		sub_alldog_tA.setText(discovery_place);

		sub_alldog_Lb = new JLabel("발견장소", JLabel.CENTER);
		sub_alldog_Lb.setBounds(12, 256, 100, 64);
		sub_alldog_panel.add(sub_alldog_Lb);

		sub_alldog_frame.setVisible(true);

	}

	public void sub_missing_data(String key2) {

		ArrayList<missing> sub_missing_output = new ArrayList<missing>();

		sub_missing_output = dao.missing_record_sqlrun1(key2);

		String animal_num = sub_missing_output.get(0).getAnimal_num();
		String dog_name = sub_missing_output.get(0).getDog_name();
		String dog_kind = sub_missing_output.get(0).getDog_kind();
		String sex = sub_missing_output.get(0).getSex();
		String unique = sub_missing_output.get(0).getUnique();
		String miss_place = sub_missing_output.get(0).getMiss_place();
		String miss_time = sub_missing_output.get(0).getMiss_time();
		String miss_date = sub_missing_output.get(0).getMiss_date().toString();
		String id = sub_missing_output.get(0).getId();

		sub_missing_frame = new JFrame();
		sub_missing_frame.setBounds(100, 100, 911, 403);
		sub_missing_panel = new JPanel(); // 메인 패널 생성
		sub_missing_panel.setBounds(0, 0, 897, 305);
		sub_missing_frame.setContentPane(sub_missing_panel);
		sub_missing_panel.setLayout(null);

		String[] sub_missing_headArr2 = { "동물등록번호", "반려견이름", "반려견품종", "성별", "실종된시간", "실종된날짜", "신고자 아이디" };

		for (int i = 0; i < sub_missing_tLArray2.length; i++) {
			sub_missing_tLArray2[i] = new JLabel(sub_missing_headArr2[i], JLabel.CENTER);
			sub_missing_tLArray2[i].setBounds(0 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 100, 28);
			sub_missing_panel.add(sub_missing_tLArray2[i]);
		}

		String[] sub_missing_dataArr2 = { animal_num, dog_name, dog_kind, sex, miss_time, miss_date, id };

		for (int i = 0; i < sub_missing_tfArray2.length; i++) {
			sub_missing_tfArray2[i] = new JTextField();
			sub_missing_tfArray2[i].setColumns(10);
			sub_missing_tfArray2[i].setBounds(100 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 127, 28);
			sub_missing_panel.add(sub_missing_tfArray2[i]);
			sub_missing_tfArray2[i].setText(sub_missing_dataArr2[i]);
		}

		sub_missing_Lb1 = new JLabel("실종 장소", JLabel.CENTER);
		sub_missing_Lb1.setBounds(300, 190, 100, 28);
		sub_missing_tF = new JTextField();
		sub_missing_tF.setColumns(10);
		sub_missing_tF.setBounds(400, 190, 420, 28);
		sub_missing_tF.setText(miss_place);
		sub_missing_panel.add(sub_missing_Lb1);
		sub_missing_panel.add(sub_missing_tF);

		sub_missing_tA = new JTextArea();
		sub_missing_tA.setColumns(10);
		sub_missing_tA.setBounds(124, 256, 710, 64);
		sub_missing_panel.add(sub_missing_tA);
		sub_missing_tA.setText(unique);

		sub_missing_Lb2 = new JLabel("특이사항", JLabel.CENTER);
		sub_missing_Lb2.setBounds(12, 256, 100, 64);
		sub_missing_panel.add(sub_missing_Lb2);

		sub_missing_frame.setVisible(true);
	}

	// 입양 신청 창
	public void make_member_panel(String 보호기관번호, String 유기견번호) {
		member_frame = new JFrame(); // 프레임 생성
		member_frame.setBounds(100, 100, 800, 600);
		member_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		member_panel = new JPanel(); // 메인 패널 생성
		member_panel.setBounds(100, 100, 700, 500);
		member_frame.setContentPane(member_panel);
		member_data();
		member_table = new JTable(member_model); // 입력 받은 DB 데이터들을 JTable에 추가
		member_scroll = new JScrollPane(member_table, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		member_scroll.setBounds(0, 50, 500, 480); // 위치 설정
		member_panel.setLayout(null);
		member_Bt = new JButton("입양 신청서 작성");
		member_Bt.addActionListener(new ActionListener() { // 상세 정보 버튼
			public void actionPerformed(ActionEvent e) {
				int row = member_table.getSelectedRow();							// 목록에서 선택한 데이터의 행을 반환
				String 회원아이디 = (String) member_table.getModel().getValueAt(row, 0); 	// 데이터의 값을 반환
				System.out.println(회원아이디);
				dao.p_adoption(보호기관번호, 회원아이디, Integer.parseInt(유기견번호));
				JOptionPane.showMessageDialog(null, "입양 신청이 완료되었습니다.");
				member_frame.setVisible(false);
				make_main_frame();
			}
		});
//		JOptionPane.showMessageDialog(null, "6개월 이내에 입양기록이 있는 회원이므로 입양이 불가능합니다.",
//				"입양 조건 미충족", JOptionPane.WARNING_MESSAGE);									// 입양 미충족 메시지창
		member_Bt.setBounds(600, 200, 150, 30);
		member_panel.add(member_Bt);
		member_panel.add(member_scroll); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		member_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		member_frame.setVisible(true);
	}

	// 유기견 데이터 입력 창
	public void make_dogdata() {
		make_dogdata_frame = new JFrame(); // 프레임 생성
		make_dogdata_frame.setBounds(100, 100, 911, 500);
		make_dogdata_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		make_dogdata_panel = new JPanel(); // 메인 패널 생성
		make_dogdata_panel.setBounds(0, 0, 897, 480);
		make_dogdata_frame.setContentPane(make_dogdata_panel);
		make_dogdata_panel.setLayout(null);
		String[] make_dogdata_headArr3 = { "유기견이름", "유기견품종", "성별", "나이", "몸무게", "구조 일자", "보호기관번호" };

		for (int i = 0; i < make_dogdata_tLArray3.length; i++) {
			make_dogdata_tLArray3[i] = new JLabel(make_dogdata_headArr3[i], JLabel.CENTER);
			make_dogdata_tLArray3[i].setBounds(0 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 100, 28);
			make_dogdata_panel.add(make_dogdata_tLArray3[i]);
		}

		for (int i = 0; i < make_dogdata_tfArray3.length; i++) {
			make_dogdata_tfArray3[i] = new JTextField();
			make_dogdata_tfArray3[i].setColumns(10);
			make_dogdata_tfArray3[i].setBounds(100 + (300 * (i % 3)), 30 + (80 * ((int) (i / 3))), 127, 28);
			make_dogdata_panel.add(make_dogdata_tfArray3[i]);
		}

		make_dogdata_tA = new JTextArea();
		make_dogdata_tA.setColumns(10);
		make_dogdata_tA.setBounds(124, 256, 710, 64);
		make_dogdata_panel.add(make_dogdata_tA);
		in_discovery_place = make_dogdata_tA.getText();

		make_dogdata_Lb = new JLabel("발견장소", JLabel.CENTER);
		make_dogdata_Lb.setBounds(12, 256, 100, 64);
		make_dogdata_panel.add(make_dogdata_Lb);

		make_dogdata_Bt = new JButton("등록하기");
		make_dogdata_Bt.setBounds(600, 400, 150, 30);
		make_dogdata_panel.add(make_dogdata_Bt);

		make_dogdata_Bt.addActionListener(new ActionListener() { // 유기견 등록
			public void actionPerformed(ActionEvent e) {
				in_name = make_dogdata_tfArray3[0].getText();
				in_kind = make_dogdata_tfArray3[1].getText();
				in_gender = make_dogdata_tfArray3[2].getText();
				in_age = make_dogdata_tfArray3[3].getText();
				in_weight = make_dogdata_tfArray3[4].getText();
				in_rescure_date = make_dogdata_tfArray3[5].getText();
				in_protection_agency = make_dogdata_tfArray3[6].getText();
				in_discovery_place = make_dogdata_tA.getText();
				dao.insert_abandoned_dog(in_name, in_kind, in_gender, in_age, in_weight, in_rescure_date, in_discovery_place,in_protection_agency);
				JOptionPane.showMessageDialog(null, "유기견 정보가 입력되었습니다.");
				make_dogdata_frame.setVisible(false);
				main_frame.setVisible(false); // 메인화면 새로고침 느낌
				make_main_frame();				 // 메인화면 새로고침 느낌
			}
		});
		make_dogdata_frame.setVisible(true);
	}

	private void make_main_frame() {
		main_frame = new JFrame(); // 프레임 생성
		main_frame.setBounds(100, 100, 800, 600);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = new JPanel(); // 메인 패널 생성
		main_frame.setContentPane(main_panel); // 패널을 컨텐트 팬처럼 사용하기 위한 메소드
//		--------------------------------------------------------------------- 메인 UI

		main_dog_data();
		main_dog_panel = new JPanel(); // 유기견 패널 생성
		main_dog_table = new JTable(main_dog_model); // 입력 받은 DB 데이터들을 JTable에 추가
		main_dog_scroll = new JScrollPane(main_dog_table, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		main_dog_scroll.setBounds(0, 120, 600, 400); // 위치 설정
		main_dog_panel.setLayout(null);
		main_dog_panel.add(main_dog_scroll); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		main_dog_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		JtableMouseEvent Click1 = new JtableMouseEvent(main_dog_table); // 더블클릭시 상세정보
		main_dog_table.addMouseListener(Click1); //

		maindog_Bt1 = new JButton("입양 신청");
		maindog_Bt2 = new JButton("상세 정보");
		maindog_Bt3 = new JButton("유기견 등록");

		maindog_Bt1.setBounds(630, 120, 120, 30);
		maindog_Bt2.setBounds(630, 220, 120, 30);
		maindog_Bt3.setBounds(630, 320, 120, 30);

		main_dog_panel.add(maindog_Bt1);
		main_dog_panel.add(maindog_Bt2);
		main_dog_panel.add(maindog_Bt3);

		maindog_Bt1.addActionListener(new ActionListener() { // 입양 신청 버튼
			public void actionPerformed(ActionEvent e) {
				int row = main_dog_table.getSelectedRow();							// 목록에서 선택한 데이터의 행을 반환
				String 유기견번호 = (String) main_dog_table.getModel().getValueAt(row, 0); 	// 데이터의 값을 반환
				String 보호기관번호 = (String) main_dog_table.getModel().getValueAt(row, 4); 	// 데이터의 값을 반환
				System.out.println(유기견번호);
				System.out.println(보호기관번호);
				make_member_panel(보호기관번호,유기견번호);
				main_frame.setVisible(false);
			}
		});

		maindog_Bt2.addActionListener(new ActionListener() { // 상세 정보 버튼
			public void actionPerformed(ActionEvent e) {
				detail_page_int_key(main_dog_table);
			}
		});

		maindog_Bt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				make_dogdata();
			}
		});
		
		dog_search_text = new JTextField();
		dog_search_text.setBounds(120, 40, 400, 30);
		dog_search_text.setColumns(10);
		maindog_Bt4 = new JButton("검색하기");
		dog_search_Lb = new JLabel("지역 검색", JLabel.CENTER);
		dog_search_Lb.setBounds(20, 40, 100, 30);
		maindog_Bt4.setBounds(550, 40, 120, 30);
		maindog_Bt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search_str = dog_search_text.getText();
				main_dog_search_data(search_str);
				main_dog_table.setModel(main_search_dog_model);
			}
		});
		main_dog_panel.add(dog_search_text);
		main_dog_panel.add(dog_search_Lb);
		main_dog_panel.add(maindog_Bt4);
		
//		---------------------------------------------------------------------탭1

		main_missing_data();
		main_missing_panel = new JPanel(); // 실종 신고 패널 생성
		main_missing_table = new JTable(main_missing_model); // 입력 받은 DB 데이터들을 JTable에 추가
		main_missing_scroll = new JScrollPane(main_missing_table, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		main_missing_scroll.setBounds(0, 50, 600, 480); // 위치 설정
		main_missing_panel.setLayout(null);
		main_missing_panel.add(main_missing_scroll); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		main_missing_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		JtableMouseEvent2 Click2 = new JtableMouseEvent2(main_missing_table); // 더블클릭시 상세정보
		main_missing_table.addMouseListener(Click2); //
		main_missing_Bt1 = new JButton("상세 정보");
		main_missing_Bt2 = new JButton("삭제하기");
		main_missing_Bt1.addActionListener(new ActionListener() { // 상세 정보 버튼
			public void actionPerformed(ActionEvent e) {
				detail_page_str_key(main_missing_table);
			}
		});														// 내용 추가
		main_missing_Bt2.addActionListener(new ActionListener() { // 삭제하기 버튼
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "6개월 이내에 입양기록이 있는 회원이므로 입양이 불가능합니다.",
						"입양 조건 미충족", JOptionPane.WARNING_MESSAGE);// 입양 미충족 메시지창
				System.out.println("삭제하는 기능");
			}
		});
		main_missing_Bt1.setBounds(630, 50, 120, 30);
		main_missing_Bt2.setBounds(630, 150, 120, 30);
		main_missing_panel.add(main_missing_Bt1);
		main_missing_panel.add(main_missing_Bt2);
//		---------------------------------------------------------------------탭2

		main_adopt_data();
		main_adopt_panel = new JPanel(); // 입양신청 패널 생성
		main_adopt_table = new JTable(main_adopt_model); // 입력 받은 DB 데이터들을 JTable에 추가
		main_adopt_scroll = new JScrollPane(main_adopt_table, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		main_adopt_scroll.setBounds(0, 100, 770, 480); // 위치 설정
		main_adopt_panel.setLayout(null);
		main_adopt_panel.add(main_adopt_scroll); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		main_adopt_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		adopt_search_text1 = new JTextField();
		adopt_search_text1.setBounds(200, 40, 150, 30);
		adopt_search_text1.setColumns(10);
		adopt_search_text2 = new JTextField();
		adopt_search_text2.setBounds(350, 40, 150, 30);
		adopt_search_text2.setColumns(10);
		adopt_Bt = new JButton("검색하기");
		adopt_search_Lb = new JLabel("날짜(년,월) 검색", JLabel.CENTER);
		adopt_search_Lb.setBounds(80, 40, 90, 30);
		adopt_Bt.setBounds(550, 40, 120, 30);
		adopt_Bt.addActionListener(new ActionListener() { // 입양신청 버튼
			public void actionPerformed(ActionEvent e) {
				String year = adopt_search_text1.getText();
				String month = adopt_search_text2.getText();
				main_adopt_search_data(year,month);
				main_adopt_table.setModel(main_search_adopt_model);
			}
		});
		main_adopt_panel.add(adopt_search_text1);
		main_adopt_panel.add(adopt_search_text2);
		main_adopt_panel.add(adopt_search_Lb);
		main_adopt_panel.add(adopt_Bt);

//		---------------------------------------------------------------------탭3
		main_protection_agency_data();
		main_protection_agency_panel = new JPanel(); // 보호소 패널 생성
		main_protection_agency_table = new JTable(main_protection_agency_model); // 입력 받은 DB 데이터들을 JTable에 추가
		main_protection_agency_scroll = new JScrollPane(main_protection_agency_table, // 목록(JTable)에 스크롤 추가
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // 스크롤 안에 테이블을 추가(스크롤 옵션을 추가)
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		main_protection_agency_scroll.setBounds(0, 50, 770, 480); // 위치 설정
		main_protection_agency_panel.setLayout(null);
		main_protection_agency_panel.add(main_protection_agency_scroll); // 서브 패널에 스크롤 추가(스크롤안에 JTable이 추가되어있음)
		main_protection_agency_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		main_frame.setResizable(false); // 메인 GUI 크기 변경 불가
		main_panel.setLayout(null);
		pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setBounds(0, 0, 785, 590);
		pane.add("유기견 목록", main_dog_panel); // 탭(pane) >> 각 목록 gui 창(sub_panel) 유기견 탭에 유기견 목록 패널 추가
		pane.add("실종 신고 목록", main_missing_panel); // 실종 신고 탭에 유기견 목록 패널 추가
		pane.add("입양 신청 목록", main_adopt_panel); // 입양 신청 탭에 입양 신청 목록 패널 추가
		pane.add("보호소 목록", main_protection_agency_panel);
		main_frame.getContentPane().add(pane); // 프레임 >> 컨텐트팬(메인패널) >> 탭(pane)
		main_frame.setVisible(true); // 보이게 하는거

	}
}