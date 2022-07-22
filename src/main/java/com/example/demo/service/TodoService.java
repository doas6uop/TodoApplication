package com.example.demo.service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // 해당 어노테이션은 내부에 Component 어노테이션을 가지고 있다. 그러나 기능차이는 없으며, 서비스 레이어임을 표시할 목적으로 구분된다.
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String testService(){
        // TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();

        //TodoEntity 저장
        repository.save(entity);

        // TodoEntity 검색
        TodoEntity savedEntity = repository.findById(entity.getId()).get();

        return savedEntity.getTitle();
    }



}
