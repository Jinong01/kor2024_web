package day57task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // * MVC 관련 컴포넌트(클래스)들을 스캔 해서 등록 처리한다
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

// 학생들의 점수를 관리하는 RestFul API 구축하기
// 점수 등록 , 전체 점수 출력 , 특정 학생 수정 , 특정 학생 삭제
// Controller -> Service -> Dao
// Controller <- Service <- Dao