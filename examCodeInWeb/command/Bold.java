package command;

import editor.Editor;
import java.awt.Font;

public class Bold extends Command{
    public Bold(Editor e){
        super(e);
    }
    @Override
    public boolean execute(){
        
        Font font = new Font("Serif", Font.BOLD, 19);
        editor.textField.setFont(font);
        return true;  
    }
}