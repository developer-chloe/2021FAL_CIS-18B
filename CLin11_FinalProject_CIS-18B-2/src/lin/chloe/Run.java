package lin.chloe;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import animal.Animal;

public class Run implements Runnable 
{
	public String threadName;
	private String filePathWithName;
	private ArrayList<Animal> animalList;
	private Thread thread;
	
	File outputFile;
	private BufferedWriter fileWriter;
	
	// constructor
	Run(String threadName, String filePathWithName, ArrayList<Animal> animalList)
	{
		this.threadName = threadName;
		this.filePathWithName = filePathWithName;
		this.animalList = animalList;
		thread = new Thread(this, threadName);
	}
	
	// static factory method
	public static Run createAndStart(String threadName, String filePathWithName, ArrayList<Animal> animalList)
	{
		Run run = new Run(threadName, filePathWithName, animalList);
		run.thread.start();
		return run;
	}
	
	public void run()
	{
		// write to file
		try 
		{
			outputFile = new File("" + filePathWithName);
			fileWriter = new BufferedWriter(new FileWriter(outputFile));
			for (Animal thisAnimal : animalList) 
			{
				fileWriter.write("" + thisAnimal.getName() + " is a " + thisAnimal.getType() + "\n");
			}
				fileWriter.close();
				System.out.println("Successfully outputted to file!\n" + outputFile.getAbsolutePath());
			}
		catch (Exception e) {
				System.out.println("Error writing to file!");
			}
	}
	
	public Thread getThread()
	{
		return thread;
	}
}