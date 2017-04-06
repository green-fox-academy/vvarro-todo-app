public class Main {
  public static void main(String[] args) {
    ToDoApp toDoApp = new ToDoApp();

    final String DESCR_NAME = "appDescription.txt";
    final String FILE_NAME = "list.csv";

    //Kapcsolok
    if (args[0].equals("-l") && args.length == 1) {
      System.out.println("kiirom a listat");
    } else if (args[0].equals("-a") && args.length == 3) {
      System.out.println("hozzaadok elemet");
    } else if (args[0].equals("-r") && args.length == 1) {
      System.out.println("torlok egy elemet");
    } else if (args[0].equals("-c") && args.length == 1) {
      System.out.println("megcsinalok egy feladatot");
    } else {
      System.out.println(toDoApp.readDescriptionFromFile(DESCR_NAME));
    }

  }
}
