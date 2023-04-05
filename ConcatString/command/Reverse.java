package command;
import editor.Editor;

public class Reverse extends Command{
    public Reverse(Editor e){
        super(e);
    }
    @Override
    public  boolean excute(){
        String input = editor.rs.getText();
        StringBuilder input1 = new StringBuilder();
        input1.append(input);
        input1.reverse();
        editor.rs.setText(input1.toString());
        return true;
    }
}