package edu.ty.socialmedia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.ty.socialmedia.model.SocialMedia;
import edu.ty.use.model.User1;

public class DAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	Scanner scanner = new Scanner(System.in);

	public void addUser() {
		User1 user=new User1();
		System.out.println("enter user id");
		user.setUserId(scanner.nextInt());
		System.out.println("enter user name");
		user.setUserName(scanner.next());
		System.out.println("enter user email");
		user.setUserEmail(scanner.next());
		System.out.println("enter user phone");
		user.setUserPhone(scanner.nextLong());
		System.out.println("enter user password");
		user.setUserPassword(scanner.next());
		entityTransaction.begin();
		System.out.println("enter number of social media");
		int n=scanner.nextInt();
		List<SocialMedia> social=new ArrayList<SocialMedia>();
		for(int i=0;i<n;i++) {
		SocialMedia media=new SocialMedia();
		System.out.println("enter the social media id");
		 int id=scanner.nextInt();
		SocialMedia mediaa=entityManager.find(SocialMedia.class, id);
		 
		 if(mediaa==null) {
			 media.setSocialId(id);
			 System.out.println("enter the social media name");
			 media.setSocialMediaName(scanner.next());
			 System.out.println("enter founded year");
			 media.setFoundedYear(scanner.nextInt());
			 System.out.println("enter the head quater location");
			 media.setHeadQuaters(scanner.next());
			 entityManager.persist(media);
			 social.add(media);
		
		 }
		 else {
			 social.add(mediaa);
		 }
		 
		}
		user.setSocialMedia(social);
		entityManager.persist(user);
		 entityTransaction.commit();
	}
	public User1 findUser(int id) {
		return entityManager.find(User1.class, id);
	}
	
	public void updateUserNameById(int id,String name) {
		User1 user=findUser( id);
		if(user!=null) {
			user.setUserName(name);
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			System.out.println("updated");
		}
		else
			System.out.println("no record found");
	}
	public void deleteUser(int id) {
		User1 user=findUser( id);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			System.out.println("deleted");
		}
		else
			System.out.println("no record found");
	}
	public void deleteUserBySocialName() {
		Query query=entityManager.createQuery("select u.userName,s.socialMediaName from User1 u inner join u.socialMedia s  ");
		List li=query.getResultList();
		for (Object object : li) {
			Object[] row=(Object[]) object; 
			System.out.println(row[1]+" : "+row[0]);
		}
	}
}
