package mz.driver;

import java.util.HashMap;
import java.util.Map;

public class Registry {

	Map<String,Object> mapping = new HashMap<String, Object>();
	
	public void register(String key, Object obj)
	{
		if(!mapping.containsKey(key) || !mapping.containsValue(obj))
			mapping.put(key, obj);
	}
	
	public Object getRegistry(String key)
	{
		return mapping.get(key);
	}
	
}
