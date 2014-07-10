package TopCoder;
public class CatAndRat {

	public double getTime(int R, int T, int Vrat, int Vcat) {
		double dist=2*Math.PI*R;
		double mindist=T*Vrat;
		if(T*Vrat>dist/2){
			mindist=dist/2;
		}
		if(Vcat>Vrat){
			Vcat-=Vrat;
			return mindist/Vcat;
		}
		
		if(Vrat>=Vcat)
			return -1;
		
		return 0.0;
	
	}

}
