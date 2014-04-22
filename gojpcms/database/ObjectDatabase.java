package gojpcms.database;

import gojpcms.util.Encryption;
import gojpcms.util.Encryption.TYPE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
/**
 * @author Oshane Bailey
 * @category  Database Management
 * @version 1
 */
public class ObjectDatabase implements Serializable{
	/**
	 * @serial generated serialized number to aid in the encryption of the object
	 */
	static final long serialVersionUID = -2145525264607194302L;
	HashMap<String, Object> objects; //the set of objects to be stored
	Class<?> classname; //the class name of the objects to be stored
	
	/**
	 * ObjectDatabase is used to store a bundle of object of the same type in a serialize file based on the class name of that object
	 * This file is located in the assets/data folder under the object class.	
	 * @param classname is the class of object(s) the user wish to saved in the serialized object class file.
	 */
	public ObjectDatabase(Class<?> classname){
		this.classname = classname;
		this.objects = new HashMap<String, Object>(); //initiate the ArrayList for the objects to be stored
 	}
	
	/**
	 * add method is used to added an object to be stored in the serialized object class file.
	 * @param object - takes a child object of the object class to be appended to the object ArrayList
	 */
	public void add(String id, Object object){
		if(classname == object.getClass()){
			this.objects.put(id, object);
		}
	}
	
	/**
	 * savedObject method is used to commit or write the the current ObjectDatabase object to the object class file that is defined
	 * by the class name of the objects within the object ArrayList.
	 */
	public void saveObject(){
		try{
			System.out.println("Writing object to file "+this.classname.getSimpleName());
			if(!(new File("assets/data/")).exists())
					new File("assets/data/").mkdirs();
			File file = new File("assets/data/"+Encryption.encrypt(TYPE.MD5, this.classname.getSimpleName())+".ser");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream obout = new ObjectOutputStream(fout);
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
	public HashMap<String, Object> getObjects(){
		return this.objects;
	}
	
	/**
	 * getObject gets the object of based on the given input [not full implemented as yet]
	 * @return object based on the given input
	 */
	public Object getObject(String id){
		return this.objects.get(id);
	}
	
	public Class<?> getObjectClass(){
		return this.classname;
	}
	
	/**
	 * readDatabase gets the objects of the class that is given
	 * @param classname is the class name of the objects which were serialized
	 * @return an ObjectDatabase object which has a bundle of objects that was defined by the classname parameter.
	 * This object contains the object ArrayList of the bundle of objects which based on the classname. 
	 * {@link see getObject} 
	 */
	public void readDatabase(){
		try{
			System.out.println("Getting object from file "+this.classname.getSimpleName());
			File file = new File("assets/data/"+Encryption.encrypt(TYPE.MD5, this.classname.getSimpleName())+".ser");
			FileOutputStream fout = new FileOutputStream(file);
			ObjectInputStream oreader = new ObjectInputStream(fin);
			ObjectDatabase obj = (ObjectDatabase) oreader.readObject();
			this.objects = obj.getObjects();
			this.classname = obj.getObjectClass();
			oreader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}   
