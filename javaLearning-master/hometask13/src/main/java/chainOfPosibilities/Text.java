package chainOfPosibilities;

public abstract class Text {
    private int choise;
    private Text next;

    public Text(int choise) {
        this.choise = choise;
    }

    public void setNext(Text next) {
        this.next = next;
    }

    public void manager(String report, int level) {
        if (level >= choise) {
            write(report);
        }
        if (next != null) {
            next.manager(report, level);
        }
    }

    public abstract void write(String report);
}
