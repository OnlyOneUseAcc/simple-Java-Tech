package repository;

import models.Music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Class MusicTable
 *
 */
public class MusicTable extends BaseTable implements TableOperations {
    /**
     * Default constructor with call super("Musics")
     * @throws SQLException
     */
    public MusicTable() throws SQLException {
        super("Musics");
    }

    /**
     * Creating sql table
     * with raws:
     * id
     * title
     * artist
     * date
     * listPrice
     * price
     * version
     * @throws SQLException
     */
    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS Musics(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "title NVARCHAR(30) NOT NULL," +
                "artist NVARCHAR(30) NOT NULL," +
                "date NVARCHAR(30) NOT NULL," +
                "listPrice integer NOT NULL," +
                "price integer NOT NULL," +
                "version integer NOT NULL)",
                "Создана таблица " + tableName);
    }

    /**
     * Insert music into the table
     * @param music Input music
     * @throws SQLException database access error or other errors
     */
    public void insertIntoTable(Music music) throws SQLException {
        super.executeSqlStatement("INSERT INTO Musics VALUES " +
                "(DEFAULT, '" + music.getTitle() + "', '" + music.getArtist() +
                "', date '" + music.getDate() + "'," + music.getListPrice() + ","
                + music.getPrice() + ", " + music.getVersion() + ");\n");
    }

    /**
     * Print all musics from table
     *
     * @throws SQLException database access error or other errors
     */
    public void printAll() throws SQLException {
        Statement state = connection.createStatement();
        ResultSet resultSet = state.executeQuery("SELECT * FROM Musics");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String artist = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            int listPrice = resultSet.getInt(5);
            int price = resultSet.getInt(6);
            int version = resultSet.getInt(7);
            System.out.println(id + "   \t" + title + '\t' + artist + '\t' + date + '\t' + listPrice + '\t' + price + '\t' + version);
        }
    }

    /**
     * Search music by ID
     * @param inputID Input ID
     * @return Searched music
     * @throws SQLException database access error or other errors
     */
    public Music searchByID(int inputID) throws SQLException {
        Statement state = connection.createStatement();
        ResultSet resultSet = state.executeQuery("SELECT * FROM Musics WHERE ID =" + inputID);
        Music music = new Music();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String artist = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            int listPrice = resultSet.getInt(5);
            int price = resultSet.getInt(6);
            int version = resultSet.getInt(7);
            music.setTitle(title);
            music.setArtist(artist);
            music.setDate(date.toString());
            music.setListPrice(listPrice);
            music.setPrice(price);
            music.setVersion(version);
        }
        return music;
    }

    /**
     * Delete music by ID
     *
     * @param inputID Input ID
     * @throws SQLException An exception that provides information on a database access error or other errors
     */
    public void deleteByID(int inputID) throws SQLException {
        Statement state = connection.createStatement();
        int rows = state.executeUpdate("DELETE FROM Musics WHERE Id = " + inputID);

        System.out.println(rows + " delete");
    }
}
