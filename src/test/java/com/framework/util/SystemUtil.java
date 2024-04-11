package com.framework.util;

public class SystemUtil {

	public  String getOSDetails() throws Exception {
		String OS = System.getProperty("os.name");
		OS = (OS).toUpperCase();
		//System.out.println(OS);
		return OS;
	}

	public  String getHostDetails() throws Exception {

		String strMachinerName=System.getenv("COMPUTERNAME");
		return strMachinerName;

	}

	public  String GetUserName()
	{
		String strUserName = System.getProperty("user.name");//user with domain
		//string strUserName = Environment.UserName;//only user
		return strUserName;
	}




	}
