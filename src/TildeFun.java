import java.util.ArrayList;

public class TildeFun {

	public static void main(String[] args) {
		// construct and fill up AarraList
		ArrayList<String> words = new ArrayList<String>();
		words.add("four");
		words.add("score");
		words.add("and");
		words.add("seven");
		words.add("years");
		words.add("ago");
		System.out.println("words = " + words);
		
		// insert one tilde in front of each word
		for (int i = 0; i < words.size(); i += 2){
			words.add(i, "~");
		}
		System.out.println("after loop words = " + words);
		
		// remove tildes
		for (int i = 0; i < words.size(); i ++){
			words.remove(i);
		}
		System.out.println("after second loop words = " + words);
		
		int sum = 0;
		for (String s:words){
			sum = sum+= s.length();
		}
		System.out.println("Total length of words is: " + sum);
		
		// play with int arraylist
		ArrayList<Integer> numList = new ArrayList<Integer>();
		numList.add(38);
		numList.add(56);
		numList.add(12);
		numList.add(9);
		numList.add(25);
		
		int sum_ = 0;
		for (int n : numList){
			sum_ += n;
		}
		System.out.println("list: " + numList);
		System.out.println("sum is: " + sum_);
	}

}
