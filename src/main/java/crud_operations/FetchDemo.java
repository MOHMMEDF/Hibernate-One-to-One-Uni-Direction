package crud_operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entites.Pancard;
import entites.Person;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("one_to_one_uni");
    	
    	
    	EntityManager em=emf.createEntityManager();
    	
    	
    	//Now let say if we want to fetch Person record with id 1,fetch by using em.find()
    	
    	em.find(Person.class, 1);//it will return in Person obj because we r specified in find()method,so write in..
    	
    	Person p=em.find(Person.class, 1);//so we have to write in Person Object format
    	
    	//now if we want to find Pancard so as we created Pancard refrence variable in PersonClass
    	
    	// so we can fetch Pancard by using Person also ,from Person table fetch record Pancard also one-to-one-uni
    	
    	
    	p.getPancard();//it will return in Pancard object so we have to write in that format
    	
    	Pancard pan=p.getPancard();//p.get() method get because in PancardClass we created getter&setter methods
    	
    	System.out.println(p);
    	
    	System.out.println(pan);
		
	}

}
