package gojpcms;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserComponent{

	public UserComponent() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] arg){
		JFrame frame = new JFrame();
		
		UserLoginPanel pn_usrlogin = new UserLoginPanel();
		frame.getContentPane().add(pn_usrlogin);
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.gray);
	}
	

	public static class UserLoginPanel extends JPanel implements ActionListener{
		/**
		 * 
		 */
		static final long serialVersionUID = 1L;
		JButton bn_login, bn_register;
		JTextField jt_username, jt_password;
		
		public UserLoginPanel(){
			loginView();
			setBackground(Color.gray);
			
		}
		

		public void loginView(){			
			bn_login = new JButton("Login");
			bn_register = new JButton("Register");
			
			bn_login.addActionListener(this);
			bn_register.addActionListener(this);
			
			jt_username = new JTextField(25);
			jt_password = new JTextField(25);
			
			add(jt_username);
			add(jt_password);
			add(bn_login);
			add(bn_register);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(bn_login)){
				String username = jt_username.getText().toString();
				String password = jt_password.getText().toString();
				//User
			}else{
				
			}
		}
	}
		
}
