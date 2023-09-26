package az.code.course26mvc.controller;

import az.code.course26mvc.model.User;
import az.code.course26mvc.model.UsrDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "index"; // This corresponds to the HTML template name (hello.html)
    }

    @GetMapping("/mypage")
    public String second(Model model) {
        model.addAttribute("message", "Ikinci sehive");
        return "my"; // This corresponds to the HTML template name (hello.html)
    }


    @GetMapping("/userForm")
    public String userForm(Model model) {
        // 'user' should match the th:object attribute in the form
        return "userForm";
    }

    @GetMapping("/user")
    public ModelAndView user() {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
//        modelAndView.addObject("message", "Hello, World!");
        modelAndView.setViewName("user"); // Set the view name explicitly
        return modelAndView; // This corresponds to the HTML template name (hello.html)
    }

    @PostMapping("/processForm")
    public ModelAndView user2(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getEmail() + " " + user.getUsername());
        modelAndView.addObject("username", user.getUsername());
        modelAndView.setViewName("success"); // Set the view name explicitly
        return modelAndView; // This corresponds to the HTML template name (hello.html)
    }


    @GetMapping("/js")
    public String js() {
        return "jsexample"; // This corresponds to the HTML template name (hello.html)
    }


    @ResponseBody
    @PostMapping("/to_console")
    public String toConsole(@RequestBody UsrDTO usrDTO) {
       return usrDTO.getName()+" "+usrDTO.getSurname()+" login success";
    }


}
