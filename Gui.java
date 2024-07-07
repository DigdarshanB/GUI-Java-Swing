import javax.swing.*;
import java.awt.*;

public class Gui{
    private JFrame f;
    private JPanel p;
    private JComboBox cb;
    private JButton b;
    
    
    public Gui(){
    
        JFrame f=new JFrame();
        f.setSize(400,500);
        
        JPanel p=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();
        
        JComboBox<String>cb=new JComboBox<>();
        cb.addItem("hehe");
        cb.addItem("haha");
        gbc.gridx=0;
        gbc.gridy=2;
        p.add(cb,gbc);
        
        JButton b=new JButton("Click me");
        gbc.gridx=1;
        gbc.gridy=2;
        p.add(b,gbc);
        
        
        
        
        
        
        f.getContentPane().add(p,BorderLayout.CENTER);
        f.setVisible(true);
        
    }
    
    public static void main(String[]args){
        new Gui();
    }
}
