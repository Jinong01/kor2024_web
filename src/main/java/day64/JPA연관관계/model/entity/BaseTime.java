package day64.JPA연관관계.model.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter@MappedSuperclass@EntityListeners(AuditingEntityListener.class)
public class BaseTime {

    @CreatedDate
    LocalDateTime cdate; // 생성날짜
    @LastModifiedDate
    LocalDateTime udate; // 수정날짜
}
