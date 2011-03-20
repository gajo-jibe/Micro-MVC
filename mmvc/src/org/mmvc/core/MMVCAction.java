package org.mmvc.core;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * An {@link Action} based of {@link MMVCActionType}
 * Corresponds to an instantiation of action type for an object
 * @author jbg 18 mars 2011
 */
public class MMVCAction extends AbstractAction
{

	/**
	 * @param mmvcActionType
	 * @param actionOwwner
	 */
	public MMVCAction(MMVCActionType mmvcActionType, Object actionOwner)
	{
		super( mmvcActionType.getName() );
		this.mmvcActionType = mmvcActionType;
		this.actionOwner = actionOwner;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		mmvcActionType.execute( actionOwner );
	}

	private MMVCActionType mmvcActionType;
	private Object actionOwner;

	private static final long serialVersionUID = 1L;
}
