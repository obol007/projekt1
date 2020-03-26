package pl.obol007.projekt1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing (jezeli uzywamy klasy abstrakcyjnej
public class Projekt1Application {

	public static void main(String[] args) {
		SpringApplication.run(Projekt1Application.class, args);
	}

}
