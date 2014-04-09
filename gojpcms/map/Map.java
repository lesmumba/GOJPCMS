package gojpcms.map;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

public class Map {	
	  // instance variables - replace the example below with your own
    double cords[];
    String location, title, description;
    public static int LATTITUDE = 0, LONGITUDE = 1; 
    ImageIcon img;
	String mapkey, typemap;
	int zoom = 14;

    public Map(String location, double x_cord, double y_cord)
    {
        // initialise instance variables
        this.cords = new double[2];
        this.cords[LATTITUDE] = x_cord;
        this.cords[LONGITUDE] = y_cord;
        this.location = location;
        img = new ImageIcon();
        this.mapkey = "AIzaSyA-Y2n0AoEnL9nRQPTB9UdYG4Hp92eiDvw";
        this.typemap = "roadmap";
    }
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public void setTooltip(String title, String description){
        this.description = description;
        this.title = title;
    }
    
    public void setCords(double[] cords ){
        this.cords = cords;
    }
    
    public double[] getCord(){
        return this.cords;
    }
    
    public void setCord(int cordinate, float value){
        this.cords[cordinate] = value;
    }
    
    public ImageIcon getMap(){
        cords[LATTITUDE] = getDouble(cords[LATTITUDE]);
        cords[LONGITUDE] = getDouble(cords[LONGITUDE]);
        try{
            System.out.println(cords[LATTITUDE]+" : " +cords[LONGITUDE]); 
            String mapkey = "";
			if(this.mapkey != null)
				mapkey = "&key="+this.mapkey;
			String mapurl = "http://maps.googleapis.com/maps/api/staticmap?center="+cords[LATTITUDE]+","+cords[LONGITUDE]+"&zoom="+zoom+"&size=500x400&maptype="+typemap+"&sensor=true"+mapkey+"";
			System.out.println(mapurl);
             img.setImage(getGoogleMap(mapurl).getImage()); 
        }catch(Exception e){
        	e.printStackTrace();
        }
        return img;
    }
    
    public double getDouble(double d){
        DecimalFormat twoDForm = new DecimalFormat("#.####");
        return Double.valueOf(twoDForm.format(d));
    }
    
    private ImageIcon getGoogleMap(String mapurl){
        URL url;
        ImageIcon imgcom =null;
        try {
            url = new URL(mapurl);
            URLConnection conn = url.openConnection();
            BufferedImage img=ImageIO.read(ImageIO.createImageInputStream(conn.getInputStream()));
            imgcom = new ImageIcon(img);	           
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgcom;
    }

}
