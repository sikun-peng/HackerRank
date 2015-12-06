class Queen{
	static final int maxQueen = 8;
	static int num = 0;
	static int[] qArray = new int[maxQueen];
	
	Queen(){
		put(0);
		System.out.println("total of method is "+num);		
	}
	
	public static void put(int n){
		boolean no[] = new boolean[maxQueen];
		
		for(int j = 0; j< n; j++){
			no[qArray[j]] = true;
			 int d = n-j;  
            if(qArray[j]-d >= 0) {
				no[qArray[j]-d]=true;  
			}
            if(qArray[j]+d <= maxQueen-1){
				no[qArray[j]+d]=true;   
			}
			
		}
		
		for(int i = 0; i< maxQueen; i++){
			if( no[i] == false){
				qArray[n] = i;
				if(n < maxQueen - 1){
					put(n+1);
				}
				else{
					num++;
					print();
				}
			}
		}
	}

	public static void print(){
		for(int i = 0; i< maxQueen; i++){
			for(int j = 0; j < maxQueen; j++){
				if(j == qArray[i]){
					System.out.print("Q");
				}
				else{
					System.out.print("*");
				}
			}
			System.out.println();
		}
			
	}
	
	public static void main(String[] args){
		Queen q = new Queen();
		print();
		System.out.println("wo");
	}
}