import java.util.Scanner;


public class SimilarityGraph {
	public static void main(String[] args) {
	    
	        Integer[][] graphA;
	        Integer[][] graphB;
	        Scanner in = new Scanner(System.in);
	        System.out.print("Enter the number of Nodes for GraphA:");
	        int n = in.nextInt();
	        graphA =  new Integer[n][n];
	        for(int i=0;i<n;i++){
	            graphA[i] = new Integer[n];
	            for(int j=0;j<n;j++){
	            	if(i==j)
	            		graphA[i][j]=0;
	            	else{
	            		System.out.print("is there a connection b/w Node " + i + " and " + j + " :");
	            		graphA[i][j]=in.nextInt();
	            	}
                }
            }
	        Graph A = new Graph(graphA);
	        //calculate the no of indegree nodes and outdegree nodes for graph A
	        A.calculateInOut();
	        System.out.print("Enter the number of Nodes for GraphB:");
            n = in.nextInt();
            graphB =  new Integer[n][n];
            for(int i=0;i<n;i++){
                graphB[i] = new Integer[n];
                for(int j=0;j<n;j++){
                	if(i==j){
                		graphB[i][j]=0;
                	}
                	else{
                		System.out.print("is there a connection b/w Node " + i + " and " + j + " :");
                		graphB[i][j]=in.nextInt();
                	}
                }
            }
	        Graph B = new Graph(graphB);
	        //calculate the no of indegree nodes and outdegree nodes for graph A
	        B.calculateInOut();
	        //Find the similarity of each node in graphA with refernce to graphB
	        Graph.findSimilarity(A, B);

       
    }
}
