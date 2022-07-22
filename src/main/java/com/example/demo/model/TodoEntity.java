package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id // 기본키가 될 필드에 지정한다. 오브젝트를 데이터베이스에 저장할 때마다 생성할 수도 있으나, GeneratedValue 어노테이션을 이용해 자동으로 생성할 수도 있다.
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String id; // 오브젝트의 아이디
    private String userId; // 오브젝트를 생성한 사용자의 아이디
    private String title; // Todo 타이틀
    private boolean done; // true-false : todo를 완료한 경우 체크

}
