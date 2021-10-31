package animal;

public interface Animal 
{
	default String speak() 
	{
		return "This animal doesn't speak.";
	}

// 2. Inside the Animal interface, add a new method called "getName" that returns a string indicating what type of animal it is.  Create a default implementation for this that returns "This animal is unknown!".
	default String getName()
	{
		return "This animal is unknown!";
	}
}
