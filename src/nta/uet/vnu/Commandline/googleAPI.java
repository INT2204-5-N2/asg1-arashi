package nta.uet.vnu.Commandline;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
public class googleAPI {
    public googleAPI() {

    }

    public String translate(String langFrom, String langTo, String text) throws IOException {

        String urlStr = "https://script.google.com/macros/s/AKfycbwhoDW_xJr-22qvo26yfNB92ZfAu5r-0aCQG6MZXKavu8ojgDg/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public static void main(String[] args) {

        try
        {
            googleAPI a = new googleAPI();
            String m = a.translate("en","vi","house");
            System.out.println(m);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}