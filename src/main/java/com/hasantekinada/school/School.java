package com.hasantekinada.school;

import java.util.ArrayList;
import java.util.List;

public class School {
    public String schoolName;
    public int studentNumber;
    public int teacherNumber;

public List<Teacher> teachers = new ArrayList();
public List<Student> students = new ArrayList();

public void changeName(School school, String name){
    school.schoolName = name;
}

}
