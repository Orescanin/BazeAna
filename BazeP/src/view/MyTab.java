package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.LineBorder;

public class MyTab extends JScrollPane {
	private String name;
	private JTable content;
	private JScrollPane jsc;
	
	public MyTab(String name, JScrollPane content) {
		this.name=name;
		this.jsc=content;
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}
