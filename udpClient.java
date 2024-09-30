// Java program to illustrate Client side Implementation using DatagramSocket
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.net.SocketException;
import java.net.UnknownHostException;

public class udpClient
{
	// Constructor
	public udpClient()
	{
		try {
			Scanner sc = new Scanner(System.in);

			// Step 1:Create the socket object for carrying the data. (port 7500)
			DatagramSocket ds = new DatagramSocket(7500);
		}
		catch (SocketException e) {
			System.out.println("ERROR creating socket");
			System.out.println(e.getMessage());
		}

		try {
			InetAddress ip = InetAddress.getLocalHost();
			//InetAddress ip = InetAddress.getByName("192.168.1.100"); // Address given in slides
		}
		catch (UnknownHostException e) {
			System.out.println("ERROR connecting to host");
			System.out.println(e.getMessage());
		}
		byte[] buf = null;
	}

	// Update function, runs every frame
	public int update(Scanner SC, DatagramSocket DS, byte[] B, InetAddress IP)
	{
		Scanner sc = SC;
		DatagramSocket ds = DS;
		byte[] buf = B;
		InetAddress ip = IP;

		String inp = sc.nextLine();

		// convert the String input into the byte array.
		buf = inp.getBytes();

		// Step 2 : Create the datagramPacket for sending the data.
		DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 7501);

		try {
			// Step 3 : invoke the send call to actually send the data.
			ds.send(DpSend);
		}
		catch (IOException e) {
			System.out.println("ERROR sending data");
			System.out.println(e.getMessage());
		}

		// break the loop if user enters "bye"
		if (inp.equals("bye"))
			return 1; // Returns 1 when exiting
		return 0;
	}
}

/*
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);

		// Step 1:Create the socket object for carrying the data.
		DatagramSocket ds = new DatagramSocket(7500);

		InetAddress ip = InetAddress.getLocalHost();
      //InetAddress ip = InetAddress.getByName("192.168.1.100"); // Address given in slides
		byte buf[] = null;

		// loop while user not enters "bye"
		while (true)
		{
			String inp = sc.nextLine();

			// convert the String input into the byte array.
			buf = inp.getBytes();

			// Step 2 : Create the datagramPacket for sending the data.
			DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 7501);

			// Step 3 : invoke the send call to actually send the data.
			ds.send(DpSend);

			// break the loop if user enters "bye"
			if (inp.equals("bye"))
				break;
		}
	}
*/