package com.tasks.service;


import com.tasks.data.Task;
import com.tasks.dto.TaskDtoRequest;

import java.util.List;
import java.util.Optional;

public interface ITaskService {

        List<Task> all();

        Optional<Task> findById(String id );

        Task create(TaskDtoRequest task );

        Task update( TaskDtoRequest task, String id );

        boolean deleteById(String id );
}