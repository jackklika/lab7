package llm.lab7;

import java.util.Scanner;

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
    	System.out.println(
    			"-LADY LIGHTNING MONKEYS INC BANK THING!-" + 
    			"POWER: Toggles power of machine\n" +
    			"CLR: Clears database\n" +
    			"ADD: Adds records\n" +
    			"PRINT: Prints out a full directory"
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
    			while (true){
    				subCmd = scan.nextLine().toUpperCase();
    				
    				if (subCmd.equals("END")){
    					break; // get out of this while loop!
    				}
    				else {
    					
    					// PARSE INPUT
    					
    				}
    				
    			}
    			
    		}
    		else if (cmd.equals("CLR")){
    			// Clear the directory 
    		}
    		else if (cmd.equals("PRINT")){
    			// Print out the full directory employing toString implimented for Employee and Directory classes
    		}
    		else {
    			System.out.println("[INVALID COMMAND] Type POWER to quit.");
    		}
    	}
    	
    	System.out.println("Goodbye!");
    }
}
