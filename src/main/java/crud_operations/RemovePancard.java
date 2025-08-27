package crud_operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Pancard;
import entites.Person;

public class RemovePancard {

	//since it is delete operation ,its a DML query so we need all 3 things EMF,EM,ET
	
	public static void main(String[] args) {
		

    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_uni");
    	
    	
    	EntityManager em=emf.createEntityManager();
    	
    	EntityTransaction et=em.getTransaction();
    	
//now let say want to remove Pancard with id 102
    	
   // how to remove =>first find the Pancard by using em.find()
    	
em.find(Pancard.class, 102);//it return 102 Pancard in Pancard Object format so we hv to write in that format

	Pancard pan=em.find(Pancard.class, 102);
	
	//now,since it is associated with Person with id 2 so we can't remove directly
	/*
	 * first we have to terminate this relationship from Person class reference of Pancard
	 * How to Terminate follow this steps
	 * step1
	 * 		find the id of person 102 by em.find()
	 * NOW as u know person is pointing to object ref of pancard
	 * step2
	 * 		set the pancard id 102 is 'null' means its not pointing to anyone
	 * 
	 * this changes done here only means in java only to do in database also we hv to update by 
	 * using ' em.merge() '
	 * step3
	 * 		update the record in b/w et.begin & et.commit by using em.merge()
	 * 
	 * step4
	 * 		now since the Pancard id 2 is not pointing to anyone so we can remove easily
	 * 		remove by 
	 * 		
	 * 		
    	
    	
    	*/
	//step 1
	em.find(Person.class, 2);//it will return in Person object format so we hv to write in that format
	
	Person p=em.find(Person.class, 2);//it will returning person 2
	
	//step 2
	p.setPancard(null);
	
		
			et.begin();
			
			em.merge(p);//here we r updating due to this updated in Database also
			
			em.remove(pan);
			
			et.commit();
			
			//now if we want to remove person with id 1 so we can remove easily  beacuse 
			//it is Person class does not hv any refrence varibale of Pancard and also
			// person is not associated to any one
			
			//directly find and remove
			
			//removing person with id 1
			em.find(Person.class, 1);//it return in PersonClass object format so we hv to write in that format
			
			Person p2=em.find(Person.class, 1);
			
			et.begin();
			
			em.remove(p2);
			
			et.commit();
			
			
	
	}
	
}
