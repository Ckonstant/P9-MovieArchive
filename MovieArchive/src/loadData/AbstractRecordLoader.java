package loadData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;


public abstract class AbstractRecordLoader<E> {
	
	
public abstract int constructObjectFromRow(String [] tokens, ArrayList<E>objCollection);
		
	
public int load(String fileName, String delimeter, boolean hasHeaderLine, int numFields, ArrayList<E> objCollection){
	if (numFields < 1){
		System.out.println("Wrong number of fields, less than 1!");
		System.exit(0);		
	}
	//Opening files for read and write, checking exception
	Scanner inputStream = null;
	try {
		inputStream = new Scanner(new FileInputStream(fileName));

	} catch (FileNotFoundException e) {
		System.out.println("Problem opening file: " + fileName);
		System.exit(0);
	}

	int count = 0;

	//process the title of the csv
	if(hasHeaderLine){
		String titleLine = inputStream.nextLine();
		count++;
	}
	String line = "";
	//process the actual rows one by one
	while (inputStream.hasNextLine()) {
		line = inputStream.nextLine();
		count++;

		StringTokenizer tokenizer = new StringTokenizer(line, delimeter);
		if(tokenizer.countTokens() <numFields  ){
			//|| !delimeter.equals("\t")
			//System.out.println("Wrong Input format in file " + fileName +". I found " + tokenizer.countTokens() + " values, but I expect " + numFields + " values per row!");
			//System.out.println("Error in line:"+line.toString());
		
			line=inputStream.nextLine();
			tokenizer = new StringTokenizer(line,delimeter);
			}
  			
						// System.exit(0);				
		

		String[] tokens =  new String[numFields];
		for (int i=0; i< numFields;i++){
			tokens[i] = tokenizer.nextToken();
		}

		//ToDo: here add the method that takes the token and forms the object and puts it in the resultList			
		int objConstructionErrorCode;
		objConstructionErrorCode = constructObjectFromRow(tokens, objCollection);
		if (objConstructionErrorCode !=0){
			System.out.println("ObjParsingError. I found a problem at line " + count + " of file " + fileName);
			System.exit(0);
		}
	}		
	inputStream.close();
	System.out.println("Processed " + count + " rows and loaded " + objCollection.size() + " objects.");
	return count;
}
}

