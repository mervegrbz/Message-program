
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package elements;
/**
 * All messages is the instance of this class . messages have unique ID, a text, sender and receiver also different time stamps.
 * @author merve gurbuz
 *
 */
public class Message implements Comparable<Message>{
	/**
	 * it is the static amount of messages which increase if a message is created
	 */
	static int numOfMessages=0;
	/**
	 * the unique id of message
	 */
	private int id;
	/**
	 * body of the message
	 */
	public String body;
	/**
	 * sender of the message
	 */
	private User sender;
	/**
	 * receiver of the message
	 */
	private User receiver;
	/**
	 * time of when the message sent
	 */
	private int timeStampSent;
	/**
	 * time when the message is read
	 */
	private int timeStampRead;
	/**
	 * time when the message is received
	 */
	private int timeStampReceived;

	
	/**
	 * it is constructor of message. it takes parameter and create an object with that information
	 * @param sender the sender of the message 
	 * @param receiver the receiver of the message
	 * @param body the body of message
	 * @param server the server that store message at first
	 * @param time the time that message is created
	 */
	public Message(User sender,User receiver,String body,Server server,int time) {
		this.body=body;
		this.id=numOfMessages++;
		this.receiver=receiver;
		this.sender=sender;
		this.timeStampSent=time;
		
	}
	/**
	 * 
	 * @return the sender if message
	 */
	public User getSender() {
		return sender;
	}
		
	/**
	 * 
	 * @return the receiver of message
	 */
	public User getReceiver() {
		return receiver;
	}
	/**
	 * 
	 * @return the body text of message
	 */
	public String getBody() {
		return body;
	}
	
	/**
	 * it sets the sent time of message
	 * @param timeStampSent the time that is message is sent
	 */
	public void setTimeStampSent(int timeStampSent) {
		this.timeStampSent = timeStampSent;
	}
	/**
	 * 
	 * @return the time that message is read
	 */
	public int getTimeStampRead() {
		return timeStampRead;
	}
	/**
	 * it sets to time when the message is read
	 * @param timeStampRead the time that message is read
	 */
	public void setTimeStampRead(int timeStampRead) {
		this.timeStampRead = timeStampRead;
	}
	/**
	 * 
	 * @return the time when message is received from a user
	 */
	public int getTimeStampReceived() {
		return timeStampReceived;
	}
	/**
	 * it sets the time when the message is received
	 * @param timeStampReceived the time that message is received
	 */
	public void setTimeStampReceived(int timeStampReceived) {
		this.timeStampReceived = timeStampReceived;
	}
	
	/**
	 * 
	 * @return the unique id of message
	 */
	public int getId() {
		return id;
	}

	@Override
	/**
	 * it compares messages with respect to their body length
	 */
	public int compareTo(Message other) {
		int result=this.getBody().length()-other.getBody().length();
		
		return result;
	}
	/**
	 * if id's are equal that means two messages is the same 
	 * @param o other message that will compare
	 * @return if they are equal or not
	 */
	public boolean equals(Message o) {
		return o.getId()==this.id;
	}
	@Override
	/**
	 * it returns the sender receiver read and received information of message
	 */
	public String toString() {
		String message="\tFrom: "+sender.getId()+" To: "+receiver.getId()+"\n"
				+ "\tReceived: "+this.timeStampReceived+" Read: "+this.getTimeStampRead()+"\n\t"+this.getBody();
		return message;
	}
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

