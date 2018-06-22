
/* second version of vocabulary program which reads two files
 * and reports the overlap between them. 
 * Compute Overlap
 */

import java.util.*;
import java.io.*;

public class Vocabulary2 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in1 = new Scanner(new File("test1.txt"));
		Scanner in2 = new Scanner(new File("test2.txt"));
		
		ArrayList<String> list1 = getWords(in1);
		ArrayList<String> list2 = getWords(in2);
		ArrayList<String> common = getOverlap(list1, list2);
	}

	public static ArrayList<String> getWords(Scanner input){
		//read all words and sort
		ArrayList<String> words = new ArrayList<>();
		while (input.hasNext()){
			String next = input.next().toLowerCase();
			words.add(next);
		}
		Collections.sort(words);
		
		// add unique words to new list and return 
		ArrayList<String> result = new ArrayList<>();
		if (words.size() > 0){
			result.add(words.get(0));
			for (int i = 0; i < words.size(); i ++){
				if(!words.get(i).equals(words.get(i-1))){
					result.add(words.get(i));
				}
			}
		}
		return result;
	}
	
	public static ArrayList<String> getOverlap(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> result = new ArrayList<String>();
		int i1 = 0;
		int i2 = 0;
		while (i1 < list1.size() && i2 < list2.size()){
			int num = list1.get(i1).compareTo(list2.get(i2));
			if (num == 0){
				result.add(list1.get(i1));
				i1 ++;
				i2 ++;				
			} else if (num < 0){
				i1 ++;
			} else{
				i2 ++;
			}							
		}
		return result;
	}
	
}
