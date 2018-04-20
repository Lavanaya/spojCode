package array;

import java.util.HashMap;
import java.util.Map;

 class firstFrequentlyOccringChar {
    public static void main(String[] args) {
        String str = "yoloo stringggg stream";
        Map<Character, Integer> map = new HashMap<>();
        int max_count = 0;
        char max_character='@';
        for (char c : str.toCharArray()) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
            int counter = map.get(c);
            if (counter > max_count) {
                max_count = counter;
                max_character=c;
            }
        }

        System.out.println("Max. occurring count:  " + max_count);
        System.out.println("Max. frequently occurring char: " + max_character);

    }
}

//time: o(1) and 26 extra spaces for map