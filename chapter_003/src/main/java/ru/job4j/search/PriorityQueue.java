package ru.job4j.search;

import java.util.LinkedList;

/**
 * PriorityQueue.
 *
 * @author Lobach Vitaly (deta4ed@gmail.com)
 * version $id$
 * since 0.1
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**Put.
     * @param task - task.
     */
    public void put(Task task) {
        int index = 0;
        for (Task current : tasks) {
            if (current.getPriority() >= task.getPriority()) {
                break;
            }
            index++;
        }
        tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}
