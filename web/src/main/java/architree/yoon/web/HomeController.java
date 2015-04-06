package architree.yoon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yoon on 15. 3. 25..
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}