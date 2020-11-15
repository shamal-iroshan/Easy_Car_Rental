package lk.ijse.easy_car_rental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "lk.ijse.easy_car_rental")
public class WebAppConfig {

    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
