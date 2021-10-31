package lin.chloe;

import java.util.*;
import animal.Animal;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Main 
{
	public static void main(String args[])
	{
		int in;
		Scanner sc = new Scanner(System.in);
		Lion lion = new Lion();
		Giraffe giraffe = new Giraffe();
		
// 4. In your main function instantiate an array of type Animal and fill it with any number of Lions and Giraffes
		Animal [] animals = {lion, giraffe};
		
// 5. Start by printing out a message to the user tell them how many animals are in the array.
		System.out.println("There are " + animals.length + " animals in the array.");
		
// 6. Ask the user to enter a number for which animal they want more information on.
		System.out.println("Enter a number to find the animal at that location!");
		in = sc.nextInt();
		
		try {
// 8b. ...if a user enters a number outside the bounds of the animal array...
			if (in < 0 || in > animals.length)
			{
				throw new Exception();
			}
			else
			{
// 7. Have the animal at that spot in the array call it's "getName" function (remember that arrays start at 0).
			System.out.println(animals[in].getName());
			}
// 8a. Use a catch block to catch... and tell the user "You entered an invalid number!"
		} 
		catch (Exception E) {
			System.out.println("You entered an invalid number!");
		} 
		finally {
			System.out.println("Goodbye!");
		}
		
	}
}