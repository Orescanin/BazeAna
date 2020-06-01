package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

public class MyTab extends JScrollPane {
	private String name;
	private JScrollPane content;
	private JPanel panel;
	
	public MyTab(String name, JScrollPane content) {
		this.name=name;
		this.content=content;
		panel=new JPanel();
		
		//add(panel);
		panel.setLayout(new BorderLayout());
		panel.add(content, BorderLayout.CENTER);
		this.add(panel);
		
		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}
	
	
	public JScrollPane getContent() {
		return content;
	}

	public void setContent(JScrollPane content) {
		this.content = content;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	

}
