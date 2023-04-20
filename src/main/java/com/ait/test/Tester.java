package com.ait.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ait.entity.EmployeeEntity;

public class Tester {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sample");
		
		/*
		 * 
		 * EntityManager em1 = factory.createEntityManager(); EntityManager em2 =
		 * factory.createEntityManager();
		 * 
		 * 
		 * EmployeeEntity e1 = em1.find(EmployeeEntity.class, 7788);
		 * 
		 * System.out.println("========================================");
		 * 
		 * 
		 * try { Thread.sleep(25000); } catch(Exception e) {
		 * 
		 * }
		 * 
		 * 
		 * EmployeeEntity e2 = em2.find(EmployeeEntity.class, 7788);
		 * 
		 * System.out.println("========================================");
		 */
		
		/*
		 * 
		 * EmployeeEntity e3 = em1.find(EmployeeEntity.class, 7788);
		 * 
		 * System.out.println("========================================");
		 * 
		 * 
		 * EmployeeEntity e4 = em2.find(EmployeeEntity.class, 7878);
		 * 
		 */
		
		
		  EntityManager em1 = factory.createEntityManager(); 
		  TypedQuery<EmployeeEntity>
		  query = em1.createQuery("FROM EmployeeEntity e WHERE e.sal > ?1",
		  EmployeeEntity.class); 
		  query.setParameter(1, 4000.0);
		  query.setHint("org.hibernate.cacheable", true); 
		  List<EmployeeEntity> lst =
		  query.getResultList(); // lst.forEach(System.out::println); em1.close();
		  
		  try { Thread.sleep(19000); } catch(Exception e) {
			  
		  }
		  
		  System.out.println(
		  "=========================================================================================="
		  );
		  
		  EntityManager em2= factory.createEntityManager(); 
		  TypedQuery<EmployeeEntity>
		  query2 = em2.createQuery("FROM EmployeeEntity e WHERE e.sal > ?1",
		  EmployeeEntity.class);
		  query2.setParameter(1, 4000.0);
		  query2.setHint("org.hibernate.cacheable", true); 
		  List<EmployeeEntity> lst2 =
		  query2.getResultList(); // lst2.forEach(System.out::println); em2.close();
		  
		 	
		factory.close();
		

	}

}
