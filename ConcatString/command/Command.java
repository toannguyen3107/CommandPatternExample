package command;
import editor.Editor;

public abstract class Command{
    public Editor editor;

    Command(Editor editor){
        this.editor = editor;
    }
    public abstract boolean excute();
}