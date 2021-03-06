/**
 * This abstract class contains the general information such as the area and the location of the shape. 
 * It is used as a parent class for other shapes' classes.
 * @author Osama Tanveer
 * @version 1.0, 12 March 2019
 */
package shapes;
public abstract class Shape implements Locatable {

  //properties
  int x = 0;
  int y = 0;
  
  // Abstract methods
  
  // to get the area of the shape
  public abstract double getArea();
  
  // to get the information of the shape 
  public abstract String getInfo();
  
  
  // to get the location of the x-coordinate of the shape
  public int getX() {
    return x;
  }
  
  // to get the location of the y-coordinate of the shape
  public int getY() {
    return y;
  }
  
  // to set the location of the shape using x and y coordinates
  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }
}