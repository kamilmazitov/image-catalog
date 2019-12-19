import java.io.*;
import java.util.*;

import Sorter.Sorter;

public class Sort {

    public static void main(String[] args) {

        try {
            List<Integer> numbers = new ArrayList<Integer>();
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\mazit\\IdeaProjects\\ImageCatalog\\in.txt"));
            String curLine;
            Integer curInt;
            while((curLine = reader.readLine()) != null) {
                curInt = Integer.parseInt(curLine);
                numbers.add(curInt);
            }

            Collections.sort(numbers, new Sorter());
            Writer writer = new BufferedWriter(new FileWriter("C:\\Users\\mazit\\IdeaProjects\\ImageCatalog\\in.txt", false));
            for(String num : numbers) {

            }

            writer.write();
            writer.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

