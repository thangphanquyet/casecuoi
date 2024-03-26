package com.example.carmanager.controller;

import com.example.carmanager.model.product.Type;
import com.example.carmanager.service.type.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/type")
public class TypeController {
    @Autowired
    private ITypeService typeService;
    @GetMapping("")
    public ModelAndView showList(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("type/index");
        Page<Type> types = typeService.findAll(pageable);
        modelAndView.addObject("types",types);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("type/create");
        modelAndView.addObject("type",new Type());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createType(@ModelAttribute("type") Type type){
        typeService.save(type);
        return "redirect:/type";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("type/update");
        Optional<Type> type = typeService.findById(id);
        modelAndView.addObject("type",type.get());
        return modelAndView;
    }
    @PostMapping("/update")
    public String updateCar(@ModelAttribute("type") Type type){
        typeService.save(type);
        return "redirect:/type";
    }
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id){
        typeService.remove(id);
        return "redirect:/type";
    }
}