package resource.implementation;

import lombok.Data;
import lombok.ToString;
import resource.DBNode;
import resource.DBNodeComposite;
import resource.enums.ConstraintType;

@Data
@ToString(callSuper = true)
public class AttributeConstraint extends DBNode {

    private ConstraintType constraintType;
    private DBNode parent;
    private String name;

    public AttributeConstraint(String name, DBNode parent, ConstraintType constraintType) {
        super(name, parent);
        this.constraintType = constraintType;
        this.parent=parent;
        this.name=name;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
    
    
}
