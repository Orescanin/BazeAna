package controller;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.TextStyle;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import resource.DBNode;
import resource.DBNodeComposite;
import resource.implementation.Attribute;
import resource.implementation.Entity;
import view.MainFrame;
import view.MyTab;
import view.MyTabPane;
import view.TableModel;

public class DoubleClickAction extends MouseAdapter {
	private DBNodeComposite nodePressed = null;
	private ArrayList<MyTab> tables = new ArrayList<>();
	private MyTabPane tabPane;
	private MyTabPane tabPane2;
	private JScrollPane jsc;
	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {
			nodePressed = (DBNodeComposite) MainFrame.getInstance().getStablo().getLastSelectedPathComponent();
			
		
			
			
			tabPane = MainFrame.getInstance().getTabPane();
			tabPane2=MainFrame.getInstance().getTabPane2();
			tabPane2.removeAll();
			if (nodePressed instanceof Entity) {
				
				JTable jTable=new JTable();
				TableModel model=new TableModel();
				MainFrame.getInstance().getAppCore().setTableModel(model);
				model.setRows(MainFrame.getInstance().getAppCore().getDatabase().readDataFromTable(nodePressed.getName()));
				//MainFrame.getInstance().getAppCore().getTableModel().setRows(MainFrame.getInstance().getAppCore().getDatabase().readDataFromTable(nodePressed.getName()));
				//jTable = MainFrame.getInstance().getjTable();
				MainFrame.getInstance().setJTableModel(jTable);
				JScrollPane jsc=new JScrollPane(jTable);
				tabPane.openTab(nodePressed, jsc);
				
				for (DBNode child : nodePressed.getChildren()) {
					Attribute relacija=((Attribute)child).getInRelationWith();
					if(relacija==null)
						continue;
					DBNodeComposite tabelaR=(DBNodeComposite) relacija.getParent();
					JTable jTable2=new JTable();
					TableModel model2=new TableModel();
					MainFrame.getInstance().getAppCore().setTableModel(model2);
					model2.setRows(MainFrame.getInstance().getAppCore().getDatabase().readDataFromTable(tabelaR.getName()));
					MainFrame.getInstance().setJTableModel(jTable2);
					JScrollPane jsc2=new JScrollPane(jTable2);
					tabPane2.openTab(tabelaR, jsc2);
					//if(tabPane.getTabCount()>1)
					//tabPane.setSelectedIndex(tabPane.getSelectedIndex()+1);
				}
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo());
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());
			}

		}
	}

}
