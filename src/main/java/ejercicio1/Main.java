package ejercicio1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClimaOnline clima = new WeatherChannelService();
        Medidor medidor = new Medidor(clima);
        var consola = new Console();
        var registroTemperatura = new RegistroDeTemperatura();

        medidor.agregarObservadores(List.of(consola, registroTemperatura));
        System.out.println("Temperatura actual: " + medidor.leerTemperatura());
    }
}