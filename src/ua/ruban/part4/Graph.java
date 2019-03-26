package ua.ruban.part4;

public class Graph {

    private int n;



    Graph(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public boolean create(){
        n++;
        return true;
    }

    public boolean remove(){
        n--;
        return true;
    }
}
