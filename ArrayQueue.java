import java.util.NoSuchElementException;
import java.util.Arrays;

public class ArrayQueue<String> implements Queue<String> {

	int head;
	int tail;
	int current = 0;
	Object[] tempArray = new Object[10];
	String[] arr = (String[]) tempArray;


	public String dequeue(){
		if(empty()){
			throw new NoSuchElementException();
		}
		String temp = arr[head];
		head = (head+1)%arr.length;
		current--;
		return temp;
	}

	public void enqueue (String t){
		if((tail+1)%arr.length == head){
			grow_array();
		}
		arr[tail++] = t;
		tail = tail%arr.length;
		current++;	
	}

	public boolean empty(){
		if(head == tail){
			return true;
		}
		return false;
	}

	protected void grow_array(){
		Object[] tempArray = new Object[arr.length*2];
		String[] temp = (String[]) tempArray;
		int tempHead = head;
		int index = -1;
		while(tempHead != tail){
			temp[++index] = arr[tempHead];
			tempHead++;
			if(tempHead == arr.length){
				tempHead = 0;
			}
			if(current == index+1){
				break;
			}
		}
		arr = temp;
		head = 0;
		tail = index + 1;
	}
}