import static org.junit.jupiter.api.Assertions.*;

/* Code provided by Professor Josiah Greenwell */

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CsvParserTest {

  /**
   * to do Add tests for print operations (then DB ones)
   */

  CsvParser csv;

  @BeforeEach
  void setUp() throws IOException, CsvValidationException {
    csv = new CsvParser("bookstore_report2.csv");
  }

  @Test
  void printCsv() {
  }
}