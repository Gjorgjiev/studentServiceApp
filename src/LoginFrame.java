
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	JLabel userLabel = new JLabel("");
	JLabel passwordLabel = new JLabel("");
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JCheckBox showPassword = new JCheckBox("Show Password");
	private final JLabel lblX = new JLabel("X");

	LoginFrame() {
		getContentPane().setBackground(new Color(100, 149, 237));
		setLayoutManager();
		setLocationAndSize();
		addComponentsToContainer();
		addActionEvent();

	}

	public void setLayoutManager() {
	}

	public void setLocationAndSize() {

	}

	public void addComponentsToContainer() {
		getContentPane().setLayout(null);
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/username-screen.png")));
		userLabel.setBounds(128, 102, 57, 30);
		container.add(userLabel);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/lock-screen.png")));
		passwordLabel.setBounds(128, 172, 57, 30);
		container.add(passwordLabel);
		userTextField.setBounds(197, 102, 222, 30);
		container.add(userTextField);
		passwordField.setBounds(197, 172, 222, 30);
		container.add(passwordField);
		showPassword.setBackground(new Color(100, 149, 237));
		showPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		showPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		showPassword.setBounds(197, 199, 222, 30);
		container.add(showPassword);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginButton.setBackground(new Color(100, 149, 237));
		loginButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		loginButton.setBounds(197, 252, 100, 30);
		container.add(loginButton);
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		resetButton.setBackground(new Color(255, 69, 0));
		resetButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		resetButton.setBounds(319, 252, 100, 30);
		container.add(resetButton);

		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(197, 25, 222, 64);
		getContentPane().add(lblNewLabel);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(597, 0, 28, 30);

		getContentPane().add(lblX);
		setUndecorated(true);
	}

	public void addActionEvent() {
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginButton) {
			String userText;
			String pwdText;
			userText = userTextField.getText();
			pwdText = passwordField.getText();
			if (userText.equalsIgnoreCase("pmf") && pwdText.equalsIgnoreCase("pmf")) {
				JOptionPane.showMessageDialog(this, "Login Successful");
				dispose();
				TablePMF tblInfo = new TablePMF();
				tblInfo.setVisible(true);

			}else if(
				userText.equalsIgnoreCase("elektro") && pwdText.equalsIgnoreCase("elektro")) {
					JOptionPane.showMessageDialog(this, "Login Successful");
					dispose();
					TableElektro tblInfo = new TableElektro();
					tblInfo.setVisible(true);
			}else if(
					userText.equalsIgnoreCase("finki") && pwdText.equalsIgnoreCase("finki")) {
						JOptionPane.showMessageDialog(this, "Login Successful");
						dispose();
						TableFinki tblInfo = new TableFinki();
						tblInfo.setVisible(true);
			}else if(
				userText.equalsIgnoreCase("mfs") && pwdText.equalsIgnoreCase("mfs")) {
					JOptionPane.showMessageDialog(this, "Login Successful");
					dispose();
					TableMashinski tblInfo = new TableMashinski();
					tblInfo.setVisible(true);
		}
					else {
				JOptionPane.showMessageDialog(this, "Invalid Username or Password");
			}

		}

		if (e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}

		if (e.getSource() == showPassword) {
			if (showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
			} else {
				passwordField.setEchoChar('*');
			}

		}
	}
}
