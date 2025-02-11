class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

class TextEditor {
    private TextState current;
    private int historyLimit;
    private int historyCount;

    public TextEditor(int historyLimit) {
        this.historyLimit = historyLimit;
        this.historyCount = 0;
    }

    // Add a new state
    public void addState(String content) {
        TextState newState = new TextState(content);
        if (current != null) {
            newState.prev = current;
            current.next = newState;
        }
        current = newState;
        historyCount++;

        // Maintain history limit
        if (historyCount > historyLimit) {
            TextState temp = current;
            while (temp.prev != null && historyCount > historyLimit) {
                temp = temp.prev;
                historyCount--;
            }
            temp.prev = null;
        }
    }

    // Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    // Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    // Display current state
    public void displayState() {
        if (current != null) {
            System.out.println("Current State: " + current.content);
        } else {
            System.out.println("No content available.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        
        editor.displayState(); // Current: Hello World!
        editor.undo();
        editor.displayState(); // Current: Hello World
        editor.redo();
        editor.displayState(); // Current: Hello World!
    }
}
