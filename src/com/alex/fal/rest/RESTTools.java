package com.alex.fal.rest;

import java.util.ArrayList;

import com.alex.fal.action.TaskConfig;
import com.alex.fal.utils.UsefulMethod;
import com.alex.fal.utils.Variables;
import com.alex.fal.utils.xMLGear;
import com.alex.fal.utils.Variables.agentStatus;
import com.alex.fal.utils.Variables.requestType;

public class RESTTools
	{
	
	/**
	 * To logout a finesse user
	 * 
	 * Need a supervisor account
	 */
	public static void FinesseAgentLogout(TaskConfig task, String userID) throws Exception
		{
		Variables.getLogger().debug("Agent "+userID+" logout request started");
		String uri = "https://"+task.getUccxhost()+":"+task.getUccxport()+"/finesse/api/User/"+userID;
		String content = "<User>"
				+ "	<state>LOGOUT</state>"
				+ "</User>";
			
		String reply = RESTGear.send(requestType.PUT, uri, content, task.getUccxusername(), task.getUccxpassword(), task.getTimeout());//To logout the agent
		
		Variables.getLogger().debug("Agent "+userID+" logout done !");
		}
	/*
	public static void FinesseAgentLogout(TaskConfig task, String userID) throws Exception
		{
		Variables.getLogger().debug("Agent "+userID+" logout request started");
		String uri = "https://"+task.getUccxhost()+":"+task.getUccxport()+"/finesse/api/User/"+userID;
		String logoutContent = "<User>"
				+ "	<state>LOGOUT</state>"
				+ "</User>";
			
		RESTRequest logout = new RESTRequest(logoutContent, requestType.PUT, uri, task.getTimeout(), task.getUccxusername(), task.getUccxpassword());
		logout.send();//To logout the agent
		
		Variables.getLogger().debug("Agent "+userID+" logout done !");
		}
	*/
	
	/**
	 * To get the given agent current status
	 * 
	 * Need administrator account
	 * 
	 * @throws Exception 
	 */
	public static agentStatus FinesseGetAgentStatus(TaskConfig task, String userID) throws Exception
		{
		Variables.getLogger().debug("Agent "+userID+" get status request started");
		String uri = "https://"+task.getUccxhost()+":"+task.getUccxport()+"/finesse/api/User/"+userID;
		String getStatusContent = "";
		
		RESTRequest getStatus = new RESTRequest(getStatusContent, requestType.GET, uri, task.getTimeout(), task.getUccxusername(), task.getUccxpassword());
		String reply = getStatus.send();//To get the agent status
		
		//We parse the reply
		reply = "<xml>"+reply+"</xml>";
		ArrayList<String> listParams = new ArrayList<String>();
		listParams.add("User");
		ArrayList<String[][]> parsedReply = xMLGear.getResultListTab(reply, listParams);
		agentStatus status = UsefulMethod.convertStringToAgentStatus(UsefulMethod.getItemByName("state", parsedReply.get(0)));
		
		Variables.getLogger().debug("Agent "+userID+" status retreived : "+status.name());
		return status;
		}
	
	/*2020*//*RATEL Alexandre 8)*/
	}
