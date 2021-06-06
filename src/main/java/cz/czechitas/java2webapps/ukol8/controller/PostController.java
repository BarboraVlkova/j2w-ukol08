package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * vyuziti PostService s anotaci @Autowired (vytvoreni konstruktoru)
 * metoda zobrazuje uvodni stranku se seznamem postu
 * metoda zobrazuje jeden post
 */

@Controller
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }


    @GetMapping("/")
    public ModelAndView seznamPostu (@PageableDefault Pageable pageable){
        return new ModelAndView("seznamVsechPostu").addObject("seznamPostu", service.list(pageable));
    }


    @GetMapping("/post/{slug}")
    public ModelAndView detailJednohoPostu (@PageableDefault String slug) {
        return new ModelAndView("detailJednohoPostu").addObject("detailPostu", service.singlePost(slug));
    }

}


