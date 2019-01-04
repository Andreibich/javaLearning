package domain;

import java.util.concurrent.Semaphore;

public class CallCenterSemaphore {
    static boolean[] callCenter;
    static Semaphore semaphore;
    private int operatorQuantity;

    public CallCenterSemaphore(int operatorQuantity) {
        this.operatorQuantity = operatorQuantity;
        this.callCenter = new boolean[operatorQuantity];
        this.semaphore = new Semaphore(operatorQuantity, true);
    }

    public int getOperatorQuantity() {
        return operatorQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallCenterSemaphore that = (CallCenterSemaphore) o;

        return operatorQuantity == that.operatorQuantity;
    }

    @Override
    public int hashCode() {
        return operatorQuantity;
    }

    @Override
    public String toString() {
        return "CallCenterSemaphore{" +
                "operatorQuantity=" + operatorQuantity +
                '}';
    }
}
