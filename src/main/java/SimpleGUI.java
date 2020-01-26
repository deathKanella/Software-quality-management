
import javafx.event.ActionEvent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGUI extends JFrame {
    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");


    public SimpleGUI(){
        super("Simple Example");
        this.setBounds(100, 100, 250, 100);
        //условие закрытия закрыли форму все закрылось
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //контейнер для помещения наших кнопок
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3,2,2,2));//ширина высота отступы
        container.add(label);
        container.add(input);

        //для работы с кнопкой
        button.addActionListener(new ButtonEventListener());//записываем класс который будем вызывать
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            String message ="";
            message +="Button was pressed\n";
            message +="Text is " + input.getText() + "\n";
            JOptionPane.showMessageDialog(null,message,"Output",JOptionPane.PLAIN_MESSAGE);
        }
    }

}


