package animal.carnivore;

import animal.Animal;

public class Lion implements Animal 
{
	// 3. Add getName methods to both the Lion and the Giraffe classes.
	@Override
	public String getName()
	{
		return "This animal is a Lion!";
	}
	
	public String speak() 
	{
		return "The lion roars!";
	}
}
