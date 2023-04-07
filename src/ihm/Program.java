package ihm;

import java.util.List;

import afc.Afc;
import afc.Iafc;
import afc.afc;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import math_box.Vector;

public class Program extends Application {
	 static List<Vector> projLigne;
	 static  List<Vector> projColonne;
	public static void main(String[] args) {
		List<Vector> vectors=Afc.loadData("src/math_box/data.txt");
		Afc afc=new Afc(vectors);
		System.out.println("---------------Original data --------------------");
		System.out.println(vectors);
	
		System.out.println("---------------Matrice M --------------------");
		afc.PrintM_residus_standariser();
		System.out.println("---------------Decomposition de M --------------------");
		afc.PrintUSV();
		//traitements � terminer
		System.out.println("---------------projection des modalite ligne sur les facteurs--------------------");
	    projLigne=afc.getProjectionModaliteLigne();
		System.out.println(projLigne);
		
		System.out.println("---------------projection des modalite colonne sur les facteurs--------------------");
		projColonne=afc.getProjectionModaliteColonne();
		System.out.println(projColonne);
		
		Application.launch(args);
	}

	@Override
	public void start(Stage window ) throws Exception {
	//	BorderPane root=new BorderPane();
		
		window.setTitle("AFC");
		window.setWidth(800);
		window.setHeight(600);
		
	        final NumberAxis xAxis = new NumberAxis(-1.5, 0.5,0.01);
	        final NumberAxis yAxis = new NumberAxis(-1.5, 0.5,0.01);
	        final BubbleChart<Number,Number> blc = new
	            BubbleChart<Number,Number>(xAxis,yAxis);
	      
	        xAxis.setLabel("Facteur1");
	        yAxis.setLabel("Facteur2");
	        blc.setTitle("Projection des modalite ligne&colone sur les facteur principeaux");
	       
	        XYChart.Series series1 = new XYChart.Series();
	        series1.setName("CSP");
	        for(int i=0;i<projLigne.size();i++) {
	            series1.getData().add(new XYChart.Data(projLigne.get(i).getCoordinates()[0], projLigne.get(i).getCoordinates()[1],0.03));
	}
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Spicialite");
	        for(int i=0;i<projColonne.size();i++) {
	        	series2.getData().add(new XYChart.Data(projColonne.get(i).getCoordinates()[0], projColonne.get(i).getCoordinates()[1],0.03));
	        }
	        Scene scene  = new Scene(blc);
	        blc.getData().addAll(series1, series2);           
	        window.setScene(scene);
	        window.show();
	    
      
           
        
        
       
       
                       
      
	}
	
}
