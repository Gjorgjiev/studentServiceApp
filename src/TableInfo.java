//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.Color;
//import javax.swing.JTable;
//import javax.swing.JTabbedPane;
//import javax.swing.JButton;
//import java.awt.ComponentOrientation;
//import javax.swing.JScrollPane;
//import javax.swing.JEditorPane;
//import javax.swing.JTextArea;
//import javax.swing.JLabel;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
//import java.awt.Font;
//import java.awt.Cursor;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import javax.swing.JComboBox;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class TableInfo extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//	private JButton btnAccept;
//	private JButton btnGetStudents;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TableInfo frame = new TableInfo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public TableInfo() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 960, 781);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(100, 149, 237));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//
//		btnAccept = new JButton("Accept Student");
//		btnAccept.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnAccept.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//			}
//		});
//		btnAccept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnAccept.setBounds(64, 511, 198, 87);
//		contentPane.add(btnAccept);
//
//		JButton btnDecline = new JButton("Decline Student");
//		btnDecline.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//			}
//		});
//		btnDecline.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		btnDecline.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnDecline.setBounds(675, 511, 198, 87);
//		contentPane.add(btnDecline);
//
//		JComboBox comboBox = new JComboBox();
//		comboBox.addItem("Teaching_Mathematics");
//		comboBox.addItem("Theoretical_Mathematics");
//		comboBox.addItem("Actuarial_and_Financial_Mathematics");
//		comboBox.addItem("Applied_Mathematics");
//		comboBox.addItem("Mathematics_Informatics");
//		comboBox.setSelectedItem(null);
//		comboBox.setBounds(64, 75, 576, 32);
//		contentPane.add(comboBox);
//
//		btnGetStudents = new JButton("Get Students");
//		btnGetStudents.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ObjectMapper objectMapper = new ObjectMapper();
//				try {
//					String item = comboBox.getSelectedItem().toString();
//					URL url = new URL("http://localhost:8080/getStudents?major=" + item);
//					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//					conn.setRequestMethod("GET");
//					conn.connect();
//					int responsecode = conn.getResponseCode();
//					StudentApplication[] studentApplication = objectMapper.readValue(url, StudentApplication[].class);
//					String[] column = { "ID", "Name", "Surname", "Age","Email", "Points","Major"
//							, "Diploma", "Testimony 1st year", "Testimony 2nd year", "Testimony 3rd year", "Testimony 4th year", "Birth Certificate"};
//					String[][] scores = new String[5][13];
//					for (StudentApplication s : studentApplication) {
//						Integer id = s.getId();
//						String name = s.getStudent().getName();
//						String surname = s.getStudent().getSurname();
//						double age = s.getStudent().getAge();											
//						String email = s.getStudent().getEmail();
//						Integer points = s.getPoints();
//						String faculty = s.getFaculty();
//						String highschoolDiploma = s.getHighschoolDiploma();
//						String testimonyOfFirstYear = s.getTestimonyOfFirstYear();
//						String testimonyOfSecondYear = s.getTestimonyOfSecondYear();
//						String testimonyOfThirdYear = s.getTestimonyOfThirdYear();
//						String testimonyOfFourthYear = s.getTestimonyOfFourthYear();
//						String birthCertificate = s.getBirthCertificate();
//												
//						scores[0][0] = id.toString();
//						scores[0][1] = name;
//						scores[0][2] = surname;
//						scores[0][3] = age + "";										
//						scores[0][4] = email;
//						scores[0][5] = points.toString();						
//						scores[0][6] = faculty;
//						scores[0][7] = highschoolDiploma;
//						scores[0][8] = testimonyOfFirstYear;
//						scores[0][9] = testimonyOfSecondYear;
//						scores[0][10] = testimonyOfThirdYear;
//						scores[0][11] = testimonyOfFourthYear;
//						scores[0][12] = birthCertificate;
//					}
//					JTable table = new JTable(scores, column);
//					table.setFillsViewportHeight(true);
//					table.setBackground(new Color(255, 255, 255));
//					table.setBounds(64, 120, 809, 356);
//					JScrollPane sp = new JScrollPane();
//					contentPane.add(sp);
//					contentPane.setSize(300, 400);
//					contentPane.setVisible(true);
//					contentPane.add(table);
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//
//			}
//		});
//		btnGetStudents.setBounds(691, 75, 182, 32);
//		contentPane.add(btnGetStudents);
//
//	}
//}
