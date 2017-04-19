
public class Tree {
	Node node;
	Tree left;
	Tree right;
	static Tree root;
	
	public Tree(){
		
	}
	
	public Tree(Node node){
		this.node = node;
		this.left=null;
		this.right=null;
	}
	
	//Insert respective node relation to a Binary Tree based on the Similarity
	public void insertSimilarity(Node node){

			if(node.v<this.node.v){
				if(this.left==null){
					Tree tree = new Tree(node);
					this.left=tree;
					
				}
				else{
					this.left.insertSimilarity(node);
				}
					
			}
			else{
				if(this.right==null){
					Tree tree = new Tree(node);
					this.right=tree;
					
				}
				else{
					this.right.insertSimilarity(node);
				}
			}
		}
		
			
	
	//Prints the node relation with similarity greater than 0.95
	public void print(){
		Node node = this.node;
		System.out.println("("+node.i+","+node.j+")="+node.v);
		if(this.left!=null) this.left.print();
		if(this.right!=null) this.right.print();
	}
	
	
	
}
class Node{
	int i,j;
	Double v;
	public Node(int i,int j,Double v){
		this.i = i;
		this.j = j;
		this.v = v;
	}
}