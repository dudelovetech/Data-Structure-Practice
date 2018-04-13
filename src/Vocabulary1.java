import java.io.*;
import java.util.*;

public class Vocabulary1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in1 = new Scanner(new File("/Users/owner/Documents/GitHub/Data-Structure-Practice/src/test1.txt"));
		Scanner in2 = new Scanner(new File("/Users/owner/Documents/GitHub/Data-Structure-Practice/src/test2.txt"));
		
		ArrayList<String> list1 = getWords(in1);
		ArrayList<String> list2 = getWords(in2);
		
		System.out.println("list1 before remove duplicate = " + list1);
		System.out.println("list2 before remove duplicate = " + list2);
		
		list1 = removeDuplicate(list1);
		list2 = removeDuplicate(list2);
		
		System.out.println("list1 = " + list1);
		System.out.println("list2 = " + list2);
	}
	
	private static ArrayList<String> getWords(Scanner input){
		ArrayList<String> words = new ArrayList<String>();
		while(input.hasNext()){
			String next = input.next().toLowerCase();
			words.add(next);
		}
		Collections.sort(words);
		return words;
	}
	
	private static ArrayList<String> removeDuplicate(ArrayList<String> list_){
		/*construct a new empty list.
		add first word to new list.
		for (each i) {
		    if (value at i does not equal value at i-1) {
		        add value at i.
		} }
		*/
		ArrayList<String> unique_ = new ArrayList<String>();
		unique_.add(list_.get(0));
		System.out.println(unique_.toString());
		for (int i = 1; i < list_.size(); i++){
			if (!list_.get(i).equals(list_.get(i-1))){
				unique_.add(list_.get(i));
			}
		}
		return unique_;
	}

}
