package gojpcms;

import gojpcms.user.ProjectOfficer;
import gojpcms.user.User;
import gojpcms.ProjectComponent.ProjectListing;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserComponent {

	public UserComponent() {
		// TODO Auto-generated constructor stub
	}

	public static class UserLoginPanel extends JPanel implements ActionListener {
		JButton bn_login, bn_register;
		JTextField jt_username, jt_password;
		JLabel jl_error;
		GridBagConstraints cons;
		String status_message;
		static ArrayList<String> login_attempts = new ArrayList<String>();
		static final long serialVersionUID = 1L;

		public UserLoginPanel() {
			super(new GridBagLayout());
			initiateView();
		}

		public void initiateView() {
			cons = new GridBagConstraints();
			setBackground(Color.gray);
			Main.page = "login";
			cons.fill = GridBagConstraints.HORIZONTAL;
			cons.insets = new Insets(5, 5, 5, 5);

			JLabel jl_username = new JLabel("Username");
			cons.gridx = 0;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jl_username, cons);

			jt_username = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jt_username, cons);

			JLabel jl_password = new JLabel("Password");
			cons.gridx = 0;
			cons.gridy = 2;
			cons.gridwidth = 3;
			add(jl_password, cons);

			jt_password = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 2;
			cons.gridwidth = 3;
			add(jt_password, cons);

			bn_login = new JButton("Login");
			cons.gridx = 3;
			cons.gridy = 4;
			cons.gridwidth = 3;
			add(bn_login, cons);

			bn_register = new JButton("Register");
			cons.gridx = 0;
			cons.gridy = 4;
			cons.gridwidth = 3;
			add(bn_register, cons);

			jl_error = new JLabel(status_message);
			cons.gridx = 0;
			cons.gridy = 6;
			cons.gridwidth = 6;
			add(jl_error, cons);

			bn_login.addActionListener(this);
			bn_register.addActionListener(this);
		}

		
		public void paint(){
			Main.repaintFrame(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(bn_login)){
				status_message = "";
				//if the user is on the login page and click the login button, then check user credentials else pass show the register page on click
				String username = jt_username.getText().toLowerCase();
				String password = jt_password.getText().toString();
				if(User.login(username, password)){
					(new ProjectListing()).paint();
				}
			}else if(e.getSource().equals(bn_register)){
				(new UserRegisterPanel()).paint();
			}
		}
	}

	public static class UserRegisterPanel extends JPanel implements
			ActionListener {
		JButton bn_login, bn_register;
		JTextField jt_username, jt_password, jt_firstname, jt_lastname;
		JLabel jl_error;
		GridBagConstraints cons;
		String status_message;
		static ArrayList<String> login_attempts = new ArrayList<String>();
		static final long serialVersionUID = 1L;

		public UserRegisterPanel() {
			super(new GridBagLayout());
			initiateView();
		}

		public void initiateView() {
			// TODO Auto-generated method stub
			cons = new GridBagConstraints();
			setBackground(Color.gray);
			Main.page = "login";
			cons.fill = GridBagConstraints.HORIZONTAL;
			cons.insets = new Insets(5, 5, 5, 5);

			JLabel jl_username = new JLabel("Username");
			cons.gridx = 0;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jl_username, cons);

			jt_username = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jt_username, cons);
			
			JLabel jl_firstname = new JLabel("Firstname");
			cons.gridx = 0;
			cons.gridy = 2;
			cons.gridwidth = 3;
			add(jl_firstname, cons);

			jt_firstname = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 2;
			cons.gridwidth = 3;
			add(jt_firstname, cons);
			
			JLabel jl_lastname = new JLabel("lastname");
			cons.gridx = 0;
			cons.gridy = 4;
			cons.gridwidth = 3;
			add(jl_lastname, cons);

			jt_lastname = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 4;
			cons.gridwidth = 3;
			add(jt_lastname, cons);

			JLabel jl_password = new JLabel("Password");
			cons.gridx = 0;
			cons.gridy = 6;
			cons.gridwidth = 3;
			add(jl_password, cons);

			jt_password = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 6;
			cons.gridwidth = 3;
			add(jt_password, cons);

			bn_login = new JButton("Login");
			cons.gridx = 3;
			cons.gridy = 8;
			cons.gridwidth = 3;
			add(bn_login, cons);

			bn_register = new JButton("Register");
			cons.gridx = 0;
			cons.gridy = 8;
			cons.gridwidth = 3;
			add(bn_register, cons);

			jl_error = new JLabel(status_message);
			cons.gridx = 0;
			cons.gridy = 10;
			cons.gridwidth = 6;
			add(jl_error, cons);

			bn_login.addActionListener(this);
			bn_register.addActionListener(this);
		}
		
		public void paint(){
			Main.repaintFrame(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(bn_login)){
				(new UserLoginPanel()).paint();				
			}else if(e.getSource().equals(bn_register)){
				String username = jt_username.getText().toLowerCase();
				String firstname = jt_firstname.getText().toString();
				String lastname = jt_lastname.getText().toString();
				String password = jt_password.getText().toString();
				ProjectOfficer user = new ProjectOfficer(username, firstname, lastname);
				user.setPassword(password);
				if(user.registerUser()){
					(new ProjectListing()).paint();
				}
			}
		}
	}

}
