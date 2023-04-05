package command;
import editor.Editor;

public class Concat extends Command{
    public Concat(Editor editor){
        super(editor);
    }
    @Override
    public boolean excute(){
        editor.rs.setText(editor.tf1.getText() + editor.tf2.getText());
        return true;
    }
}