package models;

/**
 * Class Music
 */
public class Music extends BaseModel {
    private String title;
    private String artist;
    private String date;
    private int listPrice;
    private int price;
    private int version;

    /**
     * Constructor with parameters
     *
     * @param title     Title of music
     * @param artist    Artist of music
     * @param date      Date of introduce
     * @param listPrice List price of music
     * @param price     Price of music
     * @param version   Version of music
     */
    public Music(String title, String artist, String date, int listPrice, int price, int version) {
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.listPrice = listPrice;
        this.price = price;
        this.version = version;
    }

    /**
     * Default constructor
     */
    public Music() {
    }

    /**
     * Get artist name
     *
     * @return Name of artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Set artist name
     *
     * @param artist Input artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Get date of introduce
     *
     * @return Date of introduce
     */
    public String getDate() {
        return date;
    }

    /**
     * Set date of introduce
     *
     * @param date Input date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get list price
     *
     * @return List price
     */
    public int getListPrice() {
        return listPrice;
    }

    /**
     * Set list price
     *
     * @param listPrice Input list price
     */
    public void setListPrice(int listPrice) {
        this.listPrice = listPrice;
    }

    /**
     * Get price
     *
     * @return Price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set price
     *
     * @param price Price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get version of music
     *
     * @return Version
     */
    public int getVersion() {
        return version;
    }

    /**
     * Set version of music
     *
     * @param version Input version
     */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
     * Get title
     *
     * @return Title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     *
     * @param title Input title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public void printAll() {
        System.out.println(title + '\t' + artist + '\t' + date + '\t' + listPrice + '\t' + price + '\t' + version);
    }
}
