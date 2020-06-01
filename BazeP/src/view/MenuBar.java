package view;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
	
public MenuBar() {
		
		
		JMenu fileMenu = new JMenu("File");
		JMenu analyzeMenu = new JMenu("Analyze");
		JMenu windowMenu = new JMenu("Window");
		JMenu helpMenu = new JMenu("Help");
		
		this.add(fileMenu);
		this.add(analyzeMenu);
		this.add(windowMenu);
		this.add(helpMenu);
		
		add(Box.createHorizontalGlue());
	}

}
