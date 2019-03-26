package ua.ruban.part3;

import java.util.Arrays;

public class Parking {

    private static Object[] park = new Object[0];
    private static int fg;

    public static void createOb(int n){
        park = Arrays.copyOf(park,n);
    }

    private static class Car{
        private  int d;

        Car(){
            this.d =fg++;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Car").append(Car.this.d);
            return String.valueOf(sb);
        }
    }

    public static void county(Object ob){
        if (ob ==null){
            System.out.println("Null object");
        }else {
            for (int i=0; i<park.length;i++){
                if (ob.equals(park[i])){
                    park[i]=null;
                }
            }
        }
        print();
    }

    public static void arrival(int k){
        Car car = new Car();
        if (park[k] != null){
            for (int i=k; i<park.length-1;i++){
                k++;
                if (park[k] == null){
                    park[k] = car;
                    break;
                }
            }
        }else {
            park[k] = car;
        }
        print();
    }

    public Object[] getPark() {
        return park.clone();
    }

    public static void print(){
        for (int i=0;i<park.length;i++){
            if (i ==park.length-1){
                System.out.println(park[i]);
            }else {
                System.out.print(park[i]+" | ");
            }
        }
    }
}
