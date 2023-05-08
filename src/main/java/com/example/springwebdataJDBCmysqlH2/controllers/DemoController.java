package com.example.springwebdataJDBCmysqlH2.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class DemoController {

    @Autowired
    @Qualifier("db1JdbcTemplate")
    JdbcTemplate db1JdbcTemplate;

    @Autowired
    @Qualifier("db2JdbcTemplate")
    JdbcTemplate db2JdbcTemplate;

    @Autowired
    @Qualifier("h2JdbcTemplate")
    JdbcTemplate h2JdbcTemplate ;

//    MovieRepository movieRepository ;

    @GetMapping("/hello")
    public String sayHello() {


//        movieRepository.saveAll(
//                            Stream.of(
//                                new Movie("Bahubali", "Mythological Thriller", "Rajamouli", 2010),
//                                new Movie("RRR", "Mythological Thriller", "Rajamouli", 2022)
//                            )
//                            .collect(Collectors.toList()));
        //System.out.println(dataSource.toString());
        String sqldb1 = "SELECT * FROM movies";
        db1JdbcTemplate.query(sqldb1, (rs, rowNum) -> {
            //int id = rs.getInt("id");
            String name = rs.getString("title");
            System.out.println( "FROM  DB1.MOVIES - title: " + name);
            return null;
        });
        h2JdbcTemplate.execute("INSERT INTO counts (name) VALUES('DB1')");

        String sqldb2 = "SELECT * FROM cinemas";
        db2JdbcTemplate.query(sqldb2, (rs, rowNum) -> {
            //int id = rs.getInt("id");
            String name = rs.getString("title");
            System.out.println( "FROM  DB2.CINEMAS - title: " + name);
            return null;
        });
        h2JdbcTemplate.execute("INSERT INTO counts (name) VALUES('DB2')");

        return "Movies Added !";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}