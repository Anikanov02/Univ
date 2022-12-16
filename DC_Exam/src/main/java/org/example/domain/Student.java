package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String fathersName;
    private Long dateOfBirth;
    private String address;
    private String phone;
    private String faculty;
    private Integer course;
    private String group;
}
