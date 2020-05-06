import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Queue {
	
	public PriorityQueue <Client> clients;
	public int length;
	public int queueNumber;
	public Client headClient;
	
	public Queue(int queueNumber) {
		this.clients = new PriorityQueue <Client> ((a,b) -> a.getRank() - b.getRank());
		this.length = 0;
		this.queueNumber = queueNumber;
	}
	
	public void addClient(Client c) {
		try {
		c.setRank(this.clients.size() + 1);
		this.clients.add(c);
		this.length ++;
		} catch(NullPointerException e) {
			
		}
	}
	
	public void showClients() {
		Iterator <Client> it = this.clients.iterator();
		int i = 0;
		while(it.hasNext()) {
			Client curr = it.next();
			i++;
			System.out.println("Client #" + i + ": " + curr.arrivalTime + "  " + curr.rank);
		}
	}
	
	public Client extract() {
		Client c;
		if((c = this.clients.poll()) == null) {
			//System.out.println("ERROR: Extracted from empty queue");
			return null;
		}
		else {
			Iterator <Client> it = this.clients.iterator();
			while(it.hasNext()) {
				it.next().decreaseRank();
			}
		}
		this.length --;
		return c;
	}
	
	public String toString() {
		String s = new String();
		if(!this.clients.isEmpty()) {
		Iterator <Client> it = this.clients.iterator();
		while(it.hasNext()) {
			Client currClient = it.next();
			if(currClient != null)
			s = s + currClient.arrivalTime;
			s = s + "  ";
		}
		}
		return s;
	}
	public boolean isEmpty() {
		if(this.length == 0)
			return true;
		return false;
	}

	
}
