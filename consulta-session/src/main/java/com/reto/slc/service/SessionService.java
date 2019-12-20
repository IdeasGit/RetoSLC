package com.reto.slc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.slc.model.SessionData;
import com.reto.slc.repository.ISessionRepository;

@Service
public class SessionService implements ISessionService {
	
	@Autowired
	private ISessionRepository sessionRepository;

    public SessionData saveSession(SessionData sessionData) {
	        return this.sessionRepository.save(sessionData);
    }

    public SessionData getSession(String sessionId) {
        return this.sessionRepository.getOne(sessionId);
    }
}
