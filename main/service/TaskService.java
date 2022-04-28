package kz.iitu.itse1910.sagyndykov.todo.service;

import kz.iitu.itse1910.sagyndykov.todo.model.Projects;
import kz.iitu.itse1910.sagyndykov.todo.model.Tasks;

import java.util.List;

public interface TaskService {
    List<Tasks> getTasks(long projectId);
    List<Tasks> getAllTasks();
    void addTaskToProject(Tasks task, long projectId);
    boolean checkTaskContainsInProjects(long taskId, long projectId);
    Tasks getTask(long taskId);
    void updateTask(Tasks task);
    void deleteTask(Tasks task, Projects project);
    List<Tasks> ToDoTasks();
    List<Tasks> inProgressTasks();
    List<Tasks> doneTasks();
}