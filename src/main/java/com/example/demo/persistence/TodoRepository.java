package com.example.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.TodoEntity;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    // JpaRepository : 이 인터페이스를 사용하려면 새 인터페이스를 작성해 JpaRepository를 확장해야 한다.
    // 이 때 JpaRepository<T, ID>는 GeneticType을 받아야한다.
    // T : 엔티티의 클래스(TodoEntity), ID : 엔티티의 기본키 타입(String)

    // TodoRepository는 JpaRepository를 상속한다.
    // JpaRepository는 기본적인 데이터베이스 오펑레이션 인턴페이스를 제공한다. save, findById, findAll 등이 기본적으로 제공되는 인터페이스에 해당한다.

    // 스프링이 JpaRepository를 실행하는 과정을 정확히 알려면 AOP(Aspec Oriented Programming)을 알아야 한다.

    // 메서드이름작성방법 및 예제 : https://docs.spring.io/spring-data/jpa/docs/current/refernce/html/#jpa.query-methods.query-creation
    @Query("select * from todo t where t.user_Id = ?1")    // ?1 은 매개변수의 순서 위치다.
    List<TodoEntity> findByUserId(String userId);


}
