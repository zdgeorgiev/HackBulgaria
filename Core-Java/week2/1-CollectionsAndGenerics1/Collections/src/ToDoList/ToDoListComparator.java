package ToDoList;

import java.util.Comparator;

public class ToDoListComparator implements Comparator<Task> {

    public int compare(Task arg0, Task arg1) {
        if (arg0.getPriority() < arg1.getPriority()) {
            return -1;
        }
        if (arg0.getPriority() > arg1.getPriority()) {
            return 1;
        }

        return 0;
    }
}