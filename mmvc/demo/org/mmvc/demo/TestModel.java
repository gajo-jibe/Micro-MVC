package org.mmvc.demo;

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

	@Action("Default Action")
	public void action()
	{
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	private String name,adress;
}
