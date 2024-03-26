package com.example.carmanager.controller;

import com.example.carmanager.model.product.Car;
import com.example.carmanager.model.product.Type;
import com.example.carmanager.model.user.Role;
import com.example.carmanager.service.car.ICarService;
import com.example.carmanager.service.type.ITypeService;
import com.example.carmanager.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private ICarService carService;
    @Autowired
    private IUserService userService;
    @Autowired
    ITypeService typeService;
    @ModelAttribute("types")
    public Page<Type> listType(Pageable pageable){
        return typeService.findAll(pageable);
    }
    @ModelAttribute("roles")
    @GetMapping("")
    public ModelAndView showList(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("car/index");
        Page<Car> cars = carService.findAll(pageable);
        modelAndView.addObject("cars",cars);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("car/create");
        modelAndView.addObject("car",new Car());
        return modelAndView;
    }
    @PostMapping("create")
    public String createCar(@ModelAttribute("car") Car car){
        carService.save(car);
        return "redirect:/car";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("car/update");
        Optional<Car> car = carService.findById(id);
        modelAndView.addObject("car",car.get());
        return modelAndView;
    }
    @PostMapping("/update")
    public String updateCar(@ModelAttribute("car") Car car){
        carService.save(car);
        return "redirect:/car";
    }
    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id){
        carService.remove(id);
        return "redirect:/car";
    }
}