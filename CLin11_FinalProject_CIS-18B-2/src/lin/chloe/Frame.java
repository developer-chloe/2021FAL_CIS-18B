package lin.chloe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import animal.Animal;
import animal.carnivore.Lion;
import animal.herbivore.Giraffe;

public class Frame extends JFrame implements ActionListener 
{
	// variables
	private static int input;
	
	private static ArrayList<Animal> animalList = new ArrayList<Animal>();
	private static ArrayList<Run> threadList = new ArrayList<Run>();
	
	private static File inFile;
	private static File outFolder;
	
	private static JButton inButton;
	private static JButton outButton; 
	private static JButton finButton;
	
	private static JTextField lionInput;
	private static JTextField giraffeInput;
	private static JTextField threadsInput;
	
	private static Scanner fileReader;

	private static boolean isGiraffeInput = false;
	private static boolean isLionInput = false; 
	private static boolean isThreadInput = false;	
	
	private static boolean isInputFile = false;
	private static boolean isOutputFolder = false;

	// constructor
	Frame() 
	{
		// JFrame settings
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // terminate on close
		this.setTitle("Final Programming Assignment");
		this.setLayout(new GridLayout(0, 1));
		
		inButton = new JButton("Select File");
		inButton.addActionListener(this);
		
		outButton = new JButton("Select Output Folder");
		outButton.addActionListener(this);
		
		// button for once everything is inputted
		finButton = new JButton("Finished");
		finButton.addActionListener(this);

// LIONS 
		
		// get input for # of lions
		lionInput = new JTextField("How many Lions?");
		
		lionInput.setHorizontalAlignment(JTextField.CENTER);
		
		lionInput.addFocusListener(new FocusAdapter() 
		{
			public void focusGained(FocusEvent e) 
			{
				if (lionInput.getText().equalsIgnoreCase("How many Lions?")) 
					lionInput.setText(null);
			}

			public void focusLost(FocusEvent e) 
			{
				if (lionInput.getText().equals("")) 
				{
					lionInput.setText("How many Lions?");
					isLionInput = false;
				} 
				else 
				{
					isLionInput = true;
				}
			}
		});
		
		// only accept int values
		lionInput.addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e) 
			{
				char ch = e.getKeyChar();
				if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE)) 
					e.consume();
			}
		});

// GIRAFFES
		
		// get input for # of giraffes
		giraffeInput = new JTextField("How many Giraffes?");
		
		giraffeInput.setHorizontalAlignment(JTextField.CENTER);
		
		giraffeInput.addFocusListener(new FocusAdapter() 
		{
			public void focusGained(FocusEvent e) 
			{
				if (giraffeInput.getText().equalsIgnoreCase("How many Giraffes?")) 
				{
					giraffeInput.setText(null);
				}
			}

			public void focusLost(FocusEvent e) 
			{
				if (giraffeInput.getText().equals("")) 
				{
					giraffeInput.setText("How many Giraffes?");
					isGiraffeInput = false;
				} 
				else 
				{
					isGiraffeInput = true;
				}
			}
		});
		
		// only accept int values
		giraffeInput.addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e) 
			{
				char ch = e.getKeyChar();
				if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE)) 
					e.consume();
			}
		});

// THREADS
		
		// get input for # of threads
		threadsInput = new JTextField("How many Threads?");
		
		threadsInput.setHorizontalAlignment(JTextField.CENTER);
		
		threadsInput.addFocusListener(new FocusAdapter() 
		{
			public void focusGained(FocusEvent e) 
			{
				if (threadsInput.getText().equalsIgnoreCase("How many Threads?")) 
				{
					threadsInput.setText(null);
				}
			}

			public void focusLost(FocusEvent e) 
			{
				if (threadsInput.getText().equals("")) 
				{
					threadsInput.setText("How many Threads?");
					isThreadInput = false;
				} 
				else 
				{
					isThreadInput = true;
				}
			}
		});
		
		// only accept int values
		threadsInput.addKeyListener(new KeyAdapter() 
		{
			public void keyTyped(KeyEvent e) 
			{
				char ch = e.getKeyChar();
				if (!(Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_DELETE))
					e.consume();
			}
		});

		this.add(giraffeInput);
		this.add(lionInput);
		this.add(threadsInput);
		
		this.add(inButton);
		this.add(outButton);
		this.add(finButton);
		
		this.setSize(300, 300);
		this.setVisible(true);
	}

	// manage events
	public void actionPerformed(ActionEvent e) {
		// inButton clicked
		if (e.getSource() == inButton) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
			int response = fileChooser.showOpenDialog(null);
			
			if (response == JFileChooser.APPROVE_OPTION) 
			{
				inFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
				inButton.setText(inFile.getPath());
				isInputFile = true;
			}
			else 
			{
				isInputFile = false;
				inButton.setText("Select File");
			}
		}
		// outButton clicked
		if (e.getSource() == outButton) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int response = fileChooser.showOpenDialog(null);
			
			if (response == JFileChooser.APPROVE_OPTION) {
				outFolder = new File(fileChooser.getSelectedFile().getAbsolutePath());
				outButton.setText(outFolder.getPath());
				isOutputFolder = true;
			}
			else 
			{
				isOutputFolder = false;
				outButton.setText("Select Output Folder");
			}
		}

		// finButton clicked
		if (e.getSource() == finButton) 
		{
			animalList.clear();
			if (!(isThreadInput == false || isLionInput == false || isGiraffeInput == false || isInputFile == false || isOutputFolder == false)) 
			{
				input = Integer.parseInt(giraffeInput.getText());
				createAnimal("Giraffe");

				input = Integer.parseInt(lionInput.getText());
				createAnimal("Lion");

				input = Integer.parseInt(threadsInput.getText());
				startThreads();
			}
		}
	}

	// create animal using names from a file and add to a list of animals
	private static void createAnimal(String animal) 
	{
		try {
			fileReader = new Scanner(inFile);
			if (animal.equalsIgnoreCase("giraffe")) 
			{
				for (int i = input; i > 0; i--) 
					animalList.add(new Giraffe(fileReader.nextLine()));
			} 
			else if (animal.equalsIgnoreCase("lion")) 
			{
				for (int i = input; i > 0; i--) 
					animalList.add(new Lion(fileReader.nextLine()));
			}
			
			fileReader.close();
		} catch (Exception e) {
			System.out.println("Animal error!");
		}
	}

	// start threads
	private static void startThreads() 
	{
		for (int i = 0; i < input; i++) 
		{
			Run run = Run.createAndStart("thread" + i, outFolder.getAbsolutePath() + "/output" + i + ".txt", animalList);
			threadList.add(run);
		}

		for (int i = 0; i < input; i++) 
		{
			try {
				threadList.get(i).getThread().join();
			} catch (Exception e) {
				System.out.println("Thread error!");
			}
		}
	}
}