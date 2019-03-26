package ua.ruban.part1;

import java.util.ArrayList;

public class WordContainer extends ArrayList {

    private static WordContainer wK;
    private static final long serialVersionUID = 1;

    public WordContainer getwK() {
        return wK;
    }

    public static void main(String[] args) {
        wK = new WordContainer();
        String[] myStr = args.clone();
        if (myStr.length ==0){
            Part1.main(new String[0]);
        }
        for (int i=0; i<myStr.length; i++){
            Word word = new Word(myStr[i]);
            wK.add(word);
        }
        wK.sort();
    }

    public void sort(){
        for (int i=0; i<wK.size();i++){
            for (int j=0; j<wK.size()-1;j++){
                if (wK.get(j+1).getFrequency()>wK.get(j).getFrequency()){
                    Word ws = wK.get(j);
                    wK.set(j,wK.get(j+1));
                    wK.set(j+1,ws);
                }
                if (wK.get(j+1).getFrequency()==wK.get(j).getFrequency()){
                    int comT = (wK.get(j+1).getContent()).compareTo(wK.get(j).getContent());
                    sortMini(comT,j);
                }
            }
        }
    }

    private static void sortMini(int comT, int j){
        if (comT<0){
            Word ws = wK.get(j);
            wK.set(j,wK.get(j+1));
            wK.set(j+1,ws);
        }
    }

    public boolean add(Word o) {
        boolean result = true;
        for (int i=0; i<wK.size(); i++){
            Word wAdd = wK.get(i);
            if ((wAdd.getContent()).equals(o.getContent())){
                result = false;
                int f = wAdd.getFrequency();
                wK.get(i).setFrequency(++f);
                break;
            }
        }
        if (result){
            super.add(o);
        }
        return result;
    }

    @Override
    public Word get(int index) {
        return (Word) super.get(index);
    }

    public Word set(int index, Word element) {
        return (Word) super.set(index, element);
    }

    public WordContainer removeAll() {
        while (wK.size()!=0){
            wK.remove(0);
        }
        return wK;
    }
}

