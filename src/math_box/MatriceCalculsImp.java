package math_box;

import java.util.List;

public class MatriceCalculsImp implements MatriceCalculs{
    private double[][] data;
    
    private double[] freqlines;
    
    private double[] freqcols;
    
	public  double[][] initializeMatrix(double M[][])
	{   data=new double[M.length][M[0].length];
	    freqlines=new double[M.length];
	    freqcols=new double[M[0].length];
		data=M;
		return data;
	}
    public int getEffectif(double M[][]) {
    	 int n=0;
         /*calcule d'effictif totale */
    		for(int i=0;i<M.length;i++)
    		{
    			for(int j=0;j<M[0].length;j++)
    			{
    				n+=M[i][j];
    			}
    		}
    	
    	return n;
    }
	//calcul des frequence
	public  double[][] getfrequences(double M[][])
	{
		
		double freq[][]=new double[M.length][M[0].length];
        int n=getEffectif(M);
		
	/*	calcule matrice de frequence */
		for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				freq[i][j]=M[i][j]/n;
				
			}
		}
	
		return freq;
	}
	//calcule des frequences marginal ligne
    public double[] getFrequenLigne(double M[][]) 
    {   
    	double[][] freq=getfrequences(M);
    	freqlines=new double[M.length];
    	for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				freqlines[i]+=freq[i][j];
			}
		}
     return freqlines;
    }
  //calcule des frequences marginal colone
    public double[] getFrequencolon(double[][] m) 

    {   
    	freqcols=new double[m[0].length];
    	double[][] freq=getfrequences(m);
    	for(int i=0;i<m[0].length;i++)
		{
			for(int j=0;j<m.length;j++)
			{
				freqcols[i]+=freq[j][i];
			}
		}
    	return freqcols;
    }
    //calcule effectif ligne 
    public double[] getEffictifLigne(double[][] M) 
    {   double[] EffLine=new double[M.length];
    	for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				EffLine[i]+=M[i][j];
			}
		}
    	return EffLine;
    }
    
    //calcule effectif colonne
    public double[] getEffictifCol(double M[][]) 
    {   double[] Effcol=new double[M[0].length];
    	for(int j=0;j<M[0].length;j++)
		{
			for(int i=0;i<M.length;i++)
			{
				Effcol[j]+=M[i][j];
			}
		}
    	return Effcol;
    }
  //calcule profile ligne
	public  double[][] getlinesprofils(double M[][])
	{
		double[][] proflines=new double[M.length][M[0].length];
		double[] EffLine=getEffictifLigne(M);
		
		for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				proflines[i][j]=M[i][j]/EffLine[i];
			}
		}
		
		return proflines;
	}
     //calcule distance entre profil ligne
	public  double[][] getDistancesProfileLines(double M[][])
	{   double[][] Disligne=new double[M.length][M.length];
	    double[] frq_col=getFrequencolon(M);
	    double[][] profilLigne=getlinesprofils(M) ;
		for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M.length;j++)
			{
				for(int k=0;k<M[0].length;k++)
				{
					Disligne[i][j]+=(1/frq_col[k])*Math.pow(profilLigne[i][k]-profilLigne[j][k], 2);
				}
			}
		}
		return Disligne;
	}
	//calcul distance a l'origine des ligne
	public  double[] getOriginDistancesProfileLines(double M[][])
	{
		double[] DisligneOrigin=new double[M.length];
	    double[] frq_col=getFrequencolon(M);
	    double[][] profilLigne=getlinesprofils(M) ;
		for(int i=0;i<M.length;i++)
		{
				for(int k=0;k<M[0].length;k++)
				{
					DisligneOrigin[i]+=(1/frq_col[k])*Math.pow(profilLigne[i][k]-frq_col[k], 2);
				}
		}
		return DisligneOrigin;
	}
	//calcul inertie ligne
    public double[] getInertieLigne(double M[][]) {
    	double [] InertieLigne=new double[M.length];
    	double[] freqligne=getFrequenLigne(M);
    	double[] distOrigine=getOriginDistancesProfileLines(M);
    	int n=getEffectif(M);
    	for(int i=0;i<M.length;i++) {
    		InertieLigne[i]=distOrigine[i]*freqligne[i]/n;
    	}
    	return InertieLigne;
    	
    }
    //calcule profile colone
 	public  double[][] getcolonesprofils(double M[][])
	{
		double[][] profcols=new double[M.length][M[0].length];
		double[] Effcol=getEffictifCol(M);
		
		for(int i=0;i<M.length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				profcols[i][j]=M[i][j]/Effcol[j];
			}
		}
		
		return profcols;
	}
 	//calcule distance entre profils colone
	public  double[][] getDistancesProfilecolone(double M[][])
	{
		double[][] Discol=new double[M[0].length][M[0].length];
	    double[] frq_ligne=getFrequenLigne(M);
	    double[][] profilcol=getcolonesprofils(M) ;
		for(int i=0;i<M[0].length;i++)
		{
			for(int j=0;j<M[0].length;j++)
			{
				for(int k=0;k<M.length;k++)
				{
					Discol[i][j]+=(1/frq_ligne[k])*Math.pow(profilcol[k][i]-profilcol[k][j], 2);
				}
			}
		}
		return Discol;
	}
	//calcul la distance a l'origine des collone
	public  double[] getOriginDistancesProfilecolone(double M[][])
	{

		double[] DiscolOrigin=new double[M[0].length];
	    double[] frq_line=getFrequenLigne(M);
	    double[][] profilcols=getcolonesprofils(M) ;
		for(int i=0;i<M[0].length;i++)
		{
				for(int k=0;k<M.length;k++)
				{
					DiscolOrigin[i]+=(1/frq_line[k])*Math.pow(profilcols[k][i]-frq_line[k], 2);
				}
		}
		return DiscolOrigin;
	}
	//calcule inertie colone
    public double[] getInertieColone (double M[][]) {
    	double [] InertieColone=new double[M[0].length];
    	double[] freqCol=getFrequencolon(M);
    	double[] distOrigine=getOriginDistancesProfilecolone(M);
    	int n=getEffectif(M);
    	for(int i=0;i<M[0].length;i++) {
    		InertieColone[i]=distOrigine[i]*freqCol[i]/n;
    	}
    	return InertieColone;
    	
    }
    //la matrice des effictifs sous hypothese null
	public  double[][] getNullEffictives(double M[][])
	{  double[][] EffNullHypo=new double[M.length][M[0].length];
	   int n=getEffectif(M);
	   double[] n_ligne=getEffictifLigne(M);
	   double[] n_col=getEffictifCol(M);
	   for(int i=0;i<M.length;i++) {
		   for(int j =0;j<M[0].length;j++) {
			   EffNullHypo[i][j]=(n_ligne[i]*n_col[j])/n;
		   }
	   }
	   return EffNullHypo;
	   
	}

	public  double[][] getStandarizedResedus(double M[][])
	{
		double[][] effectifNull=getNullEffictives(M);
		double [][] ResiduStandarise=new double[M.length][M[0].length]; 
	for(int i=0;i<M.length;i++) {
	   for(int j =0;j<M[0].length;j++) {
		   ResiduStandarise[i][j]=(M[i][j]-effectifNull[i][j])/Math.sqrt(effectifNull[i][j]);
	   }
   }
   
   
 	 	return ResiduStandarise;
	}

	public  double[][] getM_residus(double M[][])
	{
		double[][] residusStand=getStandarizedResedus(M);
		double [][] M_residus=new double[M.length][M[0].length]; 
	for(int i=0;i<M.length;i++) {
	   for(int j =0;j<M[0].length;j++) {
		   M_residus[i][j]=residusStand[i][j]/Math.sqrt(getEffectif(M));
		   
	   }
   }

 	 	return M_residus;
	}
	
	

	
	
}
