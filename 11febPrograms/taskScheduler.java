class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    private Task head = null;
    private Task tail = null;

    // Add task at the end
    public void addTask(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Remove a task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;
        Task temp = head, prev = null;
        
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // View current task and move to the next task
    public void viewTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by Priority
    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task -> Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tasks found with priority " + priority);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        CircularTaskList taskList = new CircularTaskList();
        taskList.addTask(1, "Complete Report", 2, "2025-02-15");
        taskList.addTask(2, "Submit Assignment", 1, "2025-02-20");
        taskList.addTask(3, "Attend Meeting", 3, "2025-02-18");
        
        System.out.println("\nAll Tasks:");
        taskList.viewTasks();
        
        System.out.println("\nSearching for Priority 2 tasks:");
        taskList.searchByPriority(2);
        
        System.out.println("\nRemoving Task ID 2 and viewing tasks again:");
        taskList.removeTask(2);
        taskList.viewTasks();
    }
}
