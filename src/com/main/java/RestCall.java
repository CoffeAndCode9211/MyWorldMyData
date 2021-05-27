package com.main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestCall {

    public static void main(String[] args) throws URISyntaxException, HttpException {
        // TODO Auto-generated method stub

        String BASE_URL = "http://localhost:8080/webservice/rest/employee?";

        DefaultHttpClient client = new DefaultHttpClient();

        client.getCredentialsProvider().setCredentials(
                new AuthScope("localhost", 8080),
                new UsernamePasswordCredentials("jboss", "Password1!"));

        HttpGet httppost = new HttpGet(BASE_URL);

        System.out.println("executing request " + httppost.getRequestLine());
        HttpResponse response = null;
        try {
            response = client.execute(httppost);
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            client.getConnectionManager().shutdown();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
