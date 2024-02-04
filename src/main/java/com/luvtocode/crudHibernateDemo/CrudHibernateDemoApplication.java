package com.luvtocode.crudHibernateDemo;

import com.luvtocode.crudHibernateDemo.dao.StudentDAO;
import com.luvtocode.crudHibernateDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CrudHibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudHibernateDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner ->{
			//switch on the method to create one student
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//switch on the method to read student
			//readStudent(studentDAO);

			//switch on the method to read student by query
			//QueryStudent(studentDAO);
			//QuerytofindByLastName(studentDAO);

			//switch on the method to update student by query
			//updateStudent(studentDAO);

			//switch on the method to delete student by query
			//deleteStudent(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleting All Students");
		int n=studentDAO.deleteAll();
		System.out.println(n+" Rows Deleted");
	}


	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting Student");
		studentDAO.delete(3001);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve the student based on id;
		Student thestudent=studentDAO.findById(3000);
		System.out.println("Old Deatils: "+thestudent);

		//change the name
		thestudent.setFirstname("Chinaman");
		System.out.println("Updating the Deatils .....");

		//update
		studentDAO.update(thestudent);


		//display student details
		Student newstudent=studentDAO.findById(3000);
		System.out.println("Updated Student Details: "+newstudent);
	}

	private void QuerytofindByLastName(StudentDAO studentDAO) {

		List<Student> thestudents=studentDAO.findStudentByName("Tiwari");

		for(Student student:thestudents)
		{
			System.out.println(student.getFirstname());
		}

	}

	private void QueryStudent(StudentDAO studentDAO) {
		List<Student> studentslist= studentDAO.findAll();

		for(Student student:studentslist)
		{
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		Student tempstudent=new Student("Vikas", "Tiwari", "suyash@luvtocode.com");

		//save the student
		studentDAO.save(tempstudent);

		int id=tempstudent.getId();
		System.out.println("Created id of the new student = "+ id);

		//display the id of the student object
		Student mystudent= studentDAO.findById(id);
		System.out.println("Name of the new student is:"+ mystudent.getFirstname());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//student creation
		System.out.println("Creating 3 student object  .....");
		Student tempstudent1=new Student("Suyash", "Pathak", "Suyash@luvtocode.com");
		Student tempstudent2=new Student("Anjali", "Awasthi", "Anjali@luvtocode.com");
		Student tempstudent3=new Student("Saurabh", "Kashyap", "Saurabh@luvtocode.com");
		//Student tempstudent4=new Student("Anjali", "Awasthi", "anjali@luvtocode.com");

		//save the student objects
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
	}


	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object  .....");
		Student tempstudent=new Student("Anjali", "Awasthi", "anjali@luvtocode.com");



		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempstudent);


		//display the id of the saved student object
		System.out.println("Saved student. Generated id: "+ tempstudent.getId());


	}





}
