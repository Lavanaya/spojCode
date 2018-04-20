class Subsequence {

    public static void print(String prefix, String remaining, int k) {
        //if (k == 0)
        {
            System.out.println(prefix);
          //  return;
        }
        if (remaining.length() == 0) return;
        print(prefix + remaining.charAt(0), remaining.substring(1), k-1);
        print(prefix, remaining.substring(1), k);
    }


    public static void main(String[] args) {
        String s = "abcc";
        int k = 3;
        print("", s, k);
    }

}