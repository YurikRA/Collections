package ua.ruban.part3;

public class Part3 {

    public static void main(String[] args) {
        int n=6;
        Parking p = new Parking();
        Parking.createOb(n);
        Parking.print();
        Parking.print();
        Parking.arrival(1);
        Parking.arrival(5);
        Parking.arrival(5);
        Parking.arrival(1);
        Parking.arrival(1);
        Object[] c1 = p.getPark();
        Parking.county(c1[1]);
        Parking.county(c1[2]);
    }
}
