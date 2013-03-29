package info.cukes;

import cucumber.api.junit.Cucumber;
import cucumber.runtime.model.CucumberBackground;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * User: Jeffrey
 * Date: 29/03/13
 * Time: 2:54 PM
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = {"info.cukes", "cucumber.api.spring"}, format = "html:target/cukes")
public class RunCukesTest {
}
