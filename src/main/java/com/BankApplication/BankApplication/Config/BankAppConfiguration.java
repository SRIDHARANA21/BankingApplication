package com.BankApplication.BankApplication.Config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class BankAppConfiguration {
 @Bean
 public OpenAPI swaggerDocOpenApi()
 {
Server developmentserver=new Server();
developmentserver.setUrl("http://localhost:8080");
developmentserver.setDescription("This is for devlopment");

Server productserver=new Server();
productserver.setUrl("http://localhost:8080");
productserver.setDescription("This is for production");

Contact contact=new Contact();
contact.setName("Banking Application");
contact.setEmail("help.bank.in");
contact.setUrl("https://mvnrespoitory");


License license=new License();
license.setName("2 years license");
license.setUrl("write licence provider's url");

Info info=new Info();
info.title("Global Bank");
info.version("1.0");
info.contact(contact);
info.description("Designed for banking");
info.termsOfService("pass url");
info.license(license);
 
 OpenAPI openapi=new OpenAPI();
 openapi.info(info);
 openapi.servers(Arrays.asList(developmentserver,productserver));
 
 return openapi;
 }
}
