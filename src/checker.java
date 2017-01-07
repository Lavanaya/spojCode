import java.util.*;
public class checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Map<String,List<Integer>> name=new HashMap<>();
		Map<String,List<Integer>> address=new HashMap<>();
		Map<String,List<Integer>> homeTown=new HashMap<>();
		Map<String,List<Integer>> age=new HashMap<>();
		
		
		
		List<Integer> nameL=new ArrayList<>();
		List<Integer> addressL=new ArrayList<>();
		List<Integer> homeTownL=new ArrayList<>();
		List<Integer> ageL=new ArrayList<>();
		
		Set<String> myList = new HashSet<String>();
		
		int n=Integer.valueOf(sc.nextLine());
		for (int i=1;i<=n;i++){
			String s=sc.nextLine();
			String[] array=s.split(" ");
			if(name.containsKey(array[0])){
				nameL.remove(array[0]);
				nameL.addAll(name.get(array[0]));name.put(array[0],nameL);
				
				for(Integer list : name.get(array[0]))
				myList.add(list+" "+i);
				} 
			else{
				nameL=new ArrayList<Integer>();
				nameL.add(i);
				name.put(array[0],nameL);
				
			}
			
			if(address.containsKey(array[1])) 
			{ 
				addressL.remove(array[1]);
				addressL.addAll(address.get(array[1]));
				address.put(array[1],addressL);
				
				for(Integer list:address.get(array[1])) myList.add(list+" "+i);
			
			}
			else
			{
				addressL=new ArrayList<Integer>();
				addressL.add(i);
				address.put(array[1],addressL);
			}
			
			if(homeTown.containsKey(array[2])) 
			{
				homeTownL.remove(array[2]);
				homeTownL.addAll(homeTown.get(array[2]));homeTown.put(array[2],homeTownL);
				
				for(Integer list:homeTown.get(array[2])) myList.add(list+" "+i);
			
			}
			else
			{
				homeTownL=new ArrayList<Integer>();
				homeTownL.add(i);
				homeTown.put(array[2],homeTownL);
			}
			
			if(age.containsKey(array[3])) 
			{
				ageL.remove(array[3]);
				ageL.addAll(age.get(array[3]));age.put(array[3],ageL);
			
				for(Integer list:age.get(array[3])) myList.add(list+" "+i);
			}
			else
			{
					ageL=new ArrayList<Integer>();
					ageL.add(i);
					age.put(array[3],ageL);
			}
			
		}

		System.out.print("\n"+myList.size());
		
		 Iterator iterator = myList.iterator(); 
	      
		   // check values
		   while (iterator.hasNext()){
		   System.out.println(iterator.next());  
		   }
		/*for(int i=0;i<myList.size();i++)
			System.out.println(myList.get(i));
*/	}

}
