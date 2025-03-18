package com.example.LabAssignment01Noulis;

import com.example.LabAssignment01Noulis.models.Data;
import com.example.LabAssignment01Noulis.repositories.DataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabAssignment01NoulisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabAssignment01NoulisApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(DataRepository repository) {
		return (args) -> {
			// Create sample items
			Data item1 = new Data();
			item1.setProductName("Mini rocket");
			item1.setQt(10);

			Data item2 = new Data();
			item2.setProductName("Mega rocket");
			item2.setQt(20);

			// Save them to the database
			repository.save(item1);
			repository.save(item2);

			System.out.println("Sample data inserted at startup.");
		};

}
}
