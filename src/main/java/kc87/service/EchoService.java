package kc87.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class EchoService
{
   private static final Logger LOG = LogManager.getLogger(EchoService.class);

   @PostConstruct
   public void init()
   {
      LOG.info("Init service");
   }

   public String echo(String msg)
   {
      return msg;
   }

   @PreDestroy
   public void destroy()
   {
      LOG.info("Destroy service");
   }

}
