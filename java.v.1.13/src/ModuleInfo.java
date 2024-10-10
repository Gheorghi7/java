 
public class ModuleInfo{
	
	public static void main(String[] args) {
		System.out.println(getXO("xxxooo"));
	}
	
	 public static boolean getXO (String str) {
		 int xCount = 0;
		 int oCount = 0;
		 
		 	for(int i =0; i<= str.length()-1; i++) {
		 		if(str.charAt(i) == 'x') {
		 			xCount++;
		 		}else if(Character.toLowerCase(str.charAt(i)) == 'o') {
		 			oCount++;
		 		}
		 		
		 	}

		    return (xCount == oCount)?true:false;
		    
	  }
}
