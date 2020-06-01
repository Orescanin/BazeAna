package resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

@Data
@ToString(callSuper = true)
public abstract class DBNodeComposite extends DBNode {

    private List<DBNode> children;
    private DBNode parent;
    private String name;


    public DBNodeComposite(String name, DBNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
        this.parent=parent;
        this.name=name;
    }

    public DBNodeComposite(String name, DBNode parent, ArrayList<DBNode> children) {
        super(name, parent);
        this.children = children;
        this.parent=parent;
        this.name=name;
    }


    public abstract void addChild(DBNode child);
    
    @Override
	public void add(MutableTreeNode newChild) {
		// TODO Auto-generated method stub
		children.add((DBNodeComposite) newChild);
	}

    public DBNode getChildByName(String name) {
        for (DBNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

	public List<DBNode> getChildren() {
		return this.children;
	}
	
	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public TreeNode getChildAt(int index) {
		// TODO Auto-generated method stub
		return children.get(index);
	}
	
	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return children.size();
	}
	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void remove(MutableTreeNode aChild) {
		// TODO Auto-generated method stub
		children.remove(aChild);
	}
	
	@Override
	public void remove(int childIndex) {
		// TODO Auto-generated method stub
		children.remove(childIndex);
	}
	
	@Override
	public int getIndex(TreeNode aChild) {
		// TODO Auto-generated method stub
		return children.indexOf(aChild);
	}
	
	@Override
	public void insert(MutableTreeNode newChild, int childIndex) {
		
		if(this.children.contains(newChild)) {
			newChild.removeFromParent();
		}
		
		newChild.setParent(this);
		this.children.add(childIndex, (DBNode) newChild);
	}
	
	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return parent;
	}
    
	@Override
	public void setParent(MutableTreeNode newParent) {
		// TODO Auto-generated method stub
		this.parent=(DBNode) newParent;
	}
    

}
