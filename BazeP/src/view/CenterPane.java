package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import model.DBTreeModel;



public class CenterPane extends JPanel {

	public MyTreeView stablo;

	public CenterPane(MyTreeView stablo) {
		
		System.out.println("mytree");
		
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		this.add(stablo,BorderLayout.WEST);
		
	}
}
