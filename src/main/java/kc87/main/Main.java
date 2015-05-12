package kc87.main;

import kc87.config.RootConfiguration;
import org.apache.catalina.Context;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.File;

public class Main
{
   private static final String CONTEXT_PATH = "";
   private static final int DEFAULT_WEBAPP_PORT = 8080;

   public static void main(String[] args) throws Exception
   {
      final int httpPort = DEFAULT_WEBAPP_PORT;
      final String docBase = new File("src/main/resources/webapp/").getAbsolutePath();
      //final String baseDirectory = "webapp/";

      final String tmpDirectory = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();

      final Tomcat tomcat = new Tomcat();

      ClassLoader loader = Thread.currentThread().getContextClassLoader();

      /*
      tomcat.getEngine().setParentClassLoader(loader);
      tomcat.getHost().setParentClassLoader(loader);
      tomcat.getServer().setParentClassLoader(loader);
      tomcat.getService().setParentClassLoader(loader);
      */

      tomcat.getHost().setAutoDeploy(false);
      tomcat.getHost().setDeployOnStartup(false);
      tomcat.setHostname("localhost");
      tomcat.setPort(httpPort);
      tomcat.setBaseDir(tmpDirectory);

      final Context rootContext = tomcat.addWebapp(CONTEXT_PATH, docBase);

      rootContext.addParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
      rootContext.addParameter("contextConfigLocation", RootConfiguration.class.getName());
      rootContext.addApplicationListener(ContextLoaderListener.class.getName());
      rootContext.setLoader(new WebappLoader(loader));

      tomcat.start();
      tomcat.getServer().await();
   }

}
