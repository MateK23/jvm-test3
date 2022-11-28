package ge.edu.btu.chat.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerRunnable implements Runnable {
    private Socket client;
    private  int clientID;
    private boolean running = true;
    BankChat bankChat = new BankChat(3.5f);

    ServerRunnable(Socket client, int clientID) {
        this.client = client;
        this.clientID = clientID;
    }


    @Override
    public void run() {
        System.out.println("ID - " + clientID + " Add - " + client.getInetAddress().getHostName());

        try {
            while(true){
                System.out.println("Reading data ...");
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                String str = (String) objectInputStream.readObject();
                System.out.println("Client " + clientID + " asked : " + str);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
                objectOutputStream.writeObject(bankChat.readAndRespondToMessage(str));
            }
            // მონაცემების წაკითხვა და ეკრანზე გამოტანა



            // ნაკადის და სერვერის დახურვა
            //            objectInputStream.close();
            // System.out.println("Connection Ended! ");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }


}
