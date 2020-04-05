package com.spring.codeblog.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.spring.codeblog.models.Post;
import com.spring.codeblog.service.CodeblogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * CodeblogController
 */

 @Controller
public class CodeblogController {

    @Autowired
    CodeblogService codeblogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = codeblogService.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetalhes(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("detalhesPost");
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET )
    public String getPostFrom(){
        return "/postForm";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Preencha todos os campos e tente novamente!");
            return "redirect:/newpost";
        }

        post.setData(LocalDate.now());

        codeblogService.save(post);
        return "redirect:/posts";
    }

}