package kc87.web;

import kc87.service.EchoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController
{
   private static final Logger LOG = LogManager.getLogger(HomeController.class);

   @Autowired
   private EchoService echoService = null;

   @RequestMapping(value = "/home.html", method = RequestMethod.GET)
   public String home(Locale locale, Model model)
   {
      LOG.info("Controller called!");

      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

      String formattedDate = dateFormat.format(date);

      model.addAttribute("serverTime", formattedDate);
      model.addAttribute("echoService", echoService);
      model.addAttribute("someItems", new String[]{"one", "two", "three"});

      return "home.html";
   }
}
