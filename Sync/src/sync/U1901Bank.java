package sync;

public class U1901Bank {
    private int intTo;
    private int intFrom = 220;

    public synchronized void  Calc(int intTransaction, long lngTimeout){
        System.out.println("\tBefore:");
        System.out.println("to - " + intTo);
        System.out.println("from - " + intFrom);
        System.out.println(Thread.currentThread().getName());

        intFrom -= intTransaction;

        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intTo += intTransaction;
        System.out.println("\tAfter:");
        System.out.println("to - " + intTo);
        System.out.println("from - " + intFrom);
        System.out.println(Thread.currentThread().getName());

    }
}
