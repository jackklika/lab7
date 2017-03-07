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
    		
    			
    			
    		}
    		else if (cmd.equals("CLR")){
    			// Clear?
    		}
    		else if (cmd.equals("PRINT")){
    			// Print
    		}
    		else {
    			System.out.println("[INVALID COMMAND] Type POWER to quit.");
    		}
    	}
    	
    	System.out.println("Goodbye!");
    }
}
