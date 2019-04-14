import java.awt.Container;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ComplexApp {
	private static final String[] FACES = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
	public static void main(String[] args){
		JFrame frame = new JFrame("My App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		
		JPanel facesPanel = new JPanel();
		GridLayout layout = new GridLayout(0, 3);
		layout.setHgap(5);
		layout.setVgap(2);

		facesPanel.setLayout(layout);

		for(String face : FACES){
			facesPanel.add(new JButton(face));
		}

		frame.getContentPane().setLayout(new BorderLayout());
		
		JTextField textField = new JTextField();
		textField.setFont(textField.getFont().deriveFont(24.0f));
		frame.add(textField, BorderLayout.PAGE_START);
		
		frame.add(facesPanel, BorderLayout.CENTER);
		
		JButton button = new JButton("Done");
		button.setPreferredSize(new Dimension(100, 50));
		frame.add(button, BorderLayout.PAGE_END);
		
		frame.setVisible(true);
	}
}
import javax.swing.JFrame;
import javax.swing.JPanel;

  public DrawPolyPanel() {
  }

  public DrawPolyPanel() {
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DrawPolyPanel)) {
            return false;
        }
        DrawPolyPanel drawPolyPanel = (DrawPolyPanel) o;
        ret;
  }

  @Override
  public int hashCode() {
    return Objects.hashCod);
  }

  @Override
  public String toString() {
    return "{" +
      "}";
  }

public class DrawPolyPanel extends JPanel {
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Polygon p = new Polygon();
    for (int i = 0; i < 5; i++)
      p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
          (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

    g.drawPolygon(p);

    Polygon s = new Polygon();
    for (int i = 0; i < 360; i++) {
      double t = i / 360.0;
      s.addPoint((int) (150 + 50 * t * Math.cos(8 * t * Math.PI)),
          (int) (150 + 50 * t * Math.sin(8 * t * Math.PI)));
    }
    g.drawPolygon(s);
  }
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("DrawPoly");
    frame.setSize(350, 250);
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    Container contentPane = frame.getContentPane();
    contentPane.add(new DrawPolyPanel());

    frame.show();
  }
}