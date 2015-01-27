
public class Selection {	
   public static void selectionSort(Temperature[] tempList, int length) { 
	  for ( int i = 0; i < length - 1; i++ ) { //acts as a pointer to what's been sorted already
        int indexLowest = i; 
        for ( int j = i + 1; j < length; j++ ) //goes through the list and finds the lowest value
           if ( (tempList[j]).compareTo(tempList[indexLowest]) == -1 ) 
              indexLowest = j;
            //swaps the lowest value with where the pointer is up to        
            if ( (tempList[indexLowest]).compareTo(tempList[i]) != 0 ) { 
               Temperature temporary = new Temperature((tempList[indexLowest]).getTemperature());
               (tempList[indexLowest]).setTemperature(tempList[i].getTemperature()); 
               (tempList[i]).setTemperature(temporary.getTemperature());
            }  // if
      } // for i   
   } // method selectionSort 
}//Selection
