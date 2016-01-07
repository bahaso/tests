package bahaso;

import java.net.MalformedURLException;
import mz.enumeration.Platform;

public class Device {
	private static Device instance;
	
	private Device(){}
	
	public static Device getInstance()
	{
		return instance;
	}
	
	public void InitiateDriver(Platform platform) throws MalformedURLException
	{
		switch (platform) 
		{
		case Android:
			
			break;
		case iOS:
			break;
		}
	}
}
