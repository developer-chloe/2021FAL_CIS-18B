package animal;

public interface Animal 
{
	default String speak() 
	{
		return "This animal doesn't speak.";
	}
}
