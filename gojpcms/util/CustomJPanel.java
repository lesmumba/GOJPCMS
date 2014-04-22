package gojpcms.util;

import gojpcms.Main;

import java.awt.LayoutManager;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CustomJPanel extends JPanel {
	public CustomJPanel(LayoutManager layout) {
		// TODO Auto-generated constructor stub
		super(layout);
	}

	public void paint(){
		Main.repaintFrame(this);
	}
}
