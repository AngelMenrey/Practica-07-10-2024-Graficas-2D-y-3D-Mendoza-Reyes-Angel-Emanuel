import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Escalado extends JFrame {
    
    private Grafico panel;
    private JCheckBox jchAmbos;
    private JSpinner jspEscaladoX;
    private JSpinner jspEscaladoY;
    private JButton jbnReiniciar;

    int x = 20;
    int y = 40;
    int ancho = 1;
    int alto = 1;
    double escaladoX = 1.0; 
    double escaladoY = 1.0; 

    public Escalado() {
        setTitle("Tema: Escalado");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(0, 0, 1200, 800);

        panel = new Grafico();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);

        jchAmbos = new JCheckBox("Escalado parejo");
        jchAmbos.setBounds(20, 10, 120, 20);

        jspEscaladoX = new JSpinner();
        jspEscaladoX.setBounds(150, 10, 40, 25);
        
        jspEscaladoY = new JSpinner();
        jspEscaladoY.setBounds(200, 10, 40, 25);

        jbnReiniciar = new JButton("Reiniciar");
        jbnReiniciar.setBounds(250, 10, 100, 25);

        jspEscaladoX.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int exponente = (int) jspEscaladoX.getValue();
                escaladoX = Math.pow(2, exponente);
                if (jchAmbos.isSelected()) {
                    jspEscaladoY.setValue(jspEscaladoX.getValue());
                }
                repaint();
            }
        });

        jspEscaladoY.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int exponente = (int) jspEscaladoY.getValue();
                escaladoY = Math.pow(2, exponente);
                if (jchAmbos.isSelected()) {
                    jspEscaladoX.setValue(jspEscaladoY.getValue());
                }
                repaint();
            }
        });

        jbnReiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = 20;
                y = 40;
                ancho = 1;
                alto = 1;
                escaladoX = 1.0; 
                escaladoY = 1.0;
                jspEscaladoX.setValue(0);
                jspEscaladoY.setValue(0);
                jchAmbos.setSelected(false);
                repaint();
            }
        });

        panel.add(jchAmbos);
        panel.add(jspEscaladoX);
        panel.add(jspEscaladoY);
        panel.add(jbnReiniciar);
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
            grafico.scale(escaladoX, escaladoY);
            grafico.fillRect(0, 0, ancho, alto);
        }
    }
    public static void main(String[] args) {
        new Escalado();
    }
}