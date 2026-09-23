package rs.ac.bg.fon.ps.client.main;

import javax.swing.SwingUtilities;
import rs.ac.bg.fon.ps.client.form.FrmLogin;

public class ClientMain {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }
}