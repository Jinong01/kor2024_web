package day52.boardservice12mvc;

import day52.boardservice8mvc.view.BoardView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {

//        BoardView.getInstance().run();

        SpringApplication.run(AppStart.class);
    }
}
