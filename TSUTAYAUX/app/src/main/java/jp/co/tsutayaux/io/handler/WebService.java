
package jp.co.tsutayaux.io.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by DuongND on 11/18/2016.
 */
public class WebService {

    public String loadUrl(String url) throws IOException {
        HttpURLConnection connection = null;
        URL urlConnection = new URL(url);
        connection = (HttpURLConnection) urlConnection.openConnection();
        if (connection == null) {
            return null;
        }
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type",
                "application/json");
        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(30000);

        // Get Response
        InputStream is = connection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.defaultCharset()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        connection.disconnect();
        return response.toString();
    }

}
