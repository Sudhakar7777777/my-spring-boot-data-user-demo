package org.sbk.demo.user;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

  public UserProfile findByLastName(@Param("lastName") String lastName);
  public List<UserProfile> findByCity(@Param("city") String city);
  public List<UserProfile> findByState(@Param("state") String state);

}