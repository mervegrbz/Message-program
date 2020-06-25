
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package elements;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
/**
 * This server has capacity and current size and each of the is sum of the length of the bodies of messages. server has msgs 
 * queue which holds messages that in server.
 * @author merve
 *
 */
public class Server{
	/**
	 * the capacity of server
	 */
	private long capacity;
	/**
	 * the sum of the whole messages body length
	 */
	private long currentSize;
	/**
	 * the queue that  holds messages
	 */
	private Queue<Message>msgs;
	/**
	 * the warning message if the current size exceeds 50 or 80& of capacity
	 */
	private String warningmsg ="";
	/**
	 * printstream object that writes results to output file
	 */
	public PrintStream output;

	/**
	 * it is the constructor class of server which takes capacity as parameter
	 * @param capacity capacity of the server
	 */ 
	public Server(long capacity) {
		this.capacity=capacity;
		msgs=new ArrayDeque<Message>();
		currentSize=0;
	}
	
	/**
	 * it sets the current size of server
	 * @param currentSize the current size of server
	 */
	public void setCurrentSize(long currentSize) {
		this.currentSize = currentSize;
	}
	/**
	 * it returns the msgs queue
	 * @return the message queue
	 */
	public Queue<Message> getMsgs() {
		return msgs;
	}
	/**
	 * it sets the msgs queue of server
	 * @param msgs the new queue of msgs
	 */
	public void setMsgs(Queue<Message> msgs) {
		this.msgs = msgs;
	}
	/**
	 * Warnings are made only once when 50%
     *or 80% is achieved. As stated, the overall capacity and the allocated capacity of the
     *server is represented through the size of the messages as the number of characters
     *in total. Whenever the utilization of the server exceeds 50% or 80% it prints the warning message but it does not write the warning messages again and again if warning type is not changed.
     *and if it exceeds the capacity it flushes the server msgs queue
	 * @param printer the printstream that writes result to output txt
	 */
	public void checkServerLoad(PrintStream printer) {
		double ratio=currentSize*100.0/capacity;
		int op=0;
		if(ratio>=50&&ratio<80)
			op=5;
		else if(ratio>=80)
			op=8;
		else {
			op=0;
			warningmsg="";
		}
		String yazii="Warning! Server is ";
		if(!warningmsg.equals("%50")&&op==5) {
			warningmsg="%50";
			printer.println(yazii+ "50% full.");
		}
		else if(op==8&&!warningmsg.equals("80%")) {
			warningmsg="80%";
			printer.println(yazii+ warningmsg+" full.");
			
		}else if(currentSize>=capacity) {
			this.flush();
			System.out.println("flushed");
			printer.println("Server is full. Deleting all messages...");
			}
		
		
			
		
	}
	/**
	 * it enables to reach current size
	 * @return current size of server
	 */
	
	public long getCurrentSize() {
		
		return this.currentSize;
	}
	/**
	 * it deletes all the messages of server
	 */
	public void flush() {
		currentSize=0;
		msgs.clear();
		warningmsg="";
	}
	/**
	 * it adds the given message to the server queue
	 * @param msg the message body
	 * @param printer printer that will write result to output
	 */
	public void addMessage(String msg,PrintStream printer) {
		currentSize+=msg.length();
		checkServerLoad(printer);
		
	}
	/**
	 * it removes the given message from server queue
	 * @param msg the message that will be removed
	 * @param output the printstream that will write result
	 */
	public void remove(Message msg,PrintStream output) {
		currentSize-=msg.getBody().length();
		checkServerLoad(output);
	}
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

