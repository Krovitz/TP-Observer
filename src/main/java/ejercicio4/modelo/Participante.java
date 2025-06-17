package ejercicio4.modelo;

public class Participante {
    private final String nombre;
    private final String telefono;
    private final String region;

    public Participante(String nombre, String telefono, String region) {
//        if (!validarTelefono(telefono))
//            throw new RuntimeException("El telefono ingresado no es valido");
        if (esVacio(telefono))
            throw new RuntimeException("El telefono no debe estar vacio");
        if (esVacio(nombre))
            throw new RuntimeException("El nombre no debe estar vacio");
        if (esVacio(region))
            throw new RuntimeException("La region no debe estar vacio");
        if (!regionConocida(region))
            throw new RuntimeException("La region no es conocida");
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    public boolean esVacio(String cadena) {
        return cadena.isEmpty();
    }

    public boolean regionConocida(String region) {
        return region.equals("China") || region.equals("US") || region.equals("Europa");
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getTelefono() {
        return telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRegion() {
        return region;
    }
}
