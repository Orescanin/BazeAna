package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


import resource.DBNodeComposite;
import resource.implementation.Entity;

public class MyTabPane extends JTabbedPane {
	
	private ArrayList<DBNodeComposite> nodes;
	private ArrayList<MyTab> tabs= new ArrayList<>();
	private MyTab myTab;
	private String imeTaba;
	
	
	public ArrayList<MyTab> getTabs() {
		return tabs;
	}
	public void setTabs(ArrayList<MyTab> tabs) {
		this.tabs = tabs;
	}
	
	public MyTabPane() {
		nodes=new ArrayList<>();
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
	}
	
	
	public void openTab(DBNodeComposite node, JScrollPane panel) {
		
		if(node instanceof Entity) {
			if(!nodes.contains(node)) {
				nodes.add(node);
				myTab=new MyTab(node.getName(), panel);
				
				imeTaba=node.getName();
				addTab(imeTaba,myTab);
				tabs.add(myTab);
				
			}
		}
		
		
		
	}
	
	
}
