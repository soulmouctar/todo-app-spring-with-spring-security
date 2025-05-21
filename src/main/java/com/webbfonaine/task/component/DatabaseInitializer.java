package com.webbfonaine.task.component;

import com.webbfonaine.task.entity.Task;
import com.webbfonaine.task.entity.User;
import com.webbfonaine.task.repository.TaskRepository;
import com.webbfonaine.task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Override
    public void run(String... args) {
        // Create users
        User userA = new User();
        userA.setUsername("userA");
        userA.setPassword("password");
        userA.addRole("ROLE_USER");
        userService.save(userA);
        
        User userB = new User();
        userB.setUsername("userB");
        userB.setPassword("password");
        userB.addRole("ROLE_ADMIN");
        userService.save(userB);
        
        // Create some initial tasks
        Task task1 = new Task();
        task1.setTitle("Complete Project Documentation");
        task1.setDescription("Write user guide and technical documentation for the new project");
        task1.setCompleted(false);
        task1.setAssignedTo(userA);
        taskRepository.save(task1);
        
        Task task2 = new Task();
        task2.setTitle("Fix Homepage Responsiveness");
        task2.setDescription("The homepage layout breaks on mobile devices");
        task2.setCompleted(false);
        task2.setAssignedTo(userB);
        taskRepository.save(task2);

        Task task3 = new Task();
        task3.setTitle("Adding spring security to the project");
        task3.setDescription("The homepage layout breaks on mobile devices");
        task3.setCompleted(false);
        task3.setAssignedTo(userA);
        taskRepository.save(task3);

        Task task4 = new Task();
        task4.setTitle("Designing the front for view with thymeleaf");
        task4.setDescription("The homepage layout breaks on mobile devices");
        task4.setCompleted(false);
        task4.setAssignedTo(userA);
        taskRepository.save(task4);
    }
}