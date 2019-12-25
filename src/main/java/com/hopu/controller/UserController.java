package com.hopu.controller;

import com.hopu.entity.User;
import com.hopu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("hello")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("word")
    @ResponseBody
    public String sayHello(){
        System.out.println("adiashfyiahado");
        return  "success";
    }

    /**
     * 根据主键查找
     *
     * @param i
     * @return
     */

    @GetMapping("/{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") long i){
      User user=userService.queryUserById(i);
      return user;
    }
    /**
     * 根据主键删除
     */
    @GetMapping("/del/{ids}")
    @ResponseBody
    public  String deleteUserById(@PathVariable("ids") long id){
        userService.deleteUserById(id);
        return "success";
    }

    @GetMapping("list")
    public  String queryAll(Model model){
        List<User> userList=userService.queryAll();
        model.addAttribute("users",userList);
        return  "item";
    }

}
