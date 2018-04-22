package com.pinzi;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "app")
public class AppProperties {
	
	
	@Getter @Setter private String scheduledRateInMs;
	@Getter @Setter private String ipa;
	@Getter @Setter private String ipaDestinationFolder;
	@Getter @Setter private String scriptFolder;
	

}
