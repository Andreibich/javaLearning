package com.htp.hometask4;



import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Test {




    public static void main(String[] args) {
        Transport newTransport = new Transport("Minsk - St.Petersburg", 800);
        newTransport.type();

        Plane newPlane = new Plane(100, 800, "kerosene", 70);
        newPlane.transportType();
        newPlane.trip("Minsk - Moscow", 700);
        newPlane.altTrip();

        Train newTrain = new Train(300, 100, "diesel", 50);
        newTrain.transportType();
        newTrain.trip("Minsk - Moscow", 700);
        newTrain.altTrip();

        Bus newBus = new Bus(40, 80, "diesel", 40);
        newBus.transportType();
        newBus.trip("Minsk - Moscow", 700);
        newBus.altTrip("Minsk - Smolensk", 400);


        int[] speedArray = new int[]{newPlane.getSpeed(), newTrain.getSpeed(), newBus.getSpeed()};
        int[] passangerArray = new int[]{newPlane.getPassangers(), newTrain.getPassangers(), newBus.getPassangers()};
        int[] ticketCostArray = new int[]{newPlane.getTicketCost(), newTrain.getTicketCost(), newBus.getTicketCost()};
        String[] nameArray = {"Airplane ", "Train ", "Bus "};

        Generator generator = new Generator((int[]) speedArray, (int[]) passangerArray, (int[]) ticketCostArray, (String[]) nameArray);

        generator.speedSorting();
        generator.passangerSorting();
        generator.minMaxSearch();


        Comparator<TransportName> transportComparator = new TransportComparator();
        List<TransportName> trans = new LinkedList<>();
        for (int i=0; i<nameArray.length; i++) {
            trans.add(new TransportName(nameArray[i]));
        }
        trans.sort(transportComparator);
        trans.forEach(System.out::println);

        }

    }



