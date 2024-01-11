package com.hasantekinada.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@SpringBootApplication
@RestController
public class SchoolApplication {

	List<School> schoolList = new ArrayList();


	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);


	}
	@CrossOrigin
	@GetMapping("/hello")
	public String sayHello() {
		return "Yurtta sulh cihanda sulh " +
				"Mustafa Kemal Atatürk";

	}
	@CrossOrigin
	@GetMapping("/school")
	public School getSchool() {
		School school = new School();
		school.schoolName = "Hasan tekin ada";
		school.studentNumber = 480;
		school.teacherNumber = 30;

		Teacher teacher = new Teacher();
		teacher.name = "Yasin";

		school.teachers.add(teacher);
		return school;
	}
	@CrossOrigin
	@PostMapping("/school/create")
	public School createSchool(@RequestBody School school) {
		schoolList.add(school);
		return school;
	}
	@CrossOrigin
	@GetMapping ("/schools")
	public List<School> getSchoolList() {

		return schoolList;
	}
	@CrossOrigin
	@GetMapping ("/teachers")
	public List<Teacher> getTeachers(@RequestParam String schoolName) {

		School school = null;

		for (School school1 : schoolList){
			if (school1.schoolName.equals(schoolName))
				school = school1;

		}

		return school.teachers;
	}

	@CrossOrigin
	@PostMapping("/school/update")
	public School updateSchool(@RequestBody School schoolUpdated) {
		School school = null;

		for (School school1 : schoolList){
			if (school1.schoolName.equals(schoolUpdated.schoolName))
				school = school1;

		}

		school.teachers = schoolUpdated.teachers;
		school.schoolName = schoolUpdated.schoolName;
		school.studentNumber = schoolUpdated.studentNumber;
		school.teacherNumber = schoolUpdated .teacherNumber;


		return school;
	}

	@CrossOrigin
	@DeleteMapping  ("/delete/school")
	public void deleteSchools() {

		schoolList.clear();
	}

}
