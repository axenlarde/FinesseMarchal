package com.alex.fal.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.alex.fal.misc.User;
import com.alex.fal.utils.UsefulMethod;
import com.alex.fal.utils.Variables;

/**
 * To store a task configuration
 *
 * @author Alexandre RATEL
 */
public class TaskConfig
	{
	/**
	 * Variables
	 */
	private String id,runTime,uccxhost,uccxport,uccxversion,uccxusername,uccxpassword,axlhost,axlport,axlversion,axlusername,axlpassword;
	private ArrayList<String> runDays;
	private ArrayList<User> userList;
	private int timeout;
	
	public TaskConfig(String id, String userFileName, String runTime, String uccxhost, String uccxport, String uccxversion,
			String uccxusername, String uccxpassword, String axlhost, String axlport, String axlversion,
			String axlusername, String axlpassword, ArrayList<String> runDays, int timeout) throws Exception
		{
		super();
		this.id = id;
		this.runTime = runTime;
		this.uccxhost = uccxhost;
		this.uccxport = uccxport;
		this.uccxversion = uccxversion;
		this.uccxusername = uccxusername;
		this.uccxpassword = uccxpassword;
		this.axlhost = axlhost;
		this.axlport = axlport;
		this.axlversion = axlversion;
		this.axlusername = axlusername;
		this.axlpassword = axlpassword;
		this.runDays = runDays;
		this.userList = UsefulMethod.initUserList(userFileName);
		this.timeout = timeout;
		}
	
	public String getInfo()
		{
		return id+" "+
				runTime;
		}
	
	public boolean isItLaunchedTime()
		{
		Date now = new Date();
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm",Locale.FRANCE);
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE",Locale.FRANCE);
		
		//Temp
		Variables.getLogger().debug("Is it launched time ? : "+dayFormat.format(now)+" : "+timeFormat.format(now));
		//temp
		
		if(runDays.contains(dayFormat.format(now)))
			{
			if(runTime.equals(timeFormat.format(now)))
				{
				Variables.getLogger().debug("It is time !");
				return true;
				}
			}
		
		return false;
		}

	public String getId()
		{
		return id;
		}

	public void setId(String id)
		{
		this.id = id;
		}

	public String getRunTime()
		{
		return runTime;
		}

	public void setRunTime(String runTime)
		{
		this.runTime = runTime;
		}

	public String getUccxhost()
		{
		return uccxhost;
		}

	public void setUccxhost(String uccxhost)
		{
		this.uccxhost = uccxhost;
		}

	public String getUccxport()
		{
		return uccxport;
		}

	public void setUccxport(String uccxport)
		{
		this.uccxport = uccxport;
		}

	public String getUccxversion()
		{
		return uccxversion;
		}

	public void setUccxversion(String uccxversion)
		{
		this.uccxversion = uccxversion;
		}

	public String getUccxusername()
		{
		return uccxusername;
		}

	public void setUccxusername(String uccxusername)
		{
		this.uccxusername = uccxusername;
		}

	public String getUccxpassword()
		{
		return uccxpassword;
		}

	public void setUccxpassword(String uccxpassword)
		{
		this.uccxpassword = uccxpassword;
		}

	public String getAxlhost()
		{
		return axlhost;
		}

	public void setAxlhost(String axlhost)
		{
		this.axlhost = axlhost;
		}

	public String getAxlport()
		{
		return axlport;
		}

	public void setAxlport(String axlport)
		{
		this.axlport = axlport;
		}

	public String getAxlversion()
		{
		return axlversion;
		}

	public void setAxlversion(String axlversion)
		{
		this.axlversion = axlversion;
		}

	public String getAxlusername()
		{
		return axlusername;
		}

	public void setAxlusername(String axlusername)
		{
		this.axlusername = axlusername;
		}

	public String getAxlpassword()
		{
		return axlpassword;
		}

	public void setAxlpassword(String axlpassword)
		{
		this.axlpassword = axlpassword;
		}

	public ArrayList<String> getRunDays()
		{
		return runDays;
		}

	public void setRunDays(ArrayList<String> runDays)
		{
		this.runDays = runDays;
		}

	public ArrayList<User> getUserList()
		{
		return userList;
		}

	public void setUserList(ArrayList<User> userList)
		{
		this.userList = userList;
		}

	public int getTimeout()
		{
		return timeout;
		}

	public void setTimeout(int timeout)
		{
		this.timeout = timeout;
		}
	

	
	
	/*2020*//*RATEL Alexandre 8)*/
	}
