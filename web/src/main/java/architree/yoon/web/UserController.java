package architree.yoon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yoon on 15. 3. 31..
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/form")
    public String form() {
        return "form";
    }
}