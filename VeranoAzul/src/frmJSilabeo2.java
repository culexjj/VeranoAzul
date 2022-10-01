/**
 * @author edmond duke
 * @author MODIFICADO culex.jj
 * @version  0.1.2 (01/10/2022)
 */
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class frmJSilabeo2 extends JFrame implements ActionListener,WindowListener,KeyListener {
    private JButton cmdOK, cmdLimpiar;
    private JTextField txtTexto, txtSilabeo;
    private JPanel panelPrincipal,pane2;
    private JMenuBar bMenu;
    private JMenu mnuAbrir, mnuAyuda;
    private JMenuItem mnuItemSalir,mnuItemAcercaDe;
    private JLabel lbl1,lbl2;

    public frmJSilabeo2 (){
        super();
        IniciaComponentes();
        this.setTitle("Verano Azul v 0.1.1");
        this.setSize(480,320);
        this.setLocation(new Point(100,220));
    }

    private void IniciaComponentes(){
        panelPrincipal = new JPanel(new GridLayout(6,1));
        bMenu = new JMenuBar();
        mnuAbrir = new JMenu("Abrir");
        mnuItemSalir = new JMenuItem("Salir");
        mnuAbrir.add(mnuItemSalir);
        mnuItemSalir.addActionListener(this);

        mnuAyuda = new JMenu("Ayuda");
        mnuItemAcercaDe = new JMenuItem("Acerca de VERANO AZUL");
        mnuItemAcercaDe.addActionListener(this);
        mnuAyuda.add(mnuItemAcercaDe);

        bMenu.add(mnuAbrir);
        bMenu.add(mnuAyuda);
        //pane2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pane2 = new JPanel(new GridLayout(1,2));
            lbl1 = new JLabel("Palabra:");
            lbl1.setFont(new Font("Arial",Font.BOLD,18));

            txtTexto = new JTextField("Ingeniería",30);
            txtTexto.setFont(new Font("Arial",Font.PLAIN,22));
            txtTexto.addKeyListener(this);

            //URL cher = getClass().getResource("/jsilabeo2/resources/cher.TTF");

            lbl2 = new JLabel("Sílabas:");
            lbl2.setFont(new Font("Arial",Font.BOLD,18));

            txtSilabeo = new JTextField(" In-ge-nie-rí-a");
            txtSilabeo.setFont(new Font("Arial",Font.PLAIN,22));
            //txtSilabeo.setFont(new Font(cher,Font.PLAIN,22));
            //txtSilabeo.set

            cmdOK = new JButton("Al revés");
            cmdOK.addActionListener(this);
            cmdOK.setFont(new Font("Arial",Font.PLAIN,22));

            cmdLimpiar = new JButton("Limpiar");
            cmdLimpiar.setFont(new Font("Arial",Font.PLAIN,22));
            cmdLimpiar.addActionListener(this);
            
            pane2.add(cmdLimpiar);
            pane2.add(cmdOK);

        panelPrincipal.add(bMenu);
        panelPrincipal.add(lbl1);
        panelPrincipal.add(txtTexto);
        panelPrincipal.add(lbl2);
        panelPrincipal.add(txtSilabeo);
        panelPrincipal.add(pane2);
        this.add(panelPrincipal);
    }

    private void frmAcercaDe(){
        frmAcercaDe ventana = new frmAcercaDe();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.show();
    }

    private static Vector getPalabras(String cadena) {
        Vector palabras = new Vector();
        String palabra = "";
        cadena = cadena.trim().toLowerCase() + " ";
        char[] c = cadena.toCharArray();
        int i;
        for(i = 0; i < cadena.length(); i++){
            if ( c[i] == ' '){
                palabras.add(palabra);
                palabra = "";
            }
            else
                palabra = palabra + String.valueOf(c[i]);
        }
        return palabras;
    }
    /*private static int ContarSpacios(String cadena){
        int i, k ;
        cadena = cadena.trim() + " ";
        char c[] = cadena.toCharArray();
        k = 0;
        for ( i = 0; i < cadena.length(); i++){
            if ( c[i]  == ' ')
                k++;
        }
        return k;
    }*/
    private static boolean Verificar(String cadena){
        String s;
        char c[],x;
        int i,j,k;
        int error = 0;
        s = " abcdefghijklmnñopqrstuvwxyzáéíóúü";
        c = s.toCharArray();
        for( i=0 ;  i < cadena.length() && error == 0;i++){
            x = cadena.charAt(i);
            k = 0;
            for(j = 0 ;  j < s.length() && k == 0;j++){
                if(x==c[j])
                    k++;
            }
            if( k == 0)
                error++;
        }
        if(error == 0)
            return true;
        else
            return false;
    }

    private void Silabear(){
            if(Verificar(txtTexto.getText().trim().toLowerCase())){
                Vector palabras = getPalabras(txtTexto.getText());
                //SeparaSilabas s = new SeparaSilabas();
                separaSilabas s = new separaSilabas();
                int i;
                txtSilabeo.setText("");
                for ( i = 0; i < palabras.size(); i++){
                    s.setString((String)palabras.get(i));
                    txtSilabeo.setText( txtSilabeo.getText() + " " + s.silabear());
                }
                
            }else
                txtSilabeo.setText("Palabra no válida");
    }
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj.equals(cmdOK)){
            Silabear();
        }else if(obj.equals(cmdLimpiar)){
            txtTexto.setText("");
            txtSilabeo.setText("");
            txtTexto.requestFocus();
        }else if(obj.equals(mnuItemSalir)){
            this.dispose();
        }else if(obj.equals(mnuItemAcercaDe) ){
            frmAcercaDe();
        }
    }

    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowClosing(WindowEvent e) {
        //Declaramos una variable w del tipo Windows
        //Capturamos en ella la ventana en la cual se dio el evento
        // a través del método getWindow() del objeto
        //WindowsEvent e
        Window w = e.getWindow();

        //Preguntamos si la ventana es la actual y la cerramos y
        // luego terminamos la aplicación
        if(w.equals(this)){
            this.dispose(); //Cerramos la ventana actual
            System.exit(0); //Terminamos la aplicación actual
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowClosed(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == '\n')
            Silabear();
    }

    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
