package array;

import java.util.LinkedHashSet;

public class firstNonRepeatingChar {
    public static void main(String[] args) {
        getNonRepeatingChar gNRC=new getNonRepeatingChar();
        gNRC.push('a');
        System.out.println(gNRC.getFirstChar());
        gNRC.push('a');
        gNRC.push('b');
        gNRC.push('c');
        System.out.println(gNRC.getFirstChar());
    }

}

class getNonRepeatingChar{
    LinkedHashSet<Character> set;

    public getNonRepeatingChar(){set=new LinkedHashSet<>();}
    public void push(char c){
        if(!set.contains(c))
            set.add(c);
        else
            set.remove(c);
    }
    public char getFirstChar(){
        if(set.iterator().hasNext())
            return set.iterator().next();
        else
            return '@';
    }
}
