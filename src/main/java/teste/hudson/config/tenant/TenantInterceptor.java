//package teste.hudson.config.tenant;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import java.util.Optional;
//
//@Component
//public class TenantInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    TenantService tenantService;
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
//        Optional.ofNullable(req.getHeader("X-TenantID"))
////                .map(String::toUpperCase)
//                .ifPresent(TenantContext::setCurrentTenant);
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        TenantContext.clear();
//    }
//
//}
