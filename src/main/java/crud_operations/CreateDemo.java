package crud_operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Pancard;
import entites.Person;

public class CreateDemo {

            public static void main(String[] args) {
				
           //Now we have to insert since it is DML operation we need all 3 things EMF,EM,ET
            	
            	EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_uni");
            	
            	
            	EntityManager em=emf.createEntityManager();
            	
            	EntityTransaction et=em.getTransaction();
            	
            	System.out.println(emf);
            	
            	//now we have to insert in Pancard class  record insert as u want by creating object
            	
            	Pancard pan1=new Pancard(101, "Pune");
            	Pancard pan2=new Pancard(102, "Banglore");
            	
            	
            	
            	//Now inserting record in Person class insert as u want by creating object
            	
            	Person p1=new Person(1, "Pinku",pan1);
            	Person p2=new Person(2, "Tinku", pan2);
            	
            	
            	//now both PersonClass & PancardClass inserting new record so we have to persist
            	
            	et.begin();
            	
            	em.persist(pan1);
            	em.persist(pan2);
            	
            	
            	em.persist(p1);
            	em.persist(p2);
            	
            	
            	et.commit();
            	
            	
            	
            	
			}
	
}
