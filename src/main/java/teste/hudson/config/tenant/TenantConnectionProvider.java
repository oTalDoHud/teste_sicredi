//package teste.hudson.config.tenant;
//
//import br.com.celk.service.TenantService;
//import org.hibernate.HibernateException;
//import org.hibernate.cfg.AvailableSettings;
//import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
//import org.jboss.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Map;
//
//@Component
//public class TenantConnectionProvider implements MultiTenantConnectionProvider, HibernatePropertiesCustomizer {
//    private static final Logger LOG = Logger.getLogger(TenantConnectionProvider.class);
//
//    @Autowired
//    private DataSource datasource;
//    @Autowired
//    private TenantService tenantService;
//
//    @Override
//    public Connection getAnyConnection() throws SQLException {
//        return datasource.getConnection();
//    }
//
//    @Override
//    public void releaseAnyConnection(Connection connection) throws SQLException {
//        connection.close();
//    }
//
//    @Override
//    public Connection getConnection(String tenantIdentifier) throws HibernateException, SQLException {
//        final Connection connection = getAnyConnection();
//        try {
//            tenantIdentifier = TenantContext.getCurrentTenant();
//
//            if (!TenantContext.DEFAULT_TENANT.equalsIgnoreCase(TenantContext.getCurrentTenant())) {
//                tenantService.initDatabase(tenantIdentifier);
//            }
//
//            connection.setSchema(tenantIdentifier);
//
//            LOG.info("Connect: - " + tenantIdentifier);
//
//        } catch (HibernateException e) {
//            throw new HibernateException("Não foi possivel alterar para o schema [" + tenantIdentifier + "]", e);
//        }
//
//        return connection;
//    }
//
//    @Override
//    public void releaseConnection(String tenantIdentifier, Connection connection) {
//        try (connection) {
//            connection.createStatement().execute("SET SCHEMA '".concat(TenantContext.DEFAULT_TENANT).concat("'"));
//        } catch (SQLException e) {
//            throw new HibernateException("Não foi se conectar ao schema padrão", e);
//        }
//    }
//
//    @Override
//    public boolean supportsAggressiveRelease() {
//        return false;
//    }
//
//    @Override
//    public boolean isUnwrappableAs(Class unwrapType) {
//        return false;
//    }
//
//    @Override
//    public <T> T unwrap(Class<T> unwrapType) {
//        return null;
//    }
//
//    @Override
//    public void customize(Map<String, Object> hibernateProperties) {
//        hibernateProperties.put(AvailableSettings.MULTI_TENANT_CONNECTION_PROVIDER, this);
//    }
//}
