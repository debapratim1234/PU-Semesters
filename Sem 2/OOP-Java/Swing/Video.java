import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Video extends JFrame implements ItemListener
{
  JComboBox movieBox = new JComboBox();
  FlowLayout flow = new FlowLayout();
  JLabel movieList = new JLabel("Movie List");
  JLabel aMovie = new JLabel("Play It Again Videos");
  JTextField totPrice = new JTextField(10);
  double[] moviePrice = {0,20.00,25.00,22.00,25.00,25.00,21.00,22.00,25.00,26.00,27.00};
  double totalPrice = 0.00;
  String output;
  int FavorNum;

  public Video()
  {
    super("Play It Again Videos");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pane = new JPanel();
    pane.setLayout(flow);
    movieBox.addItemListener(this);
    pane.add(movieList);
    movieBox.addItem("none");
    movieBox.addItem("Joker");
    movieBox.addItem("Robo");
    movieBox.addItem("Banglore Days");
    movieBox.addItem("Anand");
    movieBox.addItem("Duet");
    movieBox.addItem("3 Idiots");
    movieBox.addItem("Jurasic Park");
    movieBox.addItem("Dil se");
    movieBox.addItem("Gladiator");
    movieBox.addItem("13 Days");
    pane.add(movieBox);
    pane.add(aMovie);
    pane.add(totPrice);
    movieBox.setEditable(true);
    setContentPane(pane);
  }
  public static void main(String[] args)
  {
    JFrame mrame = new Video();
    mrame.setSize(250,150);
     mrame.setVisible(true);
  }
  public void itemStateChanged(ItemEvent list)
  {
    Object source = list.getSource();
    if (source == movieBox)
    {
      int favorNum = movieBox.getSelectedIndex();
      totalPrice = moviePrice[favorNum];
      output = "Movie Price Rs." + totalPrice;
      totPrice.setText(output);
    }
  }
}