package ru.geekbrains.marketautumn;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.geekbrains.marketautumn.dto.Product;
import ru.geekbrains.marketautumn.dto.ProductDao;

import javax.security.auth.login.Configuration;

@SpringBootApplication
public class MarketAutumnApplication {

	public static void main(String[] args) {
		SessionFactoryUtis sessionFactoryUtis = new SessionFactoryUtis();
		sessionFactoryUtis.init();

		try{
			ProductDao productDao = new ProductDao(sessionFactoryUtis);
			System.out.println(productDao.findAll());
			productDao.deleteByID(2l);
			System.out.println(productDao.findAll());
			Product product = new Product("Mushroom", 28F);
			productDao.save(product);
			System.out.println(productDao.findAll());


		}catch (Exception e){
			e.printStackTrace();
		}finally {
			sessionFactoryUtis.shutdown();
		}

		//SpringApplication.run(MarketAutumnApplication.class, args);
	}

}
