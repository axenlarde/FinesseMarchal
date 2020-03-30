package com.alex.fal.action;

import java.util.ArrayList;

import com.alex.fal.misc.User;
import com.alex.fal.rest.RESTTools;
import com.alex.fal.utils.UsefulMethod;
import com.alex.fal.utils.Variables;

/**
 * Used to execute a logout task
 *
 * @author Alexandre RATEL
 */
public class Task extends Thread
	{
	/**
	 * Variables
	 */
	private TaskConfig config;
	
	public Task(TaskConfig config)
		{
		super();
		this.config = config;
		start();
		}

	public void run()
		{
		Variables.getLogger().info("Starting task "+config.getInfo());
		
		StringBuffer result = new StringBuffer("");
		result.append(UsefulMethod.getTargetOption("smtpemailcontent"));
		//For each agent we trigger a logout
		for(User u : config.getUserList())
			{
			result.append("- User '"+u.getUserID()+"' :");
			try
				{
				RESTTools.FinesseAgentLogout(config, u.getUserID());
				result.append("Success\r\n\t");
				}
			catch (Exception e)
				{
				Variables.getLogger().error("ERROR while loguing out agent '"+u.getUserID()+"' : "+e.getMessage());
				result.append("Error : "+e.getMessage()+"\r\n\t");
				}
			}
		
		Variables.getLogger().info("Task "+config.getInfo()+" ends");
		
		//We then send a mail with the task result
		UsefulMethod.sendEmailToTheAdminList(Variables.getSoftwareName()+" : Logout report", result.toString());
		}

	public TaskConfig getConfig()
		{
		return config;
		}

	public void setConfig(TaskConfig config)
		{
		this.config = config;
		}
	
	/*2020*//*RATEL Alexandre 8)*/
	}
