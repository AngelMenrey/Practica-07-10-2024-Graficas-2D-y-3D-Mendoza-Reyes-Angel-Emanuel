import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Traslacion extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    private JLabel jlbCoordX;
    private JLabel jlbCoordY;
    private JTextField jtfCoordX;
    private JTextField jtfCoordY;
    private JButton jbnTrasladar;
    private Grafico panel;

    int x = 100;
    int y = 100;
    int ancho = 100;
    int alto = 100;

    public Traslacion() {
        setTitle("Tema: Traslación");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(809, 600);

        panel = new Grafico();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);

        jlbCoordX = new JLabel("X: ");
        jlbCoordX.setBounds(20, 15, 20, 20);

        jtfCoordX = new JTextField();
        jtfCoordX.setBounds(40, 15, 40, 20);

        jlbCoordY = new JLabel("Y: ");
        jlbCoordY.setBounds(100, 15, 20, 20);

        jtfCoordY = new JTextField();
        jtfCoordY.setBounds(140, 15, 40, 20);

        jbnTrasladar = new JButton("Trasladar");
        jbnTrasladar.setBounds(200, 15, 100, 20);

        jtfCoordX.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char numero = e.getKeyChar();
                if (jtfCoordX.getText().length() > 2) {
                    e.consume();
                } else if (!Character.isDigit(numero)) {
                    e.consume();
                }
            }
        });

        jtfCoordY.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char numero = e.getKeyChar();
                if (jtfCoordY.getText().length() > 2) {
                    e.consume();
                } else if (!Character.isDigit(numero)) {
                    e.consume();
                }
            }
        });

        jbnTrasladar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                x = Integer.parseInt(jtfCoordX.getText());
                y = Integer.parseInt(jtfCoordY.getText());
                repaint();
            }
        });

        panel.add(jlbCoordX);
        panel.add(jlbCoordY);
        panel.add(jtfCoordX);
        panel.add(jtfCoordY);
        panel.add(jbnTrasladar);
        setContentPane(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
    }

    public class Grafico extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D grafico = (Graphics2D) g;
            grafico.setColor(Color.blue);
            grafico.translate(x, y);
            grafico.fillRect(0, 0, ancho, alto);
            ImageIcon mario = new ImageIcon(getClass().getResource("ladrillo.png"));
            grafico.drawImage(mario.getImage(), 0, 0, this);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    public static void main(String[] args) {
        new Traslacion();
    }
}