
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package elements;
import boxes.*;
import java.util.*;
/**
 * Each user object has an ID inbox outbox and friend list. users only can receive messages from 
 * their friends. These messages stored in the server than receives the users. 
 * @author merve gurbuz
 *
 */
public class User{
	/**
	 * ID of te User
	 */
	private int id;
	/**
	 * inbox of the user that store received messages
	 */
	private Inbox inbox;
	/**
	 * outbox that store the sent messages
	 */
	private Outbox outbox;
	/**
	 * friends list
	 */
	ArrayList<User>friends;
	/**
	 * constructer of this class that takes the ID and create a new object
	 * @param id the id of the user
	 */
	public User(int id) {
		this.id=id;
		friends=new ArrayList<User>();
		this.inbox=new Inbox(this);
		this.outbox=new Outbox(this);
		
	}
	/**
	 * if the user is not friends if this method called two users becomes friends to each other.
	 * @param other the other user that will be friend with this user
	 */
	public void addFriend(User other) {
		if(!isFriendWith(other))
			friends.add(other);
		if(!other.isFriendWith(this))
			other.addFriend(this);
	}
	/**
	 * if two user is friends this method remove the given user to the friend list
	 * and also removes this user from other user friend list. 
	 * @param other the other suer that will be removed from friend list
	 */
			
	public void removeFriend(User other) {
		if(this.isFriendWith(other)) {
			friends.remove(other);
			other.removeFriend(this);}
		
	}
	/**
	 * 
	 * @param other the user that will be checked whether is friend or not
	 * @return return if given user and this user is friend
	 */
	public boolean isFriendWith(User other) {
		if(friends.contains(other))
			return true;
		return false;
			
	}
	/**
	 * it create a message from given parameter 
	 * and send it to the server msgs list also the outbox list.
	 * @param receiver the receiver of message
	 * @param body the body of the new message
	 * @param time the time that the message is created
	 * @param server the server that  stores the messages until it reaches the receiver or flush.
	 */
	public void sendMessage(User receiver,String body,int time,Server server) {
		Message msg=new Message(this, receiver, body, server, time);
		server.getMsgs().add(msg);
		this.outbox.addMessage(msg);
		}
	/**
	 * 
	 * @return it return the inbox of user
	 */
	public Inbox getInbox() {
		return inbox;
	}
	/**
	 * 
	 * @return the outbox of user
	 */
	public Outbox getOutbox() {
		return outbox;
	}
	/**
	 * 
	 * @return the ID of user.
	 */
	public int getId() {
		return id;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

