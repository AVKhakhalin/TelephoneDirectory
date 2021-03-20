package TelephoneDirectory;

import javax.swing.*;
import java.awt.*;

public class SolveTask2 extends DialogWindow // Класс телефонный справочник
{
    public JComboBox<String> telephoneElements;
    public DefaultComboBoxModel<String> defTelephoneElements;

    SolveTask2(String[] families, String[] telephones)
    {
        defTelephoneElements = new DefaultComboBoxModel<String>();
        for (int i = 0; i < families.length; i++)
        {
            defTelephoneElements.addElement(families[i] + ", телефон: " + telephones[i]);
        }
        telephoneElements = new JComboBox<String>(defTelephoneElements);
        telephoneElements.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        telephoneElements.setMaximumRowCount(9);
        telephoneElements.setBounds(30, 460, 367, 30);
    }

    public JComboBox<String> getTelephoneElements()
    {
        return telephoneElements;
    }

    public DefaultComboBoxModel<String> getDefTelephoneElements()
    {
        return defTelephoneElements;
    }

    public String searchTelephone(String questionFamily)
    {
        String answer = "";
        char[] buf;
        for (int i = 0; i < defTelephoneElements.getSize(); i++)
        {
            if (defTelephoneElements.getElementAt(i).indexOf(questionFamily) > -1)
            {
                buf = new char[defTelephoneElements.getElementAt(i).length()];
                defTelephoneElements.getElementAt(i).getChars(defTelephoneElements.getElementAt(i).indexOf(": ") + 2, defTelephoneElements.getElementAt(i).length(), buf, 0 );
                if (answer.length() > 0)
                {
                    answer += ", " + String.valueOf(buf).trim();
                }
                else
                {
                    answer += String.valueOf(buf).trim();
                }
            }
        }
        return answer;
    }

    public String addNewContact(String family, String number)
    {
        defTelephoneElements.addElement(family + ", телефон: " + number);
        return "В телефонном справочнике создан новый контакт с фамилией \"" + family + "\".";
    }

}
