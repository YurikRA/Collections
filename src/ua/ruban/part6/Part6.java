package ua.ruban.part6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String file = null;
        String funk = null;
        if (args.length <2){
            String st = args[0];
            Pattern p = Pattern.compile("(\\S+)");
            Matcher m = p.matcher(st);
            int k=0;
            while (m.find()){
                k++;
                if (k==2){
                    file = m.group();
                }
                if (k==4){
                    funk = m.group();
                }
            }
        }
        if ((file == null)||(funk == null) ){
            file = args[1];
            funk = args[3];
        }
        switch (funk){
            case "frequency":
                Part61.main(new String[]{file});
                break;
            case "length":
                Part62.main(new String[]{file});
                break;
            case "duplicates":
                Part63.main(new String[]{file});
                break;
            default:
                System.out.println("No function");
                break;
        }
    }
}
