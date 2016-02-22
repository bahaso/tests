package mz.general;

import java.util.HashMap;
import java.util.Map;

public class Registry {

	private static Registry instance = new Registry();
	private Map<String,Object> obj = new HashMap<String,Object>();
	
	private Registry(){}
	
	public static Registry getInstance()
	{
		return instance;
	}
	
	public Object registry(String key, Object obj)
	{
		if(!this.obj.containsKey(key))this.obj.put(key, obj);
		return this.obj;
	}
	
	public Object registry(String key)
	{
		if(this.obj.containsKey(key))return this.obj.get(key);
		/*
		 * TO DO: Bikin class exception untuk menangani apabila registry tidak ditemukan. 
		 * Jika return null, maka harus terjadi validasi lagi di class yang memanggil function ini
		 * */
		return null;
	}
	
	public void removeRegistry(String key)
	{
		if(this.obj.containsKey(key))this.obj.remove(key);
	}
	
}
