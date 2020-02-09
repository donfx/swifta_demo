package com.swifta.felix.demo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.swifta.felix.demo.User;

@Transactional
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
 
	@Query(value="SELECT * FROM User WHERE firstname LIKE CONCAT('%',:criteria, '%')"
			+ " OR lastname LIKE CONCAT('%',:criteria, '%') "
			+ " OR email LIKE CONCAT('%',:criteria, '%') "
			+ " OR phone LIKE CONCAT('%',:criteria, '%') "
			+ " OR gender LIKE CONCAT('%',:criteria, '%') "
			+ " OR nationality LIKE CONCAT('%',:criteria, '%') "
			+ " OR role LIKE CONCAT('%',:criteria, '%') "
			
			,
            nativeQuery = true)
	 public List<User> getAllUsersBySearchCriteria(@Param("criteria")String search);
	
	
	@Modifying
	@Query(value="DELETE FROM User WHERE id IN (:criteria)", nativeQuery = true	)
	 public int deleteUsers(@Param("criteria")List<Integer> items);
	
	
 User findByEmail(String email);
 User findByFirstname(String firstname);
 
}