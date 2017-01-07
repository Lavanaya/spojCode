
public class sort012 {

	public static void main(String[] args) {
			int[] a={};
	}
	
	public static int[] fn(int[] a){
		int l=0,r=a.length,m=1;
		
		while(l!=r){
			if(a[l]>a[r])
			{
				int t=a[l];
				a[l]=a[r];
				a[r]=a[l];
				l++;r--;
				
			}
			else if(a[l]>a[r]){
				l++;r--;
			}
			else if (a[l]==a[r]&&a[l]<m){
				r--;
			}
			else if(a[l]==a[r]&&a[l]>m){
				j++;
			}
		}
		return a;
		
	}

}
