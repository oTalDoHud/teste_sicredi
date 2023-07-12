package teste.hudson.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import teste.hudson.service.DBservice;
import teste.hudson.utils.StringUtils;

@Configuration
public class DevConfig {

    @Autowired
    private DBservice dBservice;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    @Bean
    public void instanciandoBancoDeDados() {
        if (isDevProfile()) {
            dBservice.instanciandoBancoDeDados();
        }
    }

    private boolean isDevProfile() {
        return !StringUtils.isNullOrEmpty(activeProfile) && activeProfile.equalsIgnoreCase("dev");
    }
}
