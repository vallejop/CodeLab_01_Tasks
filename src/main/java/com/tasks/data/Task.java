package com.tasks.data;

import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    UUID id;

    String name;

    String description;

    String status;

    String asignedTo;

    String dueDate;

    String created;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAsignedTo() {
        return asignedTo;
    }

    public void setAsignedTo(String asignedTo) {
        this.asignedTo = asignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
