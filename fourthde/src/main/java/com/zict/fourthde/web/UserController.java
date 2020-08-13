package com.zict.fourthde.web;


import com.zict.fourthde.model.User;
import com.zict.fourthde.service.UserService;
import com.zict.fourthde.utils.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {


    private String key = "key";

    @Resource
    UserService userService;

    @Autowired
    JedisAdapter jedisAdapter;



    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        String name =user.getUserName();

        //判断缓存中是否存在该名字的user
        if(jedisAdapter.sismember(key, name)){
            System.out.println("the user has been add");
            return "redirect:/list";
        }

        userService.save(user);
        jedisAdapter.sadd(key, name);
        return "redirect:/list";
    }




}
