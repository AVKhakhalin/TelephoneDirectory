package TelephoneDirectory;

import javax.swing.*; // импортируем весь свинг, дабы не заморачиваться(мы ведь только учимся))
import java.awt.*; // и весь авт аналогично
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Font;

public class DialogWindow
{
    int sizeWidth;
    int sizeHeight;

    public final int NUMBER_WORDS = 20;
    public final int NUMBER_WORDS_PER_ROW = 9;
    public String[] sampleWords = {"Абрикос", "Киви", "Арбуз", "Вишня", "Черешня", "Нектарин", "Айва", "Малина", "Арбуз", "Черешня", "Манго", "Абрикос", "Виноград", "Памело", "Мандарин", "Апельсин", "Банан", "Абрикос", "Абрикос", "Клубника"};
    JTextField[] textField_1_;

    public String[] defaultFamilies = new String[] {"Агрономов", "Галицын", "Агрономов", "Лукашевич", "Майоров", "Переверзев", "Сидоров", "Яковлев", "Яшин"};
    public String[] defaultTelephones = new String[] {"89051112233", "89052223344", "89653334455", "89073338899", "89359998877", "89613334411", "89689998877", "89053962383", "89999999999"};
    JTextField textField_TelephoneSearch;
    JTextField textField_TelephoneEnter;
    JTextField textField_FamilyEnter;
    public SolveTask2 solveTask2;

    DialogWindow (int _sizeWidth, int _sizeHeight)
    {
        this.sizeWidth = _sizeWidth;
        this.sizeHeight = _sizeHeight;
    }

    public DialogWindow() {
    }

    public JPanel createContentPane ()
    {
        // Создаём панель
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(new Color(200, 203, 255)); // смена фона окна
        totalGUI.setLayout(null);

        // Добавляем текст в окно
        String tabText1 = "&nbsp&nbsp&nbsp";
        String tabText2 = "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
        JLabel blueLabel = new JLabel("<html><font face=\"MyFont, Verdana, Arial\", size=\"5\"><br>" +
                "Домашнее задание №10 включало в себя следующее:<br>" +
                "1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.<br><br><br><br><br>" +
                "2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add()<br>можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.<br><br>Содержание телефонного справочника:" + tabText1 + "Введите фамилию для поиска:<br><br><br>" + tabText2 + "Добавьте фамилию и телефон<br>" + tabText2 + "в телефонный справочник:</html>");
        blueLabel.setLocation(30, 0); // координаты текста
        blueLabel.setSize(sizeWidth - 70, sizeHeight - 100); // размер области с текстом
        blueLabel.setVerticalAlignment(1);
        blueLabel.setHorizontalAlignment(0);
        blueLabel.setForeground(Color.BLACK); // Цвет текста
        totalGUI.add(blueLabel);

        // Создание кнопки для задания №1
        JButton task_1_button = new JButton("Проверить задание");
        task_1_button.setToolTipText("<html>Нажмите для проверки задания №1</html>");
        task_1_button.setLocation(700, 123); // это координаты кнопки
        task_1_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_1_button);
        ActionListener actionListener1 = new TestActionListener(1); // Подключение обработчика событий к кнопке
        task_1_button.addActionListener(actionListener1);

        // Создание текстовых полей для ввода слова для задания №1
        textField_1_ = new JTextField[NUMBER_WORDS];
        int tempDelta_x = 70;
        int tempDelta_y = 30;
        int counterRows = 0;
        for (int i = 0; i < NUMBER_WORDS; i++)
        {
            textField_1_[i] = new JTextField(10);
            textField_1_[i].setToolTipText("<html>Введите слово для задания №1 и нажмите соответствующую кнопку<br>\"Проверить задание\"</html>");
            textField_1_[i].setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
            textField_1_[i].setBounds(60 + tempDelta_x * (i - counterRows * NUMBER_WORDS_PER_ROW), 123 + tempDelta_y * counterRows, 70, 30);
            textField_1_[i].setText(sampleWords[i]);
            totalGUI.add(textField_1_[i]);
            if ((i + 1) % NUMBER_WORDS_PER_ROW == 0)
            {
                counterRows++;
            }
        }

