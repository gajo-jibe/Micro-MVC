package org.mmvc.core;

import java.util.HashMap;

import javax.swing.JToolBar;

/**
 * @author jbg
 * 
 */
public class MMVC
{
	private MMVC()
	{
		object_view = new HashMap<Object, MMVCView>();
		object_type = new HashMap<Object, MMVCType>();
	}

	/**
	 * View will be registered as View of provided model. View annotated methods
	 * will be inspected :
	 * <ul>
	 * <li>model notification methods : triggered when model changes</li>
	 * <li>actions related to View</li>
	 * <li>action in model</li>
	 * </ul>
	 * <p/>
	 * Moreover, if MMVC knows how to listen to the view (for instance, by
	 * inspecting jcomponent), any view modifications will trigger view actions
	 * update so that action enable state is up to date. If MMVC does not how to
	 * do that, refer to {@link #viewHasChanged(Object)}
	 * 
	 * @param view
	 * @param model
	 */
	public static void registerView(Object view, Object model)
	{
		MMVCView mmvcView = new MMVCView( view );
		MMVC.object_view.put( model , mmvcView );
		mmvcView.modelHasChanged();
	}

	/**
	 * Invoke this method when you know that the view has changed. When invoked,
	 * MMVC can update actions enable state.
	 * <p/>
	 * Refer to {@link #registerView(Object, Object)} for automatic view change
	 * 
	 * @param view
	 */
	public static void viewHasChanged(Object view)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Invoke this method when you know that the model has changed.
	 * <p/>
	 * When invoked, MMVC can notify all views and controllers of modified
	 * model.
	 * 
	 * @param view
	 */
	public static void modelHasChanged(Object model)
	{
		MMVCView view = MMVC.object_view.get( model );
		if (view == null)
		{
			return;
		}
		view.modelHasChanged();
	}

	/**
	 * create a toolBar containing actions found in provided objects
	 * 
	 * @param viewOrModel
	 * @return
	 */
	public static JToolBar newToolBar(Object viewOrModel)
	{
		// TODO Auto-generated method stub
		return new JToolBar();
	}

	// ///////////////////////////////////// MIGHT not be useful
	/**
	 * if controller implements actionListener, then any action performed will
	 * invoke @UpdateModelWithView
	 * 
	 * @param view
	 * @param controller
	 */
	public static void registerUpdateModelController(Object view, Object controller)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * if controller implements actionListener, then any action performed will
	 * invoke @ModelChanged
	 * 
	 * @param view
	 * @param controller
	 */
	public static void registerUpdateViewController(Object view, Object controller)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * reset all that have been registered including types ...
	 */
	public static void reset()
	{
		MMVC.object_view.clear();
		MMVC.object_type.clear();
	}

	/**
	 * @param object
	 * @return type of object
	 */
	public static MMVCType getType(Object object)
	{
		return getTypeForClass( object.getClass() );
	}

	/**
	 * @param objectClass
	 * @return type of objectClass
	 */
	private static MMVCType getTypeForClass(Class<? extends Object> objectClass)
	{
		MMVCType type = MMVC.object_type.get( objectClass );
		if (type == null)
		{
			type = MMVCInspector.inspect( objectClass );
			MMVC.object_type.put( objectClass , type );
		}
		return type;
	}

	private HashMap<Object, MMVCType> object_type;
	private HashMap<Object, MMVCView> object_view;
	public static MMVC MMVC = new MMVC();

}
