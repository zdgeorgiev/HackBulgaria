package weatherCrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Program {

    private static final float MINIMUM_TEMP = 30.0f;

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("contries.txt"))) {
            File outputResults = new File("results.txt");

            if (outputResults.exists()) {
                outputResults.delete();
                outputResults.createNewFile();
            }

            String currentCountry;

            while ((currentCountry = reader.readLine()) != null) {
                URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
                        + currentCountry.replace(" ", "%20") + "&units=metric");

                boolean isCompleted = false;

                while (!isCompleted) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                        isCompleted = true;

                        String countryResult;
                        while ((countryResult = in.readLine()) != null) {

                            if (countryResult.contains("Not found city")) {
                                continue;
                            }

                            try (FileWriter fw = new FileWriter(outputResults.getAbsoluteFile(), true);
                                    BufferedWriter bw = new BufferedWriter(fw)) {
                                bw.write(countryResult + System.lineSeparator());

                                printCountries(currentCountry, countryResult);
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printCountries(String currentCountry, String countryResult) {

        try {
            JSONObject json = new JSONObject(countryResult);
            Float temperature = Float.parseFloat(new JSONObject(json.get("main").toString()).get("temp").toString());

            if (temperature >= MINIMUM_TEMP) {
                System.out.println(currentCountry + " - " + temperature);
            }
        } catch (JSONException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}