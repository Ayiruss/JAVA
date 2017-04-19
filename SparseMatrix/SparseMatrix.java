import java.util.Scanner;


public class SparseMatrix {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int nz,n_nz_rows,max_col=0;
		int val[],col_ind[],row_ptr[];
		int sparse[][];
		System.out.println("Enter the total no of Non-Zero Values : ");
		nz=in.nextInt();
		val=new int[nz];
		//Read the input of non-zero values
		for(int i=0;i<nz;i++){
			System.out.println("Enter the value of " + i + " :");
			val[i]=in.nextInt();
		}
		col_ind = new int[nz];
		//Read the input of Column Indicator
		for(int i=0;i<nz;i++){
			System.out.println("Enter the column_indicator" + i + " :");
			col_ind[i]=in.nextInt();
			if(max_col<col_ind[i])
				max_col=col_ind[i];
		}
		
		System.out.println("Enter the No of row pointers : ");
		n_nz_rows=in.nextInt();
		int max[]=new int[n_nz_rows];
		row_ptr = new int[n_nz_rows];
		//Read the input of Row Pointer
		for(int i=0;i<n_nz_rows;i++){
			System.out.println("Enter the row pointer" + i + " :");
			row_ptr[i]=in.nextInt();
		}
		//Finding the Maximum in Each Row 
		for(int i=0;i<n_nz_rows;i++){
			max[i]=0;
			int len;
			int j;
			if(i+1==n_nz_rows){
				len =nz;
				j=row_ptr[i];
			}
			else{
				len = row_ptr[i+1];
				j=row_ptr[i];
			}
			for(;j<len;j++){
				if(max[i]<val[j])
					max[i]=val[j];
			}
			System.out.println(max[i]);
		}
		int row=0,col=0,val_ind=0;
		sparse = new int[n_nz_rows][max_col+1];
		//Generating the Matrix with Max element in index with zero value
		System.out.println("Final Matrix :");
		for(int i=0;i<n_nz_rows;i++){
			for(int j=0;j<max_col+1;j++){
				if(j==col_ind[col]){
					sparse[i][j]=val[val_ind];
					col++;
					val_ind++;
				}
				else{
					sparse[i][j]=max[i];
				}
				System.out.print(sparse[i][j] + "   ");
			}
			System.out.println();
		}
	}
}
