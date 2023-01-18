import java.util.List;
import java.util.ArrayList;
public class SortMethods{
    public void selectionSort(List<City> arr){
        for(int i=arr.size();i>1;i--){
            int max = 0;
            for(int j = 1;j < i; j++){
                if(arr.get(j).compareTo(arr.get(max))>0) max = j;
            }
            swap(arr,i-1,max);
        }

    }
    
    public void insertionSort(List<City> arr){
        for (int j = 1; j < arr.size(); j++) {
            City temp = arr.get(j);
            int i = j-1;
            while ((i > -1) && ((arr.get(i).getName().compareTo(temp.getName())) > 0)) {
                arr.set(i+1, arr.get(i));
                i--;
            }
            arr.set(i+1, temp);
        }
    }

    private void swap(List<City> arr,int x, int y){
        City temp = new City(arr.get(x).getName(),arr.get(x).getState(),arr.get(x).getDesignation(),arr.get(x).getPopulation());
        arr.set(x,arr.get(y));
        arr.set(y,temp);
    }

    public List<City> mergeSort(List<City> arr){
        if(arr.size()==1) return arr;
        List<City> arr1 = new ArrayList<City>();
        List<City> arr2 = new ArrayList<City>();
        for(int i=0;i<arr.size()/2;i++){
            arr1.add(arr.get(i));
        }
        for(int i=arr.size()/2;i<arr.size();i++){
            arr2.add(arr.get(i));
        }
        return merge(mergeSort(arr1),mergeSort(arr2));
    }

    public List<City> merge(List<City> arr1, List<City> arr2){
        List<City> ret = new ArrayList<City>();
        int indx1 = 0;
        int indx2 = 0;
        for(int i=0; i<arr1.size()+arr2.size(); i++){
            
            if(indx1 >= arr1.size()){
                ret.add(arr2.get(indx2));
                indx2++; 
            }
            else if(indx2 >= arr2.size() || arr1.get(indx1).compareTo(arr2.get(indx2))>=0){
                ret.add(arr1.get(indx1));
                indx1++; 
            }
            else {
                ret.add(arr2.get(indx2));
                indx2++; 
            }
        }
        return ret;
    }

        //FOR NAMES
    public List<City> mergeSort2(List<City> arr){
        if(arr.size()==1) return arr;
        List<City> arr1 = new ArrayList<City>();
        List<City> arr2 = new ArrayList<City>();
        for(int i=0;i<arr.size()/2;i++){
            arr1.add(arr.get(i));
        }
        for(int i=arr.size()/2;i<arr.size();i++){
            arr2.add(arr.get(i));
        }
        return merge2(mergeSort(arr1),mergeSort(arr2));
    }

    public List<City> merge2(List<City> arr1, List<City> arr2){
        List<City> ret = new ArrayList<City>();
        int indx1 = 0;
        int indx2 = 0;
        for(int i=0; i<arr1.size()+arr2.size(); i++){
            
            if(indx1 >= arr1.size()){
                ret.add(arr2.get(indx2));
                indx2++; 
            }
            else if(indx2 >= arr2.size() || arr1.get(indx1).getName().compareTo(arr2.get(indx2).getName())>=0){
                ret.add(arr1.get(indx1));
                indx1++; 
            }
            else {
                ret.add(arr2.get(indx2));
                indx2++; 
            }
        }
        return ret;
    }


    /*** TESTING ***/
    public void selectionSortTest(List<Integer> arr){
        for(int i=arr.size();i>1;i--){
            int max = 0;
            for(int j = 1;j < i; j++){
                if(arr.get(j).compareTo(arr.get(max))>0) max = j;
            }
            swapTest(arr,i-1,max);
        }

    }
    public void insertionSortTest(List<Integer> arr){
        for (int j = 1; j < arr.size(); j++) {
            Integer temp = arr.get(j);
            int i = j-1;
            while ((i > -1) && ((arr.get(i).compareTo(temp)) > 0)) {
                arr.set(i+1, arr.get(i));
                i--;
            }
            arr.set(i+1, temp);
        }
    }

    public List<Integer> mergeSortTest(List<Integer> arr){
        if(arr.size()==1) return arr;
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();
        for(int i=0;i<arr.size()/2;i++){
            arr1.add(arr.get(i));
        }
        for(int i=arr.size()/2;i<arr.size();i++){
            arr2.add(arr.get(i));
        }
        return mergeTest(mergeSortTest(arr1),mergeSortTest(arr2));
    }

    public List<Integer> mergeTest(List<Integer> arr1, List<Integer> arr2){
        List<Integer> ret = new ArrayList<Integer>();
        int indx1 = 0;
        int indx2 = 0;
        for(int i=0; i<arr1.size()+arr2.size(); i++){
            
            if(indx1 >= arr1.size()){
                ret.add(arr2.get(indx2));
                indx2++; 
            }
            else if(indx2 >= arr2.size() || arr1.get(indx1).compareTo(arr2.get(indx2))<=0){
                ret.add(arr1.get(indx1));
                indx1++; 
            }
            else {
                ret.add(arr2.get(indx2));
                indx2++; 
            }
        }
        return ret;
    }

    private void swapTest(List<Integer> arr,int x, int y){
        Integer temp = (int) arr.get(x);
        arr.set(x,arr.get(y));
        arr.set(y,temp);
    }
    public static void main(String [] args){
        SortMethods sm = new SortMethods();
        sm.run();
    }
    public void run(){
        List<Integer> arr = new ArrayList<Integer>();
		// Fill arr with random numbers
		for (int a = 0; a < 10; a++)
			arr.add((int)(Math.random() * 100) + 1);
		System.out.println("\nSelection Sort");
		System.out.println("Array before sort:");
		printArrayTest(arr);
		System.out.println();
		selectionSortTest(arr);
		System.out.println("Array after sort:");
		printArrayTest(arr);
        System.out.println();
        
        for (int a = 0; a < 10; a++)
			arr.set(a,(int)(Math.random() * 100) + 1);
		System.out.println("\nInsertion Sort");
		System.out.println("Array before sort:");
		printArrayTest(arr);
		System.out.println();
		insertionSortTest(arr);
		System.out.println("Array after sort:");
		printArrayTest(arr);
        System.out.println();
        
        for (int a = 0; a < 10; a++)
			arr.set(a,(int)(Math.random() * 100) + 1);
		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArrayTest(arr);
        System.out.println();
        arr = mergeSortTest(arr);
		System.out.println("Array after sort:"+arr.size());
		printArrayTest(arr);
		System.out.println();
    }

    public void printArrayTest(List<Integer> arr) {
		if (arr.size() == 0) System.out.print("(");
		else System.out.printf("( %4d", arr.get(0));
		for (int a = 1; a < arr.size(); a++) {
			if (a % 10 == 0) System.out.printf(",\n  %4d", arr.get(a));
			else System.out.printf(", %4d", arr.get(a));
		}
		System.out.println(" )");
	}
}
