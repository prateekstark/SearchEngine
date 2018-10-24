import java.util.*;
import java.io.*;
class PageEntry{
	String pageName;
	PageIndex myPageIndex;
	int totalWords = 0;
	public PageEntry(String str){
		this.pageName = str;
		myPageIndex = new PageIndex();		 
		try {
			FileReader file = new FileReader(str);
		 	BufferedReader br = new BufferedReader(file); 
			int count = 0;
			int realCount = 0;
			//Scanner s = new Scanner(file);
			String temp = br.readLine(); 
			while (temp!=null){ 
				
				int n = temp.length();
				for(int i=0;i<n;i++){
					if(temp.charAt(i) == '{' || temp.charAt(i) == '}' || temp.charAt(i) == '[' || temp.charAt(i) ==']'|| temp.charAt(i) =='<' || temp.charAt(i) =='>' || temp.charAt(i) =='=' || temp.charAt(i) =='(' || temp.charAt(i) ==')' ||temp.charAt(i) =='.' || temp.charAt(i) ==',' || temp.charAt(i) ==';'||temp.charAt(i) =='\'' || temp.charAt(i) =='\"' || temp.charAt(i) =='?' || temp.charAt(i) =='#' || temp.charAt(i) =='!' || temp.charAt(i) =='-' || temp.charAt(i) ==':')
					{
						if(i==0){
							temp = " " + temp.substring(1,temp.length());
						}
						else{
							if(i==temp.length()-1){
								temp = temp.substring(0,temp.length()-1)+" ";
							}
							else{
								temp = temp.substring(0,i)+ " "+ temp.substring(i+1,temp.length());
							}
						}
					}
				}
				Scanner sc = new Scanner(temp);
				while(sc.hasNext()){
					totalWords++;
					String te = sc.next();
					te = te.toLowerCase();
					switch(te){
						case "a":
						case "an":
						case "the":
						case "they":
						case "these":
						case "this":
						case "for":
						case "is":
						case "are":
						case "was":
						case "of":
						case "or":
						case "and":
						case "does":
						case "will":
						case "whose":
							count++;
							te = " ";
							break;
					}
					if(te != " "){
						realCount++;
						count++;
						//Position q = new Position(this,count);
						Position q = new Position(this,count,realCount);
						myPageIndex.addPositionForWord(te,q);
					}
				}
				temp = br.readLine();
			}
		}
		catch(Exception e) {
			System.out.println("Page not found");
		}
	}

	public int wordOccurance(String str){
		MyLinkedList.Node temp = myPageIndex.wordlist.head;
		if((temp.data.word).equals(str)){
			return temp.llist.getSize();
		}
	}
	public float getTermFrequency(String str){
		if(totalWords!=0){
			return ((float)wordOccurance(str))/totalWords;
		}
	}

	public PageIndex getPageIndex(){
		return myPageIndex;
	}



	/*
Implement the following method in the PageEntry class.
– float getRelevanceOfPage(String str[ ], boolean doThese-
WordsRepresentAPhrase): Return the relevance of the webpage
for a group of words represented by the array str[ ]. If the flag
doTheseWordsRepresentAPhrase is true, it means that the words
represent a phrase; otherwise the words are part of a complex
query (AND/OR).*/
	//float
	float getRelevanceOfPage(String str[], boolean doTheseWordsRepresentAPhrase){
		if(!doTheseWordsRepresentAPhrase){
			float tf = getTermFrequency(str[0]);
			float idf = 
			


		}
	}
}