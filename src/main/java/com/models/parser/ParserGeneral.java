package com.models.parser;


import com.models.stock.CacheStockGeneral;
import com.models.stock.StockGeneral;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


/**
 * Created by gmo on 17/06/2015.
 */
public class ParserGeneral {

    static String cac40 = "http://bourse.lesechos.fr/bourse/actions/cours_az.jsp?select_fMARCHE_COURS=ind_FR0003500008&col=&ord=&page=&lettre=A";
    static String refCode = "tr";

    public static void loader() {

        try {
            String text = ParserCommon.loadUrl(new URL(cac40));

            Document doc = Jsoup.parse(text);

            Elements links = doc.select(refCode);
            for (Element link : links) {

                String linkItem = link.attr("data-item");
                if ((!linkItem.isEmpty()) && linkItem.compareToIgnoreCase("actionsParisTr") == 0) {
                    StockGeneral g = new StockGeneral();
                    g.setCode(link.attr("data-code"));
                    g.setPlace(link.attr("data-place"));
                    Elements es = link.select("span");
                    for (Element e : es) {
                        String linkField = e.attr("data-field");
                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("name") == 0)
                            g.setName(e.text());
                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("valorisation") == 0)      {
                            String t = e.text().replace(',','.');
                            g.setValue(Float.parseFloat(t));
                        }

                    }

                    Elements et = link.select("td");
                    for (Element e : et) {
                        String linkField = e.attr("data-field");
                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("open") == 0)      {
                            String t = e.text().replace(',','.');
                            g.setOpening(Float.parseFloat(t));
                        }
                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("high") == 0)      {
                            String t = e.text().replace(',','.');
                            g.setHighest(Float.parseFloat(t));
                        }
                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("low") == 0)      {
                            String t = e.text().replace(',','.');
                            g.setLowest(Float.parseFloat(t));
                        }

                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("variation") == 0)      {
                            String t = e.text().replace(',','.').replace('%',' ');//.replace('+','0');
                            g.setVariation(Float.parseFloat(t));
                        }
                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("variationY") == 0)      {
                            String t = e.text().replace(',','.').replace('%',' ');
                            g.setFirstJanuaryVariation(Float.parseFloat(t));
                        }

                        if (!linkField.isEmpty() && linkField.compareToIgnoreCase("volume") == 0)      {
                            String t = e.text().replace('�',' ').replaceAll(" ","");
                            g.setVolume(Integer.parseInt(t));
                        }


                    }

                    CacheStockGeneral.getCache().put(g.getCode(),g);
                }

            }

            System.out.print(CacheStockGeneral.getCache().size());


            for (StockGeneral g: CacheStockGeneral.getCache().values()) {
                System.out.println(g.getName());
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
