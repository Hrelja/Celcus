package Convert;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Celsius extends JFrame
{

	private static final long serialVersionUID = 1L;

	Celsius() {
    super("Convert Celsius to Fahrenheit");

    Container content = getContentPane();
    LayoutManager layout = new GridLayout(3, 2);
    content.setLayout(layout);

    _celsiusLabel = new JLabel("Celsius"); //création des objets
    _fahrenheitLabel = new JLabel("Fahrenheit");
    _C = new JTextField(5);
    _F = new JTextField(5);
    _convert = new JButton("Convert");
 

    Font font = new Font("SansSerif", 0, 10);
    content.setFont(font);
    _C.setFont(null); //set les objets à NULL
    _F.setFont(null);
    _celsiusLabel.setFont(null);
    _fahrenheitLabel.setFont(null);
    _convert.setFont(null);
    

    ActionListener celsiusListener = new ConvertCelsiusListener(); //création des boutons
    _convert.addActionListener(celsiusListener);
    _C.addActionListener(celsiusListener);


    content.add(_celsiusLabel); //ajout des fenêtres + boutons
    content.add(_fahrenheitLabel);
    content.add(_C);
    content.add(_F);
    content.add(_convert);

  }

  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() 
    {
    	
	  public void run() {
	    Celsius window = new Celsius();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.pack();
	    window.setVisible(true);
	  	}
        }
	);
  }

  private class ConvertCelsiusListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      String celsiusText = _C.getText();
      double celsius = Double.parseDouble(celsiusText);
      double fahrenheit = celsius * 9 / 5 + 32; //convertir celsius to fahrenheit
      String fahrenheitText = String.valueOf(fahrenheit);
      _F.setText(fahrenheitText);
    }
  }

 
  
  private JTextField _C; //ne pas oublier de mettre les boutons/afficheurs en private
  private JTextField _F;
  private JLabel _celsiusLabel;
  private JButton _convert;
  private JLabel _fahrenheitLabel;

}