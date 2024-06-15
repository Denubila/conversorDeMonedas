import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Resultados {
    public String respuesta(String responseBody){
        JsonObject json = JsonParser.parseString(responseBody).getAsJsonObject();
        double conversion = json.get("conversion_result").getAsDouble();
        return  Double.toString(conversion);
    }
}
