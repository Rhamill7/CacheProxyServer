import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class WebServer {
	public static void main(String argv[]) throws Exception {
		// Set the port number.
		int port = 6789;
		System.out.println("Server socket is now open.");

		ExecutorService pool = Executors.newCachedThreadPool();// create thread pool
																

		ServerSocket welcomeSocket = new ServerSocket(port); // makes new server  socket at port 6789

		/* While true will loop forever */ 
		while (true) {
			try {
				Socket connectionSocket = welcomeSocket.accept();
				// opens new socket connection
				// Construct an object to process the HTTP request message.
				//HttpRequest request = new HttpRequest(connectionSocket);
				/* Code for multi threading without threadpooling */
			//	SpoofServer spoof = new SpoofServer(connectionSocket);
				//spoof.extract();
				//Thread extract = new Thread(spoof);
				HttpRequest request = new HttpRequest(connectionSocket);
				/* run each task using a thread in pool */
			//	Thread thread2 = new Thread(spoof);

				Thread thread = new Thread(request);
				//pool.execute(thread2);
				//System.out.println("I am here");
			//	pool.execute(extract);
				pool.execute(thread);
			}

			/* Catches and prints exception */
			catch (IOException ioe) {
				System.err.println(ioe);
			}
		}
	}
}
