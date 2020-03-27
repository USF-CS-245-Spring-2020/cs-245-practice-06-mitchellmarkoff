public class LinkedList <T> implements List<T> {

    class Node<T> {
        T data; 
        Node next; 

        public Node(Object data){
            this.data = (T) data; 
        }
    }

	Node<T> head; 
	int size; 

	public LinkedList(){
		T head = null; 
		int size = 0; 
	}
	

	public void add(int pos, T item){
		if(pos>size|| pos<0){
			throw new IndexOutOfBoundsException("Out of bounds");
		}

		if(pos == 0) {
			Node current = new Node(item);
			current.next = head; 
			head = current; 
			++size; 
		} else {
			Node current = new Node(item); 
			Node temp = head; 
			for(int i = 0; i <pos-1; i++){
				temp = temp.next; 
			}
			current.next = temp.next; 
			temp.next = current; 
			++size; 
		}
	}

	public void add(T item) {
		if(head == null) {
			head = new Node(item); 
			++size; 
		} else {
			Node temp = head; 
			while(temp.next != null) {
				temp = temp.next; 
			}
		
			Node current = new Node(item); 
			temp.next = current; 
			++size; 

		}
	}

    public int size(){
		return size; 
	}

	public T remove(int pos)throws IndexOutOfBoundsException{
		if(pos > size-1 || pos <0){
			throw new IndexOutOfBoundsException("Index out of bounds"); 
		}
		if(pos == 0){
			T temp = (T) head.data; 
			head = head.next; 
			size--; 
			return temp; 
		}
		else{
			Node temp = head; 
			for(int i =0; i < pos-1; i++){
				temp = temp.next; 
			}
			Node current = temp.next;
			T item = (T) current.data; 
			size--; 
			return item; 
		}
	}

    public T get(int pos)throws IndexOutOfBoundsException{
		if(pos>=size||pos<0){
			throw new IndexOutOfBoundsException("Index out of bounds"); 
		}
		Node temp = head;  
		for(int i =0; i <pos; i++) {
			temp = temp.next; 
		}
		return (T) temp.data; 

	}

	
}