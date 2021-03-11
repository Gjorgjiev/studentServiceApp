
import java.io.IOException;
import javax.swing.JFrame;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class Login {
	public static void main(String[] a) throws JsonParseException, JsonMappingException, IOException {
		LoginFrame frame = new LoginFrame();
		frame.setTitle("Login Form");
		frame.setVisible(true);
		frame.setBounds(10, 10, 370, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(320, 180, 629, 356);
		frame.setResizable(false);
			   
	}
	
}
