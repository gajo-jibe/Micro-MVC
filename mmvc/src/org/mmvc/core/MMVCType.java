package org.mmvc.core;

import java.lang.reflect.Method;

import org.mmvc.core.annotation.ModelChanged;

/**
 * Holds all information found in a class by {@link MMVCInspector}
 * 
 * @author jbg
 * 
 */
public class MMVCType
{
	public MMVCType(Class<?> objectClass)
	{
		this.objectClass = objectClass;
	}

	public Class<?> getClassType()
	{
		return objectClass;
	}

	public void inspect()
	{
		actions = MMVCInspector.inspectActions( objectClass );
		modelChangedMethod = MMVCInspector.findAnnotatedMethod( objectClass , ModelChanged.class );
	}

	/**
	 * @param i
	 * @return
	 */
	public MMVCActionType getAction(int actionIndex)
	{
		return actions[actionIndex];
	}

	/**
	 * notify a change to object
	 * 
	 * @param object
	 */
	public void notifyModelChange(Object object)
	{
		try
		{
			modelChangedMethod.invoke( object );
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}

	protected Method modelChangedMethod;
	private MMVCActionType[] actions;
	private Class<?> objectClass;

}
