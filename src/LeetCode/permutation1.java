package LeetCode;

import java.util.*;

/**
 * string permutations
 * @author lavanya
 *
 */
public class permutation1 {
  
  private static List<List<Integer>> list;
	  public static void main(String args[]) {
		  list= new ArrayList<List<Integer>>();
		  int[] arr={1};
		  String s="";
		  List<Integer> listStart=new ArrayList<Integer>();
		  List<Integer> listEnd=new ArrayList<Integer>();
		  
		  
		  for(int i=0;i<arr.length;i++)
			  listEnd.add(arr[i]);
				  
		    permuteString(listStart, listEnd);
		    
		  }

		  public static void permuteString(List<Integer> beginningString, List<Integer> endingString) {
		    if (endingString.size() <= 1)
		    {
		    	//ArrayList<Integer> temp=new ArrayList<>();
		    	List<Integer> s1= new ArrayList<Integer>();
		    	s1.addAll(beginningString);
		    	s1.addAll(endingString);
		    	/*for(int i=0;i< (s1).length();i++)
		    	temp.add(Integer.parseInt(s1.charAt(i)+""));
		    	*/
		    	list.add(s1);
		    	System.out.println(s1);
		    }
		    else
		      for (int i = 0; i < endingString.size(); i++) {
		        try {
		          List<Integer> newList =new ArrayList<Integer>();
		          newList.addAll(endingString.subList(0, i));
		          newList.addAll(endingString.subList(i + 1, endingString.size()));
		         // beginningString.add(endingString.get(i));
		          ArrayList<Integer> temp=new ArrayList<>();
		          temp.addAll(beginningString);
		          temp.add(endingString.get(i));
		         // System.out.println("new List"+temp);
		          permuteString(temp, newList);
		        } catch (StringIndexOutOfBoundsException exception) {
		          exception.printStackTrace();
		        }
		      }
		  }
		}
	

