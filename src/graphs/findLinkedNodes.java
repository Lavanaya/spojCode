package graphs;


import java.util.*;

public class findLinkedNodes {

    public static void main(String[] args) {
        String[][] dependencies= new String[][]{
                {"A", "B"},   // A depends on B
                {"A", "C"},   // A depends on C

                {"A", "C"},   // A depends on C - yes we can have duplicate entries
                {"B", "C"},
                {"B", "E"},
                {"C", "G"},
                {"D", "A"},
                {"D", "F"},

                {"E", "F"},

                {"F", "H"},

        };
        HashMap<String,Set<String>> map=makeGraph(dependencies);
        System.out.println(getAttachedNodes("E",map,new HashSet<>(),new ArrayList<>()));

    }

    public static HashMap<String,Set<String>> makeGraph(String[][] s){
        HashMap<String,Set<String>> map=new HashMap<>();
        if(s==null) return map;
        int n=s.length;
        int m=s[0].length;
        for(int i=0;i<n;i++){
            if(map.containsKey(s[i][0])){
               map.get(s[i][0]).add(s[i][1]);
            }
            else {
                Set list= new HashSet(); list.add(s[i][1]);
                map.put(s[i][0],list);
            }
        }
        return map;
    }

    public static Set<String> getAttachedNodes(String key,HashMap<String,Set<String>> map,HashSet<String> set, List<String> visited){
        visited.add(key);
        if(!map.containsKey(key)) return set;
        Iterator<String> iterator=map.get(key).iterator();


        while (iterator.hasNext()){
           String st= iterator.next();
           set.add(st);
           if(!visited.contains(st))
               getAttachedNodes(st,map,set,visited);

        }
        return set;
    }
}
