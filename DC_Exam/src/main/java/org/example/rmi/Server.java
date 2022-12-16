package org.example.rmi;

import org.example.domain.Student;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final String UNIC_BINDING_NAME = "books.service";

    public static void main(String[] args) throws Exception {
        final List<Student> students = new ArrayList<>();
        students.add(new Student(0L, "firn0", "lasn0", "fatn0", 2000L, "addr0", "phone0", "fac0", 3, "group0"));
        students.add(new Student(1L, "firn1", "lasn1", "fatn1", 2000L, "addr1", "phone1", "fac1", 1, "group0"));
        students.add(new Student(2L, "firn2", "lasn2", "fatn2", 2002L, "addr2", "phone2", "fac2", 3, "group1"));
        students.add(new Student(3L, "firn3", "lasn3", "fatn3", 2003L, "addr3", "phone3", "fac3", 2, "group1"));
        students.add(new Student(4L, "firn4", "lasn4", "fatn4", 2004L, "addr4", "phone4", "fac4", 1, "group2"));

        StudentsServiceImpl booksService = new StudentsServiceImpl(students);
        final Registry registry = LocateRegistry.createRegistry(2099);
        Remote stub = UnicastRemoteObject.exportObject(booksService, 0);
        registry.bind(UNIC_BINDING_NAME, stub);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
