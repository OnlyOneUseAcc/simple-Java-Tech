package sync;

/**
 * Class for thread of bank transaction
 */
public class U1901Thread extends Thread {
    /**
     * simulation
     */
    private U1901Bank bankWork;
    /**
     * amount of money
     */
    private int intTrans;
    /**
     * time delay
     */
    private long lngSleep;

    /**
     * Constructor which includes all fields for our simulation
     * @param bankWork simulated bank
     * @param intTrans amount of money
     * @param lngSleep time delay
     */
    public U1901Thread(U1901Bank bankWork, int intTrans, long lngSleep) {
        this.bankWork = bankWork;
        this.intTrans = intTrans;
        this.lngSleep = lngSleep;
    }

    /**
     * Method which complete transaction
     */
    public void run() {
        bankWork.calc(intTrans, lngSleep);
    }
}
