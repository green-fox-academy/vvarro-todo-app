import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ToDoApp{

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

  public void addNewTask(LinkedHashMap toDoMap, String[] args){
    toDoMap.put(args[1],args[2]);
  }
}