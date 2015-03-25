package architree.yoon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by yoon on 15. 3. 25..
 */
@Configuration
@ComponentScan({"architree.yoon.web"})
@Import(value={
        DBConfig.class
})
public class AppConfig {

}
