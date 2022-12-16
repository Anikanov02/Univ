package org.example.sockets;

import org.example.domain.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Server {
    public void start(List<Student> students, int port) throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String input;
            while (!(input = in.readLine()).equalsIgnoreCase("stop")) {
                if (input.matches("gbf:\\w+")) {
                    String faculty = input.split(":")[1];
                    out.writeObject(getByFaculty(faculty, students));
                } else if (input.equalsIgnoreCase("gfcl")) {
                    Map<String, List<Student>> fcMap = new HashMap<>();
                    List<String> faculties = students.stream().map(Student::getFaculty).collect(Collectors.toList());
                    List<Integer> courses = students.stream().map(Student::getCourse).collect(Collectors.toList());
                    faculties.stream().forEach(fac -> {
                        try {
                            fcMap.put("Faculty:" + fac, getByFaculty(fac, students));
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    courses.stream().forEach(course -> {
                        try {
                            fcMap.put("Course:" + course, getByCourse(course, students));
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    out.writeObject(fcMap);
                } else if (input.matches("gbg:\\w+")) {
                    String group = input.split(":")[1];
                    final List<Student> filtered = students.stream()
                            .filter(student -> group.equalsIgnoreCase(student.getGroup())).collect(Collectors.toList());
                    out.writeObject(filtered);
                } else if (input.matches("gby:\\w+")) {
                    Long year = Long.parseLong(input.split(":")[1]);
                    final List<Student> filtered = students.stream()
                            .filter(student -> student.getDateOfBirth() >= year).collect(Collectors.toList());
                    out.writeObject(filtered);
                } else {
                    System.out.println("unknown command");
                }
            }
            System.out.println("Stopped server");
        }
    }

    public List<Student> getByFaculty(String faculty, List<Student> students) throws RemoteException {
        return students.stream()
                .filter(student -> student.getFaculty().equalsIgnoreCase(faculty))
                .collect(Collectors.toList());
    }

    public List<Student> getByCourse(Integer course, List<Student> students) throws RemoteException {
        return students.stream()
                .filter(student -> student.getCourse().equals(course))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        final List<Student> students = new ArrayList<>();
        students.add(new Student(0L, "firn0", "lasn0", "fatn0", 2000L, "addr0", "phone0", "fac0", 3, "group0"));
        students.add(new Student(1L, "firn1", "lasn1", "fatn1", 2000L, "addr1", "phone1", "fac1", 1, "group0"));
        students.add(new Student(2L, "firn2", "lasn2", "fatn2", 2002L, "addr2", "phone2", "fac2", 3, "group1"));
        students.add(new Student(3L, "firn3", "lasn3", "fatn3", 2003L, "addr3", "phone3", "fac3", 2, "group1"));
        students.add(new Student(4L, "firn4", "lasn4", "fatn4", 2004L, "addr4", "phone4", "fac4", 1, "group2"));
        Server server = new Server();
        server.start(students, 1111);
    }
}
