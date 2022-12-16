package org.example.rmi;

import lombok.AllArgsConstructor;
import org.example.domain.Student;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
public class StudentsServiceImpl implements StudentsService {
    private List<Student> students;

    public StudentsServiceImpl() {
        this.students = new ArrayList<>();
    }

    @Override
    public void addStudents(List<Student> books) throws RemoteException {
        this.students.addAll(books);
    }

    @Override
    public List<Student> getByFaculty(String faculty) throws RemoteException {
        return students.stream()
                .filter(student -> student.getFaculty().equalsIgnoreCase(faculty))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> getByCourse(Integer course) throws RemoteException {
        return students.stream()
                .filter(student -> student.getCourse().equals(course))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Student>> getFacultiesAndCoursesLists() throws RemoteException {
        Map<String, List<Student>> fcMap = new HashMap<>();
        List<String> faculties = students.stream().map(Student::getFaculty).collect(Collectors.toList());
        List<Integer> courses = students.stream().map(Student::getCourse).collect(Collectors.toList());
        faculties.stream().forEach(fac -> {
            try {
                fcMap.put("Faculty:" + fac, getByFaculty(fac));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
        courses.stream().forEach(course -> {
            try {
                fcMap.put("Course:" + course, getByCourse(course));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        });
        return fcMap;
    }

    @Override
    public List<Student> getGroup(String group) throws RemoteException {
        return students.stream()
                .filter(student -> group.equalsIgnoreCase(student.getGroup())).collect(Collectors.toList());
    }

    @Override
    public List<Student> getByYear(Long year) throws RemoteException {
        return students.stream()
                .filter(student -> student.getDateOfBirth() >= year).collect(Collectors.toList());
    }
}
