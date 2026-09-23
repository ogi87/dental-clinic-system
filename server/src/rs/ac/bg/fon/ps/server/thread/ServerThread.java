package rs.ac.bg.fon.ps.server.thread;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {

    private ServerSocket serverSocket;
    private boolean kraj = false;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Server je pokrenut na portu 9000.");

            while (!kraj) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao.");

                HandleClientThread hct = new HandleClientThread(socket);
                hct.start();
            }

        } catch (Exception e) {
            if (!kraj) {
                e.printStackTrace();
            }
        }
    }

    public void zaustaviServer() {
        try {
            kraj = true;
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}