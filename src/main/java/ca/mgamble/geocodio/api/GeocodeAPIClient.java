package ca.mgamble.geocodio.api;

import ca.mgamble.geocodio.classes.GeoCodeLookupResponse;
import com.google.gson.Gson;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.Request;
import org.asynchttpclient.RequestBuilder;
import org.asynchttpclient.Response;

/**
 *
 * @author mgamble
 */
public class GeocodeAPIClient implements Closeable {

    private static final String JSON = "application/json; charset=UTF-8";
    private final boolean closeClient;
    private final AsyncHttpClient client;
    private final String url;
    private final String token;
    private final Logger logger;
    private boolean closed = false;
    private static final Version version = new Version();
    Gson gson = new Gson();

    public GeocodeAPIClient(String url, String token) throws Exception {
        this.logger = Logger.getLogger(GeocodeAPIClient.class);
        this.url = url;
        this.token = token;
        this.client = new DefaultAsyncHttpClient();

        closeClient = true;

    }

    //////////////////////////////////////////////////////////////////////
    // Closeable interface methods
    //////////////////////////////////////////////////////////////////////
    public boolean isClosed() {
        return closed || client.isClosed();
    }

    public void close() {
        if (closeClient && !client.isClosed()) {
            try {
                client.close();
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(GeocodeAPIClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        closed = true;
    }

    private String encodeValue(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
    }
    
    public GeoCodeLookupResponse geoCodeLookup(String lookupString) throws Exception {
    Future<Response> f = client.executeRequest(buildRequest("GET", "/geocode?q=" + encodeValue(lookupString)));
        Response r = f.get();
        if (r.getStatusCode() != 200) {

            throw new Exception("Could not geocode address - error: " + r.getStatusText());
        } else {
            return gson.fromJson(r.getResponseBody(), GeoCodeLookupResponse.class);
        }
    }
    

    public static String getVersion() {
        return version.getBuildNumber();
    }

    private Request buildRequest(String type, String subUrl) {
        RequestBuilder builder = new RequestBuilder(type);
        Request request = builder.setUrl(this.url + subUrl)
                .addHeader("Accept", JSON)
                .addHeader("Content-Type", JSON)
                .addQueryParam("api_key", this.token)
                .build();
        return request;
    }

    private Request buildRequest(String type, String subUrl, String requestBody) {
        RequestBuilder builder = new RequestBuilder(type);
        Request request = builder.setUrl(this.url + subUrl)
                .addQueryParam("api_key", this.token)
                .addHeader("Accept", JSON)
                .addHeader("Content-Type", JSON)
                .setBody(requestBody)
                .build();
        return request;
    }
}
