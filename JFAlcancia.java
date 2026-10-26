import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class JFAlcancia extends JFrame
{
    private JLabel lblImagen;
    private JLabel lblSaldo;
    private JLabel lblTextoSaldo;
    private JLabel lbl50;
    private JLabel lbl100;
    private JLabel lbl200;
    private JLabel lbl500;
    private JLabel lbl1000;
    private JLabel lblTotal;
    private Alcancia alcancia;

    private ImageIcon iconoNormal;
    private ImageIcon iconoRoto;

    public JFAlcancia(){
        alcancia = new Alcancia();

        setTitle("Mi alcancia - POO I");
        setSize(500,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        crearInterfaz();
        actualizarInterfaz();

        setVisible(true);
    }

    public void crearInterfaz(){
        JPanel principal = new JPanel();
        principal.setLayout(new BorderLayout(15,15));
        principal.setBorder(new EmptyBorder(20,25,20,25));

        JPanel encabezado = new JPanel();
        encabezado.setLayout(new BoxLayout(encabezado, BoxLayout.Y_AXIS));
        
        
        ImageIcon tempNormal = new ImageIcon("images/cerdito.png");
        Image imgNormalEscalada = tempNormal.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        iconoNormal = new ImageIcon(imgNormalEscalada);
        
        ImageIcon tempRoto = new ImageIcon("images/cerdito_roto.png");
        Image imgRotaEscalada = tempRoto.getImage().getScaledInstance(150,150, Image.SCALE_SMOOTH);
        iconoRoto = new ImageIcon(imgRotaEscalada);
        
        
        lblImagen = new JLabel(iconoNormal);
        lblImagen.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titulo = new JLabel("MI ALCANCIA");
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblSaldo = new JLabel("$0");
        lblSaldo.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lblSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);

        lblTextoSaldo = new JLabel("Saldo disponible");
        lblTextoSaldo.setAlignmentX(Component.CENTER_ALIGNMENT);

        encabezado.add(lblImagen);
        encabezado.add(titulo);
        encabezado.add(lblSaldo);
        encabezado.add(lblTextoSaldo);

        principal.add(encabezado, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

        JLabel tituloMonedas = new JLabel("INGRESAR MONEDAS");
        tituloMonedas.setFont(new Font("Times New Roman", Font.BOLD, 20));
        tituloMonedas.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 12));
        JButton btn50 = new JButton("$50");
        JButton btn100 = new JButton("$100");
        JButton btn200 = new JButton("$200");
        JButton btn500 = new JButton("$500");
        JButton btn1000 = new JButton("$1000");

        botones.add(btn50);
        botones.add(btn100);
        botones.add(btn200);
        botones.add(btn500);
        botones.add(btn1000);

        btn50.addActionListener(e -> agregarMonedas(50));
        btn100.addActionListener(e -> agregarMonedas(100));
        btn200.addActionListener(e -> agregarMonedas(200));
        btn500.addActionListener(e -> agregarMonedas(500));
        btn1000.addActionListener(e -> agregarMonedas(1000));

        JPanel resumen = new JPanel(new GridLayout(6, 2, 5, 5));
        resumen.setBorder(BorderFactory.createTitledBorder("Resumen de la alcancia"));

        lbl50 = new JLabel("0");
        lbl100 = new JLabel("0");
        lbl200 = new JLabel("0");
        lbl500 = new JLabel("0");
        lbl1000 = new JLabel("0");
        lblTotal = new JLabel("0");

        resumen.add(new JLabel("Monedas de $50:"));
        resumen.add(lbl50);
        resumen.add(new JLabel("Monedas de $100:"));
        resumen.add(lbl100);
        resumen.add(new JLabel("Monedas de $200:"));
        resumen.add(lbl200);
        resumen.add(new JLabel("Monedas de $500:"));
        resumen.add(lbl500);
        resumen.add(new JLabel("Monedas de $1000:"));
        resumen.add(lbl1000);
        resumen.add(new JLabel("TOTAL DE MONEDAS:"));
        resumen.add(lblTotal);

        panelCentro.add(tituloMonedas);
        panelCentro.add(botones);
        panelCentro.add(resumen);

        principal.add(panelCentro, BorderLayout.CENTER);

        JButton btnVaciar = new JButton("VACIAR ALCANCIA");
        btnVaciar.addActionListener(e -> vaciarAlcancia());

        JPanel panelSur = new JPanel();
        panelSur.add(btnVaciar);
        principal.add(panelSur, BorderLayout.SOUTH);

        add(principal);
    }

    private void agregarMonedas(int valor){
        alcancia.agregarMonedas(valor);
        lblImagen.setIcon(iconoNormal);
        actualizarInterfaz();
    }

    private void vaciarAlcancia(){
        alcancia.vaciar();
        lblImagen.setIcon(iconoRoto);
        actualizarInterfaz();
    }

    public void actualizarInterfaz(){
        lblSaldo.setText("$" + alcancia.getSaldo());
        lbl50.setText(String.valueOf(alcancia.getMonedas50()));
        lbl100.setText(String.valueOf(alcancia.getMonedas100()));
        lbl200.setText(String.valueOf(alcancia.getMonedas200()));
        lbl500.setText(String.valueOf(alcancia.getMonedas500()));
        lbl1000.setText(String.valueOf(alcancia.getMonedas1000()));
        lblTotal.setText(String.valueOf(alcancia.getTotalMonedas()));
    }
}