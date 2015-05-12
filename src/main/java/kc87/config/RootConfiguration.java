package kc87.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import javax.annotation.PostConstruct;

@Configuration
//@Import({kc87.config.JettyConfiguration.class})
@ComponentScan(basePackages = {"kc87.service, kc87.repository"})
public class RootConfiguration
{

   @Autowired
   private ApplicationContext appContext;

   @PostConstruct
   public void init()
   {
      ((AbstractApplicationContext)appContext).registerShutdownHook();
   }


}
