package ru.kpfu.db;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DataBase {

    private static String fileName = null;
    private static String fileExt = null;
    private static String typeImage = null;

//    private static Map<String, ArrayList<String>> tags = new HashMap<String,ArrayList<String>>();
//    private static Map<String, String> descriptions = new HashMap<String, String>();
//    private static HashSet<String> names = new HashSet<String>();
    private static String pathToCsv = "C:\\Users\\mazit\\IdeaProjects\\ImageCatalog\\db\\DataBase.csv";


    public static void DataBase(HashSet<String> tags) {

    }

    public static void addRecord(String address, String description, String[] selectedTags, String path, String typeOfPath) throws Exception {
        if(typeOfPath.equals("URL"))
            downloadFromUrl(address, path);
        else copyFromPath();

        if (!typeImage.equals("image")) throw new Exception("Not Image");
        String fileName = DataBase.fileName;
        String fileExt = DataBase.fileExt;
        String tags = String.join(", ", selectedTags);

        try {
            Writer writer = new BufferedWriter(new FileWriter(pathToCsv, true));
            writer.append("\r\n" + fileName + "|" + fileExt + "|" + description + "|" + tags);
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private static void downloadFromUrl(String address, String path) {
        try {
            URL url = new URL(address);
            String mimeType = null;
            URLConnection uc = null;
            uc = url.openConnection();


            mimeType = uc.getContentType();
            String typeImage = mimeType.substring(0, mimeType.lastIndexOf("/"));
            DataBase.typeImage = typeImage;
            String fileExt = mimeType.substring(mimeType.lastIndexOf("/")+1, mimeType.length());
            DataBase.fileExt = fileExt;
            String fileName = address.substring(address.lastIndexOf("/")+1, address.lastIndexOf("."));
            DataBase.fileName = fileName;
            String fileNameExt = fileName + "." + fileExt;

            String filePath = path + "\\" + fileNameExt;
            File file = new File(filePath);

            InputStream in = new BufferedInputStream(url.openStream());
            FileOutputStream out = new FileOutputStream(filePath);

            int ch;
            while ((ch = in.read())!=-1)
            {
                out.write(ch);
            }
            in.close();
            out.flush();
            out.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void copyFromPath() {
    }

    public static void delete(String fileName) {

        try {
            FileInputStream fis = new FileInputStream(new File(pathToCsv));
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();
            String[] lines = new String(content, "UTF-8").split("\r\n");
            int i = 1;
            int j = 1;
            for (String line : lines) {
                String[] words = line.split("\\|");
                for (String word : words) {
                    if (word.equals(fileName)) {
                        System.out.println("Найдено в " + i + "-й строке, " + j + "-е слово");
                    }
                }
                j++;
                i++;
            }

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void search() {}

}

//public class DataBaseExcepition throw Exception {
//
//        }
