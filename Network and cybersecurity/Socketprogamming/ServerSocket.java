import java.net.*;


public class ServerSocket {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(12000); // the socket port to connect to
            System.out.println("waiting for packets bruv");

            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            socket.receive(packet); // blocks until packet is received

            String payload = new String(packet.getData(), 0, packet.getLength());
            String responsePayLoad = payload.toUpperCase();

            InetAddress adress = packet.getAddress(); // gets the address of the receiving packet
            int port = packet.getPort(); // get client port
            buf = responsePayLoad.getBytes(); // gets the bytes from the the packet body

            packet = new DatagramPacket(buf, buf.length, adress, port); // make new packet and sends it back to the client
            socket.send(packet); // send packet back to client 

        } catch(Exception e) {
            System.out.println("fuck me in the ass bruv");
        }
    }
}