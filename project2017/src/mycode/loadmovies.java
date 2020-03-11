package mycode;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class loadmovies { 
	
	//private String id;
	private String input;
	ArrayList<String> arr = new ArrayList();
	HashMap<String,String> geo = new HashMap<String,String>();
	HashMap<String,String> bak = new HashMap<String,String>();
	public HashMap<String,String> getTitle() throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("movies.dat");
		Scanner inputReader = new Scanner(inputstream);
		while(inputReader.hasNextLine()){
			input = inputReader.nextLine();
			String te []= input.split("\t");
			geo.put(te[0],te[1]);//To hashmap link exei gia kleidia ta id kai gia values tous titlous apo tis tainies
			bak.put(te[0], te[5]);//prosthetoume xronologia
		}
		inputReader.close();
		return geo;
	}
	
	public HashMap<String,String> getDate(){
		return bak;
	}
	
	HashMap<String,String> neo = new HashMap<String,String>();
	String inputtt;
	
	public String loadAllInf(String id) throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("movies.dat");
		Scanner inputReader = new Scanner(inputstream);
		while(inputReader.hasNextLine()){
			String ID=inputReader.next();
			inputtt = inputReader.nextLine();
			neo.put(ID, inputtt);
		}
		inputReader.close();
		return neo.get(id);
		
	}
	
	private String input2;
	HashMap<String,ArrayList<String>> link2 = new HashMap<String,ArrayList<String>>();
	HashMap<String,String> link3 = new HashMap<String,String>();
	public ArrayList<String> loadAllInf2(String title) throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("movies.dat");
		Scanner inputReader = new Scanner(inputstream);		
		while(inputReader.hasNextLine()){
			ArrayList<String> arr2 = new ArrayList();
			input2 = inputReader.nextLine();
			String te []= input2.split("\t");
			String s=" ";
			for (int i=2; i<te.length; i++){
				s+=" ";
				s+=te[i];
			}
			boolean p=link2.containsKey(te[1]);
			if(p==true) {
				arr2.addAll(link2.get(te[1]));
				arr2.add(te[0]);
			}else {
				arr2.add(te[0]);
			}
			link2.put(te[1],arr2);
			link3.put(te[1],s);
		}
		inputReader.close(); 
		return link2.get(title) ;
	}
	public String getLink3(String title){
		return link3.get(title);
	}
}
