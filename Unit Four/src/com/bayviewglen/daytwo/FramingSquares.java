package com.bayviewglen.daytwo;

public class FramingSquares {

	public static void main(String[] args) {
		int m, n, p, q;
		m = 3;
		n = 4;
		p = 1;
		q = 2;
		
		for (int i = 0; i < q; i++){
			for (int j = 0; j < n + 2*p + 2*q; j++){
				System.out.print("#");
			}
			System.out.println();
		}
		
		for (int i = 0; i < p; i++){
				for (int k = 0; k < q; k++){
					System.out.print("#");
				}
				for (int l = 0; l < 2*p+n; l++){
					System.out.print("+");
				}
				
				for (int k = 0; k < q; k++){
					System.out.print("#");
				}
				System.out.println();
		}

			
			
		for (int i = 0; i < m; i++){
			for (int j = 0; j < q; j++){
				System.out.print("#");
			}
			
			for (int l = 0; l < p; l++){
				System.out.print("+");
			}
		
			for (int k = 0; k < n; k++){
				System.out.print(".");
			}
			
			for (int l = 0; l < p; l++){
				System.out.print("+");
			}
			
			for (int j = 0; j < q; j++){
				System.out.print("#");
			}
			System.out.println();
		}
		
			
	
		for (int i = 0; i < p; i++){
				for (int k = 0; k < q; k++){
					System.out.print("#");
				}
				for (int l = 0; l < 2*p+n; l++){
					System.out.print("+");
				}
				
				for (int k = 0; k < q; k++){
					System.out.print("#");
				}
				System.out.println();
			}
		
			
			
		for (int i = 0; i < q; i++){
			for (int j = 0; j < n + 2*p + 2*q; j++){
				System.out.print("#");
			}
			System.out.println();
		}

	}

}
