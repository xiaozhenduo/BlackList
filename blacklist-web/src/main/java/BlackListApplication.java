import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = {"system.*","shiro.*"})
@MapperScan(basePackages = "system.dao")
public class BlackListApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlackListApplication.class, args);
    }

}
