package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import resource.DBNode;
import resource.DBNodeComposite;
import resource.implementation.Attribute;
import view.MainFrame;
import view.MyTabPane;
import view.TableModel;

public class ClickTabAction extends MouseAdapter {
	
	private MyTabPane tabPane;
	private MyTabPane tabPane2;
	private DBNodeComposite koren;
	private DBNodeComposite cvor;
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
		//if(tabPane.getSelectedComponent()==null)
		//	return;
		
		koren=(DBNodeComposite) MainFrame.getInstance().getStablo().getRoot();
		if (e.getClickCount() == 1) {
			
			tabPane=MainFrame.getInstance().getTabPane();
			tabPane2=MainFrame.getInstance().getTabPane2();
			String ime=tabPane.getTitleAt(tabPane.getSelectedIndex());
			cvor=(DBNodeComposite) koren.getChildByName(ime);
			tabPane2.removeAll();
			for (DBNode child : cvor.getChildren()) {
				Attribute relacija1=((Attribute)child).getInRelationWith();
				if(relacija1==null)
					continue;
				DBNodeComposite tabela=(DBNodeComposite) relacija1.getParent();
				JTable jTable3=new JTable();
				TableModel model3=new TableModel();
				MainFrame.getInstance().getAppCore().setTableModel(model3);
				model3.setRows(MainFrame.getInstance().getAppCore().getDatabase().readDataFromTable(tabela.getName()));
				MainFrame.getInstance().setJTableModel(jTable3);
				JScrollPane jsc3=new JScrollPane(jTable3);
				System.out.println("OVO JE JEBENA KOLONA OD TABABABABABA "+jTable3.getColumnName(0));
				tabPane2.addTab(tabela.getName(), jsc3);
			}
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getStablo());
		}
		
		
	
	}

	
}
