package afc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import math_box.Facteurs;
import math_box.USV;
import math_box.Vector;

public class Afc implements Iafc {
	
	List<Vector> vectors = new ArrayList<Vector>();
	Facteurs f;
	
	
	public Afc(List<Vector> vectors) {
		
		this.vectors = vectors;
		f=new Facteurs(vectors);
	}
	
	public static ArrayList<Vector> loadData(String path) {
		// path="src/da/project/math_box/data.txt"
		File file = new File(path);

		String[] tmpStrTab;
		ArrayList<Vector> vectors = new ArrayList<>();// each vector is a line
														// in the text file
		BufferedReader bfr = null;
		try {
			bfr = new BufferedReader(new FileReader(file));
			// -->File
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while (bfr.ready()) {
				String ligne = bfr.readLine();
				tmpStrTab = ligne.split(";");
				double values[] = new double[tmpStrTab.length];
				for (int i = 0; i < tmpStrTab.length; i++) {
					values[i] = Double.parseDouble(tmpStrTab[i]);
				}
				vectors.add(new Vector(values));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vectors;
	}
	
	@Override
	public void printData() {
		System.out.println(vectors);
		
	}

	@Override
	public ArrayList<Vector> getProjectionModaliteLigne() {//equivalent de getCompenet en acp
		 ArrayList<Vector> PMLvec=new  ArrayList<Vector>() ; 
		double[][] PML=f.getProjModligne();
		for(int i=0;i<PML.length;i++) {
			PMLvec.add(new Vector(PML[i]));
		}
		
		return PMLvec;
	}

	@Override
	public ArrayList<Vector> getProjectionModaliteColonne() {
		 ArrayList<Vector> PMCvec=new  ArrayList<Vector>() ; 
			double[][] PMC=f.getProjModColonne();
			for(int i=0;i<PMC.length;i++) {
				PMCvec.add(new Vector(PMC[i]));
			}
			
			return PMCvec;
	}

	@Override
	public void PrintProjectionModaliteLigne() {
		System.out.println(getProjectionModaliteLigne());
		
	}

	@Override
	public void PrintProjectionModaliteColonne() {
		System.out.println(getProjectionModaliteColonne());
		
	}

	@Override
	public void DrawDATA() {
		
		
	}

	@Override
	public void DrawProjectionModaliteLigne() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DrawProjectionModaliteColonne() {
		
		
	}

	@Override
	public void PrintUSV() {
		f.getDecompositionUSV();
		System.out.println(f.getUsv());
		
		
	}

	@Override
	public void PrintM_residus_standariser() {
		
		double[][] M=f.getM_residus_stand();
		
		int a=0;
		double b=0;
		System.out.print("la matrice M est  : \n[");
		
		for (int i = 0; i < M.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j <M[0].length; j++) {
				
				a=(int)(M[i][j]*100);
				b=(double)a/100;
			System.out.print(b);
				if(j!=M.length-1) {
					System.out.print(" , ");
				}
					
					
			}
			if(i!= M[0].length-1) {
				System.out.print(" ]\n");
			}
			else {
				System.out.println(" ]]");
			}
		}
		
	}

}
