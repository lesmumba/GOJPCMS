package gojpcms;
import gojpcms.map.Map;

import javax.swing.*;
public class MapComponent {
	 public static void main(String [] args)
	    {
		 	 Map gmap = new Map("Kingston", 17.9833, -76.800);
	         JOptionPane.showMessageDialog(null,new JLabel(gmap.getMap()));
	    }
}
