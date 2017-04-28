
package ejecutarbotones;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class VentanaPrincipal extends JFrame{
    
    private PanelBotones panelBotones;  //  Panel que contiene la configuracion de botones
    
    private DialogoConfiguracion dialogoConfiguracion; //   Dialogo para configurar cuantos botones
    
    private JMenuBar barraPrincipal;    //  Barra principal del menu
    
    private JMenu menuConfigurar;   //  Menu de configuracion
    
    private JMenuItem itemBotones;  //  Menu Item que abre el dialogo de configuracion

    /**
     * Constructor de la clase VentanaPrincipal
     */
    public VentanaPrincipal() {
        dialogoConfiguracion = new DialogoConfiguracion(this);
        configurarVentana();
    }
    
    /**
     * Metodo para configurar la ventana
     */
    public void configurarVentana(){
        setTitle("Matriz de botones");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout(10, 10));
        
        agregarElementos();
        
        setVisible(true);
    }
    
    /**
     * Metodo para agregar los elementos a la ventana
     */
    public void agregarElementos(){
        
        Font fuente = new Font("Calibri", Font.PLAIN, 23);
        
        itemBotones = new JMenuItem("Cantidad Botones");
        itemBotones.setFont(fuente);
        itemBotones.addActionListener(new EscucharMenu());
        
        menuConfigurar = new JMenu("Configurar");
        menuConfigurar.setFont(fuente);
        menuConfigurar.add(itemBotones);
        
        barraPrincipal = new JMenuBar();
        barraPrincipal.add(menuConfigurar);
        add(barraPrincipal, BorderLayout.NORTH);
        
        panelBotones = new PanelBotones(this);
        add(panelBotones, BorderLayout.CENTER);
    }
    
    /**
     * Clase que esta a la escucha de la barra de menu
     */
    class EscucharMenu implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
             dialogoConfiguracion.setVisible(true);
        }
        
    }

    /**
     * Obtener el valor del panel de botones
     * @return panelBotones
     */
    public PanelBotones getPanelBotones() {
        return panelBotones;
    }

    /**
     * Cambiar el valor del panel de botones
     * @param panelBotones 
     */
    public void setPanelBotones(PanelBotones panelBotones) {
        this.panelBotones = panelBotones;
    }
    
}
