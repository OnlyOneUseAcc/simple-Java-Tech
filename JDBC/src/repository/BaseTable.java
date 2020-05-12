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
     * Constructor which get sql connection
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
            e.printStackTrace();
        }
    }

    /**
     * Execute statement
     *
     * @param sql sql string
     * @param description Description
     * @throws SQLException database access error or other errors
     */
    void executeSqlStatement(String sql, String description) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            if (description != null) {
                System.out.println(description);
            }
        } catch (SQLException e) {
            throw new SQLException(e.getCause());
        }
    }

    /**
     * Execute statement
     *
     * @param sql sql string
     * @throws SQLException database access error or other errors
     */
    void executeSqlStatement(String sql) throws SQLException {
        executeSqlStatement(sql, null);
    }

    /**
     * Activate DB connection
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = StockExchangeDB.getConnection();
        }
    }
}
