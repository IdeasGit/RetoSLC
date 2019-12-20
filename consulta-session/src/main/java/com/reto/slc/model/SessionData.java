package com.reto.slc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "SESSION")
public class SessionData implements Serializable {

	private static final long serialVersionUID = 7861371462843205852L;

    @Id
    @Column(name = "SESSIONTRACKER")
	private String sessionTracker;
    @Column(name = "TRANSACTIONTRACKER")
    private String transactionTracker;
    @Column(name = "CHANNEL")
    private String channel;
    @Column(name = "SESSIONSTATUS")
	private String sessionStatus;

	
	public String getTransactionTracker() {
		return transactionTracker;
	}
	public void setTransactionTracker(String transactionTracker) {
		this.transactionTracker = transactionTracker;
	}
	public String getSessionTracker() {
		return sessionTracker;
	}
	public void setSessionTracker(String sessionTracker) {
		this.sessionTracker = sessionTracker;
	}

	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSessionStatus() {
		return sessionStatus;
	}
	public void setSessionStatus(String sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

}
