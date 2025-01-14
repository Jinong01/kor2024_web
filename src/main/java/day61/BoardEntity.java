package day61;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// 클래스
@Entity
public class BoardEntity {

    // 1. 멤버변수
    @Id
    private int bno;
    @Column
    private String btitle;
    @Column
    private String bcontent;

    // 2. 생성자

    public BoardEntity(int bno, String btitle, String bcontent) {
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
    }
}

// 클래스
