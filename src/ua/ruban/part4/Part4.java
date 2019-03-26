package ua.ruban.part4;

public class Part4 {

    public static void main(String[] args) {

        String c ="Count ";

        Graph gr = new Graph(5);
        System.out.println(c.concat(String.valueOf(gr.getN())));
        gr.create();
        System.out.println(c.concat(String.valueOf(gr.getN())));
        gr.remove();
        System.out.println(c.concat(String.valueOf(gr.getN())));
    }
}
