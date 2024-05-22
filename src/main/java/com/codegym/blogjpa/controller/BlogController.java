package com.codegym.blogjpa.controller;

import com.codegym.blogjpa.model.Blog;
import com.codegym.blogjpa.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @GetMapping("")
    public String showAll(Model model){
        List<Blog> blogs = iBlogService.findAll();
        model.addAttribute("blogs", blogs);
        return "home";
    }
    @GetMapping("/create")
    public String showForm(Model model){
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "create";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog",blog);
        return "edit";
    }
    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return  "redirect:/blog";
    }
    @GetMapping("/remove")
    public String remove(@RequestParam Long id, RedirectAttributes redirectAttributes){
        iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("message","Đã xóa thành công");
        return "redirect:/blog";
    }
}
