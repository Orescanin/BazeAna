package database;

import database.settings.Settings;
import lombok.AllArgsConstructor;
import lombok.Data;
import resource.DBNode;
import resource.DBNodeComposite;
import resource.data.Row;
import resource.enums.AttributeType;
import resource.enums.ConstraintType;
import resource.implementation.Attribute;
import resource.implementation.AttributeConstraint;
import resource.implementation.Entity;
import resource.implementation.InformationResource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class MSSQLrepository implements Repository {

	private Settings settings;
	private Connection connection;

	public MSSQLrepository(Settings settings) {
		this.settings = settings;
	}

	private void initConnection() throws SQLException, ClassNotFoundException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		String ip = (String) settings.getParameter("147.91.175.155");
		String database = (String) settings.getParameter("tim_22_bp2020");
		String username = (String) settings.getParameter("tim_22_bp2020");
		String password = (String) settings.getParameter("PAbLETPD");
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:jtds:sqlserver://" + ip + "/" + database, username, password);
	}

	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection = null;
		}
	}

	@Override
	public DBNode getSchema() {

		try {
			System.out.println("usao u try");
			this.initConnection();

			DatabaseMetaData metaData = connection.getMetaData();

			InformationResource ir = new InformationResource("RAF_BP_Primer");

			String tableType[] = { "TABLE" };
			ResultSet tables = metaData.getTables(connection.getCatalog(), null, null, tableType);

			while (tables.next()) {

				String tableName = tables.getString("TABLE_NAME");
				//System.out.println(tableName);

				Entity newTable = new Entity(tableName, ir);

				newTable.setParent(ir);

				ir.add(newTable);
				// System.out.println(ir.getChildren());

				// Koje atribute imaja ova tabela?

				ResultSet columns = metaData.getColumns(connection.getCatalog(), null, tableName, null);

				while (columns.next()) {

					String columnName = columns.getString("COLUMN_NAME");
					String columnType = columns.getString("TYPE_NAME");

					int columnSize = Integer.parseInt(columns.getString("COLUMN_SIZE"));
					Attribute attribute = new Attribute(columnName, newTable,
							AttributeType.valueOf(columnType.toUpperCase()), columnSize);
					attribute.setParent(newTable);
					newTable.add(attribute);

					//System.out.println(newTable.getChildren());

					ResultSet foreignKeys = metaData.getImportedKeys(connection.getCatalog(), null, newTable.getName());
					ResultSet primaryKeys = metaData.getPrimaryKeys(connection.getCatalog(), null, newTable.getName());
					String isNullable = columns.getString("IS_NULLABLE");
					String isDef=columns.getString("COLUMN_DEF");
					//System.out.println(isDef);
					
					if(attribute.getAttributeType()==null) {
						
						AttributeConstraint constraint = new AttributeConstraint("DOMAIN_VALUE", attribute,
								ConstraintType.DOMAIN_VALUE);
						constraint.setParent(attribute);
						attribute.addChild(constraint);
						
						
						
						
					}
					
					if (!(isNullable.equals("YES"))) {

						AttributeConstraint constraint = new AttributeConstraint("NOT_NULL", attribute,
								ConstraintType.NOT_NULL);
						constraint.setParent(attribute);
						attribute.addChild(constraint);

					}
					
				   if(isDef!=null) {
						AttributeConstraint constraint = new AttributeConstraint("DEFAULT_VALUE", attribute,
								ConstraintType.NOT_NULL);
						constraint.setParent(attribute);
						attribute.addChild(constraint);
						
						
					}

					while (primaryKeys.next()) {

						String columnkey = primaryKeys.getString("COLUMN_NAME");
						if (columnkey.equals(attribute.toString())) {
							AttributeConstraint constraint = new AttributeConstraint("PRIMARY_KEY", attribute,
									ConstraintType.PRIMARY_KEY);
							constraint.setParent(attribute);
							attribute.addChild(constraint);

						}

						while (foreignKeys.next()) {

							String fkcolumnkey = foreignKeys.getString("FKCOLUMN_NAME");
							
							if (fkcolumnkey.equals(attribute.toString())) {
								AttributeConstraint constraint = new AttributeConstraint("FOREIGN_KEY", attribute,
										ConstraintType.FOREIGN_KEY);
								constraint.setParent(attribute);
								attribute.addChild(constraint);

							}

						}

					}

				}
				

			}
			return ir;

			// TODO Ogranicenja nad kolonama? Relacije?

			

		} catch (Exception e) {
			System.out.println("uso ovde");
			e.printStackTrace();
		} finally {
			System.out.println("uzeo connect");
			this.closeConnection();
		}

		return null;
	}

	@Override
	public List<Row> get(String from) {

		List<Row> rows = new ArrayList<>();

		try {
			this.initConnection();

			String query = "SELECT * FROM " + from;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Row row = new Row();
				row.setName(from);

				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
					row.addField(resultSetMetaData.getColumnName(i), rs.getString(i));
				}
				rows.add(row);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeConnection();
		}

		return rows;
	}
}
