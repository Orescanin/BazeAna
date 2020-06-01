package resource;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;


import observer.Publisher;




public abstract class DBNode extends DefaultMutableTreeNode {


	public DBNode(String name, DBNode parent) {
		
		this.name=name;
		this.parent=parent;
	}
	
    private String name;
    
    private DBNode parent;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setParent(MutableTreeNode newParent) {
		// TODO Auto-generated method stub
		this.parent=(DBNode) newParent;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return this.parent;
	}

	@Override
	public void add(MutableTreeNode newChild) {
		
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public TreeNode getChildAt(int index) {
		// TODO Auto-generated method stub
		return super.getChildAt(index);
	}
	
	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return super.getChildCount();
	}
	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void remove(MutableTreeNode aChild) {
		// TODO Auto-generated method stub
		super.remove(aChild);
	}
	@Override
	public void remove(int childIndex) {
		// TODO Auto-generated method stub
		super.remove(childIndex);
	}	
	@Override
	public int getIndex(TreeNode aChild) {
		// TODO Auto-generated method stub
		return super.getIndex(aChild);
	}
	
	@Override
	public void insert(MutableTreeNode newChild, int childIndex) {
		// TODO Auto-generated method stub
		super.insert(newChild, childIndex);
	}
	
	
	
	
    

}
