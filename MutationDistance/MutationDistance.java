import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MutationDistance{
	public static void main(String[] args){
		String[] bank = {"AAAAAAAA","AAAAAAAT","AAAAAATT","AAAAATTT"};
		String start = "AAAAAAAA";
		String end = "AAAAAATT";
		findMutationDistance(start,end,bank);
		
	}

	private static void findMutationDistance(String start, String end,
			String[] bank) {
		List<String> bankList = new ArrayList<>();
		Collections.addAll(bankList,bank);
		int maxChanges = 1,dist =0;
		if(bankList.contains(end)){
			int index = bankList.indexOf(end);
			
			while(index!=0){
				String cmpStrin = bank[index];
				String cmp = bank[index-1];
				if(start.equals(cmpStrin)) break;
				for(int i = 0; i < 8; i++) { // go from first to last character index the words
		            if(cmpStrin.charAt(i) != cmp.charAt(i)) { // if this character from word 1 does not equal the character from word 2
		            	maxChanges--; // reduce one mistake allowed
		               
		            }
		        }
				if(maxChanges==0)
					dist = dist +1;
				else
					break;
				System.out.println(dist);
				index--;
			}
			if(maxChanges>1){
				dist=0;
				for(int i = 0; i < 8; i++) { // go from first to last character index the words
		            if(start.charAt(i) != end.charAt(i)) { // if this character from word 1 does not equal the character from word 2
		            	dist++; // reduce one mistake allowed
		               
		            }
		        }
			}
		}
		
		
	}
}