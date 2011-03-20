package org.mmvc.core;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.mmvc.core.annotation.Action;
import org.mmvc.core.annotation.ModelChanged;

/**
 * A form with name and address fields, with automatic OK,Reset and AutoNaming
 * buttons
 * 
 * @author jbg
 * 
 */
public class TestView extends JPanel
{
	public TestView(TestModel testModel)
	{
		this.testModel = testModel;
		// init
		name = new JTextField();
		address = new JTextField();
		age = new JTextField();

		// Layout
		JPanel modelPanel = new JPanel();
		modelPanel.add( name );
		modelPanel.add( address );
		modelPanel.add( age );
		add( CENTER , modelPanel );

		// 2 MMVC invocations
		MMVC.registerView( this , testModel );
		add( NORTH , MMVC.newToolBar( this ) );
	}

	/**
	 * Invoked when model has changed (so the view can be updated)
	 */
	@ModelChanged
	/**
	 * A reset action for reseting the view with current model value
	 */
	@Action("Reset")
	public void updateViewWithModel()
	{
		name.setText( testModel.getName() );
		address.setText( testModel.getAdress() );
		age.setText( Integer.toString( testModel.getAge() ));
	}

	// @UpdateModelWithView // might not be useful ???
	/**
	 * an OK action that validates model with current view value
	 */
	@Action("OK")
	public void updateModelWithView()
	{
		testModel.setName( name.getText() );
		testModel.setAdress( address.getName() );
		testModel.setAge( Integer.parseInt( age.getText() ) );
		
	}

	/**
	 * An action for setting automatic values into the view
	 */
	@Action("Auto Naming")
	public void setAutoName()
	{
		name.setText( "MyName" );
		address.setText( "MyAdress" );
	}

	private JTextField name, address, age;
	private TestModel testModel;

	private static final long serialVersionUID = 1L;

	// below methods are for testing purpose

	String getViewName()
	{
		return name.getText();
	}

	String getViewAddress()
	{
		return address.getText();
	}

	int getViewAge()
	{
		return Integer.parseInt( age.getText() );
	}
}
