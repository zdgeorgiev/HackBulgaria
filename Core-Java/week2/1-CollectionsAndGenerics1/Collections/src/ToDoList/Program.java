package toDoList;

public class Program {
    public static void main(String[] args) {
        ToDoList todo = new ToDoList(16); // 16 hours remaining!
        todo.add(new StudyForAlgebraTask(1, 5));
        todo.add(new LearnGeometryTask(4));
        todo.add(new GoOutTask(1.5f, 2));
        todo.add(new SleepTask(8));

        if (todo.canFinish()) {
            System.out.println("Woohoo!");
        } else {
            System.out.println("I am ...screwed :(");
        }

        System.out.println(todo.getTop());
    }
}