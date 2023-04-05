package command;
import editor.Editor;

public class Reset extends Command{
    public Reset(Editor e){
        super(e);
    }
    @Override
    public boolean excute(){
        editor.tf1.setText("");
        editor.tf2.setText("");
        editor.rs.setText("");
        return true;
    }
}