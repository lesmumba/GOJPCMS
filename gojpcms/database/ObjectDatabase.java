package gojpcms.database;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * @author Oshane Bailey
 * @category  Database Management
 * @version 1
 */
public class ObjectDatabase implements Serializable{
	/**
	 * @serial generated serialized number to aid in the encryption of the object
	 */
	private static final long serialVersionUID = -2145525264607194302L;
	ArrayList<Object> objects; //the set of objects to be stored
	Class<?> classname; //the class name of the objects to be stored
	/**
	 * ObjectDatabase is used to store a bundle of object of the same type in a serialize file based on the class name of that object
	 * This file is located in the assets/data folder under the object class.	
	 * @param classname is the class of object(s) the user wish to saved in the serialized object class file.
	 */
	public ObjectDatabase(Class<?> classname){
		this.classname = classname;
		this.objects = new ArrayList<Object>(); //initiate the ArrayList for the objects to be stored
 	}
	
	/**
	 * add method is used to added an object to be stored in the serialized object class file.
	 * @param object - takes a child object of the object class to be appended to the object ArrayList
	 */
	public void add(Object object){
		if(classname == object.getClass()){
			this.objects.add(object);
		}
	}
	
	/**
	 * savedObject method is used to commit or write the the current ObjectDatabase object to the object class file that is defined
	 * by the class name of the objects within the object ArrayList.
	 */
	public void saveObject(){
		try{
			System.out.println("Writing object to file "+this.classname.getClass().getSimpleName());
			FileOutputStream fout = new FileOutputStream("assets/data/"+this.classname.getSimpleName()+".ser");
			ObjectOutputStream obout = new ObjectOutputStream(fout);
			System.out.println(this.objects.get(0).toString());
			obout.writeObject(this);
			obout.close();
			System.out.println("Done!");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * getObject returns a ArrayList of objects which should be casted based on the classname of the object within the object
	 * ArrayList. 
	 * @example ArrayList<Object> object = objectDatabase.getObjects();
	 * User user = (User) object.get(1);
	 * @return ArrayList of objects the current ObjectDatabase object, which was stored or is to be stored.
	 */
	public ArrayList<Object> getObjects(){
		return objects;
	}
	
	/**
	 * getObject gets the object of based on the given input [not full implemented as yet]
	 * @return object based on the given input
	 */
	public Object getObject(){
		return null;
	}
	
	/**
	 * readDatabase gets the objects of the class that is given
	 * @param classname is the class name of the objects which were serialized
	 * @return an ObjectDatabase object which has a bundle of objects that was defined by the classname parameter.
	 * This object contains the object ArrayList of the bundle of objects which based on the classname. 
	 * {@link see getObject} 
	 */
	public ObjectDatabase readDatabase(Class<?> classname){
		try{
			FileInputStream fin = new FileInputStream("assets/data/"+this.classname.getSimpleName()+".ser");
			ObjectInputStream oreader = new ObjectInputStream(fin);
			ObjectDatabase obj = (ObjectDatabase) oreader.readObject();
			//objects = obj.getObjects();
			oreader.close();
			return obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}   
