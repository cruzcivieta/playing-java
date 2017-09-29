package thread.theory;

class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this, "thread.theory.Producer").start();
    }
    public void run() {
        int i = 0;
        while(i < 20) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q = q;
        new Thread(this, "thread.theory.Consumer").start();
    }
    public void run() {
        while(true) {
            q.get();
        }
    }
}

class ThreadTest {
    public static void main(String args[]) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);
        System.out.println("Press Control-C to stop.");
    }
}