
public class food {

	public int type;
	public int quantite;
	public int h;
	public int w;
	public int energie;
	
	public food(int x,int y,int t){
		h=x;
		w=y;
		type=t;
		if(t==1){
		quantite=5;energie=2;}
		if(t==2){
		quantite=2;energie=5;}
		
	}
	public int consommer(int q){
		int r=0;
		if((q>0)&&(q<quantite+1)){
			r=q*energie;
			quantite=quantite-q;
		}
		
		return r;
	}
	public int Typage(){
		return 0;
	}
}
