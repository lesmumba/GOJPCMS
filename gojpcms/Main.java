package gojpcms;

import gojpcms.UserComponent.UserLoginPanel;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
	public static String page;
	static JFrame mframe;
	public static void main(String[] args){
		mframe = new JFrame("GOJPCMs User Login");
		show(new UserLoginPanel());
	}
	
	public static void repaintFrame(JPanel panel){
		mframe.setContentPane(panel);
		mframe.revalidate();
		mframe.repaint();
	}

	public static void show(JPanel panel){
		mframe.getContentPane().add(panel);
		mframe.setVisible(true);
		mframe.pack();
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setSize(700, 600);
	}

}
