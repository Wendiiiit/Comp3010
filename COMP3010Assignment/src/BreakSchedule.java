
import java.util.ArrayList;
import java.util.*;

public class BreakSchedule {

	// Use this class to implement programs for Tasks 2 & 3. Your file must not
	// change the package name,
	// nor the class name. You must not change the names nor the signatures of the
	// two program stubs
	// in this file. You may augment this file with any other method or
	// variable/data declarations that you
	// might need to implement the dynamic programming strategy requested for Tasks
	// 2&3.
	// Make sure however that all your declarations are public.

	// Precondition: word is a string and breakList is an array of integers in
	// strictly increasing order
	// the last element of breakList is no more than the number of characters in
	// word.
	// Postcondition: Return the minimum total cost of breaking the string word into
	// |breakList|+1 pieces, where
	// the position of each each break is specified by the integers in breakList.
	// Refer to the assignment specification for how a single break contributes to
	// the cost.

	//Task 2 
	//Method 1: brute-force way  
	int totalCost(String word, ArrayList<Integer> breakList) { 
		//costOptions enable us to pick the most optimal cost 
		ArrayList<Integer> costOptions = new ArrayList<>();
		
		for (int i = 0; i < breakList.size(); i++){
			//getting the break index 
			int breakIndex = breakList.get(i); 
			//getting the left substring 
			String leftSubString = word.substring(0, breakIndex + 1);
			//getting the left breaklist 
			ArrayList<Integer> leftBreakList = new ArrayList<Integer>();
			for (int j = 0; j < i; j++){
				int leftBreak = breakList.get(j); 
				leftBreakList.add(leftBreak);
			}
			//getting the left cost 
			int leftCost = this.totalCost(leftSubString, leftBreakList);
			
			//getting the right substring 
			String rightSubString = word.substring(breakIndex + 1, word.length());
			//getting the right breaklist 
			ArrayList<Integer> rightBreakList = new ArrayList<Integer>();
			for (int j = i+1; j < breakList.size(); j++){
				int rightBreak = breakList.get(j) - leftSubString.length(); 
				rightBreakList.add(rightBreak);
				
			}
			//getting the right cost 
			int rightCost = this.totalCost(rightSubString, rightBreakList);
			//getting the total cost of right and left 
			int totalCost = leftCost + rightCost + word.length();
			costOptions.add(totalCost);
		}

		//Return the most optimal cost from cost options 
		if (breakList.isEmpty()){
			return 0;
		}
		return Collections.min(costOptions); 
	}



	//Method 2: Dynnamic Programming Way 









	// Precondition: word is a string and breakList is an array of integers in
	// strictly increasing order
	// the last element of breakList is no more than the number of characters in
	// word.
	// Postcondition: Return the schedule of breaks so that word is broken according
	// to the list of
	// breaks specified in breakList which yields the minimum total cost.

	ArrayList<Integer> breakSchedule(String word, ArrayList<Integer> breakList) { // TODO Complete for Task 3
		return null;
	}

	// recursive call function, which will add up all the numbers in the list
	// [0, 1, 3 , 5, 10] = 19
	// []=0
	// [23, 38] = 61
	// only add 2 numbers, the first number + the rest of the list

	Integer countNumbInteger(ArrayList<Integer> list) {
		if (list.isEmpty()) {
			return 0;
		} else {
			int first = list.get(0);
			ArrayList<Integer> rest = new ArrayList<>(list);
			rest.remove(0);
			return first + countNumbInteger(rest);
			// differnce between rest.getfunction and function(rest);?
		}

	}

	// A recursive function that will return the given string, but take out all the
	// "e"
	// {d e f}
	// s is not empty, goes to else block.
	// s.charAt(0), return 'd'. s.substring(1,s.length()), return "ef". Altogether,
	// return 'd'+ "ef". This is what the function does without a recursive function
	// involved.

	String filterE(String s) {
		if (s.isEmpty()) {
			return "";
		}
		char first = s.charAt(0);
		String rest = s.substring(1, s.length());
		return filterE(rest) + first;

		if (s.isEmpty()) {
			return "";
		} else {
			char first = s.charAt(0);
			String rest = s.substring(1, s.length());
			return filterE(rest) + first;
		}

		// need an if statement to check if e exists
	}

}
