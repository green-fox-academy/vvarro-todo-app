import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ToDoApp {

  public ToDoApp() {
  }

  public void writeOut(LinkedHashMap toDoMap) {
    if (toDoMap.size() == 0) {
      System.out.println("No todos for today! :)");
    } else {
      Set set = toDoMap.entrySet();
      Iterator iterator = set.iterator();
      for (int i = 0; i < toDoMap.size(); i++) {
        Map.Entry linked = (Map.Entry) iterator.next();
        System.out.println(i + 1 + " - " + linked.getKey());
      }
    }
  }

  public void addNewTask(LinkedHashMap toDoMap, String[] args) {
    toDoMap.put(args[2], false);
  }

  public String toFile(String[] args) {
    String result = " ";
    result = (args[1].toString().concat(";undone"));
    return result;
  }

  public void writeToFile(String result, String FILE_NAME) {
    try {
      Writer output;
      output = new BufferedWriter(new FileWriter(FILE_NAME,true));  //clears file every time
      output.append("\n" + result);
      output.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}