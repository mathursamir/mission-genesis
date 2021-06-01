import java.util.LinkedList;

public class ProdCons {


    public static void main(String[] args) throws InterruptedException {

        final PC pc = new PC();

        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();


    }

    static class PC {
        LinkedList<Integer> prodcons = new LinkedList<Integer>();
        int capacity = 10;
        int value;


        public void produce() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (prodcons.size() == capacity) wait();
                    System.out.println("producer produced" + value);
                    prodcons.push(value++);
                    notifyAll();
                    Thread.sleep(1000);

                }
            }

        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (prodcons.isEmpty()) wait();
                    int val = prodcons.removeFirst();
                    System.out.println("Consumer Consumed" + val);
                    notifyAll();
                    Thread.sleep(1000);


                }

            }
        }
    }
}
