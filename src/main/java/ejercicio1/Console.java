package ejercicio1;

public class Console implements Observer {
    @Override
    public void hacerAlgo(String temperatura) {
        String valor = temperatura.split(" ")[0];

        double temp = Double.parseDouble(valor);
        if (temp < 12) {
            System.out.println("Hace frio, se encenderá la caldera");
        } else if (temp > 17) {
            System.out.println("Hace calor, se encenderá el aire acondicionado");
        }
    }
}
