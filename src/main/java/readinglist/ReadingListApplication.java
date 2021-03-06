package readinglist;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ReadingListApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/readingList");
		registry.addViewController("/login").setViewName("login");
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new ReaderHandlerMethodArgumentResolver());
	}

	@Bean
	public HttpTraceRepository htttpTraceRepository() {
		return new InMemoryHttpTraceRepository();
	}

}
