package toDoList;

import java.util.PriorityQueue;

public class ToDoList {
    private PriorityQueue<Task> tasks;
    private float timeRemaining;

    public ToDoList(int timeRemaining) {
        this.setTimeRemaining(timeRemaining);
        this.tasks = new PriorityQueue<Task>(new ToDoListComparator());
    }

    public void add(Task t) {
        this.tasks.add(t);
        this.setTimeRemaining(this.getTimeRemaining() - t.getTime());
    }

    public void markFinished(Task t) {
        t.setFinished(true);
        this.setTimeRemaining(this.getTimeRemaining() - t.getTime());
    }

    public void markCancelled(Task t) {
        t.setFinished(true);
        this.setTimeRemaining(this.getTimeRemaining() + t.getTime());
    }

    public Task getTop() {
        return this.tasks.peek();
    }

    public boolean canFinish() {
        return this.timeRemaining >= 0;
    }

    public int getRemainigTime() {
        int time = 0;

        for (Task task : this.tasks) {
            if (!task.isFinished()) {
                time += task.getTime();
            }
        }

        return time;
    }

    public float getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(float timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
}