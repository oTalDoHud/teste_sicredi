//package teste.hudson.config.tenant;
//
//import org.hibernate.cfg.AvailableSettings;
//import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
//import org.jboss.logging.Logger;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//import java.util.Optional;
//
//@Component
//public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver, HibernatePropertiesCustomizer {
//
//    private static final Logger LOG = Logger.getLogger(TenantIdentifierResolver.class);
//
//
//    @Override
//    public String resolveCurrentTenantIdentifier() {
//        LOG.info("TenantIdentifierResolver - " + TenantContext.getCurrentTenant());
//        return Optional.ofNullable(TenantContext.getCurrentTenant()).orElse(TenantContext.DEFAULT_TENANT);
//    }
//
//    public void setCurrentTenant(String tenant) {
//        TenantContext.setCurrentTenant(tenant);
//        resolveCurrentTenantIdentifier();
//    }
//
//    @Override
//    public boolean validateExistingCurrentSessions() {
//        return true;
//    }
//
//    @Override
//    public void customize(Map<String, Object> hibernateProperties) {
//        hibernateProperties.put(AvailableSettings.MULTI_TENANT_IDENTIFIER_RESOLVER, this);
//    }
//}
