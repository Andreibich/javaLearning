package com.htp.hometaskSemaphore.util;


import com.htp.hometaskSemaphore.domain.CallCenter;
import com.htp.hometaskSemaphore.domain.CallCenterSemaphore;
import com.htp.hometaskSemaphore.domain.Client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        CallCenterSemaphore sem = new CallCenterSemaphore(3);

        Client client1 = new Client("Vasya1");
        Client client2 = new Client("Petya2");
        Client client3 = new Client("Kolya3");
        Client client4 = new Client("Maxim4");
        Client client5 = new Client("Sasha5");

        ExecutorService ex = Executors.newFixedThreadPool(5);
        ex.execute(new CallCenter(client1, sem));
        ex.execute(new CallCenter(client2, sem));
        ex.execute(new CallCenter(client3, sem));
        ex.execute(new CallCenter(client4, sem));
        ex.execute(new CallCenter(client5, sem));
        ex.shutdown();
    }
}
