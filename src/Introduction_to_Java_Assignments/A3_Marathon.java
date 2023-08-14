package Introduction_to_Java_Assignments;

public class A3_Marathon {
	
	public static int bestRunner(int[] times) {
		int best_time = Integer.MAX_VALUE;
		int best_index = -1;
		
		for(int i = 0; i < times.length; i++) {
			if(times[i] < best_time) {
				best_time = times[i];
				best_index = i;
			}
		}
		
		return best_index;
	}
	
	public static int secondBestRunner(int[] times) {
		int best_time_index = bestRunner(times);
		int second_best_time = Integer.MAX_VALUE;
		int second_best_time_index = -1;
		
		if(best_time_index == 0) {
			if(times.length <= 1) 
				return -1;
			second_best_time = times[1];
			second_best_time_index = 1;
		}
			
		for(int i = 0; i < times.length; i++) {
			if(i == best_time_index){
				continue;
			}else if(times[i] < second_best_time) {
				second_best_time = times[i];
				second_best_time_index = i;
			}
		}
		
		return second_best_time_index;
	}
	
	public static void main(String[] arguments) {
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James",
				"Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate" };

		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265 };

//		for (int i = 0; i < names.length; i++) {
//			System.out.println(names[i] + ": " + times[i]);
//		}
		
		int best_index = bestRunner(times);
		int second_best_index = secondBestRunner(times);
		
		// Best runner found		
		if(best_index >= 0) { 
			// No second place
			if(second_best_index < 0) {
				System.out.println("First Place: " + names[best_index] + ": " + times[best_index]);
				System.out.println("There's no second place.");
			// Tie!
			}else if( times[best_index] == times[second_best_index]){
				System.out.println("It's a tie! " + names[best_index] + ": " + times[best_index] + " - " + names[second_best_index] + ": " + times[second_best_index]);
			}else {
				System.out.println("First Place: " + names[best_index] + ": " + times[best_index]);
				System.out.println("Second Place: " + names[second_best_index] + ": " + times[second_best_index]);
			}
		}else {
			System.out.println("There's no runners.");
		}
	}

}
