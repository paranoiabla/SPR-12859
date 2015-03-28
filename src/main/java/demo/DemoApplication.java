package demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Bean
    public CustomConverter defaultCustomConverter() {
        return new CustomConverter();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Collection<String> source = Arrays.asList("12");
        ConfigurableConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(defaultCustomConverter());

        Object target = conversionService.convert(source, TypeDescriptor.forObject(source),
                                                  TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Integer.class)));
        System.out.println("!!!!!!!!!!!!");
        System.out.println(target);
        System.out.println("!!!!!!!!!!!!");

    }
}
