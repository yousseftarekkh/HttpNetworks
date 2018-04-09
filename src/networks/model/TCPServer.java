package networks.model;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;

public class TCPServer extends Thread {
	ServerSocket server = null;
	Socket socket = null;
	Queue<HttpRequest> requests = null;

	public Queue<HttpRequest> getRequests() {
		return requests;
	}

	public void setRequests(Queue<HttpRequest> requests) {
		this.requests = requests;
	}

	public TCPServer(int port, String host, int serverPort) {
		try {
			System.out.println("Binding to port " + port + ", please wait  ...");
			server = new ServerSocket(port);
			requests = new LinkedList<HttpRequest>();
			// socket = new Socket(host, serverPort);
			System.out.println("Server started: " + server);
			Thread thread = new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {
						try {
							System.out.println("Waiting for a client ...");
							addThread(server.accept());
						} catch (IOException ie) {
							System.out.println("Acceptance Error: " + ie);
						}
					}

				}
			});
			thread.start();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}

	public void addThread(Socket socket) {
		System.out.println("Client accepted: " + socket);
		CustomThread client = new CustomThread(socket, requests);
		client.start();
	}

	public static void main(String argv[]) throws Exception {
		TCPServer server = new TCPServer(6789, "sobky", 6888);
	}

}
