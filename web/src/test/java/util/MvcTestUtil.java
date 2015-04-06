package util;

import architree.yoon.config.WebConfig;
import architree.yoon.web.UserController;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;

/**
 * Created by yoon on 15. 4. 6..
 */
public class MvcTestUtil {

    public static MockMvc getMockMvc(Object controller) {

        WebConfig webConfig = new WebConfig();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setViewResolvers(webConfig.internalResourceViewResolver()).build();

        return mockMvc;
    }
}
