package math_box;

import java.util.ArrayList;
import java.util.List;

import Jama.*;
public class Facteurs {
        MatriceCalculsImp MatCal=new MatriceCalculsImp();
        private  USV usv;
	    private double[][] M_residus_stand;
		private double[][] data;	
		public Facteurs(double[][] matrix) {
			
			this.data=matrix;
			
		}

		public Facteurs(List<Vector> M) {
			this.data=new double[M.size()][M.get(0).getCoordinates().length];
			for(int i=0;i<M.size();i++)
			{  
				for(int j=0;j<M.get(0).getCoordinates().length;j++)
				{  
					data[i][j]=M.get(i).getCoordinates()[j];
					
				}
				
			}
			
		}
		private void calculateM_residus() {
			 this.M_residus_stand=MatCal.getM_residus(data);
			 
			
				
		 }
		
		 public USV getUsv() {
			 getDecompositionUSV();
				return usv;
			}

			public double[][] getM_residus_stand() {
				calculateM_residus();
				//System.out.println(M_residus_stand[0][0]);
				return M_residus_stand;
			}
		public void getDecompositionUSV() {
			 Matrix A = new Matrix(M_residus_stand);
		      SingularValueDecomposition dempstion=new SingularValueDecomposition(A);
		     
		      usv=new USV(new matrix(dempstion.getU().getArray()),dempstion.getSingularValues(),new matrix(dempstion.getV().getArray()));
		}

		public double[][] getProjModligne() {
			getDecompositionUSV();
			int a=0;
			double b=0;
			double[][] ProjModligne=new double[data.length][usv.getS().length-1];
			for(int i=0;i<data.length;i++)
			{
				for(int j=0;j<usv.getS().length-1;j++)
				{   a=(int)((usv.getU().getCoordinates()[i][j]*usv.getS()[j])/Math.sqrt(MatCal.getFrequenLigne(data)[i])*100);
				    b=a/100.0;
					ProjModligne[i][j]=b;
				}
			}
			return ProjModligne;
		}
		public double[][] getProjModColonne() {
			getDecompositionUSV();
			int a=0;
			double b=0;
			double[][] ProjModColonne=new double[data[0].length][usv.getS().length-1];
			for(int i=0;i<data[0].length;i++)
			{
				for(int j=0;j<usv.getS().length-1;j++)
				{   a=(int)((usv.getV().getCoordinates()[i][j]*usv.getS()[j])/Math.sqrt(MatCal.getFrequencolon(data)[i])*100);
				    b=a/100.0;
					ProjModColonne[i][j]=b;
				}
			}
			return ProjModColonne;
		}
}
