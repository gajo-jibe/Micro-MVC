package org.mmvc.core;

import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.TreeModel;

import org.mmvc.core.annotation.Action;
import org.mmvc.core.annotation.TreeSelection;

/**
 * A tree panel :
 * <ul>
 * 	<li>A JTree on the left </li> 
 * 	<li>A panel on the right to display selected node information</li>
 * 	<li>A toolbar & contextual menu containing actions related to selected node 
 * </ul>
 * @author jbg
 *  17 mars 2011
 */
public class TestTreeView extends JPanel
{
	public TestTreeView(TreeModel treeModel)
	{
		tree = new JTree(treeModel);
		
		MMVC.registerView(this,treeModel);
		
		add(BorderLayout.CENTER,tree);
		add(BorderLayout.NORTH,MMVC.newToolBar(this));
	}
	
	/**
	 * Should be invoked when tree selection is an object of class File
	 * how to retrieve TreeSelection ?
	 * 1) either MMVC inspects this JComponent and its descendants to find out a tree and then listens to its selectionListener
	 * 2) either there is an explicit relationship such as MMVC.registerTreeSelection(this,tree)
	 * 
	 * @param file
	 */
	@Action("Open File")
	public void openFile(@TreeSelection File file)
	{
		
	}
	
	/**
	 * This treeSelection is enabled when {@link #isEditFileEnabled(File)} is true
	 * @param file
	 */
	@Action("Edit File")
	public void editFile(@TreeSelection File file)
	{
		
	}
	
	//@IsActionEnabled : not really useful, association between an action and its enabler could be achieved by naming rule, or by:
	//@Action("Edit File",enabler="isEditFileEnabled" 
	public boolean isEditFileEnabled(File file)
	{
		return file.exists() && file.isFile();
	}
	
	
	private static final long serialVersionUID = 1L;
	private JTree tree;
	
}
