package llm.lab7;

import java.util.ArrayList;
import java.util.Scanner;

import llm.lab7.*;
import llm.lab7.client.*;
import llm.lab7.server.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	
    	
    	
    	boolean powerOn = true;
    	Scanner scan = new Scanner(System.in);
    	String cmd;
    	DirectoryServer ds = new DirectoryServer();
    	DirectoryProxy dp = new DirectoryProxy(ds);
    	
    	
    	
    	System.out.println(
    			"-LADY LIGHTNING MONKEYS INC BANK THING!-" + 
    			" POWER: Toggles power of machine\n" +
    			" CLR: Clears database\n" +
    			" ADD: Adds records\n" +
    			" PRINT: Prints out a full directory"
    	);
    	
    	while(powerOn){
    		System.out.print("CMD> ");
    		cmd = scan.next().toUpperCase();
    		// process command
    		
    		if (cmd.equals("POWER")){
    			powerOn = false;
    		}
    		else if (cmd.equals("ADD")){
    			
    			System.out.println("Please enter records in the following format:");
    			System.out.println("Matt Powers CAFE 1921680112");
    			System.out.println("Type 'END' when done.");
    			
    			String subCmd;
    			subCmd = scan.nextLine().toUpperCase();
    			ArrayList<Employee> col = new ArrayList<Employee>();
    			while (true){
    				
    				subCmd = scan.nextLine().toUpperCase();
					String[] in = subCmd.split(" ");
    				
    				if (subCmd.equals("END")){
    					break; // get out of this while loop!
    				} else if (in.length == 4) {
    					try {
							col.add(new Employee(in[0], in[1], in[2], in[3]));
							
    					} catch (Exception ex){
    						ex.printStackTrace();
    						System.out.println("Something went wrong. Try entering the entry again.");
    					}
    				} else {
    					System.out.println("Your input was incorrectly formatted. Try again!");
    				}
    				
    			}
    		
    			// Send it to server, reconstruct directory on server with the resulting objects ordered by last name.
    			
    			dp.add(col); // send the collection to the directory proxy.
    			
    			
    		}
    		else if (cmd.equals("CLR")){
    			ds.md = new MainDirectory(); // clear and set up new MainDirectory
    		}
    		else if (cmd.equals("PRINT")){
    			// Print out the full directory employing toString implemented for Employee and Directory classes
    			ds.md.print();
    		}
    		else {
    			System.out.println("[INVALID COMMAND] Type POWER to quit.");
    		}
    	}
    	
    	System.out.println("Goodbye!");
    }
}
