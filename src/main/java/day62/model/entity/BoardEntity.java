package day62.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.AutoConfiguration;

@Entity
// 1. 해당 클래스를 DB 의 테이블과 매핑 정의한다.
@Table(name = "board")
// 1. 해당 엔티티와 매핑된 테이블의 이름 정의한다.
@Getter@Setter@ToString
@Builder // 객체 생성시 생성자가 아닌 유연하게 객체를 만들기 위한 빌더 패턴 지원
@NoArgsConstructor@AllArgsConstructor
public class BoardEntity {

    @Id // 1. 해당 필드/속성의 제약조건에 primary key 정의하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(columnDefinition = "varchar(100)", nullable = false) // 1. 해당 필드/속성의 타입,제약조건 정의하는 어노테이션
    private String btitle;

    @Column(columnDefinition = "longtext", nullable = false)
    private String bcontent;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String bwriter; // = 값 -> default 값 설정가능

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String bpwd;
}
