package TeleTraderProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TeleTraderProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeleTraderProjectApplication.class, args);
	}

}
