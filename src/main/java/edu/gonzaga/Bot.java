package edu.gonzaga;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;
import java.util.*;

public class Bot extends Player
{
    public Bot(String name1, Coin c1)
    {
        super(name1, c1);
    }

    public int getBestMove( String s)
    {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        HtmlPage page;
        String url = "https://connect4.gamesolver.org/";
        if(s.length() > 0)
        {
            url += "?pos=" + s;
        }

        try {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(true);
            page = webClient.getPage(url);
            webClient.waitForBackgroundJavaScript(400);
            String pageText = page.asXml();
            pageText = pageText.substring(pageText.indexOf("sol0"), pageText.indexOf("class=\"board\""));
            String[] lines = pageText.split(System.getProperty("line.separator"));
            ArrayList<Integer[]> scores = new ArrayList<Integer[]>();
            ArrayList<Integer[]> best = new ArrayList<Integer[]>();
            int max = -100;
            int maxIndex = -1;
            int pos = 0;
            for(int i = 0; i < lines.length; i++)
            {
                if(isNumeric(lines[i].replaceAll("\\s", "")))
                {
                    Integer[] mapping = new Integer[2];
                    mapping[0] = pos;
                    
                    mapping[1] = Integer.parseInt(lines[i].replaceAll("\\s", ""));
                    //System.out.println(Integer.parseInt(lines[i].replaceAll("\\s", "")));
                    scores.add( mapping );
                    if(Integer.parseInt(lines[i].replaceAll("\\s", "")) > max)
                    {
                        max = Integer.parseInt(lines[i].replaceAll("\\s", ""));
                        maxIndex = pos;
                    }
                    pos++;
                }
            }
            
            // if max less than zero then do best possible move
            if(max < 0)
            {
                return maxIndex;
            }
            
            else if(max == 0)
            {
                for(int i = 0; i < scores.size(); i++)
                {
                    if(scores.get(i)[1] == 0)
                    {
                        best.add(scores.get(i));
                    }
                }
                return best.get((int)( Math.random()*best.size()))[0];
            }
            // the following two else ifs are to randomize move selection 
            // to make it harder for players to learn patterns
            else if(max > 0)
            {
                for(int i = 0; i < scores.size(); i++)
                {
                    if(scores.get(i)[1] > 0)
                    {
                        best.add(scores.get(i));
                    }
                }
                return best.get((int)( Math.random()*best.size()))[0];
            }

            return -1;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public boolean isNumeric(String str)
    {
        try
        {
            Integer.parseInt(str);
        } catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}
