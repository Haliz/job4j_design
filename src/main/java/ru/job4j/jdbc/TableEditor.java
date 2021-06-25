package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;


    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }


    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = properties.getProperty("hibernate.connection.url");
        String login = properties.getProperty("hibernate.connection.username");
        String password = properties.getProperty("hibernate.connection.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    private void sqlExecute(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS %s(%s, %s);",
                tableName,
                "id serial primary key",
                "name varchar(255)");
        sqlExecute(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format(
                "DROP TABLE %s;", tableName);
        sqlExecute(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format(
                "ALTER TABLE %s ADD %s %s;", tableName, columnName, type);
        sqlExecute(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format(
                "ALTER TABLE %s DROP COLUMN %s;", tableName, columnName);
        sqlExecute(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName);
        sqlExecute(sql);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
// Этот метод сделал для проверки работы.

    public static void main(String[] args) throws Exception {
        try (FileInputStream fin = new FileInputStream("app1.properties")) {
            Properties map = new Properties();
            map.load(fin);
            TableEditor tableEditor = new TableEditor(map);
//            tableEditor.createTable("garry");
//            tableEditor.addColumn("garry", "First_name", "varchar(255)");
//            tableEditor.renameColumn("garry", "First_name", "Last_name");
//            tableEditor.dropColumn("garry", "Last_name");
//            System.out.println(tableEditor.getScheme("garry"));
            tableEditor.dropTable("garry");
        }
    }
}
