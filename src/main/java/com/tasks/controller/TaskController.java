package com.tasks.controller;

import com.tasks.data.Task;
import com.tasks.dto.TaskDtoRequest;
import com.tasks.service.ITaskService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation("search all tasks")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "task no found"),
    })
    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        System.out.println("TaskController - getAll() ");
        return new ResponseEntity<>(taskService.all(), HttpStatus.OK);
    }

    @ApiOperation("search task by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "task no found"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable String id){
        System.out.println("TaskController - findById(id) ");
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @ApiOperation("create task")
    @ApiResponses({
            @ApiResponse(code = 201, message = "created"),
            @ApiResponse(code = 404, message = "task no found"),
    })
    @PostMapping
    public ResponseEntity<Task> createUser(@RequestBody TaskDtoRequest taskDto){
        System.out.println("TaskController - createUser(user)");
        return new ResponseEntity<>(taskService.create(taskDto), HttpStatus.CREATED);
    }

    @ApiOperation("Update task")
    @ApiResponses({
            @ApiResponse(code = 204, message = "accepted"),
            @ApiResponse(code = 404, message = "task no found"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDtoRequest taskDto, @PathVariable String id){
        System.out.println("TaskController - update(user, id) ");
        return new ResponseEntity<Task>(taskService.update(taskDto, id), HttpStatus.ACCEPTED);
    }

    @ApiOperation("Delete task")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "task no found"),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id){
        System.out.println("TaskController - delete(id) ");
        return new ResponseEntity<>(taskService.deleteById(id), HttpStatus.OK);
    }
}
