/**
 * TODO:license...
 */
package setools.gradle.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import setools.gradle.actions.dsl.ActionItem;
import setools.gradle.actions.dsl.StatusUpdate;
import setools.gradle.actions.dsl.internal.DefaultActionItem;
import setools.gradle.actions.dsl.internal.DefaultStatusUpdate;

/**
 * TODO:documentation...
 */
public class JDBCActionItemPlugin extends AbstractActionItemPlugin {

	public JDBCActionItemPlugin(Class<? extends ActionItemDatabase> classDatabase) {
		super(JDBCActionItemDatabase.class);
		// TODO Auto-generated constructor stub
	}

	/**
	 * TODO:documentation...
	 */
	public static class JDBCActionItemDatabase implements ActionItemDatabase {

		/**
		 * TODO:documentation...
		 */
		protected String url = null;
		
		/**
		 * TODO:documentation...
		 */
		protected String actionItemTable = "ACTION_ITEMS";
		
		/**
		 * TODO:documentation...
		 * @return
		 */
		public String getActionItemTable() {
			return actionItemTable;
		}
		
		/**
		 * TODO:documentation...
		 * @param table
		 */
		public void setActionItemTable(String table) {
			//TODO:validate table
			actionItemTable = table;
		}
		
		@Override
		public String getUrl() {
			return url;
		}

		@Override
		public void setUrl(String url) {
			//TODO:validate url
			this.url = url;
		}

		@Override
		public Collection<ActionItem> getActionItems() {
			if(!isNullOrEmpty(getUrl())) {
				try {
					Connection connection = DriverManager.getConnection(getUrl());
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(
							"SELECT * FROM " + getActionItemTable() + ";");
					ArrayList<ActionItem> results = new ArrayList<ActionItem>();
					while(resultSet.next()) {
						results.add(createActionItem(resultSet));
					}
					return results;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			//TODO: if not initialized or there is an error return an empty set
			return new ArrayList<ActionItem>();
		}
		
		protected ActionItem createActionItem(ResultSet resultSet) throws SQLException {
			String id = getString(resultSet,"id");
			String title = getString(resultSet,"title");
			Collection<StatusUpdate> status = getStatus(id);
			return new DefaultActionItem(id,title,status);
		}
		
		protected Collection<StatusUpdate> getStatus(String actionId) throws SQLException {
			ArrayList<StatusUpdate> results = new ArrayList<StatusUpdate>();
			Connection connection = DriverManager.getConnection(getUrl());
			Statement statement = connection.createStatement();
			String sql = String.format("SELECT * FROM '%s' WHERE action = '%s';",
					getActionItemTable(),actionId);
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				String id = getString(resultSet,"id");
				String action = getString(resultSet,"action");
				String notes = getString(resultSet,"notes");
				Date date = getDate(resultSet,"date");
				DefaultStatusUpdate update = new DefaultStatusUpdate(id,action,date,notes);
				results.add(update);
			}
			return results;
		}
		
		protected Date getDate(ResultSet data,String key) throws SQLException {
			ResultSetMetaData metadata = data.getMetaData();
			int len = metadata.getColumnCount();
			for(int x=0;x<len;x++) {
				String name = metadata.getColumnName(x);
				Object value = data.getObject(x);
				if(name.equals(key) && value instanceof Date)
					return (Date)value;
			}
			String msg = String.format("Column '%s' does not exist",key);
			throw new SQLException(msg);
		}
		
		protected String getString(ResultSet data,String key) throws SQLException {
			ResultSetMetaData metadata = data.getMetaData();
			int len = metadata.getColumnCount();
			for(int x=0;x<len;x++) {
				String name = metadata.getColumnName(x);
				Object value = data.getObject(x);
				if(name.equals(key) && value instanceof String)
					return (String)value;
			}
			String msg = String.format("Column '%s' does not exist",key);
			throw new SQLException(msg);
		}
				
		/**
		 * TODO:documentation...
		 * @param value
		 * @return
		 */
		protected static boolean isNullOrEmpty(String value) {
			return (value==null || value.isEmpty());
		}

		@Override
		public ActionItem addActionItem() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
