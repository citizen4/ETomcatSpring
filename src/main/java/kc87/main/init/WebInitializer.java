package kc87.main.init;


import kc87.config.MvcConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer
{

   @Override
   public void onStartup(ServletContext container)
   {
      ServletRegistration.Dynamic registration =
        container.addServlet("dispatcher", new DispatcherServlet(createContext(MvcConfiguration.class)));
      registration.setLoadOnStartup(1);
      registration.addMapping("/");
    }

   private static AnnotationConfigWebApplicationContext createContext(final Class<?>... annotatedClasses)
   {
      AnnotationConfigWebApplicationContext context;
      context = new AnnotationConfigWebApplicationContext();
      context.register(annotatedClasses);
      context.registerShutdownHook();
      return context;
   }
}
