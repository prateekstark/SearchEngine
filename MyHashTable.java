public class MyHashTable{
	public listNode[] wordHash;
	MyHashTable(){
		wordHash = new listNode[26];
		int i;
		for(i=0;i<26;i++){
			wordHash[i] = new listNode();
			wordHash[i].list = new MyLinkedList<WordEntry>();
		}
	}
	class listNode{
		MyLinkedList<WordEntry> list;
	}
	
	public int computeHashFunction(String str){
		int a1 = (int)str.charAt(0);
		int hashIndex = (a1)%26;
		return hashIndex;
	}
	public void addPositionsForWord(WordEntry w){
		int tempHash = computeHashFunction(w.word);
		MyLinkedList<WordEntry>.Node<WordEntry> temp = wordHash[tempHash].list.head;
		boolean flag = false;
		while(temp != null){
			WordEntry a = (WordEntry)(temp.data);
			if((a.word).equals(w.word)){
				a.addPositions(w.llist);
				flag = true;
			}
			temp = temp.next;
		}
		if(!flag){
			wordHash[tempHash].list.addLast(w);
		}
	}
}