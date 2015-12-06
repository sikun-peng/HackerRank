import java.util.*;

public class TwoSum{
	
	public static int[] twoSum(int[] array, int sum){
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i< array.length; i++){
			int value = array[i];
			if(map.containsKey(sum -  value)){
				return new int[]{map.get(sum - value) +1, i+1};
			}
			map.put(value, i);
		}
		throw new IllegalArgumentException("No valid input");
	}
	public static void main(String[] args){
		int[] a = {1, 2 , 4, 8, 16};
		int[]  b = twoSum(a, 12);
		System.out.println(b[0]+"  "+  b[1]);
	}

}