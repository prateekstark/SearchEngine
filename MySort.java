public class MySort{
	ArrayList<Sortable> sortThisList(MySet<Sortable> listOfSortableEntries){
		int i;
		MyLinkedList<Sortable> sortedLinkedList;
		int size = listOfSortableEntries.llist.getSize();
		ArrayList<Sortable> answer = new ArrayList<Sortable>();
		int min;
		MyLinkedList<Sortable>.Node<Sortable> temp = listOfSortableEntries.llist.head;
		MyLinkedList<Sortable>.Node<Sortable> minNode = listOfSortableEntries.llist.head;
		for(i=0;i<size;i++){
			temp = listOfSortableEntries.llist.head;
			for(j=0;j<listOfSortableEntries.llist.getSize();j++){
				if(minNode.data.getNumber()>temp.data.getNumber()){
					minNode = temp;
					temp = temp.next;
				}
			}
			answer.add(minNode);
			listOfSortableEntries.Delete(minNode);
		}
	}
}