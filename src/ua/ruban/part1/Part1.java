package ua.ruban.part1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        StringBuilder sbt = new StringBuilder();
        String s = null;
        boolean fl = true;
        try(BufferedInputStream bis = new BufferedInputStream(System.in)){
            int c=0;
            String f="";
            while(fl){
                c=bis.read();
                sbt.append(String.valueOf((char)c));
                if (sbt.length()>4){
                    f = sbt.substring(sbt.length()-4,sbt.length());
                }
                if ("stop".equals(f)){
                    fl= false;
                }
            }
            sbt.delete(sbt.length()-4,sbt.length());
            s = String.valueOf(sbt);
        }catch (IOException e){
            e.printStackTrace();
        }
        int k=0;
        String[] srtM = new String[0];
        Pattern p = Pattern.compile("\\S+");
        Matcher m = p.matcher(s);
        while (m.find()){
            srtM = Arrays.copyOf(srtM, srtM.length+1);
            srtM[k] = m.group();
            k++;
        }
        WordContainer.main(srtM);
        StringBuilder sb = new StringBuilder();
        WordContainer wc = new WordContainer();
        wc = wc.getwK();
        for (int i=0; i<wc.size(); i++){
            sb.append(wc.get(i).getContent()).append(" : ").append(wc.get(i).getFrequency());
            System.out.println(String.valueOf(sb));
            sb.delete(0,sb.length());
        }
        wc.removeAll();
    }
}
