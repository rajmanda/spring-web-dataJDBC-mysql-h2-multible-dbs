package com.example.springwebdataJDBCmysqlH2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringWebDataJdbcMysqlH2Application implements CommandLineRunner {

	@Autowired
	JdbcTemplate h2JdbcTemplate ;

	public static void main(String[] args) {
		SpringApplication.run(SpringWebDataJdbcMysqlH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String dropTableSQL = "DROP TABLE counts ";
		h2JdbcTemplate.execute(dropTableSQL);

		String createTableSQL = "CREATE TABLE counts ("
				+ "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(255) NOT NULL"
				+ ")";
		h2JdbcTemplate.execute(createTableSQL);
	}
}
