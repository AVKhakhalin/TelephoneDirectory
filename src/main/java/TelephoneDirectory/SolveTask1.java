package TelephoneDirectory;

import javax.swing.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class SolveTask1
{
    Set<String> words = new LinkedHashSet<String>();
    LinkedList<Integer> indexes = new LinkedList<Integer>();

    SolveTask1(String[] newWords)
    {
        int curSize;
        boolean foundSimilar;
        int counter;
        for (String analiseWord : newWords)
        {
            curSize = words.size();
            words.add(analiseWord);
            if (curSize == words.size())
            {
                Iterator<String> iterWords = words.iterator();
                foundSimilar = false;
                counter = 0;
                while((iterWords.hasNext() == true) && (foundSimilar == false))
                {
                    if (iterWords.next().equals(analiseWord) == true)
                    {
                        indexes.set(counter, indexes.get(counter) + 1);
                        foundSimilar = true;
                    }
                    counter++;
                }
            }
            else
            {
                indexes.add(1);
            }
        }
    }

    public void getWordInfo()
    {
        int counter = 0;
        Iterator<String> iterWords = words.iterator();
        String resultsToSout = "Перечень уникальных слов (частота их присутствия в списке):\n";
        String resultsToMessage = "Перечень уникальных слов (частота их присутствия в списке):<br>";
        String tempString;
        while (iterWords.hasNext() == true)
        {
            tempString = iterWords.next();
            resultsToSout += (counter + 1) + ". " + tempString + " (" + indexes.get(counter) + ")";
            resultsToMessage += (counter + 1) + ". " + tempString + " (" + indexes.get(counter) + ")";
            if (iterWords.hasNext() == true)
            {
                resultsToSout += ".\n";
                resultsToMessage += ".<br>";
            }
            else
            {
                resultsToSout += ".";
                resultsToMessage += ".";
            }
            counter++;
        }
        System.out.println(resultsToSout);
        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + resultsToMessage + "</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
    }
}
