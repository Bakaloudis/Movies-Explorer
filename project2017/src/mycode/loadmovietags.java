package mycode;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class loadmovietags { 
	
	private String input;
	ArrayList<String> arr = new ArrayList();
	HashMap<String,ArrayList<String>> link = new HashMap<String,ArrayList<String>>();
	
	public void loadfile(String id) throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("movie_tags.dat");
		Scanner inputReader = new Scanner(inputstream);
		while(inputReader.hasNextLine()){
			ArrayList<String> arr2 = new ArrayList();
			input = inputReader.nextLine();
			String te []= input.split("\t");
			boolean p=link.containsKey(te[0]);
			if(p==true) {
				arr2.addAll(link.get(te[0]));
				arr2.add(te[1]);
			}else {
				arr2.add(te[1]);
			}
			link.put(te[0],arr2);
		}
		
		inputReader.close();
		
	}
	public ArrayList<String> loadalltags(String tagid) throws FileNotFoundException{
		ArrayList<String> queue= new ArrayList();
		ArrayList<String> queue2= new ArrayList();
		queue=link.get(tagid);
		loadtags re = new loadtags();
		re.loadfile();
		for (int i=0;  i<queue.size(); i++){
			
			queue2.add(re.getTeleio(queue.get(i)));
		}
		return queue2;
	}
	
	
	public ArrayList<String> getTagid(String id){
		return link.get(id);
	}
	
	
	ArrayList<ArrayList<String>> link10= new ArrayList();
	public ArrayList<ArrayList<String>> loadMovieId(String title) throws FileNotFoundException{
		loadmovies tg = new loadmovies();
		ArrayList<String> link5= new ArrayList();
		
		link5=tg.loadAllInf2(title);
		for(int i=0; i<link5.size(); i++) {
			loadfile(link5.get(i));
			link10.add(getTagid(link5.get(i)));
		}
		return link10;
	}
	public ArrayList<String> loadtagsmovie(String title) throws FileNotFoundException{
		ArrayList<String> kappa =new ArrayList();
		loadtags re= new loadtags();
		re.loadfile();
		for (int i=0; i<link10.size(); i++){
			for (int j=0; j<link10.get(i).size(); j++){
				kappa.add(re.getTeleio(link10.get(i).get(j)));
			}
		}
		return kappa;
	}
	
	
	public ArrayList<ArrayList<String>> loadtagdates(String title) throws FileNotFoundException{
		ArrayList<ArrayList<String>> kappa =new ArrayList();
		loaduserdate gr = new loaduserdate();
		
		for (int i=0; i<link10.size(); i++){
			for (int j=0; j<link10.get(i).size(); j++){
				gr.loadfile(link10.get(i).get(j));
				kappa.add(gr.getLink(link10.get(i).get(j)));
				
			}
		}
		return kappa;
	}
}

