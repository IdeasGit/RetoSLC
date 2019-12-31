package com.reto.slc.controller;

import com.reto.slc.exception.SessionNotFoundException;
import com.reto.slc.model.SessionData;
import com.reto.slc.service.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SessionController {

    @Autowired
    private ISessionService sessionService;

	@GetMapping("/getSession/{session}")
    @Nullable
	public ResponseEntity getSession(@PathVariable String session) throws Exception {
	    if ("123".equals(session) || session.isEmpty() ){
	        throw new SessionNotFoundException("session:" + session);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded","SessionController");
        return ResponseEntity.ok().headers(headers).body(sessionService.getSession(session));
	}

	@PostMapping("/saveSession")
    public ResponseEntity saveSession(@RequestBody SessionData sessionData){
	    HttpHeaders headers = new HttpHeaders();
        headers.add("Responded","SessionController");
        return ResponseEntity.ok().headers(headers).body(sessionService.saveSession(sessionData));
    }
}
