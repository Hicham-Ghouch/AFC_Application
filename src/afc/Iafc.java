package afc;

import java.util.ArrayList;

import math_box.Vector;


public interface Iafc {

	public void printData() ;
	public ArrayList<Vector> getProjectionModaliteLigne();
	public ArrayList<Vector> getProjectionModaliteColonne();
	public void PrintProjectionModaliteLigne();
	public void PrintProjectionModaliteColonne();
	public void DrawDATA();
	public void DrawProjectionModaliteLigne();
	public void DrawProjectionModaliteColonne();
	public void PrintUSV();
	public void PrintM_residus_standariser();
	}
