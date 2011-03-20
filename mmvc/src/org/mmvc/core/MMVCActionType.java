package org.mmvc.core;

import java.lang.reflect.Method;

import org.mmvc.core.annotation.Action;

/**
 * Contains all information related to an inspected Action. (kind of model of action)
 * @author jbg 18 mars 2011
 */
public class MMVCActionType
{
	public MMVCActionType(Method method)
	{
		this.method = method;
		this.actionName = method.getAnnotation( Action.class ).value();
	}

	public String getName()
	{
		return actionName;
	}

	public MMVCAction newAction(Object actionOwwner)
	{
		return new MMVCAction( this , actionOwwner );
	}

	/**
	 * @param actionOwner
	 */
	public void execute(Object actionOwner)
	{
		try
		{
			method.invoke( actionOwner );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private Method method;
	private String actionName;
}
