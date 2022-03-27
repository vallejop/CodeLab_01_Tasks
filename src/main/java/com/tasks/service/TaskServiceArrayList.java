package com.tasks.service;

import com.tasks.data.Task;
import com.tasks.dto.TaskDtoRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class TaskServiceArrayList implements ITaskService {

    private final List<Task> taskList = new ArrayList<>();

    @Override
    public List<Task> all() {
        System.out.println("TaskServiceArrayList - all()");
        return taskList;
    }

    @Override
    public Optional<Task> findById(String id) {
        System.out.println("TaskServiceArrayList - findById(id)");
        //Task task = new Task();
        //for(Task t : taskList){ task = (t.getId().toString().equals(id)) ? t : null; }
        Task task = taskList.stream().filter(t -> t.getId().toString().equals(id)).findAny().get();
        return task != null ? Optional.of(task) : Optional.empty();
    }

    @Override
    public Task create(TaskDtoRequest taskDto) {
        System.out.println("TaskServiceArrayList - create(id)");
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setName(taskDto.getName());
        task.setStatus(taskDto.getStatus());
        task.setAsignedTo(taskDto.getAsignedTo());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setCreated(taskDto.getCreated());
        taskList.add(task);
        return taskList.contains(task) ? task : null;
    }

    @Override
    public Task update(TaskDtoRequest taskDto, String id) {
        System.out.println("TaskServiceArrayList - update(id)");
        Optional<Task> task = this.findById(id);
        if (task.isPresent()){
            task.get().setName(taskDto.getName());
            task.get().setStatus(taskDto.getStatus());
            task.get().setAsignedTo(taskDto.getAsignedTo());
            task.get().setDescription(taskDto.getDescription());
            task.get().setDueDate(taskDto.getDueDate());
            taskList.remove(task);
            taskList.add(task.get());
            return task.get();
        }
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        System.out.println("TaskServiceArrayList - deleteById(id)");
        Optional<Task> task = this.findById(id);
        if (task.isPresent()){
            return taskList.remove(task.get());
        }
        return false;
    }

}
