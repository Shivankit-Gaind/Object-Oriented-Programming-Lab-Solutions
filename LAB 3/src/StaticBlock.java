public class StaticBlock {

	static int[] values = initializeArray(10);
	private static int[] initializeArray(int N) {
	 int[] arr = new int[N];
	 for (int i = 0; i < arr.length; i++) {
		 arr [i] = i;
	 }
	 return arr;
	 }
	
	 void listValues() {
	 for (int value : values) {  //Here, what exactly is happening is that the 'values' array is accessed, but before accessing its elements, the 'initializeArray' method is called
		 System.out.println(value);
	 }
}
	 
	 public static void main(String[] args) {
	 
		 StaticBlock example = new StaticBlock();
		 System.out.println("\nFirst object:");
		 example.listValues();
		 
		 values[0]=values[4]=100;
		 
		 example = new StaticBlock();
		 System.out.println("\nSecond object:");
		 example.listValues();
	 }
}