package controller;

import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.TextStyle;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreeNode;

import resource.DBNode;
import resource.DBNodeComposite;
import resource.implementation.Attribute;
import resource.implementation.Entity;
import view.MainFrame;
import view.MyTabPane;
import view.TableModel;

public class DoubleClickAction extends MouseAdapter {
	private DBNodeComposite nodePressed = null;
	private MyTabPane tabPane;
	private MyTabPane tabPane2;
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
				MainFrame.getInstance().setJTableModel(jTable);
				JScrollPane jsc=new JScrollPane(jTable);
				if(tabPane.indexOfTab(nodePressed.getName())==-1)
				{
					
					tabPane.addTab(nodePressed.getName(), jsc);
				}
				else
				{
					tabPane.setSelectedIndex(tabPane.indexOfTab(nodePressed.getName()));
				}
				
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
					tabPane2.addTab(tabelaR.getName(), jsc2);
					tabPane.setSelectedIndex(tabPane.indexOfTab(nodePressed.getName()));
				}
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo());
			}

		}
	}

}
