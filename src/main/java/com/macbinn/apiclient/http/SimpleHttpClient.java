package com.macbinn.apiclient.http;

import com.macbinn.apiclient.AbstractLogger;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by zhibin.ning on 17-4-25.
 */
public class SimpleHttpClient extends AbstractLogger implements HttpClient {

    private String inputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder out = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
            out.append(newLine);
        }
        return out.toString();
    }

    @Override
    public String get(String url) {
        try (InputStream inputStream = new URL(url).openStream()) {
            return inputStreamToString(inputStream);
        } catch (IOException e) {
            logger.error("", e);
        }
        return null;
    }

    @Override
    public String post(String url, String body) {
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestProperty("Connection", "close");
            try (OutputStream outputStream = urlConnection.getOutputStream()) {
                outputStream.write(body.getBytes());
            }
            try (InputStream inputStream = urlConnection.getInputStream()) {
                return inputStreamToString(inputStream);
            }
        } catch (IOException e) {
            logger.error("", e);
        }
        return null;
    }
}
