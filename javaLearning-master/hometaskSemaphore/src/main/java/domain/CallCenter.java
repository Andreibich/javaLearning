package domain;

import java.util.Random;

public class CallCenter extends Thread {
    private int operatorQuantity;
    private Client client;

    public CallCenter(Client client, CallCenterSemaphore callCenterSemaphore) {
        this.operatorQuantity = callCenterSemaphore.getOperatorQuantity();
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallCenter that = (CallCenter) o;

        if (operatorQuantity != that.operatorQuantity) return false;
        return client != null ? client.equals(that.client) : that.client == null;
    }

    @Override
    public int hashCode() {
        int result = operatorQuantity;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CallCenter{" +
                "operatorQuantity=" + operatorQuantity +
                ", client=" + client +
                '}';
    }

    public void run() {
        try {
            System.out.println("Client " + client.getClientName() + " is waiting");
            sleep(1000);

            CallCenterSemaphore.semaphore.acquire();
            sleep(1000);
            int operatorID = -1;
            synchronized (CallCenterSemaphore.callCenter) {
                for (int i = 0; i < operatorQuantity; i++) {
                    if (CallCenterSemaphore.callCenter[i] == false) {
                        CallCenterSemaphore.callCenter[i] = true;
                        operatorID = i;
                        System.out.println("Client " + client.getClientName() + " start talking with operator #" + (operatorID + 1));
                        break;
                    }
                }
            }

            Random random = new Random();
            sleep(random.nextInt(9000) + 1000);
            synchronized (CallCenterSemaphore.callCenter) {
                CallCenterSemaphore.callCenter[operatorID] = false;
            }

            System.out.println("Client " + client.getClientName() + " has finished talking with operator #" + (operatorID + 1));
            CallCenterSemaphore.semaphore.release();


            sleep(3000);

        } catch (InterruptedException e) {
            System.out.println("Technical difficulties");
        }
    }
}
