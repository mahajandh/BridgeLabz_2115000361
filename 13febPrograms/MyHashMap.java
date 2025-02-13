class MyHashMap {
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE; // Simple modulo-based hashing
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        if (head == null) {
            buckets[index] = new Node(key, value);
            return;
        }

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value; // Update value if key exists
                return;
            }
            if (curr.next == null) break;
            curr = curr.next;
        }
        curr.next = new Node(key, value); // Add new node at the end
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];

        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1; // Key not found
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next; // Remove head node
                } else {
                    prev.next = curr.next; // Remove non-head node
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 10);
        hashMap.put(2, 20);
        System.out.println(hashMap.get(1)); // Output: 10
        System.out.println(hashMap.get(3)); // Output: -1
        hashMap.put(2, 25);
        System.out.println(hashMap.get(2)); // Output: 25
        hashMap.remove(2);
        System.out.println(hashMap.get(2)); // Output: -1
    }
}
