package kz.iitu.itse1910.sagyndykov.todo.service;

import kz.iitu.itse1910.sagyndykov.todo.model.Projects;

import java.util.List;

public interface ProjectService {
    List<Projects> getAllProjects();
    void addProject(Projects project);
    void deleteProject(long id);
    Projects getProject(long id);
    void updateProject(Projects project);
    List<Projects> findCompletedProjects();
    List<Projects> findActiveProjects();
    List<Projects> findNotStartedProjects();
    List<Projects> findByStartDateDecreasingOrder();
    List<Projects> findByStartDateAscendingOrder();
    List<Projects> findByPriority();
}