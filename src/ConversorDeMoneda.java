import com.google.gson.Gson;
import java.util.Map;

public class ConversorDeMoneda {

    public static ApiResponse getExchangeRates(String baseCurrency) throws Exception {
        String jsonResponse = HttpCliente.get(baseCurrency);
        Gson gson = new Gson();
        return gson.fromJson(jsonResponse, ApiResponse.class);
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        ApiResponse apiResponse = getExchangeRates(fromCurrency);
        Map<String, Double> rates = apiResponse.getConversion_rates();
        if (rates.containsKey(toCurrency)) {
            return amount * rates.get(toCurrency);
        } else {
            throw new IllegalArgumentException("Moneda no Encontrada: " + toCurrency);
        }
    }
}