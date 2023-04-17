package edu.gonzaga;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

import org.apache.xalan.templates.ElemSort;

import java.util.*;

public class Bot extends Player
{
    public Bot(String name1, Coin c1)
    {
        super(name1, c1);
    }

    @Override
    public int getMove( String s)
    {
        if(s.length() > 1)
        {
            WebClient webClient = new WebClient(BrowserVersion.CHROME);
            HtmlPage page;
            String url = "https://connect4.gamesolver.org/";
            boolean[] flags = new boolean[7];

            if(s.length() > 0) // acted on this
            {
                url += "?pos=" + s;
                for(int i = 1; i <= 7; i++)
                {
                    if(intCount(s, i) >= 6)
                    {
                        flags[i-1] = true;
                    }
                }
            }

            try {
                webClient.getOptions().setCssEnabled(false);
                webClient.getOptions().setJavaScriptEnabled(true);
                page = webClient.getPage(url);
                webClient.waitForBackgroundJavaScript(1000);
                String pageText = page.asXml();
                pageText = pageText.substring(pageText.indexOf("sol0"), pageText.indexOf("class=\"board\""));
                String[] lines = pageText.split(System.getProperty("line.separator"));
                ArrayList<Integer[]> scores = new ArrayList<Integer[]>();
                ArrayList<Integer[]> best = new ArrayList<Integer[]>();
                int max = -1000;
                //int maxIndex = -4;
                int pos = 0;
                for(int i = 0; i < lines.length; i++)
                {
                    while(pos < 7 && flags[pos] == true)
                    {
                        pos++;
                    }
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
                        }
                        pos++;
                    }
                }
                
                // the following two are to randomize move selection 
                // to make it harder for players to learn patterns

                //if best <= 0 then do a move equivalent to best move

                // if best > 0 then it can go to any move > 0

                if(max <= 0)
                {
                    for(int i = 0; i < scores.size(); i++)
                    {
                        if(scores.get(i)[1] == max)
                        {
                            best.add(scores.get(i));
                        }
                    }
                    return best.get((int)( Math.random()*best.size()))[0];
                }
                
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

                return -100;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                // might wanna give a wifi error and quit
                return -10;
            }
        }
        /*
            For first move we can hard code it to significantly reduce time.
            
            This is because move time exponentially decreases with the first move
            having the most board state combinations that it has to check
         */
        else 
        {
            if(s.equals("1"))
            {
                int rand = (int) Math.random()*4;
                if(rand == 0)
                {
                    return 1;
                }
                else if(rand == 1)
                {
                    return 2;
                }
                else if(rand == 2)
                {
                    return 3;
                }
                else
                {
                    return 5;
                }
            }
            else if(s.equals("2"))
            {
                return 2;
            }
            else if(s.equals("3"))
            {
                int rand = (int) Math.random()*4;
                if(rand == 0)
                {
                    return 2;
                }
                else if(rand == 1)
                {
                    return 3;
                }
                else if(rand == 2)
                {
                    return 4;
                }
                else
                {
                    return 5;
                }
            }
            else if(s.equals("4"))
            {
                return 3;
            }
            else if(s.equals("5"))
            {
                int rand = (int) Math.random()*4;
                if(rand == 0)
                {
                    return 1;
                }
                else if(rand == 1)
                {
                    return 2;
                }
                else if(rand == 2)
                {
                    return 3;
                }
                else
                {
                    return 4;
                }
            }
            else if(s.equals("6"))
            {
                return 2;
            }
            else if(s.equals("7"))
            { 
                int rand = (int) Math.random()*4;
                if(rand == 0)
                {
                    return 1;
                }
                else if(rand == 1)
                {
                    return 3;
                }
                else if(rand == 2)
                {
                    return 4;
                }
                else
                {
                    return 5;
                }  
            }
            else
            {
                return -1; // error
            }
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

    public int intCount(String str, int num)
    {
        int count = 0;
        for(int i = 0; i < str.length(); i++)
        {
            if(Integer.parseInt(str.substring(i, i+1)) == num)
            {
                count++;
            }
        }
        return count;
    }
}
