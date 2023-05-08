package util;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

public class Serializer {

	public static Object fromString( String str ){
		byte [] buff = Base64.getDecoder().decode( str );
		ObjectInputStream ois = null;
		Object obj = null;
		try{
			ois = new ObjectInputStream( new ByteArrayInputStream(buff) );
			obj  = ois.readObject();
		}catch(IOException e) {
			e.getMessage();
		}catch(ClassNotFoundException e) {
			e.getMessage();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				}catch(IOException e) {
				}
			}
		}
		return obj;
	}

	public static String toString( Serializable obj ){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos= new ObjectOutputStream( baos );
			oos.writeObject( obj );
		}catch(IOException e) {
			e.getMessage();
		}finally {
			if(oos != null) {
				try {
					oos.close();
				}catch(IOException e) {
				}
			}
		}
		return Base64.getEncoder().encodeToString(baos.toByteArray());
	}
}
