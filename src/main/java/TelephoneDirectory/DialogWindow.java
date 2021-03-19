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
    public final String[] sampleWords = {"Абрикос", "Киви", "Арбуз", "Вишня", "Черешня", "Нектарин", "Айва", "Малина", "Арбуз", "Черешня", "Манго", "Абрикос", "Виноград", "Памело", "Мандарин", "Апельсин", "Банан", "Абрикос", "Абрикос", "Клубника"};
    JTextField[] textField_1_;

    DialogWindow (int _sizeWidth, int _sizeHeight)
    {
        this.sizeWidth = _sizeWidth;
        this.sizeHeight = _sizeHeight;
    }

    public JPanel createContentPane ()
    {
        // Создаём панель
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(new Color(200, 203, 255)); // смена фона окна
        totalGUI.setLayout(null);

        // Добавляем текст в окно
        JLabel blueLabel = new JLabel("<html><font face=\"MyFont, Verdana, Arial\", size=\"5\"><br>" +
                "Домашнее задание №10 включало в себя следующее:<br>" +
                "1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать, сколько раз встречается каждое слово.<br><br><br><br><br>" +
                "2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add()<br>можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны. Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д). Консоль использовать только для вывода результатов проверки телефонного справочника.</html>");
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

        // Создание кнопки для задания №2
        JButton task_2_button = new JButton("Проверить задание");
        task_2_button.setToolTipText("<html>Нажмите для проверки задания №2</html>");
        task_2_button.setLocation(700, 464); // это координаты кнопки
        task_2_button.setSize(150,40 ); // это размер кнопки
        totalGUI.add(task_2_button);
        ActionListener actionListener2 = new TestActionListener(2); // Подключение обработчика событий к кнопке
        task_2_button.addActionListener(actionListener2);

        // Создание кнопки для выхода из программы
        JButton task_EXIT_button = new JButton("Выйти из программы");
        task_EXIT_button.setToolTipText("<html>Нажмите для выхода из программы</html>");
        task_EXIT_button.setLocation((int) (sizeWidth / 2 - 80), sizeHeight - 98); // это координаты кнопки
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
                case 2:
                    SolveTask2 solveTask2 = new SolveTask2();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
