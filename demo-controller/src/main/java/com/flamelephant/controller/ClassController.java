package com.flamelephant.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shaoming
 * @since 2021-07-27
 */
@RestController
@RequestMapping("/class")
public class ClassController {



    @GetMapping("/test")
    public String hello(){
        return "Hello,ShaoMing!";
    }

}

