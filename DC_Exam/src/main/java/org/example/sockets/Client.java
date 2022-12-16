package org.example.sockets;

import org.example.domain.Student;

import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {

    public void start(String ip, int port) throws IOException, ClassNotFoundException {
        try (Socket clientSocket = new Socket(ip, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
             Scanner scanner = new Scanner(System.in)) {
            printCmgInfo();
            String cmd = scanner.next();
            while (!cmd.equalsIgnoreCase("stop")) {
                if (cmd.equalsIgnoreCase("gbf")) {
                    System.out.println("Enter faculty which students you want to get:");
                    String input = scanner.next();
                    out.println("gbf:" + input);
                    System.out.println(Arrays.toString(((List<Student>) in.readObject()).toArray()));
                } else if (cmd.equalsIgnoreCase("gfcl")) {
                    out.println("gfcl");
                    Map<String, List<Student>> fcMap = (Map<String, List<Student>>)in.readObject();
                    fcMap.keySet().stream().forEach(key -> {
                        System.out.println(Arrays.toString(fcMap.get(key).toArray()));
                    });
                } else if (cmd.equalsIgnoreCase("gbg")) {
                    System.out.println("Enter group which students you want to get:");
                    String input = scanner.next();
                    out.println("gbg:" + input);
                    System.out.println(Arrays.toString(((List<Student>) in.readObject()).toArray()));
                } else if (cmd.equalsIgnoreCase("gby")) {
                    System.out.println("Enter target year:");
                    String input = scanner.next();
                    out.println("gby:" + input);
                    System.out.println(Arrays.toString(((List<Student>) in.readObject()).toArray()));
                } else {
                    System.out.println("Unknown command.");
                    printCmgInfo();
                }
                cmd = scanner.next();
            }
            System.out.println("Stopped client");
            out.write(cmd);
        }
    }

    public void printCmgInfo() {
        System.out.println("""
                allowed commands: 
                gbf(get by faculty)
                gfcl(get faculties and groups lists)
                gbg(get by group)
                gby(get by year)
                stop
                """);
    }

    public static void main(String[] args) throws Exception {
        //localhost
        new Client().start("127.0.0.1", 1111);
    }
}
