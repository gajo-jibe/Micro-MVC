package org.mmvc.core;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author jbg 18 mars 2011
 */
public class ModelViewTest
{
	@Test
	public void nominal()
	{
		MMVC.reset();
		TestModel model = new TestModel();
		model.setName( "name" );
		model.setAdress( "address" );
		model.setAge( 18 );

		TestView view = new TestView( model );
		MMVC.registerView( view , model );
		// make sure view is initialized with model
		assertEquals( "name" , view.getViewName() );
		assertEquals( "address" , view.getViewAddress() );
		assertEquals( 18 , view.getViewAge() );

		// Change model value
		model.setName( "name2" );
		model.setAdress( "address" );
		model.setAge( 19 );
		// notify model change
		MMVC.modelHasChanged( model );
		// make sure view reflects model change
		assertEquals( "name2" , view.getViewName() );
		assertEquals( "address" , view.getViewAddress() );
		assertEquals( 19 , view.getViewAge() );
	}

	@Test
	@Ignore
	public void actions()
	{

	}
}
