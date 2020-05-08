package ru.billing.client;

import ru.billing.exceptions.*;
import ru.billing.stocklist.*;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

/**
 * Loading catalog from files
 */
public class CatalogFileLoader implements ICatalogLoader {

    /**
     * name of source file
     */
    private String fileName;

    /**
     * constructor which set name of source file
     * @param fileName path to source file
     */
    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Load catalog from default structured file
     * @param cat catalog for loading
     * @throws CatalogLoadException any exception during loading except ItemAlreadyExistException
     */
    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        File file = new File(fileName);
        String line;

        try (FileInputStream stream = new FileInputStream(file)) {
            Scanner scanner = new Scanner(stream);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0) {
                    break;
                }
                String[] items = line.split(";");
                FoodItem item = new FoodItem(items[0], Float.parseFloat(items[1]),
                        Category.GENERAL, new Date(), Short.parseShort(items[2]));
                cat.addItem(item);
            }
        } catch (ItemAlreadyExistException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new CatalogLoadException();
        }
    }

    /**
     * Load catalog from structured file with UTF-8
     * @param cat catalog for loading
     * @throws CatalogLoadException any exception during loading except ItemAlreadyExistException
     */
    public void loadUTF8(ItemCatalog cat) throws CatalogLoadException {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = new String(line.getBytes(StandardCharsets.UTF_8));
                String[] items = string.split(";");
                FoodItem item = new FoodItem(items[0], Float.parseFloat(items[1]),
                        Category.GENERAL, new Date(), Short.parseShort(items[2]));
                cat.addItem(item);
            }
        } catch (ItemAlreadyExistException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new CatalogLoadException();
        }
    }

    /**
     * Load catalog from structured file with WIN-1251
     * @param cat catalog for loading
     * @throws CatalogLoadException any exception during loading except ItemAlreadyExistException
     */
    public void loadWIN1251(ItemCatalog cat) throws CatalogLoadException {
        File file = new File(fileName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String string = new String(line.getBytes("windows-1251"));
                String[] items = string.split(";");
                FoodItem item = new FoodItem(items[0], Float.parseFloat(items[1]),
                        Category.GENERAL, new Date(), Short.parseShort(items[2]));
                cat.addItem(item);
            }
        } catch (ItemAlreadyExistException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new CatalogLoadException();
        }
    }
}

