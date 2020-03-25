package pl.obol007.projekt1;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//klasa do deployowania aplikacji na Tomcata, jezeli sa takie wymagania
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Projekt1Application.class);
	}

}
