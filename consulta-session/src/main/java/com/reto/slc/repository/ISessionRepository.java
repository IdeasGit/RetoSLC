package com.reto.slc.repository;

import com.reto.slc.model.SessionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISessionRepository extends JpaRepository<SessionData,String> {

}
