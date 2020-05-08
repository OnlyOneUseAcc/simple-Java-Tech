package repository;

import Stock.StockExchangeDB;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class BaseTable
 */
public class BaseTable implements Closeable {
    protected Connection connection;  // JDBC-соединение для работы с таблицей
    protected String tableName;       // Имя таблицы

    /**
     * Constructor with parameters
     *
     * @param tableName Name of table
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    BaseTable(String tableName) throws SQLException {
        this.tableName = tableName;
        this.connection = StockExchangeDB.getConnection();
    }

    /**
     * Close table
     */
    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Ошибка закрытия SQL соединения!");
        }
    }

    /**
     * Execute statement
     *
     * @param sql         SQL
     * @param description Description
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    void executeSqlStatement(String sql, String description) throws SQLException {
        reopenConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        statement.close();
        if (description != null) {
            System.out.println(description);
        }
    }

    /**
     * Execute statement
     *
     * @param sql SQL
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

    /**
     * Activate DB connection if this disconnect (активизация соединения с СУБД, если оно не активно)
     *
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = StockExchangeDB.getConnection();
        }
    }
}
