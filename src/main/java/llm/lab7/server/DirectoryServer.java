package llm.lab7.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import llm.lab7.Employee;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;



@SuppressWarnings("restriction")
public class DirectoryServer {
	
	public static ArrayList<Employee> jsonOut;
 
	public static MainDirectory md = new MainDirectory();
	
	// a shared area where we get the POST data and then use it in the other handler
    static String sharedResponse = "";
    static boolean gotMessageFlag = false;

    public static void main(String[] args) throws Exception {

        // set up a simple HTTP server on our local host
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        // create a context to get the request to display the results
        server.createContext("/displayresults", new DisplayHandler());

        // create a context to get the request for the POST
        server.createContext("/sendresults",new PostHandler());
        
        server.createContext("/style.css", new StaticFileServer());
        
        server.setExecutor(null); // creates a default executor

        // get it going
        System.out.println("Starting Server...");
        server.start();
    }

    static class DisplayHandler implements HttpHandler {
        public void handle(HttpExchange t) throws IOException {
        	String encoding = "UTF-8";
            t.getResponseHeaders().set("Content-Type", "text/html; charset=" + encoding);
            String response = "<!DOCTYPE html>\n<html>\n";
            response += "<head><link rel =\"stylesheet\" type = \"text/css\" href = \"/style.css\"></head>\n";
            //response += "<h1>List of Employees</h1>\n"; // title
            response += "<body>\n<table>\n<tr>\n";
            response += "<th>Title</th>\n";
            response += "<th>First Name</th>\n";
            response += "<th>Last Name</th>\n";
            response += "<th>Department</th>\n";
            response += "<th>Phone</th>\n";
            response += "<th>Gender</th>\n";
            response += "</tr>\n";
			//Gson g = new Gson();
			// set up the header	
            System.out.println(response);
//			try {
//				if (!sharedResponse.isEmpty()) {
//					System.out.println(response);
//					ArrayList<Employee> fromJson = g.fromJson(sharedResponse,
//							new TypeToken<Collection<Employee>>() {
//							}.getType());
//
//					System.out.println(response);
//					response += "Before sort\n";
//					for (Employee e : fromJson) {
//						response += e + "\n";
//					}
//					Collections.sort(fromJson);
//					response += "\nAfter sort\n";
//					for (Employee e : fromJson) {
//						response += e + "\n";
//					}
//					jsonOut = fromJson;
//				}
//			} catch (JsonSyntaxException e) {
//				e.printStackTrace();
//			}
            //md.print();
            //response += md.toString();
            response += "</table>\n</body>\n</html>\n";
            System.out.println(response);
            // write out the response
            t.sendResponseHeaders(200, response.length());
            Writer os = new OutputStreamWriter(t.getResponseBody(), encoding);
            os.write(response);
            os.close();
        }
    }

    static class PostHandler implements HttpHandler {
        public void handle(HttpExchange transmission) throws IOException {

            //  shared data that is used with other handlers
            sharedResponse = "";

            // set up a stream to read the body of the request
            InputStream inputStr = transmission.getRequestBody();

            OutputStream outputStream = transmission.getResponseBody();

            // string to hold the result of reading in the request
            StringBuilder sb = new StringBuilder();

            // read the characters from the request byte by byte and build up the sharedResponse
            int nextChar = inputStr.read();
            while (nextChar > -1) {
                sb=sb.append((char)nextChar);
                nextChar=inputStr.read();
            }

            // create our response String to use in other handler
            sharedResponse = sharedResponse+sb.toString();
            
            // send JSON to main directory
            md.receive(sharedResponse);

            // respond to the POST with ROGER
            String postResponse = "RECIEVED JSON " + sharedResponse;

            System.out.println("response: " + sharedResponse);

            //Desktop dt = Desktop.getDesktop();
            //dt.open(new File("raceresults.html"));

            // assume that stuff works all the time
            transmission.sendResponseHeaders(300, postResponse.length());

            // write it and return it
            outputStream.write(postResponse.getBytes());

            outputStream.close();
        }
    }
    
    static class StaticFileServer implements HttpHandler {

        public void handle(HttpExchange exchange) throws IOException {
            String fileId = exchange.getRequestURI().getPath();
            File file = getFile(fileId);
            if (file == null) {
                String response = "Error 404 File not found.";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream output = exchange.getResponseBody();
                output.write(response.getBytes());
                output.flush();
                output.close();
            } else {
                exchange.sendResponseHeaders(200, 0);
                OutputStream output = exchange.getResponseBody();
                FileInputStream fs = new FileInputStream(file);
                final byte[] buffer = new byte[0x10000];
                int count = 0;
                while ((count = fs.read(buffer)) >= 0) {
                    output.write(buffer, 0, count);
                }
                output.flush();
                output.close();
                fs.close();
            }
        }

        private File getFile(String fileId) {
            // TODO retrieve the file associated with the id
        	String r = ".";
        	r += fileId;
        	System.out.println(r);
        	File f = new File(r);
            return f;
        }
    }
}
