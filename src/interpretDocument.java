import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class interpretDocument {

    private static final String SEMICOLON_DELIMITER = ";";

    public static void csvReader(String path) throws FileNotFoundException {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.useDelimiter(";");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
        }
        sc.close();
    }

}
