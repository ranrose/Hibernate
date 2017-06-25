package com.delhiguru.misc.client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.delhiguru.misc.Address;
import com.delhiguru.misc.Course;
import com.delhiguru.misc.Phone;
import com.delhiguru.misc.Student;
import com.delhiguru.util.HibernateUtil;

public class StudentClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentClient client = new StudentClient();
		long studentId = client.saveStudent(new Student());
		
		System.out.println("studentId : " + studentId);

	}
	
	public Long saveStudent(Student sudent) {
		Student student2 = new Student();
		Session session = null;
		Transaction tx = null;
		Long studentID = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			student2.setStudentName("Anushka");
			Address address = new Address("Bindapur", "dwarka", "New Delhi", "110059");
			student2.setStudentAddress(address);
			
			Set<Phone> phones = new HashSet<Phone>();
			Phone phone = new Phone("Home", "9811006657");
			Phone phone2 = new Phone("Office", "01125633057");
			phone.setActivatedAt(new Date());
			phone.setValidTill(new Date());
			phone2.setActivatedAt(new Date());
			phone2.setValidTill(new Date());
			
			phones.add(phone);
			phones.add(phone2);
			
			// add phones to Student
			student2.setStudentPhoneNumbers(phones);
			
			Set<Course> courses = new HashSet<Course>();
			Course course = new Course();
			course.setCourseName("Java Learning");
			
			Course course2 = new Course();
			course2.setCourseName("Spring Live Project");
			
			// Add course to collection
			courses.add(course);
			courses.add(course2);
			student2.setCourses(courses);
			
						
			studentID = (Long) session.save(student2);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return studentID;
	}

}
