import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CsvValidationException {
        // Call the parser
        CsvParser csvP = new CsvParser("src/Data/bookstore_report2.csv");
        csvP.printCsv();

        //  Create instance of GSON
        Gson gson = new Gson();

        // Create a JsonReader object using FileReader
        JsonReader jread = new JsonReader(new FileReader("src/Data/authors.json"));

        // Array of class instances of AuthorParser, assign data from our JsonReader
        AuthorParser[] authors = gson.fromJson(jread, AuthorParser[].class);

        // Check the data to print the name
        for (var element : authors) {
            System.out.println(element.getName());
        }
    }
}
