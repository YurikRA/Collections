package ua.ruban.part1;

public class Word {

    private String content;
    private int frequency;

    Word(String content){
        this.content = content;
        frequency = 1;
    }

    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
