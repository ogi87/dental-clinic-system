package rs.ac.bg.fon.ps.client.communication;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import rs.ac.bg.fon.ps.common.communication.Request;
import rs.ac.bg.fon.ps.common.communication.Response;

public class Communication {

    private static Communication instance;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private Communication() {
        try {
            socket = new Socket("localhost", 9000);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void resetInstance() {
        instance = null;
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public void sendRequest(Request request) throws Exception {
        out.writeObject(request);
        out.flush();
        out.reset(); // ovde je bio problem sto nisam imao ovo
    }

    public Response receiveResponse() throws Exception {
        return (Response) in.readObject();
    }
}