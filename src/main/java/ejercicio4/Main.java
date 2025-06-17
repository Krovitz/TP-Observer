package ejercicio4;

import ejercicio4.database.JdbcParticipante;
import ejercicio4.modelo.Participantes;
import ejercicio4.notificaciones.MailTrap;
import ejercicio4.ui.AgregarParticipante;

import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    var participantes = new Participantes(new JdbcParticipante());
                    var MailTrap = new MailTrap();
                    participantes.agregarObservador(MailTrap);
                    new AgregarParticipante(participantes);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
