package az.code.course26mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example")
public class ExampleController {

    // Forward example
    @GetMapping("/forward")
    public String forwardExample() {
        // Forward to another controller or view
        return "forward:/example/forwarded";
    }

    @GetMapping("/forwarded")
    public String forwardedPage() {
        // This is the target page for the forward
        return "forwarded_page";
    }

    // Redirect example
    @GetMapping("/redirect")
    public String redirectExample() {
        // Redirect to another URL
        return "redirect:/example/redirected";
    }

    @GetMapping("/redirected")
    public String redirectedPage() {
        // This page is shown after the redirect
        return "redirected_page";
    }
}
