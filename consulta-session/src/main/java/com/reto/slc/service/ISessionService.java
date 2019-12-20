package com.reto.slc.service;

import com.reto.slc.model.SessionData;

public interface ISessionService {
    public SessionData saveSession(SessionData sessionData);
    public SessionData getSession(String sessionData);
}
