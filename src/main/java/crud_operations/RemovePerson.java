package crud_operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entites.Person;

public class RemovePerson {

	public static void main(String[] args) {
		

    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_uni");
    	
    	
    	EntityManager em=emf.createEntityManager();
    	
    	EntityTransaction et=em.getTransaction();
    	
    	
    	//now if we want to remove person with id 1 so we can remove easily  because 
		//it is Person class does not hv any refrence varibale of Pancard and also
		// person is not associated to any one
		
		//directly find and remove
		
		//removing person with id 1
		em.find(Person.class, 1);//it return in PersonClass object format so we hv to write in that format
		
		Person p=em.find(Person.class, 1);
		
		et.begin();
		
		em.remove(p);
		
		et.commit();//commit k baad run kiya toh em.close() hojata hai ,phier wapas run kiya toh error dega
	}
}
