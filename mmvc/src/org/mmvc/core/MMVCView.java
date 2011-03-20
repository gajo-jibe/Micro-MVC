package org.mmvc.core;

/**
 * @author jbg 18 mars 2011
 */
public class MMVCView
{

	public MMVCView(Object view)
	{
		this.view = view;
		this.type = MMVC.getType( view );
	}

	/**
	 * notify view that model has changed
	 */
	public void modelHasChanged()
	{
		type.notifyModelChange( view );
	}

	private MMVCType type;
	private Object view;

}