        // Создание кнопки с поиском контакта для задания №2
        JButton task_2_1_button = new JButton("Найти телефон");
        task_2_1_button.setToolTipText("<html>Нажмите для проверки задания №2</html>");
        task_2_1_button.setLocation(700, 460);
        task_2_1_button.setSize(150,40 );
        totalGUI.add(task_2_1_button);
        ActionListener actionListener2_1 = new TestActionListener(21); // Подключение обработчика событий к кнопке
        task_2_1_button.addActionListener(actionListener2_1);

        // Создание кнопки с добавлением нового контакта для задания №2
        JButton task_2_2_button = new JButton("Добавить контакт");
        task_2_2_button.setToolTipText("<html>Нажмите для проверки задания №2</html>");
        task_2_2_button.setLocation(700, 555);
        task_2_2_button.setSize(150,40 );
        totalGUI.add(task_2_2_button);
        ActionListener actionListener2_2 = new TestActionListener(22); // Подключение обработчика событий к кнопке
        task_2_2_button.addActionListener(actionListener2_2);

        // Создание списка для задания №2
        solveTask2 = new SolveTask2(defaultFamilies, defaultTelephones);
        totalGUI.add(solveTask2.getTelephoneElements());

        // Создание текстового поля ввода телефона для поиска для задания №2
        textField_TelephoneSearch = new JTextField(10);
        textField_TelephoneSearch.setToolTipText("<html>Введите фамилию для поиска в задании №2<br>и нажмите кнопку \"Найти телефон\"</html>");
        textField_TelephoneSearch.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_TelephoneSearch.setBounds(409, 460, 280, 30);
        textField_TelephoneSearch.setText("");
        totalGUI.add(textField_TelephoneSearch);

        // Создание текстового поля для ввода фамилии для добавления в телефонный справочник для задания №2
        textField_FamilyEnter = new JTextField(10);
        textField_FamilyEnter.setToolTipText("<html>Введите фамилию для добавления в телефонный справочник<br>в задании №2 и нажмите кнопку \"Добавить контакт\"<br>(добавление произойдёт при введении и фамилии, и телефона)</html>");
        textField_FamilyEnter.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_FamilyEnter.setBounds(409, 555, 150, 30);
        textField_FamilyEnter.setText("");
        totalGUI.add(textField_FamilyEnter);

        // Создание текстового поля ввода телефона для добавления в телефонный справочник для задания №2
        textField_TelephoneEnter = new JTextField(10);
        textField_TelephoneEnter.setToolTipText("<html>Введите телефон для добавления в телефонный справочник<br> в задании №2 и нажмите кнопку \"Добавить контакт\"<br>(добавление произойдёт при введении и фамилии, и телефона)</html>");
        textField_TelephoneEnter.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
        textField_TelephoneEnter.setBounds(569, 555, 120, 30);
        textField_TelephoneEnter.setText("");
        totalGUI.add(textField_TelephoneEnter);

        // Создание кнопки для выхода из программы
        JButton task_EXIT_button = new JButton("Выйти из программы");
        task_EXIT_button.setToolTipText("<html>Нажмите для выхода из программы</html>");
        task_EXIT_button.setLocation((int) (sizeWidth / 2 - 80) + 39, sizeHeight - 98); // это координаты кнопки
        task_EXIT_button.setSize(160,40 ); // это размер кнопки
        totalGUI.add(task_EXIT_button);
        ActionListener actionListener_EXIT = new TestActionListener(0); // Подключение обработчика событий к кнопке
        task_EXIT_button.addActionListener(actionListener_EXIT);

