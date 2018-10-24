 import java.lang.*;
 class InvertedPageIndex{
	public MyHashTable webSet;
	public Myset<PageEntry> pageSet;

	public InvertedPageIndex(){
		webSet = new MyHashTable();
		pageSet = new Myset<PageEntry>();
	}
	public void addPage(PageEntry p){
		MyLinkedList<PageEntry> nakli = new MyLinkedList<PageEntry>();
		MyLinkedList<PageEntry>.Node<PageEntry> temp1 = nakli.new Node<PageEntry>();
		temp1.data = p;
		pageSet.Insert(temp1);
		MyLinkedList<WordEntry> temp = p.myPageIndex.wordList;
		MyLinkedList<WordEntry>.Node<WordEntry> temp2 = temp.head;
		while(temp2 != null){
			webSet.addPositionsForWord(temp2.data);
			temp2 = temp2.next;

		}
		//System.out.println("ght");
	}
	public Myset<PageEntry> getPagesWhichContainWord(String str){
		Myset answer = new Myset<PageEntry>();
		int a = webSet.computeHashFunction(str);
		MyLinkedList<WordEntry>.Node<WordEntry> temp = webSet.wordHash[a].list.head;
		while(temp != null){
			if((((WordEntry)temp.data).word).equals(str)){
				MyLinkedList<Position>.Node<Position> temp2 = ((WordEntry)(temp.data)).llist.head;
				while(temp2 != null){
					answer.Insert((temp2.data).p);
					temp2 = temp2.next;
				}
			}
			temp = temp.next;
		}
		return answer;
	}
	public PageEntry givePage(String str){
		MyLinkedList<PageEntry>.Node<PageEntry> temp  = this.pageSet.llist.head;
		while(temp!= null){
			if(temp.data.pageName.equals(str))
				return temp.data;
			temp = temp.next;
		}
		return null;
	}
	/*MySet<PageEntry>getPagesWhichContainPhrase(String str[]):
Return a set of page-entries for webpages which contain a sequence
of non-connector words (str[0] str[1] ... str[str.len-1]).
Assume a webpage which contains the following text: \Data struc-
tures is the study of structures for storing data." This webpage
contains the phrases: \Data structures", \Data structures study",
and \Data structures study structures".*/
	public Myset<PageEntry> getPagesWhichContainPhrase(String str[]){
		Myset<PageEntry> answer = new Myset<PageEntry>();
		Myset<PageEntry> temp = new Myset<PageEntry>();
		answer = getPagesWhichContainWord(str[0]);
		int i;
		for(i=0;i<str.length;i++){
			temp = getPagesWhichContainWord(str[i]);
			answer = answer.Intersection(temp);
		}
		MyLinkedList.Node temp = answer.llist.head;
		PageEntry a = temp.data;
	}
	public float getInverseDocumentFrequency(String str){
		int N = getPagesWhichContainWord(str).llist.getSize();
		int totalWebpages = pageSet.llist.getSize();
		float a = ((float)(N))/totalWebpages;
		return Math.log(a);
	}
}