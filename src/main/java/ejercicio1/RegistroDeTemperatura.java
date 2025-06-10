package ejercicio1;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class RegistroDeTemperatura implements Observer {
    private String path = "C:/Users/Tomas/Desktop/registro-temperatura.txt";
    private File file;

    public RegistroDeTemperatura() {
        this.file = new File(path);
    }


    @Override
    public void hacerAlgo(String temperatura) {
        try {
            Files.write(
                    file.toPath(),
                    temperatura.getBytes(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Error al exportar el reporte a disco");
        }
    }

}
