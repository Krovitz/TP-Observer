package ejercicio4.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {
    private List<Observador> observadores;

    public Sujeto() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void notificarObservadores(String email) {
        for (Observador o : observadores) {
            o.notificar(email);
        }
    }
}
