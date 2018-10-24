public class SearchResult{
	public PageEntry p;
	public float relevance;
	public SearchResult(PageEntry p, float r){
		this.p = p;
		this.relevance = r;
	}
	public PageEntry getPageEntry(){
		return p;
	}
	public float getRelevance(){
		return relevance;
	}

	public int compareTo(SearchResult otherObject){
		
	}









}