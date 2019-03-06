package com.example.mysqlthymeleaf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoDao todoDao;

    @RequestMapping("/")
    public String index(Model model, @ModelAttribute Todo todo) {

        todo = new Todo();

        List<Todo> todos = (List<Todo>) todoDao.findAll();

        model.addAttribute("todoList", todos);

        return "index";
    }

    @RequestMapping(value = "/indexpost", method = RequestMethod.POST)
    public String indexpost(Model model, @ModelAttribute Todo todo) {
        todoDao.save(todo);

        todo = new Todo();

        List<Todo> todos = (List<Todo>) todoDao.findAll();

        model.addAttribute("todoList", todos);

        return "redirect:/";
    }

}