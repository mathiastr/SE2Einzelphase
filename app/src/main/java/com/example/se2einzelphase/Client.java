package com.example.se2einzelphase;

import android.widget.TextView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;




public class Client {

    public static void sendToServer(final String matr, final TextView antw, final String dom, final int port) {

        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    Socket socket = new Socket(dom, port);

                    OutputStream os = socket.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);
                    pw.println(matr);
                    pw.flush();

                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String ans = br.readLine();

                    antw.setText(ans);

                    os.close();
                    pw.close();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

}







