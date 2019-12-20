package com.reto.slc.controller;

import com.reto.slc.model.SessionData;
import com.reto.slc.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SessionController {

    @Autowired
    private ISessionService sessionService;

	@PostMapping("/getSession")
	public SessionData getSession(@RequestBody SessionData session) {
		System.out.println(session.getTransactionTracker());
		System.out.println(session.getSessionTracker());
		System.out.println(session.getChannel());


        return sessionService.getSession(session.getSessionTracker());
	}

	@PostMapping("/saveSession")
    public SessionData saveSession(@RequestBody SessionData sessionData){
	    return sessionService.saveSession(sessionData);
    }


}
