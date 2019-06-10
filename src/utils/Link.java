/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.LinkedList;

/**
 *
 * @author dynnammo
 */
public class Link{
    public int value;
    Link next;
    Link previous;
    
    public Link(int value) {
        this.value = value;
        this.next = this;
        this.previous = this;
    }
    
    public Link getNext(){
        return getNext(1);
    }
    
    public Link getNext(int nextValueWanted){
        Link currentLink = this;
        for (int i = 0; i < nextValueWanted; i++)
            currentLink = currentLink.next;
        return currentLink;
    }
    
    public Link getPrevious(){
        return getPrevious(1);
    }
    
    public Link getPrevious(int nextValueWanted){
        Link currentLink = this;
        for (int i = 0; i < nextValueWanted; i++)
            currentLink = currentLink.previous;
        return currentLink;
    }
    
    public Link addLink(int value){
        Link nextLink = this.next;
        Link newLink = new Link(value);
        this.connectTo(newLink);
        newLink.connectTo(nextLink);
        return newLink;
    }
    
    public void removeLink(){
        previous.connectTo(this.next);
    }
    
    public void connectTo(Link link){
        this.next = link;
        link.previous = this;
    }
}

