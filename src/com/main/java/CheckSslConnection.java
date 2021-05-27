package com.main.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

public class CheckSslConnection {

    public static void main(String[] args) throws Exception {
        sendPost();
    }

    private static void sendPost() throws Exception {

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);
        EasySSLSocketFactory sf = new EasySSLSocketFactory(trustStore);
        sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(new Scheme("https", sf, 443));
        ClientConnectionManager cm = new ThreadSafeClientConnManager(params, registry);

        String url = "http://demo.ashishkumar.tech/webservice/j_security_check";

        DefaultHttpClient client = new DefaultHttpClient(cm, params);
        HttpPost post = new HttpPost(url);

        // add header
//		post.setHeader("User-Agent", s);

        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        //            urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
        //            urlParameters.add(new BasicNameValuePair("cn", ""));
        //            urlParameters.add(new BasicNameValuePair("locale", ""));
        //            urlParameters.add(new BasicNameValuePair("caller", ""));
        //            urlParameters.add(new BasicNameValuePair("num", "12345"));

        urlParameters.add(new BasicNameValuePair("j_username", "admin"));
        urlParameters.add(new BasicNameValuePair("j_password", "admin"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        HttpResponse response = client.execute(post);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + post.getEntity());
        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        Header[] headers = response.getAllHeaders();
        for (Header header : headers) {
            System.out.println("Key : " + header.getName()
                    + " ,Value : " + header.getValue());

            if (header.getName().equalsIgnoreCase("Set-Cookie") == true) {
                System.out.println("setting session id");
                //SESSIONID = header.getValue().split(";")[0];
            }
        }
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
    }

}
