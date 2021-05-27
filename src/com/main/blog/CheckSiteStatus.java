package com.main.blog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Date;

public class CheckSiteStatus {
    public static void main(String[] args) throws Exception {
        available(8080);
        // System.out.println(pingURL("http://185.119.173.138:80", 1000));
        System.out.println(pingHost("54.202.7.150", 7, 2000));
    }

    private static boolean available(int port) {
        long lStartTime = new Date().getTime();
        System.out.println("--------------Testing port " + port);
        Socket s = null;
        try {
            s = new Socket("54.202.7.150", port);
            System.out.println("--------------Port " + port + " is used by some Application");
            return false;
        } catch (IOException e) {
            System.out.println("--------------Port " + port + " is available");
            return true;
        } finally {
            long lEndTime = new Date().getTime();
            long difference = lEndTime - lStartTime;
            System.out.println("Elapsed milliseconds Port: " + difference);

            if (s != null) {
                try {
                    s.close();
                } catch (IOException e) {
                    throw new RuntimeException("You should handle this error.", e);
                }
            }
        }
    }

    public static boolean pingURL(String url, int timeout) {
        long lStartTime = new Date().getTime();
        url = url.replaceFirst("^https", "http");

        BufferedReader br = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            long lEndTime = new Date().getTime();
            long difference = lEndTime - lStartTime;
            System.out.println(responseCode + "Elapsed milliseconds URL: " + difference);
            if (200 <= connection.getResponseCode() && connection.getResponseCode() <= 399) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            return (200 <= responseCode && responseCode <= 399);
        } catch (IOException exception) {
            exception.printStackTrace();
            return false;
        }
    }


    public static boolean pingHost(String host, int port, int timeout) {
        long lStartTime = new Date().getTime();
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);
            long lEndTime = new Date().getTime();
            long difference = lEndTime - lStartTime;
            System.out.println("Elapsed milliseconds Host: " + difference);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Either timeout or unreachable or failed DNS lookup.
        }
    }

}
