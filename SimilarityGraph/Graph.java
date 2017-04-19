
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Suriya on 12/23/16.
 */
public class Graph {
    private Integer graph[][];
    private int size;
    private List<Integer> nodes;
    private List<List<Integer>> inNodes;
    private List<List<Integer>> outNodes;

    public Graph(Integer graph[][]){
        this.graph = graph;
        this.size = graph.length;
        this.inNodes = new ArrayList<List<Integer>>();
        this.outNodes = new ArrayList<List<Integer>>();
    }
    //calculate the no of indegree nodes and outdegree nodes
    public void calculateInOut(){
        for(int i=0;i<size;i++){
            inNodes.add(new ArrayList<Integer>());
            outNodes.add(new ArrayList<Integer>());

        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(graph[i][j]!=0){
                    inNodes.get(j).add(i);
                    outNodes.get(i).add(j);

                }
            }
            System.out.println(inNodes.get(0).size());
        }

    }
   //Method to find similarity and call the insert similarity method with i,j and v(similarity)
    public static void findSimilarity(Graph A, Graph B){
    	int ALen = A.getSize();
    	int BLen = B.getSize();
    	Double inNodeSimilarity[][] = new Double[ALen][BLen];
    	Double outNodeSimilarity[][] = new Double[ALen][BLen];
    	System.out.println("inNode Similarity : ");
    	for(int i=0;i<ALen;i++){
    		for(int j=0;j<BLen;j++){
    			int max = Math.max(A.inNodes.get(i).size(), B.inNodes.get(j).size());
    			if(A.inNodes.get(i).size() == B.inNodes.get(i).size())
    				inNodeSimilarity[i][j]=new Double(1);
    			else
    				inNodeSimilarity[i][j]= Double.valueOf(Math.abs(A.inNodes.get(i).size()- B.inNodes.get(j).size()))/max;
    			
    		}
    	}
    	System.out.println("outNode Similarity : ");

    	for(int i=0;i<ALen;i++){
    		for(int j=0;j<BLen;j++){
    			int max =Math.max(A.outNodes.get(i).size(), B.outNodes.get(j).size());
    			if(A.outNodes.get(i).size() == B.outNodes.get(i).size())
    				outNodeSimilarity[i][j]=new Double(1);
    			else
    				outNodeSimilarity[i][j]= Double.valueOf(Math.abs(A.outNodes.get(i).size()- B.outNodes.get(j).size()))/max;
    			
    			

    		}
    	}
    	Node node;
    	Tree.root = new Tree(new Node(-1,-1,0.95));
    	for(int i=0;i<ALen;i++){
    		for(int j=0;j<BLen;j++){
    			Double mid = (inNodeSimilarity[i][j] + outNodeSimilarity[i][j])/2;
    			node = new Node(i,j,mid);
    			Tree.root.insertSimilarity(node);
    		}
    	}
    	if(Tree.root.right!=null){
    		Tree.root.right.print();
    	}
    	else{
    		System.out.println("No node has similarity greater than 0.95");
    	}
    		//Tree.root.print();
    	
    }
    public Integer[][] getGraph() {
        return graph;
    }

    public void setGraph(Integer[][] graph) {
        this.graph = graph;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Integer> getNodeList() {
        return nodes;
    }

    public void setNodeList(List<Integer> nodes) {
        this.nodes =  nodes;
    }

    public List<List<Integer>> getInNodeList() {
        return inNodes;
    }

    public void setInNodeList(List<List<Integer>> inNodes) {
        this.inNodes = inNodes;
    }

    public List<List<Integer>> getOutNodeList() {
        return outNodes;
    }

    public void setOutNodeList(List<List<Integer>> outNodes) {
        this.outNodes = outNodes;
    }

    

}