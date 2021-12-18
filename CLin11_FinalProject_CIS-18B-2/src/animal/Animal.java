package animal;

public interface Animal 
{
	default String speak() 
	{
		return "This animal doesn't speak.";
	}

// 2. Inside the Animal interface, add a new method called "getType" that returns a string indicating what type of animal it is.  Create a default implementation for this that returns "This animal has no Type!".
	default String getType()
	{
		return "This animal has no Type!";
	}
	
	default String getName()
	{
		return "This animal has no Name!";
	}
}
