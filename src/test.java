import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class test {

	private JFrame frame;
	private JPanel panel;
	private JTextField tF1, tF2, tF3, tF4, tF5, tF6, tF7, tF8;
	private JTextArea tF9;
	private JLabel Lb1, Lb2, Lb3, Lb4, Lb5, Lb6, Lb7, Lb8, Lb9;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new test();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		tF9 = new JTextArea();

		Lb1 = new JLabel("동물등록번호", JLabel.CENTER);
		Lb2 = new JLabel("반려견 이름", JLabel.CENTER);
		Lb3 = new JLabel("반려견 품종", JLabel.CENTER);
		Lb4 = new JLabel("성별", JLabel.CENTER);
		Lb5 = new JLabel("특이사항", JLabel.CENTER);
		Lb6 = new JLabel("실종장소", JLabel.CENTER);
		Lb7 = new JLabel("실종된시간", JLabel.CENTER);
		Lb8 = new JLabel("실종된날짜", JLabel.CENTER);
		Lb9 = new JLabel("신고자 아이디", JLabel.CENTER);

		tF1.setBounds(124, 31, 127, 28);
		panel.add(tF1);
		tF1.setColumns(10);

		tF2.setColumns(10);
		tF2.setBounds(416, 31, 127, 28);
		panel.add(tF2);

		tF3.setColumns(10);
		tF3.setBounds(707, 31, 127, 28);
		panel.add(tF3);

		tF6.setColumns(10);
		tF6.setBounds(707, 107, 127, 28);
		panel.add(tF6);

		tF4.setColumns(10);
		tF4.setBounds(124, 107, 127, 28);
		panel.add(tF4);

		tF5.setColumns(10);
		tF5.setBounds(416, 107, 127, 28);
		panel.add(tF5);

		tF7.setColumns(10);
		tF7.setBounds(124, 180, 127, 28);
		panel.add(tF7);

		tF8.setColumns(10);
		tF8.setBounds(416, 180, 127, 28);
		panel.add(tF8);

		tF9.setColumns(10);
		tF9.setBounds(124, 256, 710, 64);
		panel.add(tF9);
		tF9.setText("변수명");

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

		Lb9.setBounds(12, 256, 100, 64);
		panel.add(Lb9);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("a");
			
			}
		});
		btnNewButton.setBounds(720, 196, 97, 23);
		panel.add(btnNewButton);

		frame.setVisible(true);
		
	}
}
