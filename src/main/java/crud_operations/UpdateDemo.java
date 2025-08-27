package crud_operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Pancard;
import entites.Person;

public class UpdateDemo {

	public static void main(String[] args) {

    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_uni");
    	
    	
    	EntityManager em=emf.createEntityManager();
    	
    	EntityTransaction et=em.getTransaction();
    	
    	
    	//let say as we remove pancard id 2 in RemovePancard class
    	
    	//now i want to person with id 2 is associate with pancard
    	//now again i want to associate with pancard again
		
    	
    	/*step 1
    	 * 		create new pancard because we r removed
    	 * step 2
    	 * 		now associate with pancard with person id 2
    	 * step 3
    	 * 		find the person first
    	 * step 4
    	 * 		set the pancard associate with 2 by using p.setpancard(),since we hv getter&setter methods in both class
    	 * step 5
    	 * 		as u create new object of pancard so first persist in b/w et.begin()&et.comit()
    	 * et.commit();after if we run again write any query so it gives error because after et.commit(),connection
    	 * is cloased
    	 * 
    	 * step 6
    	 * 		now update the person by using em.merge()
    	 */
    	
    	Pancard pan=new Pancard(103, "Mumbai");
    	
    	em.find(Person.class, 2);//it return in Person object so write in that format
    	
    	Person p=em.find(Person.class, 2);
    	
    	p.setPancard(pan);
    	
    	et.begin();
    	
    	em.persist(pan);
    	
    	em.merge(p);
    	
    	et.commit();//after commit connection is closed if we try run again new code it gives error
	}
}
