package architree.yoon.web;

import architree.yoon.domain.User;
import architree.yoon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yoon on 15. 3. 25..
 */
@Controller
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public @ResponseBody String test() {
        User user = new User("yoonsung", 28);
        userRepository.save(user);
        System.out.println("save Success!");
        User selectedUser = userRepository.findOne((long) 1);

        return selectedUser.toString();
    }

}