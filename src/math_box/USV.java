package math_box;

public class USV {

	private matrix U;
	private double[] S;
	private matrix V;
	
	public USV(matrix U,double[] S,matrix V){
		this.setU(U);
		this.setS(S);
		this.setV(V);
	}

	public matrix getU() {
		return U;
	}

	public void setU(matrix u) {
		U = u;
	}

	public double[] getS() {
		return S;
	}

	public void setS(double[] s) {
		S = s;
	}

	public matrix getV() {
		return V;
	}

	public void setV(matrix v) {
		V = v;
	}
	public String toString() {
		String str=new String();
		int a;
		double b;
		str="La matrice U  :\n\t\t[";
		for (int i = 0; i < U.getCoordinates().length; i++) {
			str+="[ ";
			for (int j = 0; j <U.getCoordinates()[0].length; j++) {
				a=(int)(U.getCoordinates()[i][j]*100);
				b=(double)a/100;
				str+=b;
				if(j!= U.getCoordinates()[0].length-1) {
					str+=" , ";
				}
					
					
			}
			if(i!= U.getCoordinates().length-1) {
				str+=" ]\n\t\t";
			}
			else {
				str+=" ]]\n";
			}
		}
		str+=" \n\n";
		
		str+="les valeurs singulier :\n\t\t[";
		for (int i = 0; i < S.length; i++) {
			a=(int)(S[i]*100);
			b=(double)a/100;
			str+=b;
			if(i!= S.length-1) {
				str+=" , ";
				
			}
			else{str+="]\n\n";	}	
		
		
		}
		
		str+="La matrice V  :\n\t\t[";
		for (int i = 0; i < V.getCoordinates().length; i++) {
			str+="[ ";
			for (int j = 0; j <V.getCoordinates()[0].length; j++) {
				a=(int)(V.getCoordinates()[i][j]*100);
				b=(double)a/100;
				str+=b;
				if(j!= V.getCoordinates().length-1) {
					str+=" , ";
				}
					
					
			}
			if(i!= V.getCoordinates()[0].length-1) {
				str+=" ]\n\t\t";
			}
			else {
				str+=" ]";
			}
		}
		str+=" ]\n\n";
		return str;
	}
	

}
