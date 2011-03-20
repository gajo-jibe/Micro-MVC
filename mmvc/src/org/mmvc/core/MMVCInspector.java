/**
 * 
 */
package org.mmvc.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.mmvc.core.annotation.Action;

/**
 * Class whose purpose is to inspect classes, methods by reflection
 * @author jbg
 * 
 */
public class MMVCInspector
{

	/**
	 * @param objectClass
	 * @return a new Type for this class
	 */
	public static MMVCType inspect(Class<?> objectClass)
	{
		MMVCType type = new MMVCType( objectClass );
		type.inspect();
		return type;
	}

	/**
	 * @param objectClass
	 * @return actions found while inspecting provided class
	 */
	public static MMVCActionType[] inspectActions(Class<?> objectClass)
	{
		Method[] methods = objectClass.getMethods();
		List<MMVCActionType> actions = new ArrayList<MMVCActionType>();
		for (Method method : methods)
		{
			if (method.isAnnotationPresent( Action.class ))
			{
				actions.add( new MMVCActionType( method ) );
			}
		}
		MMVCActionType[] actionArray = new MMVCActionType[actions.size()];
		int index = 0;
		for (MMVCActionType actionType : actions)
		{
			actionArray[index++] = actionType;
		}
		return actionArray;

	}

	/**
	 * 
	 * @param objectClass
	 * @param annotationClass
	 * @return first Method in provided class having annotationClass. 
	 */
	public static Method findAnnotatedMethod(Class<?> objectClass, Class<? extends Annotation> annotationClass)
	{
		for (Method method : objectClass.getMethods())
		{
			if (method.isAnnotationPresent( annotationClass ))
			{
				return method;
			}

		}
		return null;
	}

}
