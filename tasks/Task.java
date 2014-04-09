package tasks;
import project.*;
import java.util.*;


/**
 * Write a description of class tasks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Task
{
    // instance variables - replace the example below with your own
    Boolean idTaken;
    String projectId;
    String description;
    String taskId;
    String assigneeId = null;

    /**
     * Constructor for objects of class tasks
     */
    public Task(String projectId, String description, String assigneeId)
    {
        // initialise instance variables
        this.projectId = projectId;
        this.description = description;
        this.assigneeId = assigneeId;
    }

    public String addTask(String projectId, String description, String assigneeId)
    {
        this.taskId = generateTaskId();
        this.projectId = projectId;
        this.description = description;
        this.assigneeId = assigneeId;
        return taskId;
    }
    
    public getTask(String taskId)
    {
        /*
         * Get the task from the database.
         * Return null if the task is not found.
         */
        return null;
    }
    
    /**
     * generateTaskId - generates an unique id using java UUID
     * @return the taskId
     */
    private String generateTaskId(){
        idTaken = true;
        String projectId;
        do{
            taskId = UUID.randomUUID().toString();
            /* 
             * Check if project with ID exists
             * Project check_project = getProject(random_int);
             * if (check_project = None) {
             *     id_taken = False;
             *  } */
            return taskId;
        }
        while (idTaken);
    }
}
