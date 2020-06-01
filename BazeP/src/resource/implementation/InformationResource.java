package resource.implementation;

import lombok.Data;
import lombok.ToString;
import resource.DBNode;
import resource.DBNodeComposite;


@Data
@ToString(callSuper = true)
public class InformationResource extends DBNodeComposite {
	
	private String name;
    public InformationResource(String name) {
        super(name, null);
        this.name=name;
    }

    @Override
    public void addChild(DBNode child) {
        if (child != null && child instanceof Entity){
            Entity entity = (Entity) child;
            this.getChildren().add(entity);
        }
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
}
