import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class sdet {

public static Map<String,Integer> item=new HashMap<>();
public static Map<String,Integer> number_of_items=new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> result=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		String s;
		for(int i=0;i<n;i++)
		{
			s=sc.nextLine();
			String[] array=s.split(" ");
			 item.put(array[0],Integer.parseInt( array[1]));
			 number_of_items.put(array[0], 0);
			
		}
		int queries=Integer.parseInt(sc.nextLine());
		for(int j=0;j<queries;j++)
		{
			String[] type_of_query=sc.nextLine().trim().split(" ");
		//	System.out.println(type_of_query[0]+" "+type_of_query[1]);
			
			switch (type_of_query[0]) {
			case "+":
				number_of_items.put(type_of_query[1], number_of_items.get(type_of_query[1])+1);
				//System.out.println(number_of_items.get(type_of_query[1]));
				break;
			
		case "-":
			number_of_items.put(type_of_query[1], number_of_items.get(type_of_query[1])-1);
			break;
			
		case "?":
			int numberOfItems=0;
			Set<String> itemNames=new HashSet<>();
			itemNames=item.keySet();
			java.util.Iterator<String> iterator=itemNames.iterator();
			
			while(iterator.hasNext())
			{
				 String s1=iterator.next();
				// System.out.println(s1 +" cost scanned:" +Integer.parseInt(type_of_query[1])+" cost from map:" +number_of_items.get(s1));
				if(item.get(s1) > Integer.parseInt(type_of_query[1]) )
					numberOfItems=numberOfItems+number_of_items.get(s1);
		}
			result.add(numberOfItems);
			break;
		}		
		}
		for(int i=0;i<result.size();i++)
			System.out.println(result.get(i));
	}

}
