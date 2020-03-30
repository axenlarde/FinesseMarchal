package com.alex.fal.action;

import com.alex.fal.utils.Variables;

/**
 * Used to manage Task
 *
 * @author Alexandre RATEL
 */
public class TaskManager extends Thread
	{
	/**
	 * Variables
	 */
	private boolean run = true;
	
	public TaskManager()
		{
		start();
		}	
	
	public void run()
		{
		while(run)
			{
			try
				{
				for(TaskConfig tc : Variables.getTaskList())
					{
					if(tc.isItLaunchedTime())startNewTask(tc);
					}
				
				this.sleep(60000);
				}
			catch (Exception e)
				{
				Variables.getLogger().error("ERROR while starting tasks : "+e.getMessage(),e);
				}
			}
		}
	
	/**
	 * To start a new task
	 */
	public void startNewTask(TaskConfig task)
		{
		//We remove expired task
		removeStaleTasks();
		
		//We check that the task doesn't exist
		boolean exists = false;
		
		for(Task t : Variables.getProcessingTask())
			{
			if(t.getConfig().getId().equals(task.getId()))
				{
				exists = true;
				break;
				}
			}
		
		if(!exists)
			{
			if(Variables.getProcessingTask().size() > Variables.getMaxTask())
				{
				Variables.getLogger().debug("Max task reached, cannot start a new task. Please end the current ones first");
				}
			else
				{
				Variables.getProcessingTask().add(new Task(task));
				}
			}
		}
	
	private void removeStaleTasks()
		{
		for(Task t : Variables.getProcessingTask())
			{
			if(!t.isAlive())
				{
				Variables.getProcessingTask().remove(t);
				removeStaleTasks();
				}
			}
		}
	
	/**
	 * To end the taskManager
	 */
	public void buy()
		{
		run = false;
		}
	
	
	/*2020*//*RATEL Alexandre 8)*/
	}
