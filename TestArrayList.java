import java.util.*;

public class TestArrayList{
	public class SpencerArrayList<T>{
		private Object[] spencerElement;
		
		private int size;
		
		public SpencerArrayList(){
			this(10); 
		}
		
		public SpencerArrayList(int initialCapacity){
			spencerElement = new Object[initialCapacity];
		}
		
		public void ensureCapacity(int Capacity){
			int oldCapacity = spencerElement.length;
			if(Capacity > oldCapacity){
				int newCapacity = 3*oldCapacity/2 + 1;
				if(Capacity > newCapacity){
					newCapacity = Capacity;
				}
				spencerElement = Arrays.copyOf(spencerElement, Capacity);
			}
		}
		
		public int size(){
			return size;
		}
		
		public boolean isEmpt(){
			return size == 0;
		}
		
		public boolean add(T element){
			size += 1;
			ensureCapacity(size);
			spencerElement[size] = element;
			return true;
			
		}
		
		public boolean remove(Object nima){
			for(int i = 0; i< size; i++){
				if(nima.equals(spencerElement[i])){
					removeIndex(i);
					return true;
				}
			}
			
			return false;
		}
		
		public void removeIndex(int index){
			int moveLength = size - index - 1;
			System.arraycopy(spencerElement, index+1, spencerElement , index , moveLength);
			spencerElement[size] = null;
			size -= 1;
		}
		
		public void clear(){
			for(int i = 0; i< size; i++){
				spencerElement[i] = null;				
			}
			size = 0;
		}
		
		public T get(int index){
			return (T)spencerElement[index];
		}
		
		public T set(int index, T element){
			T oldValue = (T)spencerElement[index];
			spencerElement[index] = element;
			return oldValue;
		}
		
		public void add(int index, T element){			
			ensureCapacity(size+1);
			System.arraycopy(spencerElement, index, spencerElement, index+1, size - index);
			spencerElement[index] = element;
			size++;			
			
		}
		
		public int indexOf(Object o){
			for(int i = 0; i< size; i++){
				if(o.equals(spencerElement[i])){
					return i;
				}
			}
			return -1;
		}
		
		
		
	}
	
	
	
	public static void main(String[] args){
		
	}


}