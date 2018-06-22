
// This program reads two text files and compares the vocabulary used in each

import java.util.*;
import java.io.*;

public class Vocabulary3 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		giveIntro();
		
		System.out.println("file #1 name? ");
		Scanner in1 = new Scanner(new File(console.nextLine()));
		System.out.println("file #2 name? ");
		Scanner in2 = new Scanner(new File(console.nextLine()));
		System.out.println();
		
		ArrayList<String> list1 = getWords(in1);
		ArrayList<String> list2 = getWords(in2);
		ArrayList<String> common = getOverlap(list1, list2);
		
		reportResults(list1, list2, common);
	}

	// pre: common contains overlap between list1 and list2
	// post: reports statistics about lists and their overlap
	private static void reportResults(ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> common) {
		System.out.println("file #1 words = " + list1.size());
		System.out.println("file #2 words = " + list2.size());
		System.out.println("common words = " + common.size());
		
		double pct1 = 100.0 * common.size() / list1.size();
		double pct2 = 100.0 * common.size() / list2.size();
		System.out.println("% of file 1 in overlap = " + pct1);
		System.out.println("% of file 2 in overlap = " + pct2);		
	}

	// pre: list1 and list2 are sorted and have no duplicates
	// post: constructs and returns an ArrayList containing the words
	//		in common between list1 and list2
	private static ArrayList<String> getOverlap(ArrayList<String> list1, ArrayList<String> list2) {
		ArrayList<String> result = new ArrayList<>();
		int i1 = 0;
		int i2 = 0;
		while(i1 < list1.size() && i2 < list2.size()) {
			int num = list1.get(i1).compareTo(list2.get(i2));
			if (num == 0) {
				result.add(list1.get(i1));
				i1++;
				i2++;
			} else if (num < 0) {
				i1++;
			} else { //num > 0
				i2++;
			}
		}
		return result;
	}

	// post: reads words from the Scanner, converts them to lowercase,
	// returns a sorted list of unique words.
	private static ArrayList<String> getWords(Scanner input) {
		// ignore all but alphabetic characters and apostrophes
		input.useDelimiter("[^a-zA-Z']+");
		// read all words and sort
		ArrayList<String> words = new ArrayList<>();
		while (input.hasNext()) {
			String next = input.next().toLowerCase();
			words.add(next);
		}
		Collections.sort(words);
		
		// add unique words to new list and return
		ArrayList<String> result = new ArrayList<>();
		if (words.size() > 0) {
			result.add(words.get(0));
			for (int i = 1; i < words.size(); i++) {
				if (!words.get(i).equals(words.get(i - 1))) {
					result.add(words.get(i));
				}
			}
		}
		return result;
	}

	// post: explains program to user
	private static void giveIntro() {
		System.out.println("This program compares two tet files");
		System.out.println("and reports the number of words in");
		System.out.println("common and the percent overlap.");
		System.out.println();		
	}
}