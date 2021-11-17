package za.ac.nwu.ac.sh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.logic.config.LogicConfig;

import java.util.Arrays;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.sh.controllers"
})
public class WebConfig {


}
