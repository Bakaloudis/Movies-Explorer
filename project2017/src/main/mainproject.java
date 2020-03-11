package main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import mycode.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class mainproject {
	
	public static void main(String[] args) throws SQLException, IOException {
		
		
		
		
		System.out.println("Welcome  what do you want to do? ");
	    System.out.println("Press 1 to load all the movie information" );
	    System.out.println("Press 2 to load only the tags");
	    System.out.println("Press 3 to load ratings");
	    System.out.println("Press 4 to load both ratings and tags");
	    System.out.println("Press 0 to exit program\nPls put your choice:");
	    
	    Scanner keyboard = new Scanner(System.in);
	    int number = keyboard.nextInt();
	    if (number == 0){
	    	System.out.println("Thank you for using our program");
	        System.exit(0);
	    }else if(number ==1 ){
	    	loadmovies tm=new loadmovies();
	    	System.out.println("Press 1 if you want to search a movie by id" );
	    	System.out.println("Press 2 if you want to search a movie by title" );
	    	System.out.println("Press 3 if you want to search a movie by genre" );
	    	System.out.println("Press 4 if you want to search a movie by country" );
	    	System.out.println("Press 5 if you want to search a movie by actor" );
	    	System.out.println("Press 6 if you want to search a movie by director" );
	    	System.out.println("Press 0 to exit program\nPls put your choice:");
	    	int side_number = keyboard.nextInt();
	    	if (side_number == 5){
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the name of the actor" );
		    		Scanner kati = new Scanner(System.in);
		    		String actor = kati.nextLine();
		    		loadactors tb=new loadactors();
		    		tb.loadfile(actor);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(actor+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromactors().entrySet().iterator();

		    	    while (it.hasNext() && count < tb.getmoviesfromactors().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write(pairs.getValue());
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}else if (apantisi==2){
	    			System.out.println("Give me the name of the actor" );
		    		Scanner kati = new Scanner(System.in);
		    		String actor = kati.nextLine();
		    		loadactors tb=new loadactors();
		    		tb.loadfile(actor);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(actor+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromactors().entrySet().iterator();

		    	    while (it.hasNext() && count < tb.getmoviesfromactors().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write(pairs.getValue() + " ,");
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}
	    		text.close();
	    	}else if(side_number ==6){
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the name of the director" );
		    		Scanner kati = new Scanner(System.in);
		    		String director = kati.nextLine();
		    		loaddirectors tb=new loaddirectors();
		    		tb.loadfile(director);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(director+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromdirectors().entrySet().iterator();

		    	    while (it.hasNext() && count < tb.getmoviesfromdirectors().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write(pairs.getValue());
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}else if (apantisi==2){
	    			System.out.println("Give me the name of the director" );
		    		Scanner kati = new Scanner(System.in);
		    		String director = kati.nextLine();
		    		loaddirectors tb=new loaddirectors();
		    		tb.loadfile(director);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(director+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromdirectors().entrySet().iterator();

		    	    while (it.hasNext() && count < tb.getmoviesfromdirectors().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write(pairs.getValue() + " ,");
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}
	    		text.close();
	    		
	    	}else if(side_number ==1){
	    		loadmovies ty = new loadmovies();
	    		loaddirectors tu=new loaddirectors();
	    		loadcountries ti=new loadcountries();
	    		loadactors to=new loadactors();
	    		loadgenres tp=new loadgenres();
	    		
	    		
	    		
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(id+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		out.write("id	title	imdbID	spanishTitle	imdbPictureURL	year	rtID	rtAllCriticsRating	rtAllCriticsNumReviews	rtAllCriticsNumFresh	rtAllCriticsNumRotten	rtAllCriticsScore	rtTopCriticsRating	rtTopCriticsNumReviews	rtTopCriticsNumFresh	rtTopCriticsNumRotten	rtTopCriticsScore	rtAudienceRating	rtAudienceNumRatings	rtAudienceScore	rtPictureURL");
		    		out.newLine();
		    		out.write("Id: "+id +" Director: "+ tu.loadfile2(id)+"  "+"Country:"+ti.loadfile2(id)+" "+"Actors:"+ to.loadfile2(id)+"  Genres:"+tp.loadfile2(id)+"  Some more information: " +ty.loadAllInf(id));
		    	    out.close();
	    		}else if (apantisi==2){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(id+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		out.write("id	title	imdbID	spanishTitle	imdbPictureURL	year	rtID	rtAllCriticsRating	rtAllCriticsNumReviews	rtAllCriticsNumFresh	rtAllCriticsNumRotten	rtAllCriticsScore	rtTopCriticsRating	rtTopCriticsNumReviews	rtTopCriticsNumFresh	rtTopCriticsNumRotten	rtTopCriticsScore	rtAudienceRating	rtAudienceNumRatings	rtAudienceScore	rtPictureURL");
		    		out.newLine();
		    		out.write("Id: "+id +" Director: "+ tu.loadfile2(id)+"  "+"Country:"+ti.loadfile2(id)+" "+"Actors:"+ to.loadfile2(id)+"  Genres:"+tp.loadfile2(id)+"  Some more information: " +ty.loadAllInf(id));
		    	    out.close();
	    		}
	    		text.close();
	    		
	    		
	    		
	    	}else if(side_number ==3){
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the name of the genre" );
		    		Scanner kati = new Scanner(System.in);
		    		String genre = kati.nextLine();
		    		loadgenres tb=new loadgenres();
		    		tb.loadfile(genre);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(genre+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromgenres().entrySet().iterator();

		    	    out.write("Number of movies:" + tb.getmoviesfromgenres().size());
		    	    out.newLine();
		    	    while (it.hasNext() && count < tb.getmoviesfromgenres().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write("Movie name:"+pairs.getValue() +" "+"Director:"+ tb.getzelda3().get(count)+ " "+"Date:"+ tb.getzelda4().get(count));
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}else if (apantisi==2){
	    			System.out.println("Give me the name of the genre" );
		    		Scanner kati = new Scanner(System.in);
		    		String genre = kati.nextLine();
		    		loadgenres tb=new loadgenres();
		    		tb.loadfile(genre);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(genre+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromgenres().entrySet().iterator();

		    	    out.write("Number of movies:" + tb.getmoviesfromgenres().size());
		    	    out.newLine();
		    	    while (it.hasNext() && count < tb.getmoviesfromgenres().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write("Movie name:"+pairs.getValue() +" "+"Director:"+ tb.getzelda3().get(count)+ " "+"Date:"+ tb.getzelda4().get(count)+ " ,");
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}
	    		text.close();
	    	}else if(side_number == 4){
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the name of the country" );
		    		Scanner kati = new Scanner(System.in);
		    		String country = kati.nextLine();
		    		loadcountries tb=new loadcountries();
		    		tb.loadfile(country);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(country+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromcountries().entrySet().iterator();

		    	    while (it.hasNext() && count < tb.getmoviesfromcountries().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write(pairs.getValue());
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}else if (apantisi==2){
	    			System.out.println("Give me the name of the country" );
		    		Scanner kati = new Scanner(System.in);
		    		String country = kati.nextLine();
		    		loadcountries tb=new loadcountries();
		    		tb.loadfile(country);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(country+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		int count = 0;
		    		
		    	    Iterator<Entry<String, String>> it = tb.getmoviesfromcountries().entrySet().iterator();

		    	    while (it.hasNext() && count < tb.getmoviesfromcountries().size()) {

		    	        Entry<String, String> pairs = it.next();
		    	        System.out.println("Value is " + pairs.getValue());

		    	        out.write(pairs.getValue() + " ,");
		    	        out.newLine();
		    	        count++;
		    	    }
		    	    out.close();
	    		}
	    		text.close();
	    		
	    		
	    	}else if(side_number == 2){
	    		loadmovies tl =new loadmovies();
	    		loaddirectors tu=new loaddirectors();
	    		loadcountries tk = new loadcountries();
	    		loadgenres tj= new loadgenres();
	    		loadactors th=new loadactors();
	    		
	    		
	    		
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the title" );
		    		Scanner kati = new Scanner(System.in);
		    		String title = kati.nextLine();
		    		tl.loadAllInf2(title);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(title+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		
		       	    
		    	    out.write("Title:"+ title +" Director : "+ tu.loadfile3(title)+ " Country: "+tk.loadfile3(title)+ " Actors: "+th.loadfile3(title)+ " Genre: "+ tj.loadfile3(title)+  " More information"+tl.getLink3(title) );
		    	    out.newLine();
		    	    out.close();
	    		}else if(apantisi==2){
	    			System.out.println("Give me the title" );
		    		Scanner kati = new Scanner(System.in);
		    		String title = kati.nextLine();
		    		tl.loadAllInf2(title);
		    		kati.close();
		    		FileWriter fstream = new FileWriter(title+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		
		       	    
		    	    out.write("Title:"+ title +" Director : "+ tu.loadfile3(title)+ " Country: "+tk.loadfile3(title)+ " Actors: "+th.loadfile3(title)+ " Genre: "+ tj.loadfile3(title)+  " More information"+tl.getLink3(title) );
		    	    out.newLine();
		    	    out.close();
	    		}
	    		
	    		
	    	}else if (side_number == 0){
		    	System.out.println("Thank you for using our program");
		        System.exit(0);
	    	}
	    }else if(number==2){
	    	
	    	loadtags tm =new loadtags();
	    	tm.loadfile();
	    	System.out.println("Press 1 to search with id:");
	    	System.out.println("Press 2 to search with title:");
	    	Scanner lel = new Scanner(System.in);
	    	int number2= keyboard.nextInt();
	    	if (number2==1){
	    		loadmovietags tg =new loadmovietags();
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		tg.loadfile(id);
		    		loaduserdate ui =new loaduserdate();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(id+"Tag"+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		out.write("Overall  number of tags: "+tm.getSize());
		    		out.newLine();
		    		out.write("Number of tags for this id:  "+tg.getTagid(id).size() );
		    		out.newLine();
		    		out.write("TagIds: "+tg.getTagid(id)+ "    Tag Values: "+tg.loadalltags(id)+"   Dates : "+ui.loadfile(id) );
		    		 out.close();
	    		}else if(apantisi==2){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		tg.loadfile(id);
		    		loaduserdate ui =new loaduserdate();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(id+"Tag"+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		out.write("Overall  number of tags: "+tm.getSize());
		    		out.newLine();
		    		out.write("Number of tags for this id:  "+tg.getTagid(id).size() );
		    		out.newLine();
		    		out.write("TagIds: "+tg.getTagid(id));
		    		out.newLine();
		    		out.write( "Tag Values: "+tg.loadalltags(id));
		    		out.newLine();
		    		out.write("Dates : "+ui.loadfile(id));
		    		 out.close();
	    		}
		    	   
	    		
	    		
	    	}else if(number2==2) {
	    		loadmovietags tg =new loadmovietags();
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner text=new Scanner(System.in);
	    		int apantisi=text.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the title" );
		    		Scanner kati = new Scanner(System.in);
		    		String title = kati.nextLine();
		    		loaduserdate ui =new loaduserdate();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(title+"Tag"+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		out.write("Overall  number of tags: "+tm.getSize());
		    		out.newLine();
		    		out.newLine();
		    		out.write("TagIds: "+tg.loadMovieId(title));
		    		out.newLine();
		    		out.write( "Tag Values: "+tg.loadtagsmovie(title));
		    		out.newLine();
		    		out.write("Dates : "+tg.loadtagdates(title) );
		    		out.close();
	    		}else if(apantisi==2){
	    			System.out.println("Give me the title" );
		    		Scanner kati = new Scanner(System.in);
		    		String title = kati.nextLine();
		    		loaduserdate ui =new loaduserdate();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(title+"Tag"+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		out.write("Overall  number of tags: "+tm.getSize());
		    		out.newLine();
		    		out.newLine();
		    		out.write("TagIds: "+tg.loadMovieId(title));
		    		out.newLine();
		    		out.write( "Tag Values: "+tg.loadtagsmovie(title));
		    		out.newLine();
		    		out.write("Dates : "+tg.loadtagdates(title) );
		    		out.close();
	    		}
	    		
	    		
	    	}
	    }else if(number==3){
	    	System.out.println("Press 1 to search with id:");
	    	System.out.println("Press 2 to search with title:");
	    	Scanner lel = new Scanner(System.in);
	    	int number2= lel.nextInt();
	    	if (number2==1){
	    		loaduserratetime be = new loaduserratetime();
				System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner manolis=new Scanner(System.in);
	    		int apantisi=manolis.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(id+"Rating"+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(id);
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" + be.getLink(id));
		    		out.close();
	    		}else if(apantisi==2){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		kati.close();
		    		FileWriter fstream = new FileWriter(id+"Rating"+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(id);
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" + be.getLink(id));
		    		out.close();
	    		}
	    	}else if (number2==2){
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner manolis=new Scanner(System.in);
	    		int apantisi=manolis.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me a title:");
		    		Scanner katia = new Scanner(System.in);
		    		String title = katia.nextLine();
		    		loaduserratetime be= new loaduserratetime();
		    		FileWriter fstream = new FileWriter(title+"Rating"+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(title);
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" +be. getuserrateda(title));
					out.close();
	    		}else if(apantisi==2){
	    			System.out.println("Give me a title:");
		    		Scanner katia = new Scanner(System.in);
		    		String title = katia.nextLine();
		    		loaduserratetime be= new loaduserratetime();
		    		FileWriter fstream = new FileWriter(title+"Rating"+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(title);
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" +be. getuserrateda(title));
					out.close();
	    		}
	    		
	    	}
	    }else if (number==4){
	    	System.out.println("Press 1 to search with id:");
	    	System.out.println("Press 2 to search with title:");
	    	Scanner lel = new Scanner(System.in);
	    	int number2= lel.nextInt();
	    	if (number2==1){
	    		loaduserratetime be = new loaduserratetime();
				System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner manolis=new Scanner(System.in);
	    		int apantisi=manolis.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		kati.close();
		    		loadtags tm=new loadtags();
		    		tm.loadfile();
		    		loadmovietags tg =new loadmovietags();
		    		tg.loadfile(id);
		    		loaduserdate ui =new loaduserdate();
		    		FileWriter fstream = new FileWriter(id+"Tags"+ "-Ratings"+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(id);
		    		out.write("Overall  number of tags: "+tm.getSize());
		    		out.newLine();
		    		out.write("Number of tags for this id:  "+tg.getTagid(id).size() );
		    		out.newLine();
		    		out.write("TagIds: "+tg.getTagid(id)+ "    Tag Values: "+tg.loadalltags(id)+"   Dates : "+ui.loadfile(id) );
		    		out.newLine();
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" + be.getLink(id));
		    		out.close();
	    		}else if (apantisi==2){
	    			System.out.println("Give me the id" );
		    		Scanner kati = new Scanner(System.in);
		    		String id = kati.nextLine();
		    		kati.close();
		    		
		    		loadtags tm=new loadtags();
		    		tm.loadfile();
		    		loadmovietags tg =new loadmovietags();
		    		tg.loadfile(id);
		    		loaduserdate ui =new loaduserdate();
		    		FileWriter fstream = new FileWriter(id+"Tags"+ "-Ratings"+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(id);
		    		out.write("Overall  number of tags: "+tm.getSize());
		    		out.newLine();
		    		out.write("Number of tags for this id:  "+tg.getTagid(id).size() );
		    		out.newLine();
		    		out.write("TagIds: "+tg.getTagid(id)+ "    Tag Values: "+tg.loadalltags(id)+"   Dates : "+ui.loadfile(id) );
		    		out.newLine();
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" + be.getLink(id));
		    		out.close();
	    		}
	    		
	    	}else if (number2==2){
	    		System.out.println("Press 1 if you want to see the results in txt format");
	    		System.out.println("Press 2 if you want to see the results in html format");
	    		Scanner manolis=new Scanner(System.in);
	    		int apantisi=manolis.nextInt(); 
	    		if(apantisi==1){
	    			System.out.println("Give me a title:");
		    		Scanner katia = new Scanner(System.in);
		    		String title = katia.nextLine();
		    		loaduserratetime be= new loaduserratetime();
		    		loadtags tm=new loadtags();
		    		loaduserdate ui =new loaduserdate();
		    		loadmovietags tg =new loadmovietags();
		    		FileWriter fstream = new FileWriter(title+"Tags-"+"Rating"+".txt");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(title);
		    		out.write("TagIds: "+tg.loadMovieId(title));
		    		out.newLine();
		    		out.write( "Tag Values: "+tg.loadtagsmovie(title));
		    		out.newLine();
		    		out.write("Dates : "+tg.loadtagdates(title) );
		    		out.newLine();
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" +be. getuserrateda(title));
					out.close();
	    		}else if(apantisi==2){
	    			System.out.println("Give me a title:");
		    		Scanner katia = new Scanner(System.in);
		    		String title = katia.nextLine();
		    		loaduserratetime be= new loaduserratetime();
		    		loadtags tm=new loadtags();
		    		loaduserdate ui =new loaduserdate();
		    		loadmovietags tg =new loadmovietags();
		    		FileWriter fstream = new FileWriter(title+"Tags-"+"Rating"+".html");
		    		BufferedWriter out = new BufferedWriter(fstream);
		    		be.loadfile(title);
		    		out.write("TagIds: "+tg.loadMovieId(title));
		    		out.newLine();
		    		out.write( "Tag Values: "+tg.loadtagsmovie(title));
		    		out.newLine();
		    		out.write("Dates : "+tg.loadtagdates(title) );
		    		out.newLine();
		    		out.write(" userID    rating	date_day	date_month	date_year	date_hour	date_minute	date_second");
		    		out.newLine();
		    		out.write("" +be. getuserrateda(title));
					out.close();
	    		}
	    		
	    	}
	    	
	    }
	    System.out.println("Thanks for using our program.Have a great day!!!");
	}

}




