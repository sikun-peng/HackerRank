class newton{

		public static double square_root(double n){
			double x = n;
			double fx = x*x - n;
			while(fx > 0.0001 || fx < -0.0001){
				x = x - fx /(2*x) ;
				fx = x*x - n;
				System.out.println(" x " + x + " fx " + fx);
			}		
			return x;
		}
		
		
				
	

	public static void main(String[] args){
		double a = square_root(10);
		System.out.println("a is " + a);
		
	}
	
	
	
	
}