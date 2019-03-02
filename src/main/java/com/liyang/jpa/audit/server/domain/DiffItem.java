package com.liyang.jpa.audit.server.domain;

public class DiffItem {
	private Type type;
	private Object oldValue;
	private Object newValue;

	public Object getOldValue() {
		return oldValue;
	}
	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}
	public Object getNewValue() {
		return newValue;
	}
	public void setNewValue(Object newValue) {
		this.newValue = newValue;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public enum Type{
		SIMPLE,OBJECT,ARRAY
	}
}
