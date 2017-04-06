import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ToDoApp {

  public ToDoApp() {
  }

  public static String readDescriptionFromFile(String DESCR_NAME) {
    Path path = Paths.get(DESCR_NAME);
    String descr = " ";
    try {
      descr = String.valueOf(Files.readAllLines(path));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return descr;
  }
}
