package battleGame;
//Curtis Docherty
//260769767
import java.io.*;
import java.util.ArrayList;
public class FileIO {
	public static void main (String [] args) {
		System.out.println("YOYO");
	}
	public static Character readCharacter(String filename) {
		//Start with a try block
		try {
			//Initialize a File Reader and a bufferend reader
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			//Initialize the number of lines in the file
			int numLines=4;
			//Create a string array which is the same length as the file
			String [] characterAttributes = new String[4];
			//Initialize a string variable equal to the next line
			String line= br.readLine();
			//Loop through the values
			for (int i =0; i<4; i++) {
				//The array at i is equal to the current line of the file
				characterAttributes[i]=line;
				//The buffered reader moves onto the next line
				line = br.readLine();
			}
			//Close the file and buffered readers
		br.close();
		fr.close();
		//Initialize a character based on the first four lines of the file.  I type casted the last three from string to double/int
		Character player1 = new Character (characterAttributes[0],Double.parseDouble(characterAttributes[1]),Double.parseDouble(characterAttributes[2]),Integer.parseInt(characterAttributes[3]));
		return player1;
		//Catch file not found exception and IO exception and return null
		} catch (FileNotFoundException e) {
				System.out.println("file not found");
				return null;
			} catch(IOException e) {
				System.out.println("input/ output exception");
				return null;
	}	
}	
	public static ArrayList<Spell> readSpells (String fileName) {
		try {
			//creating file and buffered reader and file reader to read files
			FileReader fr= new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			//Initialize a string to be the next line
			String line= br.readLine();
			//Create an array list 
			ArrayList<Spell> items = new ArrayList<Spell>();
			//While the file has info on it...
			while(line != null) {
				//Split the info of each line into an array, each tab in the file was a different element of the array
				String [] spells = line.split("\t");
				//Created a spell based on the elements of the string array.  Again type casting the last three
				Spell which = new Spell (spells[0], Double.parseDouble(spells[1]), Double.parseDouble(spells[2]), Double.parseDouble(spells[3]));
				//Adding the spell to the Array List of spells
				items.add(which);
				//Read the next line of the file and re-stert the loop until it is null
				line= br.readLine();
			}
			//Close the buffer and file readers
			br.close();
			fr.close();
		return items;
	} catch (FileNotFoundException e) {
		//catching file not found exception and telling user
		System.out.println("File was not found!");
	} catch (IOException e) {
		//all other file io exceptions found
		System.out.println("Input/Output exception!");
	}
		return null; 
}


public static void writeCharacter(Character character, String file) {
	try {
		//creating buffered reader and file reader to read files
		FileWriter fileWrite = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fileWrite);
		//Reading the info of the file.  After getting the info I printed a new line.
		bw.write(character.getName()+"\n");
		bw.write(character.getAttackValue()+"\n");
		bw.write(character.getMaxHealth()+"\n");
		bw.write(character.getNumWins()+"\n");
		
		//telling the user that the file was successfully written
		System.out.println("Successfully wrote to file : " + file);
		bw.close();
		fileWrite.close();
	} catch (FileNotFoundException e) {
		//catching file not found exception and telling user
		System.out.println("File was not found!");
	} catch (IOException e) {
		//all other file io exceptions found
		System.out.println("Input/Output exception!");
	}
}
}

