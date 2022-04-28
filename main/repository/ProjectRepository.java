package kz.iitu.itse1910.sagyndykov.todo.repository;

import kz.iitu.itse1910.sagyndykov.todo.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProjectRepository extends JpaRepository<Projects,Long> {
    List<Projects> findAllByOrderByStartDate();
    List<Projects> findAllByOrderByPriority();
}
