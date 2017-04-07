import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

  private final static String DESCR_NAME = "ToDoApp/appDescription.txt";
  private final static String FILE_NAME = "ToDoApp/list.csv";

  public static void main(String[] args) {
    List<String> description = readDescriptionFromFile();
    List<String> toDo = readToDoFromFile();
    LinkedHashMap<String, Boolean> toDoMap = processData(toDo);

    ToDoApp toDoApp = new ToDoApp();

    //Kapcsolok
    if (args.length == 0) {
      for (int i = 0; i < description.size(); i++) {
        System.out.println(description.get(i));
      }
    } else if (args[0].equals("-l") && args.length == 1) {
      toDoApp.writeOut(toDoMap);
    } else if (args[0].equals("-a") && args.length == 2) {
      toDoApp.addNewTask(toDoMap,args);
      toDoApp.addToFile(toDoApp.toFile(args), FILE_NAME);
    } else if (args[0].equals("-a") && args.length == 1) {
      System.out.println("Unable to add: no task provided");
    } else if (args[0].equals("-r") && args.length == 2) {
      toDoApp.removeTask(toDoMap, args);
      toDoApp.reWriteList(toDoMap, FILE_NAME);
    } else if (args[0].equals("-c") && args.length == 2) {
      toDoApp.checkTask(toDoMap, args);
      toDoApp.reWriteList(toDoMap,FILE_NAME);
    } else {
      System.out.println("Try harder!");
    }
  }

  private static List<String> readDescriptionFromFile() {
    Path path = Paths.get(DESCR_NAME);
    List<String> description;

    try {
      description = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
      description = new ArrayList<>();
    }
    return description;
  }

  public static List<String> readToDoFromFile() {
    Path path = Paths.get(FILE_NAME);
    List<String> toDo;

    try {
      toDo = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
      toDo = new ArrayList<>();
    }
    return toDo;
  }

  public static LinkedHashMap<String, Boolean> processData(List<String> toDo) {
    LinkedHashMap<String, Boolean> toDoMap = new LinkedHashMap<>();
    for (int i = 0; i < toDo.size(); i++) {
      String[] splittedLine = toDo.get(i).split(";");
      if (splittedLine[1].equals("done")) {
        toDoMap.put(splittedLine[0], true);
      } else {
        toDoMap.put(splittedLine[0], false);
      }
    }
    return toDoMap;
  }
}
