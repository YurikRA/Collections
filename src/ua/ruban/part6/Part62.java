package ua.ruban.part6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part62 {

    public static void main(String[] args) {

        String fileName = args[0];
        StringBuilder sbl = new StringBuilder();
        List<String> strAll = new ArrayList<>();
        List<Integer> intAll = new ArrayList<>();

        Pattern p = Pattern.compile("(?im)(\\w+)|([Ё-їA-z]+)");
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            int c;
            while ((c=bis.read())!=-1) {
                sbl.append((char)c);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        Matcher m = p.matcher(sbl);
        while (m.find()) {
            strAll.add(m.group());
            intAll.add(m.group().length());
        }
        writeMax(intAll,strAll);
    }

    private static int searchMax(List<Integer> list){
        int max =0;
        for (int j=0; j<list.size(); j++) {
            int iTime = list.get(j);
            if (iTime>max) {
                max = iTime;
            }
        }
        return max;
    }

    private static void writeMax(List<Integer> list, List<String> st){
        int [] vInt = new int[3];
        String[] kStr = new String[3];
        int len = list.size();
        int indMass =0;
        boolean flag = true;

        while (flag){
            int max = searchMax(list);
            for (int n=0; n<len; n++) {
                if (kStr[2] !=null){
                    flag =false;
                    break;
                }
                if (list.get(n) == max){
                    kStr[indMass] = st.get(n);
                    vInt[indMass] = list.get(n);
                    len--;
                    st.remove(n);
                    list.remove(n);
                    indMass++;
                }
            }
        }
        for (int i=0; i<vInt.length; i++){
            System.out.println(kStr[i]+" ==> " +vInt[i]);
        }
    }
}