        totalGUI.setOpaque(true);
        return totalGUI;
    }

    // Обработка событий при нажатии на левую кнопку мыши
    public class TestActionListener implements ActionListener
    {
        int taskNumber = 0;

        TestActionListener (int _taskNumber)
        {
            this.taskNumber = _taskNumber;
        }

        public void actionPerformed(ActionEvent e)
        {
            switch (taskNumber)
            {
                case 1:
                    boolean existSomeWords = false;
                    String[] newWords = new String[NUMBER_WORDS];
                    for (int i = 0; i < textField_1_.length; i++)
                    {
                        if ((textField_1_[i].getText() != null) && (textField_1_[i].getText().length() > 0))
                        {
                            newWords[i] = textField_1_[i].getText();
                            existSomeWords = true;
                        }
                    }
                    if (existSomeWords == true)
                    {
                        SolveTask1 solveTask1 = new SolveTask1(newWords);
                        solveTask1.getWordInfo();
                    }
                    else
                    {
                        System.out.println("Для проверки домашнего задания №1 нужно ввести в текстовые поля хотя бы одно слово.");
                        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Для проверки домашнего задания №1<br>нужно ввести в текстовые поля хотя бы одно слово.<br>Пожалуйста, исправьте размер массива<br>и нажмите на кнопку \"Проверить задание\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 21:
                    if (textField_TelephoneSearch.getText().length() > 0)
                    {
                        String tempOut = solveTask2.searchTelephone(textField_TelephoneSearch.getText());
                        if (tempOut.length() > 0)
                        {
                            if (tempOut.indexOf(",") > 0)
                            {
                                System.out.println("В телефонном справочнике по фамилии \"" + textField_TelephoneSearch.getText() + "\" найдены следующие телефоны: " + tempOut);
                                JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">В телефонном справочнике по фамилии \"" + textField_TelephoneSearch.getText() + "\"<br>найдены следующие телефоны: " + tempOut + ".</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                            }
                            else
                            {
                                System.out.println("В телефонном справочнике по фамилии \"" + textField_TelephoneSearch.getText() + "\" найден один телефон: " + tempOut);
                                JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">В телефонном справочнике по фамилии \"" + textField_TelephoneSearch.getText() + "\"<br>найден один телефон: " + tempOut + ".</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        else
                        {
                            System.out.println("В телефонном справочнике по фамилии \"" + textField_TelephoneSearch.getText() + "\" не найден ни один телефон");
                            JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">В телефонном справочнике по фамилии \"" + textField_TelephoneSearch.getText() + "\"<br> не найден ни один телефон.</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else
                    {
                        System.out.println("Для проверки поиска телефона по фамилии нужно ввести в поле фамилии хотя бы одно слово и нажать на кнопку \"Нати телефон\".");
                        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Для проверки поиска телефона по фамилии<br>нужно ввести в поле фамилии хотя бы одно слово<br>и нажать на кнопку \"Нати телефон\".<br>Пожалуйста, исправьте размер массива<br>и нажмите на кнопку \"Найти телефон\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 22:
                    if ((textField_FamilyEnter.getText().length() > 0) && (textField_TelephoneEnter.getText().length() > 0))
                    {
                        String tempOut = solveTask2.addNewContact(textField_FamilyEnter.getText(), textField_TelephoneEnter.getText());
                        System.out.println(tempOut);
                        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">" + tempOut + "</html>", "ИНФОРМАЦИЯ", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        System.out.println("Для добавления нового контакта в телефонный справочник нужно обязательно указать и фамилию, и телефон.\nУкажите необходимые данные и нажмите на кнопку \"Добавить контакт\" ещё раз.");
                        JOptionPane.showMessageDialog(new JFrame(), "<html><font face=\"MyFont, Verdana, Arial\", size=\"4\">Для добавления нового контакта в телефонный справочник<br>нужно обязательно указать и фамилию, и телефон.<br>Укажите необходимые данные и нажмите на кнопку<br>\"Добавить контакт\" ещё раз.</html>", "ОШИБКА", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
