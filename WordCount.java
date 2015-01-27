//says how many times each word appears in the document

import java.util.regex.*;//allows regex expressions and methods
import java.util.Iterator;//allows iterator use
import java.util.Comparator;//allows comparator use
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;//allows TreeMap use

public class WordCount {
   public static void main(String[] args) {
      TextFileInput file = new TextFileInput(args[0]); //creates a TextFilInput out of the content of args[0] = project4.txt
	  String line = file.readLine();  //reads a line of input
	  TreeMap <String, Integer> map = new TreeMap <String, Integer>(); //creates a tree  map where the key is a String and the value is an Integer
	  while(line != null){ //if there are still non-empty lines left then: 
	     Pattern p = Pattern.compile("\\W"); //divide the text by any non-word character 
		 String result[] = line.split(p.pattern()); //the method 'split' uses the regex pattern as a delimeter, and puts all the separated elements into an array
		 for( int j = 0; j< result.length; j++){
		    if(map.containsKey(result[j].toUpperCase())){ //is that value already in the tree map?
		       int count = map.get(result[j].toUpperCase()); //count = the value of the tree map at that key
		       count++;
		       map.put(result[j].toUpperCase(), new Integer (count)); //put the key back into the tree map with the new updated value
		    }//count++
		    else
		       map.put(result[j].toUpperCase(), new Integer(1)); //put the element from result[] at index j into the tree map as the key element and set the value element (which represents the count of that key) to 1
	    }//for
		line = file.readLine(); //once one line was entered into the array, read the next line and continue splitting it and entering the results into the results array which then gets added into the tree map
      }//while

      Set set = map.entrySet(); //the key/value pairs of map are instantiated to set
	  Iterator i = set.iterator(); //the iterator is attached to set
	  Map.Entry<String, Integer> me; //interface Map.Entry is a key/value pair
	  System.out.println("TREE MAP: ");
	  i.next();
	  while(i.hasNext()){ //as long as the iterator can continue going
	     me = (Map.Entry)i.next(); //cast what the iterator's at to a Map.Entry
		 System.out.print(me.getKey() + ": "); //print the key value 
	     System.out.println(me.getValue()); //print the value of the tree map which represents how many times the word appears
	  }//while
	  
   }//main	
	
}//Project4
