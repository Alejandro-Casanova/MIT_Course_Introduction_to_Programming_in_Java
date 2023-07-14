package Introduction_to_Java_Assignments;

public class A2_FooCoorporation {
	public static void printTotalPay(double basePay, int hours) {
		if(basePay < 8.0) {
			System.out.println("Base Pay must be at least $8.00/hour");
		}else if(hours > 60){
			System.out.println("Weekly working hours must be under 60");
		}else if(hours <= 40){
			System.out.println("Total Pay: $" + basePay*hours);
		}else{
			System.out.println("Total Pay: $" + (basePay*40 + basePay*(hours-40)*1.5));
		}
	}
	
	public static void main(String[] args) {
		double[] employeePay = {7.5, 8.2, 10.0};
		int[] employeeHours = {35, 47, 73};
		
		for(int i = 0; i < 3; i++) {
			printTotalPay(employeePay[i], employeeHours[i]);
		}
		
	}
}
