package ejercicio1;

public class Medidor extends Sujeto {
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemperatura() {
//leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        notificarObservadores(temperatura);
        return this.temperatura;
    }
}

