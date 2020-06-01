package resource.implementation;

import javax.swing.tree.MutableTreeNode;

import lombok.Data;
import lombok.ToString;
import resource.DBNode;
import resource.DBNodeComposite;

@Data
@ToString(callSuper = true)
public class Entity extends DBNodeComposite {
	
	DBNodeComposite parent;

    public Entity(String name, DBNode parent) {
        super(name, parent);
        setParent(parent);
    }

    @Override
    public void addChild(DBNode child) {
        if (child != null && child instanceof Attribute){
            Attribute attribute = (Attribute) child;
            this.getChildren().add(attribute);
        }

    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.getName();
    }
    @Override
    public void setParent(MutableTreeNode newParent) {
    	// TODO Auto-generated method stub
    	parent=(DBNodeComposite) newParent;
    }
    
}
