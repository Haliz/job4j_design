package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String answer = "What?";
                    while (!(str = in.readLine()).isEmpty() && str.contains("?msg=")) {
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
                }
            }
        }
    }
}
