import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class TCPServerSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 12000);

            boolean autoFlush = true;
            PrintWriter out = new PrintWriter(socket.getOutputStream(), autoFlush);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            System.out.println("intput lowercase sentence: \n");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();

            out.println(message);
            out.println();
            out.flush();

            String response = in.readLine();
            System.out.println("Received: " + response);
            out.close();
            socket.close();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
    }
}