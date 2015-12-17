package ee.ut.solmir.act.web;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebConfiguration extends WebMvcConfigurerAdapter {
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/js/**");
    registry.addResourceHandler("/css/**");
    registry.addResourceHandler("/fonts/**");
    registry.addResourceHandler("/img/**");
  }
}
