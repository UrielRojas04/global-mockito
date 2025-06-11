package org.example.service;

import org.example.model.Task;
import org.example.repository.TaskRepository;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    private TaskRepository taskRepository;
    private TaskService taskService;

    @Before
    public void setUp() {
        // Crea un mock del repositorio
        taskRepository = mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
+    public void testGetTaskById() {
        Task task = new Task(1L, "Ser millonario", false);
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        Optional<Task> result = taskService.getTaskById(1L);

        Assert.assertTrue(result.isPresent());
        assertEquals("Ser millonario", result.get().getDescription());
        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateTask() {
        Task newTask = new Task(null, "Nueva tarea", false);
        Task savedTask = new Task(2L, "Nueva tarea", false);

        when(taskRepository.save(newTask)).thenReturn(savedTask);

        Task result = taskService.createTask(newTask);

        Assert.assertNotNull(result.getId());
        assertEquals("Nueva tarea", result.getDescription());
        verify(taskRepository, times(1)).save(newTask);
    }

    @Test
    public void testGetAllTasks() {
        TaskRepository mockRepo = mock(TaskRepository.class);
        TaskService service = new TaskService(mockRepo);

        Task t1 = new Task(); t1.setDescription("Tarea 1");
        Task t2 = new Task(); t2.setDescription("Tarea 2");

        when(mockRepo.findAll()).thenReturn(Arrays.asList(t1, t2));

        List<Task> result = service.getAllTasks();

        assertEquals(2, result.size());
        assertEquals("Tarea 1", result.get(0).getDescription());
        verify(mockRepo).findAll();
    }

    @Test
    public void testDeleteTask() {
        TaskRepository mockRepo = mock(TaskRepository.class);
        TaskService service = new TaskService(mockRepo);

        Long id = 10L;
        service.deleteTask(id);

        verify(mockRepo).deleteById(id);
    }
    @BeforeClass

    public static void beforeClass(){
        System.out.println("Iniciando test...");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("Finalizando test...");
    }
}
