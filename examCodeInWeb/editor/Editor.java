package editor; //export editor

import command.*; //import commands

import javax.swing.*; // GUI
import java.awt.*;
import java.awt.event.ActionEvent; // Event action
import java.awt.event.ActionListener; //Even action
import java.awt.Font; //set Font

public class Editor {
    public JTextArea textField;
    public String clipboard;
    private CommandHistory history = new CommandHistory();
    public int fontSize = 19;
    public void init() {
        JFrame frame = new JFrame("Text editor uses Command Pattern!");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        textField = new JTextArea();
        textField.setLineWrap(true);
        content.add(textField);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel buttons1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        JButton  italic = new JButton("Italic");
        JButton bold = new JButton("Bold");
        JButton reset = new JButton("Reset Font");
        JButton sizeup = new JButton("Larger");
        JButton sizedown = new JButton("Smaller");
        Editor editor = this;
        ctrlC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CopyCommand(editor));
            }
        });
        ctrlX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new CutCommand(editor));
            }
        });
        ctrlV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                executeCommand(new PasteCommand(editor));
            }
        });
        italic.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executeCommand(new Italic(editor));
            }
        });
        bold.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executeCommand(new Bold(editor));
            }
        });
        reset.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executeCommand(new ResetFont(editor));
            }
        });
        sizeup.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executeCommand(new SizeUp(editor));
            }
        });
        sizedown.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                executeCommand(new SizeDown(editor));
            }
        });
        ctrlZ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                undo();
            }
        });
        
        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        buttons1.add(italic);
        buttons1.add(bold);
        buttons1.add(reset);
        buttons1.add(sizeup);
        buttons1.add(sizedown);

        content.add(buttons);
        content.add(buttons1);

        Font font = new Font(Font.SERIF, Font.PLAIN, fontSize);
        textField.setFont(font);
        frame.setSize(700, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    private void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}