package repository;

import java.sql.SQLException;

/**
 * Interface TableOperations
 */
public interface TableOperations {
    /**
     * Create table
     *
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    void createTable() throws SQLException; // создание таблицы
}
