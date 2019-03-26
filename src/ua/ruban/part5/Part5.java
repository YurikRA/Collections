package ua.ruban.part5;

public class Part5 {

    public static void main(String[] args) {
        String kr = "~~~~~~~";
        Tree<Integer> tree = new Tree<>();

        System.out.println(tree.add(3));
        System.out.println(tree.add(3));

        System.out.println(kr);
        tree.add(new Integer[] {1,2, 5, 4, 6, 0});
        tree.print();

        System.out.println(kr);
        System.out.println(tree.remove(5));
        System.out.println(tree.remove(5));

        System.out.println(kr);
        tree.print();
    }
}
