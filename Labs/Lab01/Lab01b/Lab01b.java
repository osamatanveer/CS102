/**
 * This program creates an object of the IntBag class that can store a maximum number of prime numbers.
 * These prime numbers are computed by dividiing one number by all the previous prime numbers.
 * @author Osama Tanveer
 * @version 1.0, 19 Februrary 2019
 */
public class Lab01b {
  public static void main(String[] args) {
    
    //constants
    final int NUMBER_OF_PRIMES = 10;
    
    //variables
    IntBag primes = new IntBag(NUMBER_OF_PRIMES);
    int numberToCheck = 3;
    boolean done = false;
    int numberOfPrimes = 1;
    
    //program code
    primes.add(2); //first prime number
    
    while (!done) { //not done means that until the collection is completely full
      
      if (primes.size() == NUMBER_OF_PRIMES) {
        done = true;
        
      }
      else {
        boolean isPrime = true;
        int i = 0;
        while (i < primes.size() && isPrime) { //dividing the number by previous primes
          if (numberToCheck % primes.get(i) == 0) { 
            isPrime = false;
          }
          i += 1;
        }
        if (isPrime){ //checking if the number was divided by any prime or not
          primes.add(numberToCheck);
          numberOfPrimes += 1;
        }
        
        numberToCheck += 1;
      }
    }
    System.out.println(primes);
    System.out.println(numberOfPrimes);
  } 
  
}
