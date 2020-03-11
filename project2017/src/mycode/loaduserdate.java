package mycode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class loaduserdate {

	private String input;
	ArrayList<String> arr = new ArrayList();
	HashMap<String,ArrayList<String>> link = new HashMap<String,ArrayList<String>>();
	
	public ArrayList<String> loadfile(String id) throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("user_taggedmovies.dat");
		Scanner inputReader = new Scanner(inputstream);
		String s="";
		while(inputReader.hasNextLine()){
			s= "";
			ArrayList<String> arr2 = new ArrayList();
			input = inputReader.nextLine();
			String te []= input.split("\t");
			s+=te[0];
			s+=" ";
			s+=te[2];
			s+= " ";
			s+=te[3];
			s+= " ";
			s+=te[4];
			s+= " ";
			s+=te[5];
			s+= " ";
			s+=te[6];
			boolean p=link.containsKey(te[1]);
			if(p==true) {
				arr2.addAll(link.get(te[1]));
				arr2.add(s);
			}else {
				arr2.add(s);
			}
			link.put(te[1],arr2);
		}
		
		inputReader.close();
		return link.get(id);
	}
	public ArrayList<String> getLink(String id){
		return link.get(id);
	}
}
