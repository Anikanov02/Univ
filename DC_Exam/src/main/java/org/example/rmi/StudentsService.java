package org.example.rmi;

import org.example.domain.Student;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface StudentsService extends Remote {
    void addStudents(List<Student> books) throws RemoteException;

    List<Student> getByFaculty(String faculty) throws RemoteException;

    List<Student> getByCourse(Integer course) throws RemoteException;

    Map<String, List<Student>> getFacultiesAndCoursesLists() throws RemoteException;

    List<Student> getGroup(String group) throws RemoteException;

    List<Student> getByYear(Long year) throws RemoteException;
}
