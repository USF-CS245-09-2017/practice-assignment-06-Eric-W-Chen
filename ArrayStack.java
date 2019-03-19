public class ArrayStack<String> implements Stack<String> {

	Object[] tempArray = new Object[10];
	String[] arr = (String[]) tempArray;
	int top = -1;

	@Override
	public String pop(){
		if(empty()){
			throw new RuntimeException();
		}
		return arr[top--];
	}

	@Override
	public String peek(){
		if(empty()){
			throw new RuntimeException();
		}
		return arr[top];
	}

	@Override
	public void push(String t){
		if(top >= (arr.length-1)){
			grow_array();
		}
		arr[++top] = t;
	}

	@Override
	public boolean empty(){
		if(top == -1){
			return true;
		}
		return false;
	}

	protected void grow_array(){
		Object[] tempArray = new Object[arr.length*2];
		String[] temp = (String[]) tempArray;
		for(int i=0; i<arr.length;i++){
			temp[i] = arr[i];
			}
			arr=temp;
	}
}