package com.reto.slc.service;

import com.reto.slc.model.SessionData;
import com.reto.slc.repository.ISessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SessionServiceTest {

    @Mock
    private ISessionRepository iSessionRepository;

    @InjectMocks
    private SessionService sessionService;

    private SessionData sessionData;

    @Before
    public void setUp(){
        sessionData = new SessionData();
        sessionData.setChannel("SVP");
        sessionData.setSessionStatus("ACTIVE");
        sessionData.setSessionTracker("1234");
    }

    @Test
    public void getSessionService() {
        when(iSessionRepository.getOne(sessionData.getSessionTracker())).thenReturn(sessionData);
        SessionData request = sessionService.getSession(sessionData.getSessionTracker());
        assertThat(request).isSameAs(sessionData);
    }

    @Test
    public void saveSessionService() {
        when(iSessionRepository.save(any(SessionData.class))).thenReturn(sessionData);
        SessionData request = sessionService.saveSession(sessionData);
        assertThat(request).isSameAs(sessionData);
    }
}