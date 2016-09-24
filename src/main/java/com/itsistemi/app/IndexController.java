package com.itsistemi.app;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by msarcevic on 17.8.2015..
 */

@Controller
public class IndexController extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/results").setViewName("results");
    }

    @RequestMapping(value="/",method= RequestMethod.GET)
    public String showForm(@ModelAttribute("poziv") PozivForm poziv){
        return "Pozivform";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String checkPozivNB(@Valid @ModelAttribute("poziv") PozivForm poziv, BindingResult bindingResult){

        PozivValidator validator = new PozivValidator();
        validator.validate(poziv,bindingResult);

        if (bindingResult.hasErrors()){
            return "Pozivform";
        }
        return "redirect:/results";
    }
}
