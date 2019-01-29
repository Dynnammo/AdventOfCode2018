/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day_7;

/**
 *
 * @author dynnammo
 */
public class Worker {
    public boolean isAvailable = true;
    public int beginTaskTime = 0;
    public Task task = null;

    public Worker() {
    }
    
    public void clearTask(){
        isAvailable = true;
        task = null;
        beginTaskTime = 0;
    }

    void setTask(Task t, int time) {
        task = t;
        beginTaskTime = time;
        isAvailable = false;
        t.isCompleting = true;
    }
}
