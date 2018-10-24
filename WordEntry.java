class WordEntry{
	MyLinkedList<Position> llist;
	String word;
	WordEntry(String word){
		llist = new MyLinkedList();
		this.word = word;
	}
	public void addPosition(Position position){
		llist.addLast(position);
	}
	public void addPositions(MyLinkedList<Position> positions){
		while(!positions.isEmpty()){
			llist.addLast((positions.removeFirst()));	
		}
	}
	public MyLinkedList<Position> getAllPositionsForThisWord(){
		return llist;
	}
	float getTermFrequency(String word){
		int size = llist.getSize();
		return size; 
	}
}