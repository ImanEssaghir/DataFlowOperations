import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/* Code provided by Professor Josiah Greenwell */

public class Main {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:./res/palace";
    static final String USER = "";
    static final String PASS = "";
    static Connection conn;

    public static void main(String[] args) throws IOException, CsvValidationException, ClassNotFoundException, SQLException {
        // Call the parser
        CsvParser csvP = new CsvParser("src/Data/bookstore_report2.csv");
        csvP.printCsv();

        // Load a json file;  Create instance of GSON
        Gson gson = new Gson();

        // Create a JsonReader object using FileReader
        JsonReader jread = new JsonReader(new FileReader("src/Data/authors.json"));

        // Array of class instances of AuthorParser, assign data from our JsonReader
        AuthorParser[] authors = gson.fromJson(jread, AuthorParser[].class);

        // Check the data to print the name
        for (var element : authors) {
            System.out.println(element.getName());
        }

        System.out.println();
        testDatabaseConnection();
        System.out.println();

        String sql = "INSERT INTO author (author_name, author_email, author_url) VALUES  (? , ? , ?)";
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL);
        Statement stmt = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(sql);

        for (var element : authors) {
            ps.setString(1, element.getName());
            ps.setString(2, element.getEmail());
            ps.setString(3, element.getUrl());
        }

        ps.close();
        stmt.close();
        conn.close();

    }

    // Database Connection Test
    private static void testDatabaseConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Database Connected!");

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Database Failed to Connect!");
        }
    }
}
