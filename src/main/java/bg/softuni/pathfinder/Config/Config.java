package bg.softuni.pathfinder.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    /**
     * ModelMapper Config
     */

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
