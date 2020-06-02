package controller;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import resource.DBNodeComposite;
import resource.implementation.Entity;
import view.MainFrame;
import view.MyTab;
import view.MyTabPane;

public class DoubleClickAction extends MouseAdapter {
	private DBNodeComposite nodePressed = null;
	private ArrayList<MyTab> tables = new ArrayList<>();
	private MyTabPane tabPane = null;
	private JTable jTable;
	private JScrollPane jsc;
	

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {
			nodePressed = (DBNodeComposite) MainFrame.getInstance().getStablo().getLastSelectedPathComponent();
			
			
			tabPane = MainFrame.getInstance().getTabPane();
			if (nodePressed instanceof Entity) {
				
				
				MainFrame.getInstance().getAppCore().getTableModel().setRows(MainFrame.getInstance().getAppCore().getDatabase().readDataFromTable(nodePressed.getName()));
				jTable = MainFrame.getInstance().getjTable();
				tabPane.openTab(nodePressed, jTable);
				System.out.println(jTable.getColumnName(0));
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo());
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());
			}

		}
	}

}
