package kc87.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"kc87.web"})
public class MvcConfiguration extends WebMvcConfigurerAdapter
{
   private static final Logger LOG = LoggerFactory.getLogger(MvcConfiguration.class);


   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
   {
      configurer.enable();
   }

   @Bean
   public ResourceBundleMessageSource messageSource()
   {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("locale/messages");
      source.setUseCodeAsDefaultMessage(true);
      return source;
   }

   @Bean
   public ServletContextTemplateResolver thymeleafTemplateResolver()
   {
      ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
      resolver.setPrefix("/WEB-INF/thymeleaf/");
      //resolver.setSuffix(".html");
      resolver.setCharacterEncoding("UTF-8");
      resolver.setTemplateMode("HTML5");
      resolver.setCacheable(false);
      return resolver;
   }

   @Bean
   public SpringTemplateEngine thymeleafTemplateEngine()
   {
      SpringTemplateEngine engine = new SpringTemplateEngine();
      engine.setTemplateResolver(thymeleafTemplateResolver());
      return engine;
   }

   @Bean
   public ThymeleafViewResolver thymeleafViewResolver()
   {
      ThymeleafViewResolver resolver = new ThymeleafViewResolver();
      resolver.setTemplateEngine(thymeleafTemplateEngine());
      resolver.setCharacterEncoding("UTF-8");
      return resolver;
   }

}
