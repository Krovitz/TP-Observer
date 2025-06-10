package ejercicio1;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherChannelService implements ClimaOnline {

    private static final String API_KEY = "5c03cee8a0f40ded46ef04b26a0ecdc5"; // Reemplaza esto con tu propia API KEY
    private static final String CITY = "Ushuaia";
    private static final String COUNTRY = "Argentina";

    @Override
    public String temperatura() {
        try {
            String endpoint = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?q=%s,%s&units=metric&APPID=%s",
                    CITY, COUNTRY, API_KEY
            );

            URL url = new URL(endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Leer respuesta del servidor
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            conn.disconnect();

            // Parsear JSON
            JSONObject json = new JSONObject(content.toString());
            double temp = json.getJSONObject("main").getDouble("temp");
            return temp + " °C";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al obtener temperatura";
        }
    }
}


