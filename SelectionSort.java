public class SelectionSort {
	public static void main(String[] args) {
		int[] arr = {1,2,6,5,8,7,9};
		
		for (int i=0; i < arr.length; i++) {
			int lowestNumber = i;	
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[lowestNumber]) lowestNumber = j;
			}
			
			int temp = arr[i];
			arr[i] = arr[lowestNumber];
			arr[lowestNumber] = temp;
		}
		
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
	