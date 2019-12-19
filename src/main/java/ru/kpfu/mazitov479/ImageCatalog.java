import ru.kpfu.db.DataBase;
import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

/**
 *
 * @author Mazitov Kamil
**/
public class ImageCatalog  {
    /**
     * Поиск по тегам, поиск по названию, поиск по описанию, удаление, обработать исключения
     *
     *Общение с пользователем
     *
     */
    public static void main( String[] args ) {

        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("C:\\Users\\mazit\\IdeaProjects\\ImageCatalog\\src\\main\\config.properties");
            property.load(fis);

            String path = property.getProperty("path");

            String[] arr = property.getProperty("tags").split(", ");
            HashSet<String> tags = new HashSet<String>(Arrays.asList(arr));

            DataBase db = new DataBase();

            String address = "https://klike.net/uploads/posts/2019-01/1547367999_1.jpg";
            String descriprion = "Lorem ipsum dolor...";
            String[] tegs = new String[] {"animals", "cars", "home"};
            String url = "URL";
            db.addRecord(address, descriprion, tegs, path, url);
            db.delete("1547367999_1");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
