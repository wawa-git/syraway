package com.assaasoociates.syraway.logging;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;

/**
 * @author waheb
 *
 */
public class Log4jInit {
	
	List<String> log4JFiles;
	
	public List<String> getLog4JFiles() {
		return log4JFiles;
	}

	public void setLog4JFiles(List<String> log4jFiles) {
		log4JFiles = log4jFiles;
	}

	public Log4jInit(){
		for (String file : log4JFiles) {
			PropertyConfigurator.configure(file);
			System.out.println(file);
		}
		System.out.println("test");
	}

}
