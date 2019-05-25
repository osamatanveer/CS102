/**
 * This program is used to test the IntBag class. It tests all the methods of the class.
 * @author Osama Tanveer
 * @version 1.0, 19 Februrary 2019
 */
public class Test {
  public static void main(String[] args) { 
   
    //variable
    IntBag list; //creates an object of the class
    
    //program code
    list = new IntBag(5);  
    System.out.println(list);
    
    list.add(10);
    list.add(20);
    list.add(10);
    list.add(40);
    System.out.println(list);
    
    list.remove(2);
    System.out.println(list);
    
    System.out.println(list.remove(6));
    System.out.println(list);
    
    System.out.println(list.add(20,10));
    System.out.println(list);
    
    System.out.println(list.findAll(10));
    System.out.println(list);
    
    System.out.println(list.add(3,4));
    System.out.println(list);
    
    System.out.println(list.size());
    
    list.remove(0);
    System.out.println(list);
    
    System.out.println(list.contain(100));
    
    System.out.println(list.get(1));
    
    System.out.println(list.size());
  }
  
}
