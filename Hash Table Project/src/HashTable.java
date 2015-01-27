public class HashTable {
    int Bsize;
    linkedList[] table;
    
    public HashTable(){
    	Bsize = 0; 
    	table = new linkedList[Bsize];
    }
	
    public HashTable(int b){
		Bsize = b;
		table = new linkedList[Bsize];
		for(int i = 0; i<Bsize; i++){
		    table[i] = new linkedList();
		}
	}
	public linkedList getElement(int index) {
		return table[index];
	}
	
	public void printHashTable(){
		listNode spot;
		for(int i = 0; i<Bsize; i++){
			spot = table[i].listHead;
			System.out.print("\n["+i+"]=");
			while(spot != null){
				if(spot.data == -999999999){
					System.out.print("dummy->");
					spot = spot.next;
				}
				else{
				    System.out.print(spot.data+"->");
				    spot = spot.next;
				}//else
			}//while
			System.out.print("NULL");
		}//for
	}//printHashTable
}//HashTable