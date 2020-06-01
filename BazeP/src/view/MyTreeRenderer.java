package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;


import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;


public class MyTreeRenderer extends DefaultTreeCellRenderer{

	
	
	
	 public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
		      int row, boolean hasFocus){
		 
		    super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

			    
			  if(value instanceof AttributeConstraint)
				  setIcon(new ImageIcon(((new ImageIcon("Images\\notebook.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH))));
			  else
			  {
				  if(value instanceof Attribute)
					  setIcon(new ImageIcon(((new ImageIcon("Images\\document.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH))));
				  else if(value instanceof Entity) 
					  setIcon(new ImageIcon(((new ImageIcon("Images\\project.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH))));
			  
				  else {
					  
					  setIcon(new ImageIcon(((new ImageIcon("Images\\workspace.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH))));

				  }
			  }
			      
			    
			    return this;
			  }
	
	
	
}
