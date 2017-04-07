package demo.example.com.jasonassign;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 4/7/2017.
 */

public class HttpServiceHandler {

    static String stream = null;

    public String getHttpdata(String urlString){

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //connection.setRequestMethod("GET");

            if(connection.getResponseCode() == 200){
                InputStream  inputStream = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();

                String tempLine;

                while ((tempLine =reader.readLine()) !=null){
                    builder.append(tempLine);
                }

                stream = builder.toString();
                connection.disconnect();
            }else{
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {

        }

        return stream;
    }
}
