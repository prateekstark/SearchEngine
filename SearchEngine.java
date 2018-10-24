import java.util.*;
class SearchEngine{
	public InvertedPageIndex search;
	public SearchEngine(){
		search = new InvertedPageIndex();
	}
	private String valid(String x){
        String answer =  x.toLowerCase();
        if(answer.equals("stacks")){
            answer = "stack";
        }
        else if(answer.equals("structures")){
            answer = "structure";
        }
        else if(answer.equals("applications")){
            answer = "application";
        }
        return answer;
	}
	public void performAction(String actionMessage){
		Scanner sc = new Scanner(actionMessage);
		String action = sc.next();
		switch(action){

			case "addPage":
			
				String x = sc.next();
				x = valid(x);
				PageEntry a = new PageEntry(x);
				search.addPage(a);
	
				break;
			
			case "queryFindPagesWhichContainWord":
			
				String x1 = sc.next();
				x1 = valid(x1);
				Myset<PageEntry> ans = search.getPagesWhichContainWord(x1);
				String ajeeb = "";
				if(ans.llist.isEmpty()){
					System.out.println("No webpages contains word " + x1);
				}
				else{
                    int size = ans.llist.getSize();
                    for(int i=0;i<size;i++){
                    	if(i != size-1){
                    		ajeeb = ajeeb + ans.llist.get(i).data.pageName + ", ";
                    	}
                    	else{
                    		ajeeb = ajeeb + ans.llist.get(i).data.pageName;
                    	}
        			}
        		
        		

        			System.out.println(ajeeb);	
                }
                break;
			
			//return page entry
			case "queryFindPositionsOfWordInAPage":
		
				String x2 = sc.next();
				String y = sc.next();
				x2 = valid(x2);
				PageEntry b = search.givepage(y);
				if(b!=null)
				{
					MyLinkedList<WordEntry>.Node<WordEntry> temp = b.myPageIndex.wordList.head;
							while(temp != null){
								if(temp.data.word.equals(x2)){
									//System.out.println("afd0");
									MyLinkedList<Position>.Node<Position> temp2 = temp.data.llist.head;
									while(temp2 != null){
								//if(b.pageName.equals(temp2.data.p.pageName)){
										System.out.println(temp2.data.i);
								
										temp2 = temp2.next;
									}
									break;
								}
								temp = temp.next;
							}	
				if(temp == null)
					System.out.println("No word position found");
				}
				else
					System.out.println("Webpage not found");
				break;

			case: "queryFindPagesWhichContainAllWords":
			break;

			case: "queryFindPagesWhichContainAnyOfTheseWords":
			break;

			case: "queryFindPagesWhichContainPhrase":
			break;
		}
	}
}