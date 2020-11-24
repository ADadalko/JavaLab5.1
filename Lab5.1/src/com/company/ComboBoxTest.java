package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class ComboBoxTest extends JFrame
{
    private static final long serialVersionUID = 1L;
    // Массив элементов списка
    public String[] elements1 = new String[] {"Футбол", "Баскетбол", "Хоккей",
            "Шахматы", "Волейбол"};
    public String[] elements2 = new String[] {"Футбол", "Баскетбол", "Хоккей",
            "Шахматы", "Волейбол"};
    public String[] elements3 = new String[] {"Футбол", "Баскетбол", "Хоккей",
            "Шахматы", "Волейбол"};

    private JComboBox<String> cbFirst;
    private JComboBox<String> cbSecond;
    private JComboBox<String> cbThird;
    private DefaultComboBoxModel<String> cbModel1;
    private DefaultComboBoxModel<String> cbModel2;
    private DefaultComboBoxModel<String> cbModel3;


    public ComboBoxTest() {
        super("Работа со списками");
        int counter = 0;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        cbModel1 = new DefaultComboBoxModel<String>();
        cbModel2 = new DefaultComboBoxModel<String>();
        cbModel3 = new DefaultComboBoxModel<String>();

        for (int i = 0; i < elements1.length; i++) {
            cbModel1.addElement((String) elements1[i]);
            cbModel2.addElement((String) elements2[i]);
            cbModel3.addElement((String) elements3[i]);
        }
        cbFirst = new JComboBox<String>(cbModel1);
        cbSecond = new JComboBox<String>(cbModel2);
        cbThird = new JComboBox<String>(cbModel3);

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        CheckboxGroup direction = new CheckboxGroup();

        Checkbox leftRight = new Checkbox("НАПРАВЛЕНИЕ СЛЕВА НАПРАВО",direction,true);
        Checkbox rightLeft = new Checkbox("НАПРАВЛЕНИЕ СПРАВА НАЛЕВО",direction,false);


        JButton btnReplace1 = new JButton("Переместить");
        btnReplace1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = direction.getSelectedCheckbox().getLabel();
                if (s.equals("НАПРАВЛЕНИЕ СЛЕВА НАПРАВО")){
                    int pos = cbModel2.getSize();
                    cbModel2.insertElementAt((String) cbModel1.getSelectedItem(), pos);
                    cbModel1.removeElement(cbModel1.getSelectedItem());
                }else if(s.equals("НАПРАВЛЕНИЕ СПРАВА НАЛЕВО")){
                    int pos = cbModel3.getSize();
                    cbModel3.insertElementAt((String) cbModel1.getSelectedItem(), pos);
                    cbModel1.removeElement(cbModel1.getSelectedItem());
                }
            }
        });

        JButton btnAdd1 = new JButton("Добавить");
        btnAdd1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Выбираем позицию предпоследнего элемента
                int pos = cbModel1.getSize() - 1;
                cbModel1.insertElementAt((String) textField1.getText(), pos);
            }
        });

        JButton btnDel1 = new JButton("Удалить");
        btnDel1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cbFirst.removeItem(cbFirst.getSelectedItem());
            }
        });

        JButton btnEdit1 = new JButton("Изменить");
        btnEdit1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Выбираем позицию предпоследнего элемента
                int index = cbModel1.getIndexOf(cbModel1.getSelectedItem());
                cbModel1.removeElementAt(index);
                cbModel1.insertElementAt(textField1.getText(), index);
            }
        });


        JButton btnReplace2 = new JButton("Переместить");
        btnReplace2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = direction.getSelectedCheckbox().getLabel();
                if (s.equals("НАПРАВЛЕНИЕ СЛЕВА НАПРАВО")){
                    int pos = cbModel3.getSize() - 1;
                    cbModel3.insertElementAt((String) cbModel2.getSelectedItem(), pos);
                    cbModel2.removeElement(cbModel2.getSelectedItem());
                }else if(s.equals("НАПРАВЛЕНИЕ СПРАВА НАЛЕВО")) {
                    int pos = cbModel1.getSize() - 1;
                    cbModel1.insertElementAt((String) cbModel2.getSelectedItem(), pos);
                    cbModel2.removeElement(cbModel2.getSelectedItem());
                }
            }
        });

        JButton btnAdd2 = new JButton("Добавить");
        btnAdd2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Выбираем позицию предпоследнего элемента
                int pos = cbModel2.getSize() - 1;
                cbModel2.insertElementAt((String) textField2.getText(), pos);
            }
        });

        JButton btnDel2 = new JButton("Удалить");
        btnDel2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cbSecond.removeItem(cbSecond.getSelectedItem());
            }
        });

        JButton btnEdit2 = new JButton("Изменить");
        btnEdit2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Выбираем позицию предпоследнего элемента
                int index = cbModel2.getIndexOf(cbModel2.getSelectedItem());
                cbModel2.removeElementAt(index);
                cbModel2.insertElementAt(textField2.getText(), index);
            }
        });




        JButton btnReplace3 = new JButton("Переместить");
        btnReplace3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = direction.getSelectedCheckbox().getLabel();
                if (s.equals("НАПРАВЛЕНИЕ СЛЕВА НАПРАВО")){
                    int pos = cbModel1.getSize() - 1;
                    cbModel1.insertElementAt((String) cbModel3.getSelectedItem(), pos);
                    cbModel3.removeElement(cbModel3.getSelectedItem());
                }else if(s.equals("НАПРАВЛЕНИЕ СПРАВА НАЛЕВО")) {
                    int pos = cbModel2.getSize() - 1;
                    cbModel2.insertElementAt((String) cbModel3.getSelectedItem(), pos);
                    cbModel3.removeElement(cbModel3.getSelectedItem());
                }
            }
        });

        JButton btnAdd3 = new JButton("Добавить");
        btnAdd3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Выбираем позицию предпоследнего элемента
                int pos = cbModel3.getSize() - 1;
                cbModel3.insertElementAt((String) textField3.getText(), pos);
            }
        });

        JButton btnDel3 = new JButton("Удалить");
        btnDel3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cbThird.removeItem(cbThird.getSelectedItem());
            }
        });

        JButton btnEdit3 = new JButton("Изменить");
        btnEdit3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Выбираем позицию предпоследнего элемента
                int index = cbModel3.getIndexOf(cbModel3.getSelectedItem());
                cbModel3.removeElementAt(index);
                cbModel3.insertElementAt(textField3.getText(), index);
            }
        });


        // Размещение компонентов в интерфейсе и вывод окна
        JPanel contents = new JPanel();
        contents.setLayout(null);

        direction.setSelectedCheckbox(leftRight);
        leftRight.setLocation(30,250);
        leftRight.setSize(220, 50);
        contents.add(leftRight);
        rightLeft.setLocation(330,250);
        rightLeft.setSize(220, 50);
        contents.add(rightLeft);

        contents.add(cbSecond);
        cbSecond.setSize(150, 30);
        cbSecond.setLocation(210, 10);

        contents.add(cbFirst);
        cbFirst.setSize(150, 30);
        cbFirst.setLocation(10, 10);

        contents.add(cbThird);
        cbThird.setSize(150, 30);
        cbThird.setLocation(410, 10);

        btnAdd1.setSize(140, 30);
        btnAdd1.setLocation(15, 140);
        btnDel1.setSize(140, 30);
        btnDel1.setLocation(15, 180);
        btnEdit1.setSize(140, 30);
        btnEdit1.setLocation(15, 220);
        btnReplace1.setSize(150, 35);
        btnReplace1.setLocation(10, 50);

        btnAdd2.setSize(140, 30);
        btnAdd2.setLocation(215, 140);
        btnDel2.setSize(140, 30);
        btnDel2.setLocation(215, 180);
        btnEdit2.setSize(140, 30);
        btnEdit2.setLocation(215, 220);
        btnReplace2.setSize(150, 35);
        btnReplace2.setLocation(210, 50);

        btnAdd3.setSize(140, 30);
        btnAdd3.setLocation(415, 140);
        btnDel3.setSize(140, 30);
        btnDel3.setLocation(415, 180);
        btnEdit3.setSize(140, 30);
        btnEdit3.setLocation(415, 220);
        btnReplace3.setSize(150, 35);
        btnReplace3.setLocation(410, 50);

        textField1.setSize(140, 25);
        textField1.setLocation(15, 100);
        textField2.setSize(140, 25);
        textField2.setLocation(215, 100);
        textField3.setSize(140, 25);
        textField3.setLocation(415, 100);

        contents.add(btnReplace1);
        contents.add(btnReplace2);
        contents.add(btnReplace3);
        contents.add(btnAdd1);
        contents.add(btnDel1);
        contents.add(btnEdit1);
        contents.add(btnAdd2);
        contents.add(btnDel2);
        contents.add(btnEdit2);
        contents.add(btnAdd3);
        contents.add(btnDel3);
        contents.add(btnEdit3);
        contents.add(textField1);
        contents.add(textField2);
        contents.add(textField3);
        setContentPane(contents);
        setSize(600, 330);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ComboBoxTest();
    }
}