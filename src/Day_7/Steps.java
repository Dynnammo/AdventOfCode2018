/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import utils.FileReader;
import utils.MainClass;
import utils.Node;

/**
 *
 * @author dynnammo
 */
public class Steps extends MainClass{
    public Set<Task> tasks = new HashSet<>();
    public Set<Task> bag = new HashSet<>();
    public ArrayList<Task> order = new ArrayList<>();
    public Set<Worker> workers = new HashSet<>();
    public int time;
    
    public void setTasks() throws FileNotFoundException{
        for (String s : new FileReader(this.getPath()).fileStream()) {
            String[] splitted = s.split("Step | must be finished before step | can begin.");
            Task root = new Task(splitted[1].charAt(0),(int) splitted[1].charAt(0));
            Task child = new Task(splitted[2].charAt(0), (int) splitted[1].charAt(0));
            setTask(root,child);
        }
    }
    
    private void setTask(Task r, Task c){
        Task root = getTask(r);
        Task child = getTask(c);
        root.children.add(child);
        child.ancestors.add(root);
    }

    private Task getTask(Task n) {
        if (tasks.add(n))
            return n;
        else {
            for (Task task : tasks) {
                if (task.equals(n))
                    return task;
            }
        }
        return null;
    }

    private void getRoots(){
        for (Task task : tasks) {
            if (task.ancestors.isEmpty()) 
               bag.add(task);
        }
    }
    
    public void order(){
        getRoots();
        while (!bag.isEmpty()) {            
            Task n = getFirstAvailable();
            validateTask(n);
            bag.remove(n);
        }
    }
    
    private void validateTask(Task n){
        order.add(n);
        n.children.forEach((child) -> {
            bag.add((Task) child);
        });
    }

    private boolean isAvailable(Task task) {
        for (Node ancestor : task.ancestors) {
            if (!order.contains(ancestor))
                return false;
        }
        if (task.isCompleting)
            return false;
        return true;
    }

    private Task getFirstAvailable(){
        char value = 255;
        for (Task task : bag) {
            value = (task.value < value && isAvailable(task)) ? task.value : value;
        }
        for (Task task : bag) {
            if (task.value == value)
                return task;
        }
        return null;
    }
    
    public int getExecutionTime(int workersNumber){
        getRoots();
        for (int i = 0; i < workersNumber; i++)
            workers.add(new Worker());
        int time = 0;
        boolean executionIsOver = false;
        while(!executionIsOver){
            checkWorkers(time);
            assignAvailableTasks(time);
            if (bag.isEmpty()) {
                executionIsOver = true;
            }
            time++;
        }
        return time;
    }
    
    private void checkWorkers(int time){
        for (Worker worker : workers) {
            if (!worker.isAvailable) {
                if (time - worker.beginTaskTime >= worker.task.duration) {
                    validateTask(worker.task);
                    bag.remove(worker.task);
                    worker.clearTask();
                }
            }
        }
    }
    
    private void assignAvailableTasks(int time){
        Task t = getFirstAvailable();
        Task tempTask = new Task('!', 0);
        while (t != null && t != tempTask){
            tempTask = t;
            if (!t.isCompleting)
                assignWorkerToTask(t, time);   
            t = getFirstAvailable();
        }
    }
        
    private void assignWorkerToTask(Task t, int time){
        for (Worker worker : workers) {
            if (worker.isAvailable) {
                worker.setTask(t, time);
                return;
            }
        }
    }
        
    
    @Override
    public String toString() {
        String s = "Steps{" + "tasks=";
        for (Task task : order)
            s += task.value + "";
        return s + '}';
    }
}
