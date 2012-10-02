
public class food {

	public int type;
	public int quantite;
	public int h;
	public int w;
	public int energie;
	
	public food(int x,int y,int t){
		h=x;
		w=y;
		if(t==1){
		quantite=5;energie=2;}
		if(t==2){
		quantite=2;energie=5;}
		
	}
}
