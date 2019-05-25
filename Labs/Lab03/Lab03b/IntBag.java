/**
 * This class creates a collection of integers. It stores integers in an array and keeps track of the number of 
 * elements added to the collection.
 * @author Osama Tanveer
 * @version 1.0, 19 Februrary 2019
 */
import java.util.Iterator;
public class IntBag {
  
  //properties
  private int[] bag; //holds the values
  private int valid; //elements of bag that contain elements
  
  private int maxElems = 100;
  
  //constructors
  /**
   * Constructor for class IntBag. Initializes an array of elemets with a total of maxElems number of elements.
   * @param no input parameters.
   */
  public IntBag() { 
    bag = new int[maxElems];
    valid = 0;
  }
  
  /**
   * Another constructor for class IntBag. Initializes an array of elemets with a total of number of elements provided.
   * @param numberOfElements which is the number of elements specified by the user.
   */
  public IntBag(int numberOfElements) {
    this.maxElems = numberOfElements;
    bag = new int[this.maxElems];
    valid = 0;
  }
  
  //methods
  /**
   * This method adds an integer to the end of the collection.
   * @param valueToAdd which is the integer to be added.
   * @return boolean. If added, true returned. It not, false returned.
   */
  public boolean add(int valueToAdd){
    
    if (!isValid()) {
      return false;
    }
    
    bag[valid] = valueToAdd;
    valid++;
    return true;
  }
  
  /**
   * This method adds an integer to a specified index in the collection.
   * @param valueToAdd which is the integer to be added.
   * @param i which is the index at which the integer is to be added.
   * @return boolean. If added, true returned. It not, false returned.
   */
  public boolean add(int valueToAdd , int i){
    
    if(!isValid()) {
      return false;
    }
    
    // Check if i is in withim bounds
    if ( i < 0 || i > maxElems ) {
      return false;
    }
    
    //Moving the values an index forward
    for ( int j = valid; j > i; j--) { 
      bag[j] = bag[j - 1]; 
    }
    
    // Add the element at i
    bag[i] = valueToAdd;
    
    valid++;
    return true;
  }
  
  /**
   * This method removes an integer to a specified index in the collection and moves the rest of the integers
   * "down" the collection.
   * @param i which is the index at which the integer is to be removed.
   * @return boolean. If removed, true returned. It not, false returned.
   */
  public boolean remove(int i) {
    if ( i >= 0 && i < maxElems ){
      for (int j = i ; j < bag.length - 1 ; j++) {
        bag[j] = bag[j+1];
      }
      
      valid--;
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * This method tells if an integer is present in a collection or not.
   * @param valueToSearch which is the integer that is to search in the collection.
   * @return boolean. If present, true returned. It not, false returned.
   */
  public boolean contain(int valueToSearch) {
    for (int i = 0 ; i < bag.length ; i++) {
      if (bag[i] == valueToSearch) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * This method tells the number of integers present in the collection.
   * @param No input parameters.
   * @return valid which is the number of integers in the collection.
   */
  public int size() {
    return valid;
  }
  /**
   * This method tells which element is present at a particular index.
   * @param index which is the index of an element that is to be returned.
   * @return bag[index] which is an integer present at the particular index.
   */  
  public int get(int index) {
    return bag[index];
  }
  
  /**
   * This method returns the elements of the collection in a String format.
   * @param No input parameters.
   * @return collection which is the string format of the array.
   */
  public String toString() {
    String collection = "";
    
    if (valid > 0) {
      for (int i = 0 ; i < valid ; i++) {
        collection += bag[i];
        collection += " ";
      }
    }
    else {
      collection = "Nothing in the collection.";
    }
    
    return collection;
  }
  
  
  /**
   * This method tells if the number of elements in the collection exceeds the maximum number or not.
   * @param No input parameters.
   * @return boolean. Returns false if index is exceed, and true if not.
   */
  private boolean isValid() {
    if ( valid >= this.maxElems) {
      return false;
    }
    return true;
  }
  
  /**
   * This method tells about all the indexes of a particular element in a collection.
   * @param numberToFind which is the integer that is to be searched in the collection.
   * @return allIndex which is all the positions of an integer in the collection.
   */
  public String findAll(int numberToFind) {
    String allIndex = "";  
    
    for (int i = 0 ; i < valid ; i++) {
      if (bag[i] == numberToFind) {
        allIndex += i + " ";
      }
    }
    return allIndex;
  }

    /**
   * This method creates an object using the current object so that an object is passed to the IntBagIterator class.
   * @param No input parameters.
   * @return IntBagIterator object, which contains the properties of the current object.
   */
  public Iterator iterator() {
    return new IntBagIterator(this);
  }
  
  // Inner Class
  
  /**
 * This is an inner class of the IntBag class. It contains the properties using objects.
 * @author Osama Tanveer
 * @version 1.0, 19 Februrary 2019
 */
  private class IntBagIterator implements Iterator {
    
    //properties
    private IntBag aBag;
    private int index;
    
     /**
   * Constructor for class IntBagIterator.
   * @param IntBag aBag, which contains the values from IntBag class.
   */
    public IntBagIterator(IntBag aBag) {
      this.aBag = aBag;
      this.index = 0;
    }
    
    // methods
    
    
  /**
   * This method checks if the index of the current object being accessed is less than the total size of the bag.
   * @param No input parameters.
   * @return boolean, true if index less than size, false if index exceeds size.
   */
    public boolean hasNext() {
      if (index < aBag.size() - 1) {
        return true;
      }
      else {
        return false;
      }
    }

      /**
   * This method returns the object with an Integer wrapper.
   * @param No input parameters.
   * @return Integer aBag.get(index - 1), which is the object at a particular index.
   */
    public Integer next() {
      if (hasNext()) {
        index += 1; //so that each object is reported once
        return aBag.get(index - 1);
      }
      else {
        return null;
      }
    }
  }
  
}
