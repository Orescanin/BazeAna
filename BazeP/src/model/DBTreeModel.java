package model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import resource.DBNode;
import resource.DBNodeComposite;
import resource.implementation.InformationResource;
import view.MainFrame;

public class DBTreeModel extends DefaultTreeModel {
	



	//static InformationResource root;

	private DBNode root;
	public DBTreeModel(TreeNode root) {
		super(root);
		this.root=(DBNode) root;

	}
/*
	public InformationResource getRoot() {
		return root;
||||||| .r70
=======

	public DBNodeComposite getRoot() {
		return rootz;
>>>>>>> .r72
	}

<<<<<<< .mine
	public static void setRoot(InformationResource root) {
		DBTreeModel.root = root;
||||||| .r70
=======
	public static void setRoot(InformationResource root) {
		DBTreeModel.rootz = rootz;
>>>>>>> .r72
	}
<<<<<<< .mine

	*/

	public DBNode getRoot() {
		return root;
	}


	
}
