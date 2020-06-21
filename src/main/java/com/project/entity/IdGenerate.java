package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdGenerate 
{
	@Id
	int eid=0;
	int pid=0;
	public int getEid() {
		return eid;
	}
	public int getPid() {
		return pid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
