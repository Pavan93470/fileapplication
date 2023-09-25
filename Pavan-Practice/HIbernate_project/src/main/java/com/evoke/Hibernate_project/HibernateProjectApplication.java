package com.evoke.Hibernate_project;

import com.evoke.Hibernate_project.Entity.Student;

import com.evoke.Hibernate_project.Serviceinterface.StudentInterface;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandlineRunner(StudentInterface studentInterface) {


		return runner -> {
//			createStudent(studentInterface);

//			readstudent(studentInterface);
//			studentQuery(studentInterface);
			StudentFindByName(studentInterface);


		};
	}

	private void StudentFindByName(StudentInterface studentInterface) {
		List<Student> studentDetailsByLastName= studentInterface.findByName("Battila");

		for(Student studentname: studentDetailsByLastName ){
			System.out.println(studentname);

		}

	}

//	private void studentQuery(StudentInterface studentInterface) {
//		//get list of student
//		List<Student> allDetails= studentInterface.findAll();
//
//		for(Student studentsList : allDetails){
//			System.out.println(studentsList);
//		}
//
//	}

//	private void readstudent(StudentInterface studentInterface) {
//		Student studentdetails2 = new Student("pavan", "battila", "pavan123battila@gmail.com");
//		System.out.println("save details"+ studentdetails2);
//
//		//display details by id
//		int getbyid= studentdetails2.getId();
//		System.out.println("save student by id" + getbyid);
//
//        //reterving the student details by id
//		System.out.println("data reterving"+getbyid);
//		Student studentbyid= studentInterface.findBYid(getbyid);
//
//		//display student
//		System.out.println(studentbyid);
//
//
//	}

//	private void createStudent(StudentInterface studentInterface) {
//		//create student object
//		Student studentdetails = new Student("roja", "battila", "pavan.battila@gmail.com");
//		Student studentdetails2 = new Student("pavan", "battila", "pavan123battila@gmail.com");
//
//		//save the student object
//		studentInterface.save(studentdetails);
//		studentInterface.save(studentdetails2);
//
//		//display details of student
//		System.out.println("details"+studentdetails.getId());
//
//	}
}






