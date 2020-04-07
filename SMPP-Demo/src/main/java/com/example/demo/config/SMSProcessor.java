package com.example.demo.config;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.component.smpp.SmppMessage;
import org.springframework.stereotype.Component;

@Component
public class SMSProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Message m = exchange.getIn();
		System.out.println(m.getBody());
		System.out.println(m.getHeaders());
	}
}
