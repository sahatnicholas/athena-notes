package athena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@SuppressWarnings("PMD.UseUtilityClass")
public class AthenaApplication {

  public static void main(String[] args) {
    SpringApplication.run(AthenaApplication.class, args);
  }

}
