package ru.billing.client;

import ru.billing.exceptions.*;
import ru.billing.stocklist.*;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class CatalogFileLoader implements ICatalogLoader {

    private String fileName;

    public CatalogFileLoader(String fileName) {
        this.fileName = fileName;
    }

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


    public void loadUTF8(ItemCatalog cat) throws IOException {
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
        }
    }

    public void loadWIN1251(ItemCatalog cat) throws IOException {
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
        }
    }
}