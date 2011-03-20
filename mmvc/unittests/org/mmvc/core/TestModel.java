package org.mmvc.core;

import org.mmvc.core.annotation.Action;

/**
 * 
 * @author jbg
 *
 */
public class TestModel
{

	public void setAdress(String adress)
	{
		this.adress = adress;
	}

	public String getAdress()
	{
		return adress;
	}

	@Action("Increment Age")
	public void incrementAge()
	{
		age++;
	}
	
	/**
	 * @return the age
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
	private int age;

	private String name,adress;
}
