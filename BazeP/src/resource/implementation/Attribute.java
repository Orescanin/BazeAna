package resource.implementation;

import javax.swing.tree.MutableTreeNode;

import lombok.Data;
import lombok.ToString;
import resource.DBNode;
import resource.DBNodeComposite;
import resource.enums.AttributeType;

@Data
@ToString(callSuper = true)
public class Attribute extends DBNodeComposite {


    private AttributeType attributeType;
    private int length;
    private Attribute inRelationWith;
    private DBNodeComposite parent;

    

    public Attribute(String name, DBNodeComposite parent, AttributeType attributeType, int length) {
        super(name, parent);
        this.attributeType = attributeType;
        this.length = length;
        this.attributeType=attributeType;
        setParent(parent);
    }

    @Override
    public void addChild(DBNode child) {
        if (child != null && child instanceof AttributeConstraint){
            AttributeConstraint attributeConstraint = (AttributeConstraint) child;
            this.getChildren().add(attributeConstraint);
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
    
    public AttributeType getAttributeType() {
		return attributeType;
	}
}
