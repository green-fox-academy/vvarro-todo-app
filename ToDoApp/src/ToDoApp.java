import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ToDoApp {

  public ToDoApp() {
  }

  public static java.util.List<String> readDescriptionFromFile(String DESCR_NAME) {
    Path path = Paths.get(DESCR_NAME);
    List<String> descr = null;

    try {
      descr = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return descr;
  }


}
