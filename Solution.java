public class Solution{
	
	//1.InsertionSort
	
	public static int[] InsertionSort(int[] A){
		for(int i = 2; i< A.length; i++){
			int insert = A[i];
			int j = i-1;
			while( j>0 && insert < A[j]){
				A[j+1] =  A[j];
				j--;
			}
			A[j+1] = insert;
		}
		return A;
	}
	
	//2. BubbleSort
	public static int[] BubbleSort(int[ ] A){
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A.length -1 -i ; j++){
				if(A[j] > A[j+1]){
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}
		}
		return A;
	}
	
	
	//3. SelectionSort
	
	public static int[] SelectionSort(int[] A){
		for(int i = 0; i < A.length; i++){
			int min = i;
			for(int j = i+1; j< A.length; j++){
				if(A[i] > A[j]){
					int temp = A[j];
					A[j] = A[i];
					A[i] = temp;
				}
			}
		}
		return A;
	}
	
	
	//4. mergeSort
	public static int[] mergeSort(int[] A){
		if(A.length <= 1){
			return A;
		}
		if(A.length == 2){
			if(A[0] > A[1]){
				int temp = A[0];
				A[0] = A[1];
				A[1] = temp;
			}
			return A;
		}
		int mid = A.length/2;
		int[] a = new int[mid];
		int[] b = new int[A.length - mid];
		for(int i = 0; i<mid; i++){
			a[i] = A[i];
		}
		for(int j =0; j< A.length - mid; j++){
			b[j] = A[j + mid];
		}
		a = mergeSort(a);
		b = mergeSort(b);
		return merge(a,b);
	}
	
	public static int[] merge(int[] a, int[] b){
		int[] result = new int[a.length + b.length];
		int ai = 0, bi = 0, i = 0;
		while( i < result.length){
			if(ai == a.length){
				result[i] = b[bi];
				i++;
				bi++;
			}
			else if(bi == b.length){
				result[i] = a[ai];
				i++;
				ai++;
			}
			else if(a[ai] <= b[bi]){			
				result[i] = a[ai];
				i++;
				ai++;
			}
			else if(a[ai] > b[bi]){
				result[i] = b[bi];
				i++;
				bi++;
			}
		}
		return result;
	}
	

	
	
	//5. quickSort
	
	public static int[] quickSort(int[] A, int start, int end){
			if(end - start <= 2){				
				return A;}
			int[] B = { 1, 2, 3};
			int pivot = (start + end )/2;
			int i = start;
			int j = end -1  ;
			while(i < pivot && pivot != j ){
				if(A[i] > A[pivot] && A[pivot] > A[j] ){
					swap(A, i , j);
					i++;
					if(pivot +1 != j){
						j--;
					}
				}
				
				else if(A[i] > A[pivot] && A[j] > A[pivot]){
					swap(A, i, pivot);
				}
				else if(A[i] < A[pivot] && A[j] < A[pivot]){
					swap(A, j, pivot);										
				}
				else if (A[i] < A[pivot] && A[pivot] < A[j]){
					i++;
					if(pivot +1 != j){
						j--;
					}
				}
			}
					
			quickSort(A, start, pivot);			
			quickSort(A, pivot +1, end);	
		
		return A;
	}
	
	
	
	// 6. HeapSort
	
	public static int[] heapSort(int[] A){
		int[] result = A;
		for(int i = A.length ; i > 0; i-- ){
			result = maxHeap(result, i);			
			swap(result, 0, i-1);			
		}
		return result;
	}
	public static int[] maxHeap(int[] A, int last){	
		int[] B = new int[A.length];
		B[0] = A[0];
		for(int i = 1; i< A.length ; i++){
			B[i] = A[i];
			if(i < last){
				heap(B, i);
			}
		}
		return B;
	}
	
	public static int[] heap(int[] A, int last){
		int child  = last  ;
	    int parent = (child - 1) /2;
		while(child != 0){
			if(A[child] > A[parent]){
				swap(A, child, parent);			
				child = parent;
				parent = (child - 1 ) /2;
			}
			else if( A[child] <= A[parent]){
				return A;
				
			}
		}
		return A;
	}
	
	
	//7. countingSort
	
	public static int[] countingSort(int[] A, int range){
		int[] result = new int[A.length];
		int[] C = new int[range + 1];
		for(int i = 0; i < A.length; i++){
			C[A[i]]++;
		}
		for(int j = 1; j< range ; j++){
			C[j] = C[j] + C[j-1];
		}
		C[range] = C[range] + C[range -1 ];
		
		for(int k = A.length - 1; k>= 1; k--){
			result[C[A[k]]-1] = A[k];
			C[A[k]]--;
		}	
		return result;
	}
	
	
	//8.RadixSort not finished
	public static int[] RadixSort(int[] A, int digit){
		int[][] temp = new int[10][A.length];
		int d = 10;
		int index = 0;
		while( index < d){
			for(int i = 0; i<A.length; i++){
				d*= 10;
				
			}
		}
		return A;
	}
	
	//9 BucketSort not finished
	public static int[] BucketSort(int[] A, int range){
		int size = range / A.length ;
		int index = 0;
		int[][] bucket = new int[A.length][A.length];
		int[] result = new int[A.length];
		
		for(int i = 0; i< A.length; i++){
			BucketInsert(bucket[A[i]/size], A[i]);
		}
		
		for(int j = 0; j < A.length; j++){
			InsertionSort(bucket[j]);
			if(bucket[j][0] != 0){
				int k = 0;
				while(bucket[j][k] != 0){
					result[index] = bucket[j][k];
					k++;
					index++;
				}
			}
		}
		
		return result;
	}
	
	public static void BucketInsert(int[] A, int k){
		int i = 0;
		while(A[i] != 0){
			i++;
		}
		A[i] = k;
		
	}
	
	
	
	
	public static void swap(int[] A, int a, int b){
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
	
	public static void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+ " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		
		int[] array = {0,3,4,5,1,2,3,4,1,2,9,6,7 };
		int l = array.length;
		
		//array = InsertionSort(array);
		//array = BubbleSort(array);
		//array = SelectionSort(array);
		//array = mergeSort(array);
		//array = quickSort(array, 0, l);
		//array = heapSort(array );
		array = countingSort(array, 9);
		print(array);
		
	}
}