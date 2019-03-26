package ua.ruban.part6;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part63 {

    public static void main(String[] args) {

        String fileName = args[0];
        Map<String, Integer> mp = new HashMap<>();

        StringBuilder sbl = new StringBuilder();
        List<String> strAll = new ArrayList<>();

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
            String str = m.group();
            if (mp.containsKey(str)){
                int pr = mp.get(str);
                mp.put(str,++pr);
            }else {
                mp.put(str,1);
                strAll.add(str);
            }
        }

        int ch = 0;
        for (int i=0; i<mp.size(); i++){
            int count = mp.get(strAll.get(i));
            if (count>1){
                StringBuilder strBuff = new StringBuilder();
                strBuff.append(strAll.get(i).toUpperCase());
                System.out.println(String.valueOf(strBuff.reverse()));
                ch++;
            }
            if (ch>2){
                break;
            }
        }
    }
}
