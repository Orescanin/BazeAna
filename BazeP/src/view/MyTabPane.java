package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import resource.DBNodeComposite;
import resource.implementation.Entity;

public class MyTabPane extends JTabbedPane {
	
	private ArrayList<DBNodeComposite> nodes;
	private String imeTaba;
	
	
	
	
	public MyTabPane() {
		nodes=new ArrayList<>();
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}
	
	
	
	
	
}
