package command;

import editor.Editor;
import java.awt.Font;

public class SizeDown extends Command{
    public SizeDown(Editor e){
        super(e);
    }
    @Override
    public boolean execute(){
        
        Font font = new Font("Serif", Font.PLAIN, editor.fontSize--);
        editor.textField.setFont(font);
        return true;  
    }
}