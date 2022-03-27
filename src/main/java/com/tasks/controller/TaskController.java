package com.tasks.controller;

import com.tasks.data.Task;
import com.tasks.dto.TaskDtoRequest;
import com.tasks.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/v1/task" )
public class TaskController {

    private final ITaskService taskService;

    public TaskController(@Autowired ITaskService taskService){

        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        System.out.println("TaskController - getAll() ");
        return new ResponseEntity<>(taskService.all(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable String id){
        System.out.println("TaskController - findById(id) ");
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createUser(@RequestBody TaskDtoRequest taskDto){
        System.out.println("TaskController - createUser(user)");
        return new ResponseEntity<>(taskService.create(taskDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDtoRequest taskDto, @PathVariable String id){
        System.out.println("TaskController - update(user, id) ");
        return new ResponseEntity<Task>(taskService.update(taskDto, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        System.out.println("TaskController - delete(id) ");
        return new ResponseEntity<>(taskService.deleteById(id), HttpStatus.OK);
    }
}
