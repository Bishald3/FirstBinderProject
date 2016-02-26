package com.binder.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.binder.app.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
	
	public UserInfo findById(Long id);
	@Query("SELECT u.id FROM UserInfo u WHERE u.id = :id")
	public Long getDiagramIdForProcessId(@Param("id")  Long id);

}
