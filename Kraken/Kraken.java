import java.util.Scanner;


public class Kraken {

	static int m,n,count=0;
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter No of Rows :");
		m=in.nextInt();
		System.out.println("Enter No of Columns :");
		n=in.nextInt();
		krakenCountRecursion(0,0);
		System.out.println("No of Possible Ways using Recursion : " + count);
		System.out.println("No of Possible Ways using Arrays : " + krakenCountArray(m,n));
	}
	
	
	//Using Recursion to find total no of ways but its time complexity is more
	static void krakenCountRecursion(int i,int j){
		 if(i==m-1 || j==n-1){
	            count = count +1;
	        }
	        else{
	        if(i+1<m)
	        	krakenCountRecursion(i+1,j);
	        if(j+1<n)
	        	krakenCountRecursion(i,j+1);
	        if(i+1<m && j+1<n)
	        	krakenCountRecursion(i+1,j+1);
	        }
	}
	
	//Using linear method by calculating the sum of adjacent ways
		static int krakenCountArray(int m,int n){
			int arr[][] = new int[m][n];
			int max = 0;
			if(m>n) max=m;
			else max=n;
			for(int i=0;i<max;i++){
				if(i<n)
				arr[0][i]=1;
				if(i<m)
				arr[i][0]=1;
			}
			for(int i=1;i<m;i++){
				for(int j=1;j<n;j++){
					arr[i][j]=arr[i-1][j]+arr[i][j-1]+arr[i-1][j-1];
				}
			}
			return arr[m-1][n-1];
		}

}
