package managedbeans;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named("chartview")
@SessionScoped

public class ChartView implements Serializable {

    private LineChartModel animatedModel1;

    @PostConstruct
    public void init() {
        createAnimatedModels();
    }

    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }

    private void createAnimatedModels() {
        animatedModel1 = initLinearModel();
        animatedModel1.setTitle("Inscriptions");
        animatedModel1.setAnimate(true);
        animatedModel1.setZoom(true);
        animatedModel1.setLegendPosition("se");
        Axis yAxis = animatedModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(50);

    }

    private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();

        LineChartSeries boys = new LineChartSeries();
        boys.setLabel("Nombre Inscriptions");
        boys.set(2004, 18);
        boys.set(2005, 20);
        boys.set(2006, 40);
        boys.set(2007, 30);
        boys.set(2008, 25);
        boys.set(2009, 18);
        boys.set(2010, 10);
        boys.set(2011, 30);
        boys.set(2012, 30);
        boys.set(2013, 35);
        boys.set(2014, 15);
        boys.set(2015, 33);

        LineChartSeries girls = new LineChartSeries();
        girls.setLabel("Nombre abandonnant");
        girls.set(2004, 2);
        girls.set(2005, 6);
        girls.set(2006, 4);
        girls.set(2007, 1);
        girls.set(2008, 5);
        girls.set(2009, 2);
        girls.set(2010, 6);
        girls.set(2011, 4);
        girls.set(2012, 1);
        girls.set(2013, 2);

        LineChartSeries etat = new LineChartSeries();
        etat.setLabel("Nombre gradue");
        etat.set(2004, 12);
        etat.set(2005, 19);
        etat.set(2006, 10);
        etat.set(2007, 20);
        etat.set(2008, 13);
        etat.set(2009, 9);
        etat.set(2010, 10);
        etat.set(2011, 9);
        etat.set(2012, 16);
        etat.set(2013, 8);

        model.addSeries(etat);
        model.addSeries(boys);
        model.addSeries(girls);

        return model;
    }

}
