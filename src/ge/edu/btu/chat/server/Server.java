package ge.edu.btu.chat.server;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // display exchange rate
    // show atm branches
    // OnWrong answer: „სამწუხაროდ ამ თემაზე ინფორმაციას არ ვფლობ“

    // TODO

    public static void main(String[] args) {
        ServerSocket serverSocket; // სერვერი
        Socket socket = null; // კლიენტი
        ObjectInputStream objectInputStream; // ნაკადი
        String str; // მიღებული მონაცემი
        int clientId = 0;
        Thread serverThread = null;




        try {
            serverSocket = new ServerSocket(9011);
            System.out.println("Server on!");

            while(true){
                socket = serverSocket.accept();
                ServerRunnable serverRunnable = new ServerRunnable(socket, clientId);
                serverThread = new Thread(serverRunnable);
                serverThread.start();
                System.out.println("Connected!");
                clientId++;
            }
        }catch(Exception e) {
            System.out.println("Error: " + e);
        }

        if (serverThread != null) serverThread.start();
    }
}
