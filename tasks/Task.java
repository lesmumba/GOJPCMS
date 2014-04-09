package tasks;
import project.*;
import java.util.*;


/**
 * Write a description of class tasks here.
 * 
 * @author Mumba Sambo
 * @version Apr 08,2014
 */
public class Task
{
    // instance variables
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
    
    public Task getTask(String taskId)
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
             * Check if task with ID exists
             * Project check_task = gettask(taskId);
             * if (check_ = None) {
             *     id_taken = False;
             *  } */
            return taskId;
        }
        while (idTaken);
    }
}
