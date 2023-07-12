//package teste.hudson.config.tenant;
//
//import lombok.AccessLevel;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//public class TenantContext {
//    public final static String DEFAULT_TENANT = "public";
//
//    private static final ThreadLocal<String> currentTenant = InheritableThreadLocal.withInitial(() -> DEFAULT_TENANT);
//
//    public static void setCurrentTenant(String tenant) {
//        currentTenant.set(tenant);
//    }
//
//    public static String getCurrentTenant() {
//        return currentTenant.get();
//    }
//
//    public static void clear() {
//        currentTenant.remove();
//    }
//
//}
