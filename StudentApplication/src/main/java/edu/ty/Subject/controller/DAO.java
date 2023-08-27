package edu.ty.Subject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.ty.Subject.bean.Subject;
import edu.ty.student.bean.Student;

public class DAO {

	Scanner scanner=new Scanner(System.in);
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void addSubject() {
		Subject subject=new Subject();
		System.out.println("enter subject id");
		subject.setId(scanner.nextLong());
		System.out.println("enter subject name");
		subject.setName(scanner.next());
		System.out.println("enter number of days");
		subject.setNumberofDay(scanner.nextInt());
		System.out.println("enter subject price");
		subject.setPrice(scanner.nextDouble());
		System.out.println("enter number of students");
		int num=scanner.nextInt();
		List<Student> students=new ArrayList<Student>();
		entityTransaction.begin();
		for(int i=0;i<num;i++) {
			Student student=new Student();
			System.out.println("enter the student id");
			student.setId(scanner.nextLong());
			System.out.println("enter the student name");
			student.setName(scanner.next());
			System.out.println("enter the student email");
			student.setEmail(scanner.next());
			System.out.println("enter the student phone number");
			student.setPhoneNumber(scanner.next());
			entityManager.persist(student);
			students.add(student);
		}
		subject.setStudents(students);
		entityManager.persist(subject);
		entityTransaction.commit();
	}
	
	private Subject findSubject(long id) {
		return entityManager.find(Subject.class,id);
	}
	
	public void updateSubjectNumberofDays(long id,int numberofDays) {
		Subject subject =findSubject(id);
		if(subject!=null) {
			subject.setNumberofDay(numberofDays);
			entityTransaction.begin();
			entityManager.merge(subject);
			entityTransaction.commit();
			System.out.println("updated");
		}
		else
		System.out.println("no record found");
		
	}
	public void delteSubject(long id) {
		Subject subject =findSubject(id);
		if(subject!=null) {
			entityTransaction.begin();
			entityManager.remove(subject);
			entityTransaction.commit();
			System.out.println("deleted");
		}
		else
		System.out.println("no record found");
		
	}
	
	public void getSubject(long id) {
		Subject subject=findSubject(id);
		if(subject!=null) {
			System.out.println(subject);
			 List<Student> student = subject.getStudents();
			 for (Student student2 : student) {
				
				 System.out.println(student);
			}
		}
	}
	public void deleteStudent(long id) {
		Subject subject=findSubject(id);
		if(subject!=null) {
			
			entityTransaction.begin();
			 List<Student> student = subject.getStudents();
			 for (Student student2 : student) {
				
					entityManager.remove(student2);
//				 System.out.println(student2);
				
			}
			 student.removeAll(student);
			 subject.setStudents(student);
			 entityManager.merge(subject);
			 entityTransaction.commit();
			 System.out.println("deleted");
		}
		
		
	}
}
