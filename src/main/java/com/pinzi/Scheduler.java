package com.pinzi;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	@Autowired
	private AppProperties prop;
	
	
	@Scheduled(fixedRateString = "${app.scheduled-rate-in-ms}")
	public void loop() {
		System.out.println("Loop");
		
		if(isIpaPresent()) {
			instrumentApp();
		}
	}

	private void instrumentApp() {
		Process p;
        try {
        	String s;
            p = Runtime.getRuntime().exec("ls -aF");
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
                System.out.println("line: " + s);
            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {
        	throw new RuntimeException();
        }
		
	}

	private boolean isIpaPresent() {
		File f = new File(prop.getIpaSourcePath());
		if(f.exists() && !f.isDirectory()) { 
		    return true;
		}
		return false;
	}

}
