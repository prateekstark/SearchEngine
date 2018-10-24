class PageIndex{
	public MyLinkedList<WordEntry> wordList;
	//public MyLinkedList<WordEntry> wordListReal;
	public PageIndex(){
		wordList = new MyLinkedList<WordEntry>();
		//wordListReal = new MyLinkedList<WordEntry>();
	}
	public void addPositionForWord(String str, Position p){
		MyLinkedList<WordEntry>.Node<WordEntry> temp = wordList.head;
		boolean flag = false;
		while(temp != null){
			if(temp.data.word.equals(str)){
				temp.data.addPosition(p);
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(!flag){
			WordEntry newWord = new WordEntry(str);
			wordList.addLast(newWord);
			newWord.addPosition(p);
		}
	}
	public MyLinkedList<WordEntry> getWordEntries(){
		return wordList;
	}
}