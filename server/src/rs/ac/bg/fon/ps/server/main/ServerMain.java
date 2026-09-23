package rs.ac.bg.fon.ps.server.main;

import rs.ac.bg.fon.ps.server.form.FrmServer;
import rs.ac.bg.fon.ps.server.thread.ServerThread;

public class ServerMain {

    public static void main(String[] args) {
        FrmServer frmServer = new FrmServer();
        frmServer.setLocationRelativeTo(null);
        frmServer.setVisible(true);
    }
}