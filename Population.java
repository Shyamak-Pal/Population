import java.util.List;
import java.util.ArrayList;
/**
 *	Population - <description goes here>
 *
 *	Requires FileUtils and Prompt classes.
 *
 *	@author	Shyamak Pal
 *	@since	Jan 12 2023
 */
 import java.util.Scanner;
public class Population {
	private Scanner input;
	// List of cities
	private List<City> cities;
	
	// US data file
	private final String DATA_FILE = "usPopData2017.txt";
	
	public Population(){
	}


	public static void main(String [] args){
		Population pop = new Population();
		pop.run();
	}
	
	public void run(){
		List<City> cities= new ArrayList<City>();

		printIntroduction();
		/*
		FileUtils utils = new FileUtils();
		input = utils.openToRead(DATA_FILE);*/
		try{
			input = new java.util.Scanner(new java.io.File(DATA_FILE)).useDelimiter("[\t\n]");;
		}
		catch(java.io.FileNotFoundException e ){
			System.err.println("ERROR: Cannot open "+DATA_FILE+" for reading.");
			System.exit(-1);
		}

		while(input.hasNext()){
			City temp = new City(input.next(),input.next(),input.next(),input.nextInt());
			cities.add(temp);
			//System.out.println(temp);
		}
		input.close();

		SortMethods sm = new SortMethods();
		
		printMenu();
		int response = 0;
		while(response != 9){
			response = Prompt.getInt("Enter selection");
			if(response == 1){
				long startMillisec = System.currentTimeMillis();
				sm.selectionSort(cities);
				long endMillisec = System.currentTimeMillis();	
				System.out.println("\n\nFifty least populous cities");
				System.out.printf("    %-22s %-22s %-12s %12s\n","State","City", "Type",
				"Population");
				for(int i=0;i<50;i++) System.out.printf("%2d: %s\n",i+1,cities.get(i).toString());
				System.out.print("\n\nElapsed Time "+(endMillisec-startMillisec)+" milliseconds\n\n");
			}else if(response == 2){
				long startMillisec = System.currentTimeMillis();
				sm.mergeSort(cities);
				long endMillisec = System.currentTimeMillis();	
				System.out.println("\n\nFifty most populous cities");
				System.out.printf("    %-22s %-22s %-12s %12s\n","State","City", "Type",
				"Population");
				for(int i=0;i<50;i++) System.out.printf("%2d: %s\n",i+1,cities.get(i).toString());
				System.out.print("\n\nElapsed Time "+(endMillisec-startMillisec)+" milliseconds\n\n");
			}else if(response == 3){
				long startMillisec = System.currentTimeMillis();
				sm.insertionSort(cities);
				long endMillisec = System.currentTimeMillis();	
				System.out.println("\n\nFifty cities sorted by name");
				System.out.printf("    %-22s %-22s %-12s %12s\n","State","Name", "Designation",
				"Population");
				for(int i=0;i<50;i++) System.out.printf("%2d: %s\n",i+1,cities.get(i).toString());
				System.out.print("\n\nElapsed Time "+(endMillisec-startMillisec)+" milliseconds\n\n");
			}else if(response == 4){
				long startMillisec = System.currentTimeMillis();
				sm.mergeSort2(cities);
				long endMillisec = System.currentTimeMillis();	
				System.out.println("\n\nFifty cities sorted by name descending");
				System.out.printf("    %-22s %-22s %-12s %12s\n","State","City", "Type",
				"Population");
				for(int i=0;i<50;i++) System.out.printf("%2d: %s\n",i+1,cities.get(i).toString());
				System.out.print("\n\nElapsed Time "+(endMillisec-startMillisec)+" milliseconds\n\n");
			}else if(response == 5){
				List<City> out = new ArrayList<City>();
				String state = Prompt.getString("Enter state name (ie. Alabama)");
				for(int i= 0; i< cities.size(); i++){
					if(cities.get(i).getState().equalsIgnoreCase(state)) out.add(cities.get(i));
				}

				while(out.size() == 0){
					System.out.println("ERROR: "+state+" is not valid");
					state = Prompt.getString("Enter state name (ie. Alabama)");
					out.clear();
					for(int i= 0; i< cities.size(); i++){
						if(cities.get(i).getState().equalsIgnoreCase(state)) out.add(cities.get(i));
					}
				}
				out = sm.mergeSort(out);
				System.out.println("\n\nFifty most populous cities in "+state);
				System.out.printf("    %-22s %-22s %-12s %12s\n","State","City", "Type",
				"Population");
				for(int i=0;i<Math.min(50,out.size());i++) System.out.printf("%2d: %s\n",i+1,out.get(i).toString());
				System.out.println();
			}else if(response == 6){
				List<City> out = new ArrayList<City>();
				String city = Prompt.getString("Enter city name");
				for(int i= 0; i< cities.size(); i++){
					if(cities.get(i).getName().equalsIgnoreCase(city)) out.add(cities.get(i));
				}

				while(out.size() == 0){
					System.out.println("ERROR: "+city+" is not valid");
					city = Prompt.getString("Enter city name");
					out.clear();
					for(int i= 0; i< cities.size(); i++){
						if(cities.get(i).getName().equalsIgnoreCase(city)) out.add(cities.get(i));
					}
				}
				out = sm.mergeSort(out);
				System.out.println("\n\nCity "+city+" by population");
				System.out.printf("    %-22s %-22s %-12s %12s\n","State","City", "Type",
				"Population");
				for(int i=0;i<Math.min(50,out.size());i++) System.out.printf("%2d: %s\n",i+1,out.get(i).toString());
				System.out.println();
			}
		}
		System.out.print("\n\nThanks for using Population!\n");
	}
	

	/**	Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();
	}
	
	/**	Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}
	
}
