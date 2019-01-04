package domain;

public class Factory {

    private String item;


    public Factory(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Factory factory = (Factory) o;

        return item != null ? item.equals(factory.item) : factory.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "item='" + item + '\'' +
                '}';
    }

    public void getCurrentTech() {
        if (item.equals("TV")) {
            Tv tech1 = new Tv("TV", 300, 7);
            tech1.genericMethod();
        } else if (item.equals("Owen")) {
            Owen tech2 = new Owen("Owen", 500, .6);
            tech2.genericMethod();
        } else if (item.equals("Fridge")) {
            Fridge tech3 = new Fridge("Fridge", 500, 379);
            tech3.genericMethod();
        } else {
            System.out.println("This item isn't exist");
        }

    }
}

