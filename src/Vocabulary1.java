import java.io.*;
import java.util.*;

public class Vocabulary1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in1 = new Scanner(new File("/Users/owner/Documents/GitHub/Data-Structure-Practice/src/test1.txt"));
		Scanner in2 = new Scanner(new File("/Users/owner/Documents/GitHub/Data-Structure-Practice/src/test2.txt"));

		ArrayList<String> list1 = getWords(in1);
		ArrayList<String> list2 = getWords(in2);

		System.out.println("list1 = " + list1);
		System.out.println("list2 = " + list2);
	}

	private static ArrayList<String> getWords(Scanner input) {
		// read all words and sort
		ArrayList<String> words = new ArrayList<String>();
		while (input.hasNext()) {
			String next = input.next().toLowerCase();
			words.add(next);
		}
		Collections.sort(words);

		// add unique words to new list and return
		ArrayList<String> result = new ArrayList<String>();
		if (words.size() > 0){
			result.add(words.get(0));
			for (int i = 1; i < words.size(); i++){
				if (!words.get(i).equals(words.get(i-1))){
					result.add(words.get(i));
				}
			}
		}
		return result;
	}
}
