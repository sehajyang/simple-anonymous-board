import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.script.ScriptTemplateViewResolver;

/**
 * @author seha
 * @date 2019-05-15
 */
@Configuration
public class WebConfig {
    @Bean
    public ViewResolver viewResolver() {
        ScriptTemplateViewResolver viewResolver = new ScriptTemplateViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".hbs");
        return viewResolver;
    }
}
