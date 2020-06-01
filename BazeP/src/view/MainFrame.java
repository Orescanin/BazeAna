package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

import app.AppCore;
import controller.DoubleClickAction;
import model.DBTreeModel;
import observer.Notification;
import observer.Subscriber;
import observer.enums.NotificationCode;
import resource.DBNode;
import resource.DBNodeComposite;
import resource.implementation.InformationResource;

public class MainFrame extends JFrame implements Subscriber {
	
	
	private static MainFrame instance=null;
	
	private MenuBar menuBar= new MenuBar();
	
	private JTable jTable;
	//private TableModel tableModel=new TableModel();
	private AppCore appCore;
	
	private DBNode root;
	private MyTreeView stablo;
	private JSplitPane horizSplit;
	private MyTabPane tabPane;
	
	
	private MainFrame() {
		
		
		


		
		//jTable=new JTable(tableModel);
		
	    
		jTable = new JTable();
		tabPane=new MyTabPane();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth/2 , screenHeight/2 );
		setLocationRelativeTo(null);
		setTitle("BazeBaze");
		
		this.setJMenuBar(this.menuBar);
		JScrollPane jsc=new JScrollPane(tabPane);
		
		
		horizSplit=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
		horizSplit.setRightComponent(jsc);
		horizSplit.setDividerLocation(330);
		horizSplit.setOneTouchExpandable(false);
		this.add(horizSplit,BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		this.setVisible(true);
		
		
		
		
		
		
	}
	
	
	
	
	 public void setAppCore(AppCore appCore) {
	        this.appCore = appCore;
	        this.appCore.addSubscriber(this);
	        this.jTable.setModel(appCore.getTableModel());
	        //root=appCore.loadResource();
	    }
	 
	
	 
	 public static MainFrame getInstance() {
			if (instance == null)
				instance = new MainFrame();
			return instance;
		}

	    @Override
	    public void update(Notification notification) {

	        if (notification.getCode() == NotificationCode.RESOURCE_LOADED){
	            System.out.println((InformationResource)notification.getData());
	        }

	        else{
	            jTable.setModel((TableModel) notification.getData());
	        }

	    }
	    
	    public void makeTree(DBNode root) {
			// this.root=root;
			
			 stablo=new MyTreeView(root);
			
			 JPanel panel=new JPanel();
			 
			 panel.setBackground(Color.white);
			 panel.setLayout(new BorderLayout());
			 System.out.println(panel);
			 panel.add(stablo,BorderLayout.WEST);
			 horizSplit.setLeftComponent(panel);
			 horizSplit.setDividerLocation(145);
			 stablo.addMouseListener(new DoubleClickAction());
			
			 
			 
		 }
	    
	    public AppCore getAppCore() {
	    	System.out.println("mf appcore");
			return appCore;
			
		}




		public JTable getjTable() {
			return jTable;
		}




		public void setjTable(JTable jTable) {
			this.jTable = jTable;
		}




		public MyTabPane getTabPane() {
			return tabPane;
		}




		public void setTabPane(MyTabPane tabPane) {
			this.tabPane = tabPane;
		}




		public MyTreeView getStablo() {
			return stablo;
		}




		public void setStablo(MyTreeView stablo) {
			this.stablo = stablo;
		}
	    
		
	    
	
	
}