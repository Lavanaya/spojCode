package dp;

class CutRod {

    public int cutRod(int n, int[] p, int[] val){
        int local=Integer.MIN_VALUE;
        if(n<=0) return 0;
        else{

            for(int i=0;i<n;i++)
            {
                {
                   int  local1 = cutRod(n-i-1,p,val)+p[i];
                   if(local<local1)
                       local=local1;
                }
            }
        }
        return local;
    }

    public static void main(String[] args) {
        //int[] p= new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int[] p= new int[] {3, 5, 8, 9, 10, 17, 17, 20};
        int n= 8;
        CutRod cutRod=new CutRod();
        System.out.println(cutRod.cutRod(n,p, new int[8]));

    }
}
