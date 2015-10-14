package com.models.parser;

import com.dao.InfluxDaoConnector;
import com.influxdb.dto.QueryResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gmo on 13/10/2015.
 */
public class Analyse {

    HashMap<String,Container> list = new HashMap<>();


    public void processAnalysis() {
        QueryResult res = InfluxDaoConnector.getPoints("SELECT * FROM FR0000131708");

        int len = res.getResults().get(0).getSeries().get(0).getValues().size();


        for (int index = 50; index <len;index++ ) {
            String mm20 = mmRange(res, index, 20);
        }


    }


    public String mmRange(QueryResult res, int index, int range) {

        List<Object> lStart = res.getResults().get(0).getSeries().get(0).getValues().get(index - range);
        List<Object> lEnd = res.getResults().get(0).getSeries().get(0).getValues().get(index);

        System.out.print(lStart.get(0).toString());

        String query = "SELECT mean(value) FROM FR0000131708 where time > '" + lStart.get(0) + "' and time < '"+ lEnd.get(0) + "'";
        QueryResult meanQ = InfluxDaoConnector.getPoints(query);



        return meanQ.getResults().get(0).getSeries().get(0).getValues().get(0).get(1).toString();

    }



    private class Container {
        String date;
        Map<String,String> indice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Map<String, String> getIndice() {
            return indice;
        }

        public void setIndice(Map<String, String> indice) {
            this.indice = indice;
        }
    }
}
