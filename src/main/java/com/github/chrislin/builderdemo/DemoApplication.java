package com.github.chrislin.builderdemo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    private PointService pointService;

    public DemoApplication(PointService pointService) {
        this.pointService = pointService;
    }

    public void shouldCreateTwoBuilders() throws Exception {
        //when
        var point1 = pointService.createZero();
        System.out.println(point1);
        var point2 = pointService.createOne();
        System.out.println(point2);
        //then
        int prototypeCounter = PointBuilder.getInstanceCounter();
        System.out.println("Actual: " + prototypeCounter);
        System.out.println("Expected: 2");
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            shouldCreateTwoBuilders();
        };
    }
}
