package Stock;

import org.h2.tools.DeleteDbFiles;
import models.Music;
import repository.MusicTable;

import java.sql.*;

/**
 * Class Stock.StockExchangeDB
 */
public class StockExchangeDB {

    public static final String DIR = "D:/java/SQL/db";
    public static final String FILE = "stockExchange";
    public static final String URL = "jdbc:h2:/" + DIR + "/" + FILE;
    public static final String DRIVER = "org.h2.Driver";


    MusicTable musicTable;

    /**
     * Initialisation
     * @throws SQLException database access error or other errors
     * @throws ClassNotFoundException Thrown when an application tries to load in a class through its string name
     */
    public StockExchangeDB() throws SQLException, ClassNotFoundException {
        this(false);
    }

    /**
     * Initialisation
     * @param renew flag
     * @throws SQLException database access error or other errors.
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
     * Get new connection
     * @return New connection
     * @throws SQLException database access error or other errors
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    /**
     * Create all tables
     * @throws SQLException database access error or other errors
     */
    public void createTablesAndForeignKeys() throws SQLException {
        musicTable.createTable();
    }

    public static void main(String[] args) {
        try {

            StockExchangeDB stockExchangeDB = new StockExchangeDB(true);
            stockExchangeDB.createTablesAndForeignKeys();

            //Создаем экземпляры класс Music
            Music exzampleOne = new Music("exz1",
                    "exzArt1", "2020-05-01",
                    500, 500, 1);
            Music exampleSecond = new Music("exz2",
                    "exzArt2", "2020-05-01",
                    500, 500, 1);


            stockExchangeDB.musicTable.insertIntoTable(exzampleOne);
            stockExchangeDB.musicTable.insertIntoTable(exampleSecond);

            stockExchangeDB.musicTable.printAll();

            Music searchMusic = stockExchangeDB.musicTable.searchByID(1);
            searchMusic.printAll();

            stockExchangeDB.musicTable.deleteByID(2);
            stockExchangeDB.musicTable.printAll();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
