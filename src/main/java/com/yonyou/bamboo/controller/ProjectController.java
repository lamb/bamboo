package com.yonyou.bamboo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.bamboo.model.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list() {
        return "project/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id) {
        return "project/show";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "project/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public List<FieldError> create(@Valid Project project, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getField() + error.getDefaultMessage());
            }
        }
        return result.getFieldErrors();
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.GET)
    public String edit() {
        return "project/modify";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.PUT)
    public String edit(Project project) {
        return "project/modify";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(Project project) {
        return "project/delete";
    }

}
