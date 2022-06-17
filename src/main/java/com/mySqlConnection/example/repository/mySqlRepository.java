package com.mySqlConnection.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mySqlConnection.example.entity.Contacts;


@Repository
public interface mySqlRepository extends JpaRepository<Contacts, Integer>{
	
	
	@Transactional
	@Modifying
	@Query(value = "update contacts c set c.firstname=:name where c.id=:id", nativeQuery = true)
	public int updateContactName(@Param("id") Integer id, @Param("name") String name);
   
	@Transactional
	@Modifying
	@Query(value="delete from contacts where id=:id", nativeQuery=true)
	public int deleteRecordById(@Param("id") Integer id);

	

	

}
