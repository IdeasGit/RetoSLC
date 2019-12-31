package com.reto.slc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SESSION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Setter
@Getter
public class SessionData implements Serializable {

	private static final long serialVersionUID = 7861371462843205852L;

    @Id
    @Column(name = "SESSIONTRACKER")
	private String sessionTracker;
    @Column(name = "CHANNEL")
    private String channel;
    @Column(name = "SESSIONSTATUS")
	private String sessionStatus;
}
