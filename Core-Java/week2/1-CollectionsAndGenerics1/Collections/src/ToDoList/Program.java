package ToDoList;

public class Program {
    public static void main(String[] args) {
        ToDoList todo = new ToDoList(12); // 11 hours remaining!
        todo.add(new StudyForAlgebraTask(1, 5));
        todo.add(new LearnGeometryTask(1));
        todo.add(new GoOutTask(1.5f, 1));
        todo.add(new SleepTask(8, 2));

        if (todo.canFinish()) {
            System.out.println("Woohoo!");
        } else {
            System.out.println("I am ...screwed :(");
        }
    }
}
