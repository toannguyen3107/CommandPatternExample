package command;

import editor.Editor;
import java.awt.Font;

public class ResetFont extends Command{
    public ResetFont(Editor e){
        super(e);
    }
    @Override
    public boolean execute(){
        
        Font font = new Font("Serif", Font.PLAIN, 19);
        editor.fontSize = 19;
        editor.textField.setFont(font);
        return true;  
    }
}