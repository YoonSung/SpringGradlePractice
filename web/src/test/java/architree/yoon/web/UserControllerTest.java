package architree.yoon.web;

import architree.yoon.config.AppConfig;
import architree.yoon.config.WebConfig;
import architree.yoon.domain.User;
import architree.yoon.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import util.MvcTestUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by yoon on 15. 3. 31..
 */
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class UserControllerTest {

    MockMvc mockMvc;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserController userController;


    @Before
    public void setUp() {
        mockMvc = MvcTestUtil.getMockMvc(userController);
    }

    @Test
    public void formRequest() throws Exception {

        String expectedViewName = "form";

        mockMvc.perform(get("/user/form"))
                .andExpect(status().isOk())
                .andExpect(view().name(expectedViewName))
                .andExpect(forwardedUrl(WebConfig.RESOLVER_PREFIX + expectedViewName + WebConfig.RESOLVER_SUFFIX));
    }

    @Test
    public void create() throws Exception {

        String testId = "estrella";
        String testPassword = "test";
        String testUserName = "Yoonsung";
        int testAge = 28;

        User testUser = new User(testId, testPassword, testUserName, testAge);

        when(userRepository.save(testUser)).thenReturn(testUser);

        mockMvc.perform(
                post("/user")
                        .param("id", testId)
                        .param("password", testPassword)
                        .param("name", testUserName)
                        .param("age", ""+testAge)
        )
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));

    }
}
