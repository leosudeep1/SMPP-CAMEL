package com.example.demo.config;

import org.apache.camel.builder.RouteBuilder;
import org.jsmpp.extra.ProcessRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SMPPConfig extends RouteBuilder {

	@Autowired
	private SMSProcessor sms;
	
	@Override
	public void configure() throws Exception {
		from("smpp://307188@smscsim.melroselabs.com:2775?password=OEQIDI&enquireLinkTimer=3000&transactionTimer=5000&systemType=consumer")
		  .doTry()
		    //.to("bean:dao?method=updateSmsState")
		  	.log("sms is : ${body}")
		  	.log("---------------")
		  	.process(sms)
		  .doCatch(Exception.class)
		    .throwException(new ProcessRequestException("update of sms state failed", 100))
		  .end();
		
	}
}
