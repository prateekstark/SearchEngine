public class Myset<E>{
	public MyLinkedList<E> llist;
	Myset(){
		llist = new MyLinkedList();
	}
	public boolean isEmpty(){
		return llist.isEmpty();
	}
	public boolean isMember(MyLinkedList.Node e){
		return llist.isMember(e);
	}

	public boolean isMember(E e){
		return llist.isMember(e);
	}

	public void addElement(MyLinkedList.Node e){
		if(llist.isMember(e)){
			return;
		}
		llist.addLast(e);
	}
	public void Insert(MyLinkedList.Node e){
		if(llist.isMember(e)){
			return;
		}
		llist.addLast(e);
	}

	public void Insert(E o) {
		MyLinkedList<E> nakli = new MyLinkedList<E>(); 
		MyLinkedList<E>.Node<E> temp = nakli.new Node<E>(o,null);
		if(llist.isMember(temp)){ //Check for is member
			return;
		}
		llist.addLast(temp);	
	}
	public void Delete(MyLinkedList.Node e){
		MyLinkedList.Node temp = llist.head;
		MyLinkedList.Node temp1;
		MyLinkedList.Node temp2 = temp;
		if(temp == null){
			return;
		}
		while(temp != null){
			if(temp.data == e.data){
				llist.size--;
				temp1 = temp.next;
				temp2.next = temp1;
				return;
			}
			temp2 = temp;
			temp = temp.next;
		}
	}
	public int getSize(){
		return llist.getSize();
	}
	public Myset Union(Myset a){
		Myset c = new Myset();
		MyLinkedList.Node temp1 = llist.head;
		MyLinkedList.Node temp2 = a.llist.head;
		int i,j;
		for(i=0;i<llist.getSize();i++){
			if(temp1 != null){
				c.llist.addLast(temp1);
				temp1 = temp1.next;
			}
		}
		for(i=0;i<a.llist.getSize();i++){
			c.addElement(temp2);
			temp2 = temp2.next;
		}
		return c;
	}
	public Myset Intersection(Myset a){
		MyLinkedList.Node temp = llist.head;
		Myset c = new Myset();
		for(int i=0;i<llist.getSize();i++){
			if(temp != null){
				if(a.isMember(temp)){
					c.addElement(temp);
				}
				temp = temp.next;
			}
		}
		return c;
	}
	public static void printSet(Myset a){
		int i;
		MyLinkedList.Node temp = a.llist.head;
		if(temp == null){
			return;
		}
		for(i=0;i<a.llist.getSize();i++){
			if(temp != null){
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
		return;
	}
}