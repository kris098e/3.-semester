import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12000);
            Socket socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );

            StringBuilder sb = new StringBuilder(8096);
            boolean loop = true;
            while(loop) {
                if (in.ready()){
                    int i = 0;
                    while (i != '\n') {
                        i = in.read();
                        sb.append((char) i);
                    }
                    loop = false;
                }
            }

            String payload = sb.toString();
            System.out.println(payload.toUpperCase());

            out.flush();
            out.close();
            socket.close();
            serverSocket.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}