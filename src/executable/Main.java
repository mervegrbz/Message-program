
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
package executable;

import java.io.*;
import java.util.*;
import elements.*;
import boxes.*;
/**
 * the main class reads te input file and with respect to gicen order executes the method and writes it to output file.
 * the first three input are number of users number of queries and the capatiy of server.
 *The next lines are the queries. there are 10 type queries which are:
 *1)send message
 *2)receive message
 *3)read certain amount messages
 *4) read all messages from a sender
 *5) read a specific message
 *6)add friend
 *7)remove friend
 *8)flush server
 *9)print current size
 *10)print last message that a user read
 *While proceeding these queries time variable is increased after each query. Only read message queries changes time the amount of read messages.
 * The outputs are written to the output txt file.
 *
 * @author merve gurbuz
 *
 */

public class Main{
	/**
	 * static time variable which changes by queries
	 */
	static int time=0;
	/**
	 * The main method is where all the operations executed according to given inputs.
	 * @param args the arguments that scanner and printStream objects will take
	 * @throws FileNotFoundException it throws this exception if files are not found.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner input=new Scanner(new File(args[0]));
		PrintStream output=new PrintStream(new File(args[1]));
		
		
		int numberOfUsers=input.nextInt();
		int operations=input.nextInt();
		int capacityOfServer=input.nextInt();
		Server server =new Server(capacityOfServer);
		server.output=output;
		
		ArrayList<User> userList=new ArrayList<>();
		for(int i=0; i<numberOfUsers;i++) 
			userList.add(new User(i));
			
		
	
		for(int i=0;i<operations;i++) {
			int type=input.nextInt();
			switch(type) {
			case(0):
				int senderID=input.nextInt();
				int receiverID=input.nextInt();
				
				String msgBody=input.nextLine();
				if(msgBody.charAt(0)==' ')
					msgBody=msgBody.substring(1);
				
				userList.get(senderID).sendMessage(userList.get(receiverID),msgBody, time, server);				
				server.addMessage(msgBody, output);
				time++;
				break;
			case(1)://receive all messages
				int receiver_ID=input.nextInt();
				
				userList.get(receiver_ID).getInbox().receiveMessages(server, time);
				server.checkServerLoad(output);
				time++;
				break;
			case(2)://read a certain amount of message
				int receiverid=input.nextInt();
				int numberOfMsg=input.nextInt();
				time=userList.get(receiverid).getInbox().readMessages(numberOfMsg, time);
				break;
			case(21)://read all messages from a sender
				int receive=input.nextInt();
				int sender_id=input.nextInt();
				time=userList.get(receive).getInbox().readMessages(userList.get(sender_id), time);
				break;
			case(22)://read specific id
				int receiveId=input.nextInt();
				int messageID=input.nextInt();
				userList.get(receiveId).getInbox().readMessage(messageID, time);
				time++;
				break;
			case(3)://make friend
				int id1=input.nextInt();
				int id2=input.nextInt();
				userList.get(id1).addFriend(userList.get(id2));
				time++;
				break;
			case(4):
				int id_1=input.nextInt();
				int id_2=input.nextInt();
				userList.get(id_1).removeFriend(userList.get(id_2));
				time++;
				break;
			case(5):
				server.flush();
				
				time++;
				break;
			case(6):
				output.println("Current load of the server is "+server.getCurrentSize()+" characters.");
				time++;
				break;
			case(61):
				int user_id=input.nextInt();
				Inbox inbox=userList.get(user_id).getInbox();
				if(inbox.getRead().size()!=0) {
					output.println(((ArrayDeque<Message>) inbox.getRead()).getLast().toString());
					
					}
				time++;
				break;
		
			}
		}
	}
	
	
}



//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

