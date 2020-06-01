package view;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import resource.implementation.InformationResource;
import model.DBTreeModel;
import resource.DBNode;
import resource.DBNodeComposite;


public class MyTreeView extends JTree{
	

	private DBTreeModel model;
	private MyTreeEditor editor;
	private MyTreeRenderer renderer;
	private DBNode root;

	//private static InformationResource rootz= new InformationResource("root");
	
	public MyTreeView(DBNode root) {
		renderer=new MyTreeRenderer();
		editor=new MyTreeEditor(this,renderer);
		model = new DBTreeModel(root);
		this.root=root;
	
		//System.out.println(MainFrame.getInstance().getAppCore().getSisa());
		//rootz=(InformationResource) MainFrame.getInstance().getAppCore().loadResource();
	
		
		
		setEditable(true);
		setModel(model);
		setCellRenderer(renderer);
		setCellEditor(editor);
		setInvokesStopCellEditing(true);
	}

	









	public DBTreeModel getModel() {
		return model;
	}


	public DBNode getRoot() {
		return root;
	}
	
	
	
	

}
