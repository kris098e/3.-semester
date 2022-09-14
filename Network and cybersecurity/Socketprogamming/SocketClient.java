import java.net.*;
import java.util.Scanner;

import javax.swing.SortingFocusTraversalPolicy;

public class SocketClient {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            int port = 12000;

            DatagramSocket socket = new DatagramSocket();

            System.out.print("message to send: ");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            System.out.println();

            byte[] buf = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
            System.out.println(packet.getLength());

            DatagramPacket receivePacket = new DatagramPacket(new byte[100], 100); //make new packet that can hold all the data
            socket.send(packet);
            socket.receive(receivePacket); // blocks until received packet

            System.out.println(packet.getLength());
            String received = new String(receivePacket.getData(), 0 , receivePacket.getLength());
            System.out.println("Received: " + received);
            
            socket.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        


    }
}