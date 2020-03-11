package mycode;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class loadtags { 
	private String input;
	HashMap<String,String> teleio = new  HashMap<String,String>();
	public void loadfile() throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("tags.dat");
		Scanner inputReader = new Scanner(inputstream);
		while(inputReader.hasNextLine()){
			input = inputReader.nextLine();
			String te []= input.split("\t");
			try{
				teleio.put(te[0], te[1]);
				
			}catch(Exception e){
				
			}
		}
		inputReader.close();
	}
		
	
	
	public String  getTeleio(String id){
		
		return teleio.get(id);
	}
	
	
	public int getSize(){
		return teleio.size();
	}
	
	
	
	
}
	

