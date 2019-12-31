package com.reto.slc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reto.slc.model.SessionData;
import com.reto.slc.service.ISessionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = SessionController.class)
public class SessionControllerTest {

    @MockBean
    private ISessionService sessionService;

    private ObjectMapper mapper = new ObjectMapper();

    private SessionData sessionData;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        sessionData = new SessionData();
        sessionData.setChannel("SVP");
        sessionData.setSessionStatus("ACTIVE");
        sessionData.setSessionTracker("1234");
    }

    @Test
    public void getSession() throws Exception {
        when(sessionService.getSession(anyString())).thenReturn(sessionData);
        mockMvc.perform(get("/getSession/1234"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sessionTracker").value(sessionData.getSessionTracker()))
                .andExpect(jsonPath("$.channel").value(sessionData.getChannel()))
                .andExpect(jsonPath("$.sessionStatus").value(sessionData.getSessionStatus()));
    }

    @Test
    public void saveSession() throws Exception {
        when(sessionService.saveSession(any(SessionData.class))).thenReturn(sessionData);
        mockMvc.perform(post("/saveSession")
                .content(mapper.writeValueAsString(sessionData))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sessionTracker").value(sessionData.getSessionTracker()))
                .andExpect(jsonPath("$.channel").value(sessionData.getChannel()))
                .andExpect(jsonPath("$.sessionStatus").value(sessionData.getSessionStatus()));
    }
}