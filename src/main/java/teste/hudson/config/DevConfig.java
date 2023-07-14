package teste.hudson.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import teste.hudson.service.DBservice;
import teste.hudson.utils.StringUtils;

@Configuration
public class DevConfig {

    private final DBservice dBservice;

    public DevConfig(DBservice dBservice) {
        this.dBservice = dBservice;
    }

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
