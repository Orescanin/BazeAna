package app;

import database.Database;
import database.DatabaseImplementation;
import database.MSSQLrepository;
import database.settings.Settings;
import database.settings.SettingsImplementation;
import view.MainFrame;
import view.TableModel;
import lombok.Data;
import observer.Notification;
import observer.Publisher;
import observer.Subscriber;
import observer.enums.NotificationCode;
import observer.implementation.PublisherImplementation;
import resource.implementation.InformationResource;
import utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class AppCore extends PublisherImplementation {

	
    private Database database;
    private Settings settings;
    private TableModel tableModel;
    private InformationResource root;
 

    public AppCore() {
        this.settings = initSettings();
        this.database = new DatabaseImplementation(new MSSQLrepository(this.settings));
        tableModel = new TableModel();
      
    }

    private Settings initSettings() {
        Settings settingsImplementation = new SettingsImplementation();
        settingsImplementation.addParameter("147.91.175.155", Constants.MSSQL_IP);
        settingsImplementation.addParameter("tim_22_bp2020", Constants.MSSQL_DATABASE);
        settingsImplementation.addParameter("tim_22_bp2020", Constants.MSSQL_USERNAME);
        settingsImplementation.addParameter("PAbLETPD", Constants.MSSQL_PASSWORD);
        return settingsImplementation;
    }


    public void loadResource(){
        InformationResource ir = (InformationResource) this.database.loadResource();
        this.notifySubscribers(new Notification(NotificationCode.RESOURCE_LOADED,ir));
        MainFrame.getInstance().makeTree(ir);
        
    }

    public void readDataFromTable(String fromTable){

        tableModel.setRows(this.database.readDataFromTable(fromTable));

        //Zasto ova linija moze da ostane zakomentarisana?
        //this.notifySubscribers(new Notification(NotificationCode.DATA_UPDATED, this.getTableModel()));
    }


    public TableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(TableModel tableModel) {
        this.tableModel = tableModel;
    }


	public Database getDatabase() {
		return this.database;
	}

	public InformationResource getRoot() {
		return root;
	}

	


    


}
