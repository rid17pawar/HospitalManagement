package com.project.utility;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ModelAndViewUtility {
    public ModelAndView returnModelAndView(String viewName,String attributeName,Object obj){
        ModelAndView mv= new ModelAndView();
        if(attributeName!=null) {
            mv.setViewName(viewName);
        }
        if(obj!=null) {
            mv.addObject(attributeName, obj);
        }
        return mv;
    }
}
