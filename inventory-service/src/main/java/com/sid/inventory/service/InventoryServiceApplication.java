package com.sid.inventory.service;

import com.sid.inventory.service.entities.Product;
import com.sid.inventory.service.rep.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration)
	{
		repositoryRestConfiguration.exposeIdsFor(Product.class);
		return args ->
		{
			productRepository.save(new Product(null,"Ordinateur",2990,12));
			productRepository.save(new Product(null,"Telephone",2990,12));
			productRepository.save(new Product(null,"Tablet",2990,12));
			productRepository.save(new Product(null,"Imprimante",2990,12));
			productRepository.findAll().forEach( p -> {
				System.out.println(p.toString());
			});

		};
	}

}
