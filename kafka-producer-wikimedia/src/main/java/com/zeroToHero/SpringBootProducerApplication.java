package com.zeroToHero;


import com.zeroToHero.kafka.WikimedieChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProducerApplication  implements CommandLineRunner {

    @Autowired
    private WikimedieChangesProducer wikimedieChangesProducer;



    public static void main(String[] args) {
        SpringApplication.run(SpringBootProducerApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        wikimedieChangesProducer.sendMessage();
    }
}
