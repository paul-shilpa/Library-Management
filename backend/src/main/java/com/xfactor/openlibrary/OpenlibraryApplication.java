package com.xfactor.openlibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.xfactor.openlibrary.domain.Book;
import com.xfactor.openlibrary.repositories.BookRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
@OpenAPIDefinition
public class OpenlibraryApplication implements CommandLineRunner{
	private static final Logger log = LoggerFactory.getLogger(OpenlibraryApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(OpenlibraryApplication.class);

		Environment env = app.run(args).getEnvironment();
		logApplicationStartup(env);
	}

	private static void logApplicationStartup(Environment env) {

		String serverPort = env.getProperty("server.port");
		String contextPath = env.getProperty("server.servlet.context-path");
		contextPath = "/";
		String protocol = "http";
		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info("\n----------------------------------------------------------\n\t" +
				"Application is running! Access URLs:\n\t" +
				"Local: \t\t{}://localhost:{}{}\n\t" +
				"External: \t{}://{}:{}{}\n\t" +
				"\n----------------------------------------------------------",
				protocol,
				serverPort,
				contextPath,
				protocol,
				hostAddress,
				serverPort,
				contextPath);
	}
	private BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
//		
//
		try{
			Book b=new Book();
			b.setAuthor("abd");
			b.setCategory("xyz");
			b.setCopies(1);
			b.setIsbn("qqqq1");
			bookRepository.save(b);
		}catch (Exception e) {
		    e.printStackTrace();
		}
	}

}
