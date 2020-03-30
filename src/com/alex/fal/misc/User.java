package com.alex.fal.misc;


/**
 * User
 *
 * @author Alexandre RATEL
 */
public class User
	{
	/**
	 * Variables
	 */
	private String userID,LastName,FirstName;

	public User(String userID, String lastName, String firstName)
		{
		super();
		this.userID = userID;
		LastName = lastName;
		FirstName = firstName;
		}

	public String getUserID()
		{
		return userID;
		}

	public void setUserID(String userID)
		{
		this.userID = userID;
		}

	public String getLastName()
		{
		return LastName;
		}

	public void setLastName(String lastName)
		{
		LastName = lastName;
		}

	public String getFirstName()
		{
		return FirstName;
		}

	public void setFirstName(String firstName)
		{
		FirstName = firstName;
		}
	
	/*2020*//*RATEL Alexandre 8)*/
	}
