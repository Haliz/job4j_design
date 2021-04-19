package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "What?";
                    str = in.readLine();
                    while (!(str.isEmpty()) && str.contains("?msg=")) {
                        System.out.println(str);
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        if (str.contains("?msg=Exit")) {
                            server.close();
                            break;
                        } else if (str.contains("?msg=Hello")) {
                            answer = "Hello";
                        }
                        out.write(answer.getBytes());
                    }
                } catch (IOException e1) {
                    LOG.error("Exception in OutputStream", e1);
                }
            }
        } catch (IOException e2) {
            LOG.error("Exception in ServerSocket", e2);
        }
    }
}
