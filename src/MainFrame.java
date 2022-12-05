import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{

    public void init(){
        setTitle("Welcome");
        setSize(450,360);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame myFrame = new MainFrame();
        myFrame.init();
    }

    
}
