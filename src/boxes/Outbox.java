
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package boxes;
import elements.*;
import java.util.*;
/**
 * it is the child of box class. Each outbox has a owner 
 * and outbox class store the sent messages of owner in a queue
 * @author merve gurbuz
 *
 */
public class Outbox extends Box{
	/**
	 * queue of the sent messages
	 */
	
	private Queue<Message> sent;
	/**
	 * it is constructor of outbox class. It takes owner as parameter and defines the sent queue
	 * @param owner the owner of the outbox
	 */
	public Outbox(User owner) {
		this.Owner=owner;
		sent=new ArrayDeque<Message>();
	}
	/**
	 * it gives users to access private sent queue 
	 * @return sent queue
	 */

	public Queue<Message> getSent() {
		return sent;
	}
	
/**
 * any changes from sent queue can be done with this method
 * @param sent sent queue
 */
	public void setSent(Queue<Message> sent) {
		this.sent = sent;
	}
	/**
	 * the given  message adds to sent queue
	 * @param msg the message that is sent
	 */
	public void addMessage(Message msg) {
		sent.add(msg);
	}
	
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

