package org.javahotfix.oom.config;

import java.util.ArrayList;
import java.util.List;

public class SomeSingletonInstance {

	private static SomeSingletonInstance instance;
	public static SomeSingletonInstance getInstance() {
		if(instance == null) {
			synchronized (SomeSingletonInstance.class) {
				if(instance == null) {
					instance = new SomeSingletonInstance();
				}
			}
		}
		return instance;
	}
	
	private List<Object> objectList = new ArrayList<Object>();
	
	public void addObjectToList(Object obj) {
		objectList.add(obj);
	}
		
	public void clearList() {
		objectList.clear();
	}
	
	public int getCount() {
		return objectList.size();
	}
}
