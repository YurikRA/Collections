package ua.ruban.part6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part61 {

    public static void main(String[] args) {

        String fileName = args[0];
        Map<String, Integer> mp = new HashMap<>();
        List<String> strAll = new ArrayList<>();
        Pattern p = Pattern.compile("(?im)(\\w+)|([Ё-їA-z]+)");

        StringBuilder sbl = Part61.createSB(fileName);

        Matcher m = p.matcher(sbl);
        while (m.find()) {
            String str = m.group();
            if (mp.containsKey(str)){
                int pr = mp.get(str);
                mp.put(str,++pr);
            }else {
                mp.put(str,1);
                strAll.add(str);
            }
        }

        int [] vInt = new int[3];
        String[] kStr = new String[3];
        int indMass =0;
        for (int j=0; j<3; j++){
            Collection<Integer> a = mp.values();
            int fu = Collections.max(a);
            int sizeT = mp.size();
            int kol=0;
            while (kol!=sizeT){
                if (kStr[2] !=null){
                    break;
                }
                String kT = strAll.get(kol);
                if (mp.get(kT) == fu){
                    kStr[indMass] = kT;
                    vInt[indMass] = mp.get(kT);
                    mp.remove(kT);
                    strAll.remove(kol);
                    sizeT--;
                    indMass++;
                }else {
                    kol++;
                }

            }
        }
        sortPrint(kStr, vInt);
    }

    private static StringBuilder createSB(String fileName){
        StringBuilder sbl = new StringBuilder();
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName))) {
            int c;
            while ((c=bis.read())!=-1) {
                sbl.append((char)c);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return sbl;
    }

    private static void sortPrint(String[] massS, int [] massI){
        for (int i=0; i<3; i++){
            for (int j=0; j<2; j++){
                int compare = massS[j].compareTo(massS[j+1]);
                if (compare<0){
                    String timeString = massS[j+1];
                    int timeInt = massI[j+1];
                    massS[j+1] = massS[j];
                    massI[j+1] = massI[j];
                    massS[j] = timeString;
                    massI[j] = timeInt;
                }
            }
        }
        for (int i=0; i<massI.length; i++){
            System.out.println(massS[i]+" ==> " +massI[i]);
        }
    }
}
