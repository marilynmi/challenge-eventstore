package net.intelie.challenges;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventTest {
    @Test
    public void thisIsAWarning() throws Exception {
        Event event = new Event("event1", 123L);
       
        //THIS IS A WARNING:
        //Some of us (not everyone) are coverage freaks.
        assertEquals(123L, event.timestamp());
        assertEquals("event1", event.type());
        
     
        //Testing store events in insert function
        event.insert(event);
        Event event2 = new Event("event2", 456L);
        event.insert(event2);
        Event event3 = new Event("event3", 789L);
        event.insert(event3);     
              
        //assertTrue(event3.moveNext());
                
        //Testing current event and remove current event
                
        //Removing current event
        event.remove();
        
        //Verifying if current event removed was the current event
        assertEquals("event2",event.current().type());
        
        //Testing removeAll type events
        
        //Remove event type "event2"
        event.removeAll("event2");        
        //Compare if event remove was event type "event2"
        assertEquals("event1",event.current().type());
        
        
        //Testing EventIterator
        //Get current event in arraylist before iterating list
        Event event3_aux = event.current();
      
        //Compare if current element that was returned by the EventIterator function is equal the event3_aux.
        assertEquals((Event)event.query("event1", 120L, 125L).current(),event3_aux);
        
    }
}