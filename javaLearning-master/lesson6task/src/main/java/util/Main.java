package util;

import domain.Dishwasher;
import domain.Factory;
import domain.Owen;
import domain.Tv;
import domain.Fridge;


public class Main {
    public static void main(String[] args) {

        Tv tv = new Tv("TV", 300, 7);
        tv.method1();
        tv.method2();
        tv.genericMethod();

//       pattern Singleton - dishwasher

        Dishwasher dishwasher = Dishwasher.getInstance("Dishwasher", 450, .8);
        dishwasher.method1();
        dishwasher.method2();
        dishwasher.genericMethod();

//       pattern Builder

        Owen owen = new Owen.Builder()
                .addDepth(0.6)
                .addId("Owen")
                .addValue(500)
                .build();
        owen.method1();
        owen.method2();
        owen.genericMethod();

        Fridge fridge = new Fridge("Fridge", 500, 379);
        fridge.method1();
        fridge.method2();
        fridge.genericMethod();

//       Pattern Factory

        Factory factory = new Factory("Fridge");   // TV, Owen or Fridge
        factory.getCurrentTech();
    }

}
