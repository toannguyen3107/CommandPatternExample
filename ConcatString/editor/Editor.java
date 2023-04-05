package editor;
import command.*;
import javax.swing.*;
import java.awt.event.*;

public class Editor{
    public JTextField tf1 = new JTextField();
    public JTextField tf2 = new JTextField();
    public JTextField rs = new JTextField();
    
    public void init(){
        JFrame frame = new JFrame("Concat String");
        tf1.setBounds(50, 50, 190, 30);
        tf2.setBounds(320,50, 190, 30);
        rs.setBounds(195, 100, 200, 30);
        JButton concat= new JButton("Concat");
        concat.setBounds(70, 200, 150, 30);
        JButton reset  = new JButton("Reset");
        reset.setBounds(250, 200, 150, 30);
        JButton reverse = new JButton("Reverse");
        reverse.setBounds(70, 250, 150, 30);
        Editor editor = this;
        //button event using command;
        concat.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e){
                excuteCommand(new Concat(editor));
            }
        });
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                excuteCommand(new Reset(editor));
            }
        });
        reverse.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                excuteCommand(new Reverse(editor));
            }
        });
        frame.setSize(600, 400);
        frame.add(concat); frame.add(tf1); frame.add(tf2); frame.add(rs); frame.add(reset);
        frame.add(reverse);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public void excuteCommand(Command command){
        if(command.excute()){
            //code
        }
    }
}