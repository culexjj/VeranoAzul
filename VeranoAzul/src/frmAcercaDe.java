import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author edmond duke
 * @author MODIFICADO culex.jj
 * @version  0.1.1 (10/08/2022)
 */

public class frmAcercaDe extends JFrame implements ActionListener{
    private JButton cmdSalir;
    private JLabel lblTitulo, lblDescripcion,lblIcono,lbl1,lbl2,lbl3;
    private JPanel panelPrincipal,pane1,pane2;

    public frmAcercaDe(){
        super();
        IniComponentes();
        this.setTitle("Acerca VERANO AZUL");
        this.setSize(550,250);
        this.setLocation(new Point(220,220));

    }

    private void IniComponentes(){
        panelPrincipal = new JPanel(new BorderLayout());
        pane1 = new JPanel(new GridLayout(5,1));
        pane2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            //lblTitulo = new JLabel("jSilabeo",JLabel.CENTER);
        	lblTitulo = new JLabel("VERANO AZUL",JLabel.CENTER); //new
            lblTitulo.setFont(new Font("Arial",Font.BOLD,18));
            lblIcono = new JLabel();
            //ImageIcon imgSilabas = new ImageIcon(getClass().getResource("D://Dropbox//Java//VeranoAzul//src//resources//veranoazul.png"));
            //lblIcono.setIcon(imgSilabas);
            //lblDescripcion = new JLabel("Programa para separar en sílabas de palabras en español.");
            lblDescripcion = new JLabel("Te acuerdas como hablar al reves ???."); //new
            //lbl1 = new JLabel("Versión: 0.1.1 (15/12/2009)");
            //lbl2 = new JLabel("Desarrollador: Edmond Duke");
            //lbl3 = new JLabel("Comunicar errores: edu1738@gmail.com");
            lbl1 = new JLabel("Versión: 0.1.1 (10/08/2022)"); //new
            lbl2 = new JLabel("Basado en el trabajo de  Edmond Duke - jSilabeo"); //new
            
            cmdSalir = new JButton("Salir");
            cmdSalir.addActionListener(this);

            pane2.add(cmdSalir);
            pane1.add(lblDescripcion);
            pane1.add(lbl1);
            pane1.add(lbl2);
            //pane1.add(lbl3);
            pane1.add(pane2);

       panelPrincipal.add(lblTitulo,BorderLayout.NORTH);
       panelPrincipal.add(lblIcono,BorderLayout.WEST);
       //panelPrincipal.add(pane1,BorderLayout.EAST);
       panelPrincipal.add(pane1,BorderLayout.CENTER); //new

       this.add(panelPrincipal);
       this.pack();
    }

    public void actionPerformed(ActionEvent e) {
            this.dispose();
    }

}

