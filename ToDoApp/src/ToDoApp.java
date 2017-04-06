import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoApp {

  public ToDoApp() {
  }

  public static List<String> readDescriptionFromFile(String DESCR_NAME) {
    Path path = Paths.get(DESCR_NAME);
    List<String> descr = null;

    try {
      descr = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return descr;
  }

  public static List<String> readListFromFile(String FILE_NAME) {
    Path path = Paths.get(FILE_NAME);
    List<String> list = null;

    try {
      list = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  private static void processData(List<String> list) {
    List<String> task = new ArrayList<>();
    List<String> status = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      String[] splittedLine = list.get(i).split(";");
      task.set(i, splittedLine[0]);
      status.set(i, splittedLine[1]);
    }
  }
}
