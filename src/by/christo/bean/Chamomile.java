package by.christo.bean;

public class Chamomile {
    private int petalsNum;

    public Chamomile() {
        this.petalsNum = (int)(Math.random() * 11 + 5);
    }

    public int getPetalsNum() {
        return petalsNum;
    }
}
