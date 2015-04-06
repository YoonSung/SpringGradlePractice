package architree.yoon.web;

import architree.yoon.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Callable;

/**
 * Created by yoon on 15. 3. 25..
 */
@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home() {
        log.debug("home request {}", "test");
        return "home";

    }
}