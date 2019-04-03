package intern;
import java.util.*;
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		PriorityQueue<Event> epq = new PriorityQueue<Event>(new EventComparator());
		String input;
		for(int i = 0; i< n; i++){
			input = sc.nextLine();
			if(input.equals("SERVED")){
				epq.poll();
			}else{
				String[] arr = input.split(" ");
				if(arr[0].equals("ENTER")) 
					epq.add(new Event(arr[1], Double.valueOf(arr[2]), Integer.valueOf(arr[3])));
			}
		}
		while(!epq.isEmpty()){
			System.out.println(epq.poll().name);
		}
	}

}

class EventComparator implements Comparator<Event>{
	public int compare(Event e1, Event e2){
		if(e1.cgpa < e2.cgpa){
			return 1;
		}else if(e1.cgpa > e2.cgpa){
			return -1;
		}else if(!e1.name.equals(e2.name)){
			return e1.name.compareTo(e2.name);
		}else{
			return e1.token-e2.token;
		}
	}
}

class Event{
	public String name;
	public double cgpa;
	public int token;
	
	public Event(String name, double cgpa, int token){
		this.name = name;
		this.cgpa = cgpa;
		this.token = token;
	}
}