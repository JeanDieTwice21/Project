package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	public static final int SIZE_ARRAY = 10;
	private Project[] projects;
	private String[] namesAfterDate;
	private String[] namesBeforeDate;

	public Controller() {

		projects = new Project[SIZE_ARRAY];
		namesAfterDate = new String[10];
		namesBeforeDate = new String[10];
	}
	
	public boolean registerProject(String name, String clientName, Calendar initialDate, Calendar finalDate, double budget) {

		Project project = new Project(name, clientName, initialDate, finalDate, budget);
		int pos = getFirstValidPosition();
		if(pos != -1){
			projects[pos] = project;
			return true;
		}
		else{
			return false;
		}
	}

 	public String searchProjectsAfterDate(Calendar dateToCompare) {

		String msg = " ";

		for(int i = 0; i < SIZE_ARRAY; i ++){
			
			if(projects[i] != null){
				if(projects[i].getFinalDate().after(dateToCompare)){
					int pos = getFirstValidPositionForNames();
					if(pos != -1){
						namesAfterDate[pos] = projects[i].getName(); 
					}
				}
		}	
	}
		for(int o = 0; o < 10; o++){

			if(namesAfterDate[o] != null){
				msg += namesAfterDate[o];
				if(o < 10 - 1){
					msg += ", ";
				}
			}
		}

		return msg;
	}
	
	public String searchProjectsBeforeDate(Calendar dateToCompare) {

		String msg = " ";

		for(int i = 0; i < SIZE_ARRAY; i ++){
			
			if(projects[i] != null){
				if(projects[i].getInitialDate().before(dateToCompare)){
					int pos = getFirstValidPositionForNamesTwo();
					if(pos != -1){
						namesBeforeDate[pos] = projects[i].getName(); 
					}
				}
		}	
	}
		for(int o = 0; o < 10; o++){

			if(namesBeforeDate[o] != null){
				msg += namesBeforeDate[o];
				if(o < 10 - 1){
					msg += ", ";
				}
			}
		}

		return msg;
	

	}

	public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < SIZE_ARRAY && !isFound; i++){
			if(projects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}

		public int getFirstValidPositionForNames(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < 10 && !isFound; i++){
			if(namesAfterDate[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}

		public int getFirstValidPositionForNamesTwo(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < 10 && !isFound; i++){
			if(namesBeforeDate[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}
}
