package command;

import editor.Editor;
import java.awt.Font;

public class Italic extends Command{
    public Italic(Editor e){
        super(e);
    }
    @Override
    public boolean execute(){
        // if (editor.textField.getSelectedText().isEmpty()) return false;
        backup();
        Font font = new Font("Serif", Font.ITALIC, 19);
        editor.textField.setFont(font);
        return true;  
    }
}