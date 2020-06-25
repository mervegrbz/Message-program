
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package boxes;
import elements.*;
import java.util.*;
/**
 * it is the Inbox class that receive messages and store them whether they read or unread. Each inbox has User , stack of unread and queue of read messages.
 * @author merve gurbuz
 *
 */

public class Inbox extends Box{
	/**
	 * stack of the unread messages
	 */
	private  Stack<Message> unread;
	/**
	 * queue of the read messages
	 */
	private Queue<Message>read;
	

/**
 * it is the constructor which takes user as parameter and construct the unread and read message lists
 * @param user owner of the inbox 
 */
	public Inbox(User user) {
		this.Owner=user;
		unread=new Stack<>();
		read=new ArrayDeque<>();
	
	}
	 /** 
	  * it helps to receive private read messages queue 
	  * @return read messages queue
	  */
	public Queue<Message> getRead() {
		return read;
	}
/**
 * when this method called it searches the server messages list and iterate in it . if any messages' receiver is  owner of the inbox  and receiver and the sender is friend with each other,it store it to the unread messages 
 * @param server the class that first takes messages and store them
 * @param time it is time when receive method called
 */
public void receiveMessages(Server server,int time) {
	
	Iterator<Message> itr=server.getMsgs().iterator();
	while(itr.hasNext()) {
		Message input=itr.next();
		if(input.getReceiver().getId() == this.Owner.getId()) {
		if(this.Owner.isFriendWith(input.getSender()))
		{
			input.setTimeStampReceived(time);
			unread.push(input);
			itr.remove();
			server.remove(input,server.output);
			
		}
		}
	
	}

}
/**
 * this method helps to read given number of messages to read from unread sack if num is more than unread messages
 *  or num is zero it reads all messages from unread and store them into read messages queue. Each reading process takes one time.
 * @param num the amount of messages that will be read
 * @param time the time when this method called
 * @return the changed time 
 */
public int readMessages(int num,int time) {
	int count=0;
	
	if (num==0 || num>unread.size()) {
		while(!unread.isEmpty()) {
			Message msg=unread.pop();
			msg.setTimeStampRead(time+count);
			read.add(msg);
			count++;
		}
		return count!=0?time+count:time+1;
		}
	
	for(int i=0;i<num;i++) { 
		Message msg=unread.pop();
		msg.setTimeStampRead(time+count);
		read.add(msg);	
		count++;
	}

	return count!=0?time+count:time+1;
	
}
/**
 * it is a read messages method but it reads the messages with respect to sender . 
 * if unread has any messages from given user it push it to the read message class and pop out from unread stack.
 * it also changes the time with respect to amount of messages that are read
 * @param sender the sender of the messages that will be read
 * @param time when the method is called
 * @return the final time that is added the amount of read messages added.
 */
public int readMessages(User sender, int time) {
	int count=0;
	Stack<Message> temp=new Stack<>();
	Iterator<Message> itr=unread.iterator();
	while(itr.hasNext()) {
		Message msg=itr.next();
		if(msg.getSender()==sender) {
			temp.add(msg);
			itr.remove();
		}
	}
	while(!temp.isEmpty()) {
		Message msg=temp.pop();
		msg.setTimeStampRead(time+count);
		read.add(msg);
		count++;
		}
		
	return count!=0?count+time:time+1;
}
/**
 * it reads the message which has given ID
 * @param msgId the message id that will be read
 * @param time time when this method is  called
 */
public void readMessage(int msgId,int time) {
	Iterator<Message> itr=unread.iterator();
	while(itr.hasNext()) {
		Message msg=itr.next();
		if (msg.getId()==msgId) {
			read.add(msg);
			itr.remove();
			msg.setTimeStampRead(time);
			return;
		}
			
	}
}

}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

