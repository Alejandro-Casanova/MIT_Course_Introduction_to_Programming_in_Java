package Assignment_7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MagicSquares {
	public static boolean testMagic(String pathName) throws IOException, FileNotFoundException{
		
		BufferedReader reader = new BufferedReader(new FileReader(pathName));
		ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
		
		int currentRow = 0;
        
        boolean isMagic = true;
        int lastSum = -1;
        
        // For each line in the file ...
        String line = null;
        while ((line = reader.readLine()) != null) {
            // ... sum each row of numbers
            String[] parts = line.split("\t");
            int sum = 0;
            
            try {
            	// For each string segment...
	            for (String part : parts) {
	    
	            	// Parse to int
	            	int intPart = Integer.valueOf(part);
	            	sum += intPart;
	            	
	            	// Add nums to List
	            	try {
	            		numbers.get(currentRow).add(intPart);
	            	}catch(IndexOutOfBoundsException err) {
	            		// If no row available...
	            		numbers.add(new ArrayList<Integer>()); // Initialize Row
	            		numbers.get(currentRow).add(intPart);
	            	}
	            	
	            }
	            currentRow++;
	        	
	            if (lastSum == -1) {
	                // If this is the first row, remember the sum
	                lastSum = sum;
	            } else if (lastSum != sum) {
	                // if the sums don't match, it isn't magic, so stop reading
	                isMagic = false;
	                break;
	            }
            } catch(NumberFormatException err) {
            	// Skip empty rows
            	continue;
			}
        }
        
        reader.close();
        
        // Display numbers saved in List and dimensions
        for(ArrayList<Integer> row: numbers) {
        	for(Integer num: row) {
        		System.out.print(num + " ");
        	}
        	System.out.println();
        }
        System.out.println("\nNum Rows: " + currentRow);
        System.out.println("List rows: " + numbers.size());
        System.out.println("Row size: " + numbers.get(0).size() + "\n");
        
        // Check columns
        for(int j = 0; j < numbers.size(); j++) {
        	int sum = 0;
        	for(int i = 0; i < numbers.get(j).size(); i++) {
        		sum += numbers.get(j).get(i);
        	}
        	
        	if (lastSum != sum) {
                // if the sums don't match, it isn't magic, so stop reading
                isMagic = false;
                return isMagic;
            }
        }
    
        // Check Main Diagonal
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++) {
        	sum += numbers.get(i).get(i);
        }
        if (lastSum != sum) {
            // if the sums don't match, it isn't magic, so stop reading
            isMagic = false;
            return isMagic;
        }
        
        // Check Inverse Diagonal
        sum = 0;
        for(int i = 1; i <= numbers.size(); i++) {
        	sum += numbers.get(numbers.size()-i).get(i-1);
        }
        if (lastSum != sum) {
            // if the sums don't match, it isn't magic, so stop reading
            isMagic = false;
            return isMagic;
        }
        
        
        return isMagic;
    }

	public static void main(String[] args) throws IOException {
		String[] fileNames = { "Mercury.txt", "Luna.txt" };
		for (String fileName : fileNames) {
			System.out.println(fileName + " is magic? " + testMagic("src/Assignment_7/" + fileName) + "\n");
		}
	}
}
