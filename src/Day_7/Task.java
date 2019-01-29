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
public class Task extends utils.Node{
    public int duration;
    public boolean isCompleting;
    
    public Task(char value, int duration) {
        super(value);
        this.duration = value - 4;
    }
}
