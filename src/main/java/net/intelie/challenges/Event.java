package net.intelie.challenges;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * This is just an event stub, feel free to expand it if needed.
 */
public class Event implements EventStore, EventIterator{
    private final String type;
    private final long timestamp;
    private final ArrayList <Event> list_eventstore = new ArrayList<Event>();

    public Event(String type, long timestamp) {
        this.type = type;
        this.timestamp = timestamp;
    }

    public String type() {
        return this.type;
    }

    public long timestamp() {
        return this.timestamp;
    }

	@Override
	public boolean moveNext() {
		// TODO Auto-generated method stub
		Iterator<Event> itr=list_eventstore.iterator();  

        //traverse elements of ArrayList object  
		Event ev=(Event)itr.next();
        if (ev!=null) {  
        	return true;
        }else {
        	return false;
        }    
		
	}

	@Override
	public Event current() {
		
		Event event_current = null;		
		// Return the current element as last element
		try{
			event_current = list_eventstore.get(list_eventstore.size()-1);
			return event_current;
			
		}catch(NullPointerException e) {
			return null;
		}		
	}

	@Override
	public void remove() {
		// Remove the last element considerate the last element	
		list_eventstore.remove(this.current());
	}

	@Override
	public void insert(Event event) {
		// adding elements in array list
		list_eventstore.add(event);
	}

	@Override
	public void removeAll(String type) {
		//Variable of loop
		int i;
		
		//Loop for iterator the array list
		for (i=0; i<list_eventstore.size();i++ ) {
			if(list_eventstore.get(i).type()==type) {		
				list_eventstore.remove(this.list_eventstore.get(i));				
			}		
		}		
	}

	@Override
	public EventIterator query(String type, long startTime, long endTime) {
		// List Iterator to arraylist
		ListIterator<Event> itr = list_eventstore.listIterator();  
		
       //traverse elements of ArrayList object 
		try {
	        while(itr.hasNext()==true){    
	        	Event ev=(Event)itr.next(); 
	            if (ev.type==type && ev.timestamp >= startTime && ev.timestamp < endTime) {
	            	return (EventIterator) itr.previous();
	            }else {
	            	return null;
	            }
	            
	        }  	
		}catch(NullPointerException e) {
			System.out.println(e.getCause());
		}
		//Return the previous element of the iterator because the While loop moved the iterator for next position
		return (EventIterator) itr.previous();
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
    
    
}
