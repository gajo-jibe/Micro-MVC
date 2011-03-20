package org.mmvc.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import javax.swing.Action;

import org.junit.Test;
import org.mmvc.core.annotation.ModelChanged;

/**
 * @author jbg
 * 
 */
public class InspectorTests
{
	@Test
	public void nominal()
	{
		MMVCType type = MMVCInspector.inspect( TestModel.class );
		assertNotNull( type );
		assertEquals( TestModel.class , type.getClassType() );
		MMVCActionType actionType = type.getAction( 0 );
		assertNotNull( actionType );
		assertEquals( "Increment Age" , actionType.getName() );

	}

	@Test
	public void invokeActionInModel()
	{
		MMVCActionType[] actions = MMVCInspector.inspectActions( TestModel.class );
		assertNotNull( actions );
		MMVCActionType actionType = actions[0];
		assertEquals( "Increment Age" , actionType.getName() );
		TestModel testModel = new TestModel();
		MMVCAction action = actionType.newAction( testModel );
		assertNotNull( action );
		assertEquals( "Increment Age" , action.getValue( Action.NAME ) );
		assertTrue( action.isEnabled() );
		//
		action.actionPerformed( null );
		assertEquals( 1 , testModel.getAge() );
		//
		action.actionPerformed( null );
		assertEquals( 2 , testModel.getAge() );

	}

	@Test
	public void modelHasChanged()
	{
		Method method = MMVCInspector.findAnnotatedMethod( TestView.class , ModelChanged.class );
		assertNotNull( method );
		assertEquals("updateViewWithModel",method.getName());
	}
	
	@Test
	public void modelHasChangedInType()
	{
		MMVCType type = MMVCInspector.inspect( TestView.class );
		Method method = type.modelChangedMethod;
		assertNotNull( method );
		assertEquals("updateViewWithModel",method.getName());

	}
}
