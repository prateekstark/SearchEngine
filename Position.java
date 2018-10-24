public class Position{
	public PageEntry p;
	public int i;
	public int realWorldIndex;
	Position(PageEntry a, int b){
		this.p = a;
		this.i = b;
	}
	Position(PageEntry a, int b, int c){
		this.p = a;
		this.i = b;
		this.realWorldIndex = c;
	} 
	public PageEntry getPageEntry(){
		return p;
	}
	public int getWordIndex(){
		return i;
	}
	public int getRealWorldIndex(){
		return realWorldIndex;
	}
}