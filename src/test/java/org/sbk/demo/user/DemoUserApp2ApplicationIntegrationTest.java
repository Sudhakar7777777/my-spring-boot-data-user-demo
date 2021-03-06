package org.sbk.demo.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoUserApp2Application.class)
@WebIntegrationTest
public class DemoUserApp2ApplicationIntegrationTest {

  //Required to delete the data added for tests.
  //Directly invoke the APIs interacting with the DB
  @Autowired
  private UserProfileRepository userProfileRepository;
  
  @Test
  public void testGetUserProfileDetailsApi(){
    //Create a new book using the BookRepository API
    UserProfile user = new UserProfile("john","smith","john@smith.com","10 main street","Cupertino","California","95082","09/13/15","09/13/15");
    userProfileRepository.save(user);

    String userId = user.getId();

    //Now make a call to the API to get details of the book
    RestTemplate restTemplate = new TestRestTemplate();
    UserProfile apiResponse = restTemplate.getForObject("http://localhost:8080/user/"+ userId, UserProfile.class);

    //Verify that the data from the API and data saved in the DB are same
    assertNotNull(apiResponse);
    //assertEquals(user.getId(), apiResponse.getId());
    assertEquals(user.getFirstName(), apiResponse.getFirstName());
    assertEquals(user.getLastName(), apiResponse.getLastName());
    assertEquals(user.getEmail(), apiResponse.getEmail());
    assertEquals(user.getAddress(), apiResponse.getAddress());
    assertEquals(user.getCity(), apiResponse.getCity());
    assertEquals(user.getState(), apiResponse.getState());
    assertEquals(user.getPostal_code(), apiResponse.getPostal_code());
    assertEquals(user.getCreate_time(), apiResponse.getCreate_time());
    assertEquals(user.getUpdate_time(), apiResponse.getUpdate_time());
    
    //Delete the Test data created
    userProfileRepository.delete(userId);
  }

}