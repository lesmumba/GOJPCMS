package gojpcms;

import gojpcms.project.Project;
import gojpcms.user.ProjectOfficer;
import gojpcms.user.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addProjectGUI extends JPanel implements ActionListener{

    String projectName, projectDescription, username, userPassword;
    JTextField projectNameField, projectDescriptionField, usernameField, userPasswordField;
    public void actionPerformed(ActionEvent e) {
        if ("addProject".equals(e.getActionCommand())) {
            projectName = projectNameField.getText();
            projectDescription = projectDescriptionField.getText();
            username = usernameField.getText();
            userPassword = userPasswordField.getText();
            ProjectOfficer newOfficer = new ProjectOfficer(username, "Oshane", "Bailey");
    		newOfficer.setPassword(userPassword);
    		newOfficer.registerUser();
    		User.login(username, userPassword);
    		User user = User.getCurrentUser();
    		
    		Project newProject = new Project(projectName, projectDescription, Project.TYPE.CAPITAL);
    		newProject.setEconomicSector(Project.ECONOMIC_SECTOR.SERVICE);
    		newProject.set(Project.INFO.PROJECT_LOCATION, "Spanish Town");
    		String id = newProject.get(Project.INFO.PROJECT_ID);
    		System.out.println("Project id, "+id);
    		newProject.registerProject();
    		Project newP = Project.getProject(id);
    		System.out.println("Project owner id, "+newP.get(Project.INFO.PROJECT_OWNER));
		
            
        }
    }  
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        /**
         * Project input fields.
         */
        JTextField projectNameField = new JTextField(25);
        JTextField projectDescriptionField = new JTextField(25);
        JLabel projectNameLabel = new JLabel("Project Name :");
        JLabel projectDescriptionLabel = new JLabel("Project Description :");
        
        /**
         * User login fields.
         */
        JTextField usernameField = new JTextField(25);
        JLabel usernameLabel = new JLabel("Username");
        JTextField userPasswordField = new JTextField(25);
        JLabel userPasswordLabel = new JLabel("Password");
        
        JButton submitButton = new JButton("Submit");
        submitButton.setActionCommand("addProject");
        
        GroupLayout.SequentialGroup leftToRight = layout.createSequentialGroup();
        GroupLayout.ParallelGroup column1 = layout.createParallelGroup();
        column1.addComponent(usernameLabel);
        column1.addComponent(userPasswordLabel);
        column1.addComponent(projectNameLabel);
        column1.addComponent(projectDescriptionLabel);
        
        GroupLayout.ParallelGroup column2 = layout.createParallelGroup();
        column2.addComponent(usernameField);
        column2.addComponent(userPasswordField);
        column2.addComponent(projectNameField);
        column2.addComponent(projectDescriptionField);
        column2.addComponent(submitButton);
        leftToRight.addGroup(column1);
        leftToRight.addGroup(column2);
        
        GroupLayout.SequentialGroup topToBottom = layout.createSequentialGroup();
        GroupLayout.ParallelGroup row0 = layout.createParallelGroup();
        row0.addComponent(usernameLabel);
        row0.addComponent(usernameField);
        GroupLayout.ParallelGroup row1 = layout.createParallelGroup();
        row1.addComponent(userPasswordLabel);
        row1.addComponent(userPasswordField);
        GroupLayout.ParallelGroup row2 = layout.createParallelGroup();
        row2.addComponent(projectNameLabel);
        row2.addComponent(projectNameField);
        GroupLayout.ParallelGroup row3 = layout.createParallelGroup();
        row3.addComponent(projectDescriptionLabel);
        row3.addComponent(projectDescriptionField);
        topToBottom.addGroup(row0);
        topToBottom.addGroup(row1);
        topToBottom.addGroup(row2);
        topToBottom.addGroup(row3);
        topToBottom.addComponent(submitButton);
        
        layout.setHorizontalGroup(leftToRight);
        layout.setVerticalGroup(topToBottom);
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}