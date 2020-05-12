package sync;

/**
 * Class to simulate bank operation
 */
public class U1901Bank {
    /**
     * sender
     */
    private int intTo;
    /**
     * recipient
     * default value: 220
     */
    private int intFrom = 220;

    /**
     * Method for send money
     * @param intTransaction value of sending money
     * @param lngTimeout time delay
     */
    public synchronized void calc(int intTransaction, long lngTimeout) {
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
