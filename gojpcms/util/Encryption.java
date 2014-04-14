package gojpcms.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	String entype;
	public static enum TYPE{
		MD5("MD5"), SHA("SHA");
		private String value;
		private TYPE(String value) {
			this.value = value;
		}
	}
	public static String encrypt(TYPE type, String str) {
		// TODO Auto-generated constructor stub
		try {
			MessageDigest md = MessageDigest.getInstance(type.value);		
			md.update(str.getBytes());
			byte[] digest = md.digest();
			StringBuffer sb = new StringBuffer();
			for (byte b : digest) {
				sb.append(String.format("%02x", b & 0xff));
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
