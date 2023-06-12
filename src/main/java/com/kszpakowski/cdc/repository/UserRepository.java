package com.kszpakowski.cdc.repository;

import com.kszpakowski.cdc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface UserRepository extends JpaRepository<User, Long>, RevisionRepository<User, Long, Long> {
}
