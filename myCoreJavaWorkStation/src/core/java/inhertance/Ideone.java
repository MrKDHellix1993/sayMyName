package core.java.inhertance;
// A sample Java program to demonstrate HashMap and HashTable 
import java.util.*; 
import java.lang.*; 
import java.io.*; 

/* Name of the class has to be "Main" only if the class is public. */
class Ideone 
{ 
	public static void main(String args[]) 
	{ 
		//----------hashtable ------------------------- 
		Hashtable<Integer,String> ht=new Hashtable<Integer,String>(); 
		ht.put(101," Vijay"); 
		ht.put(104,"Vijay"); 
		ht.put(102,"Ravi"); 
		ht.put(103,"Rahul"); 
//		ht.put(null,null); 
		System.out.println("-------------Hash table--------------"); 
		for (Map.Entry m:ht.entrySet()) { 
			System.out.println(m.getKey()+" "+m.getValue()); 
		} 
		
		System.out.println(ht.get(500));

		//----------------hashmap-------------------------------- 
		HashMap<Integer,String> hm=new HashMap<Integer,String>(); 
		hm.put(100,"Amit"); 
		hm.put(104,"Amit"); // hash map allows duplicate values 
		hm.put(101,"Vijay");
		hm.put(null,null);
		hm.put(102,"Rahul"); 
		System.out.println("-----------Hash map-----------"); 
		
		Iterator<Map.Entry<Integer, String>> hmItr = hm.entrySet().iterator();
		
		
		
		while(hmItr.hasNext()) {
			System.out.println(hmItr.next().getKey()+" "+hmItr.next().getValue());
//			hm.put(500,"Kalidas");
		}
		
		/*
		 * System.out.println(hm.get(500));
		 * 
		 * for (Map.Entry m:hm.entrySet()) {
		 * System.out.println(m.getKey()+" "+m.getValue()); }
		 */
		List<Map.Entry<Integer, String>> iteratorList = getIteratorList(hmItr);
		
		Map.Entry<Integer, String>[] itrArr = (Map.Entry<Integer, String>[]) iteratorList.toArray();
		
		
		while(hmItr.hasNext()) {
			System.out.println(hmItr.next().getKey()+" "+hmItr.next().getValue());
		}
	} 
	
	public static List<Map.Entry<Integer, String>> getIteratorList(Iterator<Map.Entry<Integer, String>> input) {
		 List<Map.Entry<Integer, String>> result = new ArrayList<Map.Entry<Integer, String>>();
		if(null != input) {
			input.forEachRemaining(result::add);
		}
		return result;
	}
	
} 
