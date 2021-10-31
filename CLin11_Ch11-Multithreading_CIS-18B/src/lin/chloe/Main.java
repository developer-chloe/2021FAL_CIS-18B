package lin.chloe;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import animal.Animal;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Main 
{
	private static File inFile = new File("names.txt");
	private static Scanner fileReader;
	private static ArrayList<Run> threadList = new ArrayList<Run>();
	
	private static Scanner sc = new Scanner(System.in);
	private static int in;
	
	private static ArrayList<Animal> animalList = new ArrayList<Animal>();
	
	public static void main(String args[])
	{
		System.out.println("How many Giraffes?");
		in = sc.nextInt();
		createAnimal("Giraffe");
		
		System.out.println("How many Lions?");
		in = sc.nextInt();
		createAnimal("Lion");
		
		System.out.println("How many threads?");
		in = sc.nextInt();
		
		System.out.println();
		
		for (int i = 0; i < in; i++) 
		{
			Run run = Run.createAndStart("thread" + i, "output" + i + ".txt", animalList);
			threadList.add(run);
		}
		
		for (int i = 0; i < in; i++) 
		{
			try {
				threadList.get(i).getThread().join();
			} catch (Exception e) {
				System.out.println("Error with threads.");
			}
		}
	}
	
	public static void createAnimal(String animal) 
	{
		try {
			fileReader = new Scanner(inFile);
			
			if (animal.equals("Giraffe")) 
			{
				for (int i = in; i > 0; i--) 
				{
					animalList.add(new Giraffe(fileReader.nextLine()));
				}
			}
			else if (animal.equals("Lion")) 
			{
				for(int i = in; i > 0; i--) 
				{
					animalList.add(new Lion(fileReader.nextLine()));
				}
			}
			fileReader.close();
		} catch(Exception e) {
			System.out.println("Error!");
		}
	}
}