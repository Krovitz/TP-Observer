package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public abstract class Sujeto {
    private List<Observer> observadores;


    public Sujeto() {
        this.observadores = new ArrayList<>();
    }

    public void agregarObservadores(List<Observer> observadores) {
        this.observadores.addAll(observadores);
    }

    public void notificarObservadores(String temperatura) {
        for (Observer o : observadores) {
            o.hacerAlgo(temperatura);
        }
    }
}
