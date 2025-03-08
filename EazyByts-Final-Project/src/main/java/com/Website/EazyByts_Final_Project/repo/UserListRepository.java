package com.Website.EazyByts_Final_Project.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Website.EazyByts_Final_Project.model.User;
import com.Website.EazyByts_Final_Project.model.UserList;

public interface UserListRepository extends JpaRepository<UserList, Long> {

	List<UserList> findListByUser(User user,Sort sort);
}
