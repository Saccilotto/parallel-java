package AppThreadJoining;

import java.math.BigInteger;

public class ThreadJoining {

    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        BigInteger result = BigInteger.ZERO;
        /*
            Calculate result = ( base1 ^ power1 ) + (base2 ^ power2).
            Where each calculation in (..) is calculated on a different thread
        */
        PowerCalculatingThread th1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread th2 = new PowerCalculatingThread(base2, power2);
        
        th1.start();
        th2.start();

        th1.setDaemon(true);
        th2.setDaemon(true);

        try {
            th1.join(3000);
            th2.join(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result = th1.getResult().add(th2.getResult());

        return result;
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;
    
        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
    
        @Override
        public void run() {
           /*
           Implement the calculation of result = base ^ power
           */
           BigInteger index = BigInteger.ONE;
           for(; index.compareTo(power) <= 0; index.add(BigInteger.ONE)) {
               result = result.multiply(base);
           }
        }
    
        public BigInteger getResult() { return result; }
    }
}
