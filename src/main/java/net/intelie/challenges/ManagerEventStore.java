/**
 * 
 */
package net.intelie.challenges;

/**
 * @author maril
 *
 */
public class ManagerEventStore {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// adding events in arraylist (considering events as object instance)
		
		Event event = new Event("event1", 123L);
        event.insert(event);
        System.out.println("Event 1 added!");
        Event event2 = new Event("event2", 456L);
        event.insert(event2);
        System.out.println("Event 2 added!");
        Event event3 = new Event("event3", 789L);
        event.insert(event3);
        System.out.println("Event 3 added!");
        
        //Verifying the current event
        System.out.println("Current Event before remove = "+event.current().type());
        
        //Removing current event
        event.remove();
        System.out.println("Current Event after remove = "+event.current().type());        
        
        //Remove all event type "event2"
        event.removeAll("event2");  
        System.out.println("Current Event after remove 'event2' = "+event.current().type());        
        
        //show all events as type "event1" and timestamp greater than 120L and less than 125L
        EventIterator itr = event.query("event1", 120L, 125L);
        if (itr!=null) {
          System.out.println("All events type 'event1'= "+itr.current().type()+" "+"Timestamp = "+itr.current().timestamp());
        }else {
        	System.out.println("There aren´t elements for condiction!!!");        	
        }
        
   }

}
