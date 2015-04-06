package architree.yoon.web;

import architree.yoon.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.MvcTestUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by yoon on 15. 3. 31..
 */
public class UserControllerTest {

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MvcTestUtil.getMockMvc(new UserController());
    }

    @Test
    public void formRequest() throws Exception {

        String expectedViewName = "form";

        mockMvc.perform(get("/user/form"))
                .andExpect(status().isOk())
                .andExpect(view().name(expectedViewName))
                .andExpect(forwardedUrl(WebConfig.RESOLVER_SUFFIX + expectedViewName + WebConfig.RESOLVER_SUFFIX));
    }
}
