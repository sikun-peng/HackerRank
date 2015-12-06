import java.util.*;

class GuessNumber{
	public static class GuessObject{
		private int position ; //
		private int value ;
		GuessObject(){
			Random rand = new Random();
			this.value = (rand.nextInt(10)+1)% 9 + 1  ;
		}
		
		GuessObject(int v){
			value = v;
		}
		
		GuessObject(int v, int p){
			this.value = v;
			this.position = p;
		}
		public int getPosition(){
			return this.position;
		}
		
		public int getValue(){
			return this.value;
		}			
	}

	
	public static class Guess extends GuessObject{
		private GuessObject[] gArray ;		
		Guess(int num){
			gArray = new GuessObject[num];
			gArray[0] = new GuessObject();				
			for(int i = 1; i < num; i++){
				boolean duplicate = true;
				
				while(duplicate == true){
					gArray[i] = new GuessObject();
					gArray[i].position = i ;
					boolean same = false;
					for(int j = 0; j < i ; j++){
						if(gArray[j].getValue() == gArray[i].getValue()){
							same = true;
							break;
						}
					}
					
				    if(same == false){
						duplicate = false; 
					}					
				}
			}
		}
	
		
		public int compare(GuessObject ob){
			
			for(int i = 0; i < gArray.length; i++){
				if(this.gArray[i].getValue() == ob.getValue() && this.gArray[i].getPosition() == ob.getPosition() ){
					return 1;
				}
				else if(this.gArray[i].getValue() == ob.getValue() && this.gArray[i].getPosition() != ob.getPosition()){
					return 2;
				}
			}
			return 0;
		}
		
		public void print(){
			for(int i = 0; i< gArray.length; i++){
				System.out.print(gArray[i].getValue() + " ");
			}
			System.out.println();
		}
		
		
		public GuessObject getObject(int position){
			return this.gArray[position];
		}
	}
	
	
	public static void main(String[] args){
		boolean result = false;
		int count = 0;
		Guess guess = new Guess(4); 
		guess.print();
		while(result == false && count < 8){
			
			System.out.println("put four numbers, you've tried  " + count + "  times");
			Scanner sc = new Scanner(System.in);
			int A = 0;
			int B = 0;
			for(int i = 0; i < 4; i++){				
				GuessObject temp = new GuessObject(sc.nextInt(), i);
				int index = guess.compare(temp);
				if(index == 1){
					A++;
				}
				else if(index == 2){
					B++;
				}
				
			}
			
			System.out.println(A+"A" + B+"B");
			if(A == 4){
				result = true;
			}
			count++;
			
		}
		if(result == true){
			System.out.println("You win");
			
		}
		else if(count == 8){
			System.out.println("game over");
		}
		System.out.print("the answer is " );
		guess.print();
	}
}