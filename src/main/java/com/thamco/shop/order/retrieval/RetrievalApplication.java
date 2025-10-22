package com.thamco.shop.order.retrieval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class RetrievalApplication {

	public static final Logger logger = Logger.getLogger(RetrievalApplication.class.getName());
	public static void main(String[] args)
	{
		SpringApplication.run(RetrievalApplication.class, args);
	}

}
