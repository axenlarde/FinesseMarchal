package com.alex.fal.utils;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.alex.fal.action.Task;
import com.alex.fal.action.TaskConfig;


/**********************************
 * Used to store static variables
 * 
 * @author RATEL Alexandre
 **********************************/
public class Variables
	{
	/**
	 * Variables
	 */	
	/********************************************
	 * cucmAXLVersion
	 ***************************************/
	public enum cucmAXLVersion
		{
		version80,
		version85,
		version90,
		version91,
		version100,
		version105,
		version110,
		version115,
		version120,
		version125
		};
		
	public enum agentStatus
		{
		READY,
		NOT_READY,
		RESERVED,
		TALKING,
		LOGOUT,
		LOGIN,
		WORK,
		WORK_READY,
		HOLD,
		UNKNOWN
		}
	
	public enum requestType
		{
		GET,
		POST,
		PUT
		};
		
	//Misc
	private static String softwareName;
	private static String softwareVersion;
	private static cucmAXLVersion CUCMVersion;
	private static Logger logger;
	private static ArrayList<String[][]> tabConfig;
	private static eMailSender eMSender;
	private static String mainDirectory;
	private static String configFileName;
	private static String taskListFileName;
	private static String logFileName;
	
	//Langage management
	public enum language{english,french};
	private static String languageFileName;
	private static ArrayList<ArrayList<String[][]>> languageContentList;
	
	//Task
	private static ArrayList<TaskConfig> taskList;
	private static ArrayList<Task> processingTask;
	private static int maxTask;
    
    /**************
     * Constructor
     **************/
	public Variables()
		{
		mainDirectory = ".";
		configFileName = "configFile.xml";
		languageFileName = "languages.xml";
		taskListFileName = "taskList.xml";
		taskList = new ArrayList<TaskConfig>();
		processingTask = new ArrayList<Task>();
		}

	public static String getSoftwareName()
		{
		return softwareName;
		}

	public static void setSoftwareName(String softwareName)
		{
		Variables.softwareName = softwareName;
		}

	public static String getSoftwareVersion()
		{
		return softwareVersion;
		}

	public static void setSoftwareVersion(String softwareVersion)
		{
		Variables.softwareVersion = softwareVersion;
		}

	public static cucmAXLVersion getCUCMVersion()
		{
		return CUCMVersion;
		}

	public static void setCUCMVersion(cucmAXLVersion cUCMVersion)
		{
		CUCMVersion = cUCMVersion;
		}

	public static Logger getLogger()
		{
		return logger;
		}

	public static void setLogger(Logger logger)
		{
		Variables.logger = logger;
		}

	public static ArrayList<String[][]> getTabConfig()
		{
		return tabConfig;
		}

	public static void setTabConfig(ArrayList<String[][]> tabConfig)
		{
		Variables.tabConfig = tabConfig;
		}

	public static eMailSender geteMSender()
		{
		return eMSender;
		}

	public static void seteMSender(eMailSender eMSender)
		{
		Variables.eMSender = eMSender;
		}

	public static String getMainDirectory()
		{
		return mainDirectory;
		}

	public static void setMainDirectory(String mainDirectory)
		{
		Variables.mainDirectory = mainDirectory;
		}

	public static String getConfigFileName()
		{
		return configFileName;
		}

	public static void setConfigFileName(String configFileName)
		{
		Variables.configFileName = configFileName;
		}

	public static String getLogFileName()
		{
		return logFileName;
		}

	public static void setLogFileName(String logFileName)
		{
		Variables.logFileName = logFileName;
		}

	public static String getLanguageFileName()
		{
		return languageFileName;
		}

	public static void setLanguageFileName(String languageFileName)
		{
		Variables.languageFileName = languageFileName;
		}

	public static ArrayList<ArrayList<String[][]>> getLanguageContentList()
		{
		return languageContentList;
		}

	public static void setLanguageContentList(ArrayList<ArrayList<String[][]>> languageContentList)
		{
		Variables.languageContentList = languageContentList;
		}

	public static int getMaxTask()
		{
		return maxTask;
		}

	public static void setMaxTask(int maxTask)
		{
		Variables.maxTask = maxTask;
		}

	public static ArrayList<TaskConfig> getTaskList()
		{
		return taskList;
		}

	public static void setTaskList(ArrayList<TaskConfig> taskList)
		{
		Variables.taskList = taskList;
		}

	public static ArrayList<Task> getProcessingTask()
		{
		return processingTask;
		}

	public static void setProcessingTask(ArrayList<Task> processingTask)
		{
		Variables.processingTask = processingTask;
		}

	public static String getTaskListFileName()
		{
		return taskListFileName;
		}

	public static void setTaskListFileName(String taskListFileName)
		{
		Variables.taskListFileName = taskListFileName;
		}
	
	
	/*2019*//*RATEL Alexandre 8)*/
	}

