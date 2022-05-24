package com.enkrazh.enkrazh.repo;

import com.enkrazh.enkrazh.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory,Integer> {}
