package vm.util;

import java.io.File;

public class delete {	
	public static void main(String[] args) {
		String source = "C:\\Users\\Public\\Nwt\\cache\\recv\\慕永东\\牌照可看清\\5万\\minbus";
		File sourceFile = new File(source);	
		File[] files = sourceFile.listFiles();
		int i=0;
		for(File f: files){			
			if(f.getName().endsWith(".txt")){
				i++;							
				f.delete();
				System.out.println(i);
			}
		}
	}
}
	
	
		

