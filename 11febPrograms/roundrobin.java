class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null, tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add a new process at the end
    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular link
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) return;
        Process temp = head, prev = tail;
        do {
            if (temp.processId == processId) {
                if (temp == head) head = head.next;
                if (temp == tail) tail = prev;
                prev.next = temp.next;
                if (head == temp) head = null; // If only one node existed
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // Simulate round-robin scheduling
    public void executeProcesses() {
        if (head == null) return;
        Process current = head;
        System.out.println("Executing Processes in Round-Robin manner:");
        do {
            System.out.println("Executing Process ID: " + current.processId + " for " + Math.min(timeQuantum, current.burstTime) + " units");
            current.burstTime -= timeQuantum;
            if (current.burstTime <= 0) {
                System.out.println("Process ID: " + current.processId + " completed execution.");
                removeProcess(current.processId);
            }
            current = current.next;
        } while (head != null);
    }

    // Display process queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }
        Process temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("Process ID: " + temp.processId + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        
        scheduler.displayProcesses();
        scheduler.executeProcesses();
    }
}
