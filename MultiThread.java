public class MultiThread extends Thread {
    String task;
    MultiThread(String task) {
        this.task = task;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(task + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println(ie.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        MultiThread th1 = new MultiThread("\nCut the ticket");
        MultiThread th2 = new MultiThread("\nShow your seat number");
        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th2);
        t1.start();
        t2.start();
    }
}

/*OUTPUT

Cut the ticket : 1

Show your seat number : 1

Cut the ticket : 2

Show your seat number : 2

Cut the ticket : 3

Show your seat number : 3

Cut the ticket : 4

Show your seat number : 4

Cut the ticket : 5

Show your seat number : 5

*/
public class SingleThread implements Runnable {
    int a = 20, b = 10;
    public void run() {
        addition();
        subtraction();
        multiplication();
    }
    void addition() {
        int sum = a + b;
        System.out.println("Addition of two numbers: " + sum);
    }
    void subtraction() {
        int sub = a - b;
        System.out.println("Subtraction of two numbers: " + sub);
    }
    void multiplication() {
        int multiply = a * b;
        System.out.println("Multiplication of two numbers: " + multiply);
    }
    public static void main(String[] args) {
        System.out.println("Main thread running");
        SingleThread th = new SingleThread();
        Thread t = new Thread(th);
        t.start();
    }
}

/*OUTPUT
Main thread running
Addition of two numbers: 30
Subtraction of two numbers: 10
Multiplication of two numbers: 200
*/

