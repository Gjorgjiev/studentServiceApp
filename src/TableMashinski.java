import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TableMashinski extends JFrame {

	private JPanel contentPane;

	private JButton btnAccept;
	private JButton btnGetStudents;
	
	String[] column = { "ID", "Name", "Surname", "Age","Email", "Points","Major",
			"Diploma", "Testimony 1st year", "Testimony 2nd year", "Testimony 3rd year", "Testimony 4th year", "Birth Certificate"};
			String[][] scores = new String[8][15];
			JTable table = new JTable(scores, column);
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablePMF frame = new TablePMF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TableMashinski() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 781);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAccept = new JButton("Accept Student");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				}
			});
		btnAccept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {	
					int rowNumber = table.getSelectedRow();
					String id = (String) table.getValueAt(rowNumber, 0);
					URL url = new URL("http://localhost:8080/acceptedStudents?id=" +id);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("PUT");
					conn.connect();
					int responsecode = conn.getResponseCode();
					JOptionPane.showMessageDialog(null, "Student Accepted");
					}catch (Exception e2) {
						e2.printStackTrace();
					}						
			}
		});
		btnAccept.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAccept.setBounds(64, 511, 198, 87);
		contentPane.add(btnAccept);
		
		JButton btnDecline = new JButton("Decline Student");
		btnDecline.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {		
					int rowNumber = table.getSelectedRow();
					String id = (String) table.getValueAt(rowNumber, 0);
					URL url = new URL("http://localhost:8080/rejectedStudents?id=" +id);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("PUT");
					conn.connect();
					int responsecode = conn.getResponseCode();
					JOptionPane.showMessageDialog(null, "Student Rejected");
					}catch (Exception e2) {
						e2.printStackTrace();
					}	
			}
		});
		btnDecline.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDecline.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDecline.setBounds(675, 511, 198, 87);
		contentPane.add(btnDecline);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Manufacturing_Engineering");
		comboBox.addItem("Transport_Mechanization_and_Logistics");
		comboBox.addItem("Thermal_Engineering");
		comboBox.addItem("Hydraulic_Power_Engineering");
		comboBox.addItem("Industrial_Engineering_and_Management");
		comboBox.addItem("Materials_Processes_and_Innovation");
		comboBox.addItem("Energy_and_Environment");
		comboBox.addItem("Mechatronics");
		comboBox.addItem("Automation_and_System_Control");
		comboBox.addItem("Industrial_Design");
		comboBox.addItem("Motor_Vehicles");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(64, 75, 576, 32);
		contentPane.add(comboBox);
		
		btnGetStudents = new JButton("Get Students");
		btnGetStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ObjectMapper objectMapper = new ObjectMapper();				
				try {
					String item = comboBox.getSelectedItem().toString();
					URL url = new URL("http://localhost:8080/getStudents?major=" + item);
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					int responsecode = conn.getResponseCode();					
					StudentApplication[] studentApplication = objectMapper.readValue(url, StudentApplication[].class);
					table.setBackground(new Color(255, 255, 255));
					table.setBounds(64, 120, 809, 356);
					JScrollPane sp = new JScrollPane(table);
					table.setFillsViewportHeight(true);
					contentPane.add(table);
					contentPane.setSize(300, 400);
					contentPane.setVisible(true);
					contentPane.add(sp);
					
					for (int i=0; i<studentApplication.length; i++) {
						StudentApplication s = studentApplication[i];							
							scores[i][0] = s.getId().toString();
							scores[i][1] = s.getStudent().getName();
							scores[i][2] = s.getStudent().getSurname();
							scores[i][3] = s.getStudent().getAge() + "";
							scores[i][4] = s.getStudent().getEmail();
							scores[i][5] = s.getPoints().toString();
							scores[i][6] = s.getFaculty();
							scores[i][7] = s.getHighschoolDiploma();
							scores[i][8] = s.getTestimonyOfFirstYear();
							scores[i][9] = s.getTestimonyOfSecondYear();
							scores[i][10] = s.getTestimonyOfThirdYear();
							scores[i][11] = s.getTestimonyOfFourthYear();
							scores[i][12] = s.getBirthCertificate();											
							}

					table.setBackground(new Color(255, 255, 255));
					table.setBounds(64, 120, 809, 356);
					table.setFillsViewportHeight(true);
					contentPane.add(table);
					contentPane.setSize(300, 400);
					contentPane.setVisible(true);
					contentPane.add(sp);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnGetStudents.setBounds(691, 75, 182, 32);
		contentPane.add(btnGetStudents);
		
		
		
	}
}
