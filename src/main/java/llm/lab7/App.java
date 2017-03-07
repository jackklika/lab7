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
    	
    	while(powerOn){
    		System.out.print("CMD> ");
    		cmd = scan.next().toUpperCase();
    		// process command
    		
    		if (cmd.equals("POWER")){
    			powerOn = false;
    		}
    		else if (cmd.equals("ADD")){
    			// jump into another loop, break with 'end'
    			String subCmd;
    			while (true){
    				subCmd = scan.next().toUpperCase();
    				
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
