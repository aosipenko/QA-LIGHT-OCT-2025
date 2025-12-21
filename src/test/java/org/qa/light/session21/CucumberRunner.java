package org.qa.light.session21;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.qa.light.session21.listener.MyListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import java.sql.SQLException;

@EnableTransactionManagement
@EnableJpaRepositories("org.qa.light.session21")
@ContextConfiguration(locations = "classpath*:spring/spring-context.xml")
@ComponentScan(basePackages = {"org.qa.light.session21"})
@CucumberContextConfiguration
@CucumberOptions(
        tags = "@wip",
        glue = "org.qa.light.session21",
        features = "src/test/resources/features",
        plugin = {
                "pretty",
                "html:target/report.html",
                "json:target/Cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
//                , "org.qa.light.session16.CucumberHooks"
        }
)
@Listeners(MyListener.class)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        DBConnectionFactory.getConnection().close();
    }
}
