package architree.yoon.web;

import architree.yoon.domain.User;
import architree.yoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yoon on 15. 3. 31..
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

    @RequestMapping(value ="", method = RequestMethod.POST)
    public String register(User user) {

        if (user.isValid())
            userRepository.save(user);

        return "redirect:/";
    }
}