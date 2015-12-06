public class Search{
	public static int BinarySearch(int[] A, int num){
		int low = 0; 
		int high = A.length -1 ;
		while(low <= high){
			System.out.println("low  "+ low + "  high  "+ high);
			int mid = (low + high) /2;
			if(A[mid] > num){
				high = mid ;
			}
			else if(A[mid] < num){
				low = mid ;
			}
			else{
				System.out.println(" find "+ mid); 
				return mid;
			}
		}
		return -1;
		
	}
	
	public static void main(String[] args){
		System.out.println("outpt");
		int[] array = {1, 2, 3, 6, 77, 90, 200, 302,1222};
		int a = BinarySearch(array, 77);
	}
}