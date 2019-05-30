package cl.sportapp.evaluation.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo metadata() {
        return new ApiInfoBuilder()//
                .title("JSON Web Token Authentication API")//
                .description(
                        "This is a sample JWT authentication service. You can find out more about JWT at [https://jwt.io/](https://jwt.io/). For this sample, you can use the `admin` or `client` users (password: admin and client respectively) to test the authorization filters. Once you have successfully logged in and obtained the token, you should click on the right top button `Authorize` and introduce it with the prefix \"Bearer \".")//
                .version("1.0.0")//
                .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
                .contact(new Contact(null, null, "mauriurraco@gmail.com"))//
                .build();
    }

}