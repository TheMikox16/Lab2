/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise1.purchaseapp;

import java.util.GregorianCalendar;

/**
 *
 * @author Miguel Angel Egoavil Mathison
 */
public class Status {
    
    private GregorianCalendar date;
    private StatusEnum description;

    public Status(GregorianCalendar date) {
        this.date = date;
        this.description = StatusEnum.PROCESS_WAITING;
    }

    public Status() {
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public StatusEnum getDescription() {
        return description;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void setDescription(StatusEnum description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Estado: " + description.getDescription() + ", fecha: " + date;
    }
    
    public boolean updateStatus(){
        description = description.getNext();
        date = new GregorianCalendar();
        return description.hasNext();
    }
    
}
