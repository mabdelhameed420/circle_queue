public class Main {
    public static class CircleQueue<T> {
        private int size; // Size of Circular Queue
        private int front, rear;
        private Object items[];

        CircleQueue(int size) {
            if (size<=0)
                size = 10;
            else
                items = new Object[size];
            this.size = size;
            front = -1;
            rear = -1;
        }

        // Check if the queue is full
        boolean isFull() {
            if (front == 0 && rear == size - 1) {
                return true;
            }
            if (front == rear + 1) {
                return true;
            }
            return false;
        }

        // Check if the queue is empty
        boolean isEmpty() {
            if (front == -1)
                return true;
            else
                return false;
        }

        // Adding an element
        void enQueue(Object element) {
            if (isFull()) {
                System.out.println("Queue is full");
            } else {
                if (front == -1)
                    front = 0;
                rear = (rear + 1) % size;
                items[rear] = element;
                System.out.println("Inserted " + element);
            }
        }

        // Removing an element
        T deQueue() {
            T element;
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return null;
            } else {
                element = (T) items[front];
                if (front == rear) {
                    front = -1;
                    rear = -1;
                } /* Q has only one element, so we reset the queue after deleting it. */ else {
                    front = (front + 1) % size;
                }
                return (element);
            }
        }

        void display() {
            /* Function to display status of Circular Queue */
            int i;
            if (isEmpty()) {
                System.out.println("Empty Queue");
            } else {
                System.out.println("Front -> " + front);
                System.out.println("Items -> ");
                for (i = front; i != rear; i = (i + 1) % size)
                    System.out.print(items[i] + " ");
                System.out.println(items[i]);
                System.out.println("Rear -> " + rear);
            }
        }
    }

    public static void main(String[] args) {
        CircleQueue q = new CircleQueue<>(5);

        // Fails because front = -1
        q.deQueue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        // Fails to enqueue because front == 0 && rear == SIZE - 1
        q.enQueue(6);

        q.display();

        int elem = (int) q.deQueue();

        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();

        q.enQueue(7);

        q.display();

        // Fails to enqueue because front == rear + 1
        q.enQueue(8);

        q.deQueue();

        q.display();
    }
}