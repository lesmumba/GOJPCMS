package gojpcms;

import gojpcms.project.Project;
import gojpcms.project.Project.ECONOMIC_SECTOR;
import gojpcms.project.Project.INFO;
import gojpcms.project.Project.TYPE;
import gojpcms.user.ProjectOfficer;
import gojpcms.user.User;
import gojpcms.util.CustomJPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProjectComponent {
	static JButton bn_addproject;
	
	@SuppressWarnings("serial")
	public static class ProjectListing extends CustomJPanel implements ActionListener{
		public ProjectListing(){
			super(new GridBagLayout());
			initiateView();
		}
		
		public void initiateView() {
			// TODO Auto-generated method stub
			GridBagConstraints cons =  new GridBagConstraints();
			User user = User.getCurrentUser();
			JPanel panel1 = new JPanel(new GridBagLayout());

			JLabel jl_user = new JLabel("Welcome, "+user.getUserId());
			cons.gridx = 0;
			cons.gridy = 0;
			panel1.add(jl_user, cons);
			
			bn_addproject = new JButton("Add Project");
			cons.gridx = 0;
			cons.gridy = 2;
			panel1.add(bn_addproject, cons);
			bn_addproject.addActionListener(this);			
			add(panel1);

			JPanel panel2 = new JPanel(new GridBagLayout());
			
			if(User.getCurrentUser() instanceof ProjectOfficer){
				ProjectOfficer owner = (ProjectOfficer) user;
				
				@SuppressWarnings("unchecked")
				ArrayList<String> project_ids = owner.getProjectOwned();				
				HashMap<String, Object> projects = Project.getProjects();
				if(project_ids.size() != 0 && projects.size() != 0){
					JLabel jl_projectid = new JLabel("Project Id");
					cons.gridx = 0;
					cons.gridy = 0;
					cons.gridwidth = 2;
					panel2.add(jl_projectid, cons);
					
					JLabel jl_projectname = new JLabel("Project Name");
					cons.gridx = 2;
					cons.gridy = 0;
					cons.gridwidth = 3;
					panel2.add(jl_projectname, cons);
					
					JLabel jl_projectdesc = new JLabel("Project Description");
					cons.gridx = 5;
					cons.gridy = 0;
					cons.gridwidth = 5;
					panel2.add(jl_projectdesc, cons);
					int gridy = 1;
					for(String project_id : project_ids){
						try{
							Project project = (Project) projects.get(project_id);
							
							jl_projectid = new JLabel(project.get(INFO.PROJECT_ID));
							cons.gridx = 0;
							cons.gridy = gridy;
							cons.gridwidth = 2;
							panel2.add(jl_projectid, cons);
							
							jl_projectname = new JLabel(project.get(INFO.PROJECT_NAME));
							cons.gridx = 2;
							cons.gridy = gridy;
							cons.gridwidth = 3;
							panel2.add(jl_projectname, cons);
							
							jl_projectdesc = new JLabel(project.get(INFO.PROJECT_DESCRIPTION));
							cons.gridx = 5;
							cons.gridy = gridy;
							cons.gridwidth = 5;
							panel2.add(jl_projectdesc, cons);
							
							gridy++;							
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					add(panel2);
				}
			}
			
			
			
			
			
			/*String[] a = new String[]{"sad","asd","asdad","ads"};
			JList list = new JList(a);
			list.setVisibleRowCount(3);
		    JScrollPane scroller = new JScrollPane(list);
		    add(scroller);*/
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(bn_addproject)){
				(new ProjectRegistration()).paint();
			}
		}		
	}
	
	
	@SuppressWarnings("serial")
	public static class ProjectRegistration extends CustomJPanel implements ActionListener{
		JTextField jt_projectname, jt_projectdesc, jt_projectlocation;
		@SuppressWarnings("rawtypes")
		JComboBox jc_types, jc_esector;
		JButton bn_register, bn_cancel;

		public ProjectRegistration(){
			super(new GridBagLayout());
			initiateView();
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void initiateView() {
			// TODO Auto-generated method stub
			GridBagConstraints cons = new GridBagConstraints();
			setBackground(Color.gray);
			Main.page = "login";
			cons.fill = GridBagConstraints.HORIZONTAL;
			cons.insets = new Insets(5, 5, 5, 5);

			JLabel jl_projectname = new JLabel("Project Name");
			cons.gridx = 0;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jl_projectname, cons);

			jt_projectname = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jt_projectname, cons);
			
			JLabel jl_projectdesc = new JLabel("Description");
			cons.gridx = 0;
			cons.gridy = 2;
			cons.gridwidth = 3;
			add(jl_projectdesc, cons);

			jt_projectdesc = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 2;
			cons.gridwidth = 3;
			add(jt_projectdesc, cons);
			
			JLabel jl_projectype = new JLabel("Type");
			cons.gridx = 0;
			cons.gridy = 4;
			cons.gridwidth = 3;
			add(jl_projectype, cons); 
			
			jc_types = new JComboBox(TYPE.toStringArray());
			jc_types.setSelectedIndex(0);
			cons.gridx = 3;
			cons.gridy = 4;
			cons.gridwidth = 3;
			add(jc_types, cons);
			//jc_types.addActionListener(this);	
			
			JLabel jl_projectesector = new JLabel("Economic Sector");
			cons.gridx = 0;
			cons.gridy = 6;
			cons.gridwidth = 3;
			add(jl_projectesector, cons); 
			
			jc_esector = new JComboBox(ECONOMIC_SECTOR.toStringArray());
			jc_esector.setSelectedIndex(0);
			cons.gridx = 3;
			cons.gridy = 6;
			cons.gridwidth = 3;
			add(jc_esector, cons);
			//jc_esector.addActionListener(this);			
			

			JLabel jl_location = new JLabel("Location");
			cons.gridx = 0;
			cons.gridy = 8;
			cons.gridwidth = 3;
			add(jl_location, cons);

			jt_projectlocation = new JTextField(25);
			cons.gridx = 3;
			cons.gridy = 8;
			cons.gridwidth = 3;
			add(jt_projectlocation, cons);

			bn_register = new JButton("Register");
			cons.gridx = 0;
			cons.gridy = 10;
			cons.gridwidth = 3;
			add(bn_register, cons);

			bn_cancel = new JButton("Go Back");
			cons.gridx = 3;
			cons.gridy = 10;
			cons.gridwidth = 3;
			add(bn_cancel, cons);

			bn_cancel.addActionListener(this);
			bn_register.addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(bn_register)){
				String projectname = jt_projectname.getText().toString();
				String projectdesc = jt_projectdesc.getText().toString();
				String projectype = (String) jc_types.getSelectedItem();
				String projectesector = (String) jc_esector.getSelectedItem();
				String projectlocation = jt_projectlocation.getText().toString();
				Project newproject = new Project(projectname, projectdesc, TYPE.exists(projectype));
				newproject.setEconomicSector(ECONOMIC_SECTOR.exists(projectesector));
				newproject.set(INFO.PROJECT_LOCATION, projectlocation);
				newproject.registerProject();
				(new ProjectInformation(newproject)).paint();
			}else if(e.getSource().equals(bn_cancel)){
				
			}			
		}
		
	}
	
	@SuppressWarnings("serial")
	public static class ProjectInformation extends CustomJPanel implements ActionListener{
		Project project;
		public ProjectInformation(Project project){
			super(new GridBagLayout());
			this.project = project;
			initiateView();
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void initiateView() {
			GridBagConstraints cons = new GridBagConstraints();
			setBackground(Color.gray);
			Main.page = "login";
			cons.fill = GridBagConstraints.HORIZONTAL;
			cons.insets = new Insets(5, 5, 5, 5);

			JLabel jl_projectname1 = new JLabel("Project Name");
			cons.gridx = 0;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jl_projectname1, cons);
			
			JLabel jl_projectname2 = new JLabel(project.get(INFO.PROJECT_NAME));
			cons.gridx = 3;
			cons.gridy = 0;
			cons.gridwidth = 3;
			add(jl_projectname2, cons);
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
