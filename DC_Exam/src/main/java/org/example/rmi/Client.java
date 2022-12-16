package org.example.rmi;

import org.example.domain.Student;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client {
    public static final String UNIC_BINDING_NAME = "books.service";

    public void start() throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(2099);
        StudentsService service = (StudentsService) registry.lookup(UNIC_BINDING_NAME);

        try(Scanner scanner = new Scanner(System.in)) {
            printCmgInfo();
            String cmd = scanner.next();
            while (!cmd.equalsIgnoreCase("stop")) {
                if (cmd.equalsIgnoreCase("gbf")) {
                    System.out.println("Enter faculty which students you want to get:");
                    String input = scanner.next();
                    System.out.println(Arrays.toString((service.getByFaculty(input)).toArray()));
                } else if (cmd.equalsIgnoreCase("gfcl")) {
                    Map<String, List<Student>> fcMap = service.getFacultiesAndCoursesLists();
                    fcMap.keySet().stream().forEach(key -> {
                        System.out.println(Arrays.toString(fcMap.get(key).toArray()));
                    });
                } else if (cmd.equalsIgnoreCase("gbg")) {
                    System.out.println("Enter group which students you want to get:");
                    String input = scanner.next();
                    System.out.println(Arrays.toString(service.getGroup(input).toArray()));
                } else if (cmd.equalsIgnoreCase("gby")) {
                    System.out.println("Enter target year:");
                    Long input = Long.parseLong(scanner.next());
                    System.out.println(Arrays.toString(service.getByYear(input).toArray()));
                } else {
                    System.out.println("Unknown command.");
                    printCmgInfo();
                }
                cmd = scanner.next();
            }
            System.out.println("Client stopped");
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
        new Client().start();
    }
}
