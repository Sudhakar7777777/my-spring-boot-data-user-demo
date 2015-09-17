package org.sbk.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoUserApp2Application implements CommandLineRunner{

	@Autowired
	private  UserProfileRepository repository;
	
    public static void main(String[] args) {
        SpringApplication.run(DemoUserApp2Application.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		
		repository.deleteAll();
	    System.out.println("Collection deleted");

	    repository.save(new UserProfile("john","smith","john@smith.com","10 main street","Cupertino","California","95082","09/13/15","09/13/15"));
	    repository.save(new UserProfile("sudhakar","balakrishnan","sudhakar@balakrishnan.com","11 main street","San Jose","California","95131","09/01/15","09/01/15"));
	    repository.save(new UserProfile("ryan","dickson","ryan@dickson.com","100 main street","San Deigo","California","92069","09/11/15","09/13/15"));
	    repository.save(new UserProfile("richard","lee","richard@lee.com","20 main street","San Francisco","California","93104","09/12/15","09/15/15"));
	    repository.save(new UserProfile("tom","cruise","tom@cruise.com","80 main street","New York","New York","08329","09/12/15","09/14/15"));
	    	
	    System.out.println("Users found with findAll():");
	    System.out.println("-------------------------------");
	    for ( UserProfile user : repository.findAll()) {
	      System.out.println(user);
	    }
	    System.out.println();

	  
	    System.out.println("User found with findByLastName('cruise'):");
	    System.out.println("--------------------------------");
	    UserProfile user1 = repository.findByLastName("cruise");
	    user1.setEmail("tom@crush.com");
	    // Update UserProfile
	    repository.save(user1);
	    
	    System.out.println("Find & Delete user... findByLastName('lee'):");
	    user1 = repository.findByLastName("lee");
	    System.out.println(user1);
	    
	    // Delete UserProfile
	    repository.delete(user1);
	    
	    System.out.println("User found with findByState('California'):");
	    System.out.println("--------------------------------");
	    for ( UserProfile user : repository.findByState("California")) {
	      System.out.println(user);
	    }
		
	}
}
