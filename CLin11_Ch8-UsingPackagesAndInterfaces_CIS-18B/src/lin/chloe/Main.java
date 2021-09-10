package lin.chloe;

import java.util.*;
import animal.Animal;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Main 
{
	public static void main(String args[])
	{
		Lion lion = new Lion();
		Giraffe giraffe = new Giraffe();
		
		System.out.println(lion.speak());
		System.out.println(giraffe.speak());
	}
}
