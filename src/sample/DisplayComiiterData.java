package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;


import java.util.LinkedList;

public class DisplayComiiterData{
    public PieChart displayPiechart(LinkedList<CommiterInfo> cList){
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        for(CommiterInfo temp: cList){
            pieChartData.add(new PieChart.Data(temp.getName() + " " + temp.getCommits(),temp.getCommits()));
        }
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Contributers");
        chart.setLegendSide(Side.LEFT);
        return chart;
    }
}
