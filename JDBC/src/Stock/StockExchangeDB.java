package Stock;

import org.h2.tools.DeleteDbFiles;
import models.Music;
import repository.MusicTable;

import java.sql.*;

/**
 * Class Stock.StockExchangeDB
 */
public class StockExchangeDB {

    public static final String DIR = "c:/JavaPrj/SQLDemo/db";
    public static final String FILE = "stockExchange";
    public static final String URL = "jdbc:h2:/" + DIR + "/" + FILE;
    public static final String DRIVER = "org.h2.Driver";


    MusicTable musicTable;

    /**
     * Default initialisation (инициализация по умолчанию, без удаления файла БД)
     *
     * @throws SQLException           An exception that provides information on a database access error or other errors
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name
     */
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        this(false);
    }

    /**
     * Initialisation (инициализация)
     *
     * @param renew Input renew
     * @throws SQLException           An exception that provides information on a database access error or other errors.
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name
     */
    public StockExchangeDB(boolean renew) throws SQLException, ClassNotFoundException {
        if (renew) {
            DeleteDbFiles.execute(DIR, FILE, false);
        }
        Class.forName(DRIVER);
        // Инициализируем таблицы
        musicTable = new MusicTable();
    }

    /**
     * Get new connection with DB (получить новое соединение с БД)
     *
     * @return New connection
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    /**
     * Create all tables (создание всех таблиц)
     *
     * @throws SQLException
     */
    public void createTablesAndForeignKeys() throws SQLException {
        musicTable.createTable();
    }

    public static void main(String[] args) {
        try {

            StockExchangeDB stockExchangeDB = new StockExchangeDB(true);
            stockExchangeDB.createTablesAndForeignKeys();

            //Создаем экземпляры класс Music
            Music firstMusic = new Music("Rock", "Metallica", "2010-10-02", 300, 500, 1);
            Music secondMusic = new Music("Rock", "Iron Maiden", "2000-02-10", 500, 900, 2);


            stockExchangeDB.musicTable.insertIntoTable(firstMusic);
            stockExchangeDB.musicTable.insertIntoTable(secondMusic);

            stockExchangeDB.musicTable.printAll();


            Music searchMusic = stockExchangeDB.musicTable.searchByID(1);
            searchMusic.printAll();


            stockExchangeDB.musicTable.deleteByID(1);
            stockExchangeDB.musicTable.printAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
