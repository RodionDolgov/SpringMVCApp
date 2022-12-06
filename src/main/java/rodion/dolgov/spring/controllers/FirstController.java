package rodion.dolgov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "a", required = false) int firstNumber,
                            @RequestParam(value = "b", required = false) int secondNumber,
                            @RequestParam(value = "action", required = false) String action,
                            Model model){
        int result = 0;

        if(action.equals("multiplication")){
           result = firstNumber * secondNumber;
        }
        if(action.equals("addition")){
            result = firstNumber + secondNumber;
        }
        if(action.equals("subtraction")){
            result = firstNumber - secondNumber;
        }
        if(action.equals("division")){
            result = firstNumber / secondNumber;
        }


        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Result: " + result);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
