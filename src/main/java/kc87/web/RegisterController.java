package kc87.web;

import kc87.domain.Account;

import kc87.service.EchoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
@RequestMapping(value = "/register.html")
public class RegisterController
{
   private static final Logger LOG = LogManager.getLogger(EchoService.class);

   @PostConstruct
   public void init()
   {
      LOG.debug("Init controller");
   }

   @RequestMapping(method = RequestMethod.GET)
   public String form(final Model model)
   {
      LOG.debug("GET request");
      model.addAttribute("account", new Account());
      return "register.html";
   }

   @RequestMapping(method = RequestMethod.POST)
   public String handleSubmit(@ModelAttribute Account account)
   {
      LOG.info(account.toString());
      return "register.html";
   }

   @PreDestroy
   public void destroy()
   {
      LOG.debug("Destroy controller");
   }
}
