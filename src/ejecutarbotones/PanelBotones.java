
package ejecutarbotones;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class PanelBotones extends JPanel{

    private Map<String, JButton> mapaBoton; //  Mapa que contiene los botones
    
    private GridLayout grilla;  //  Disposicion de los elementos del panel
    
    private VentanaPrincipal ventanaPrincipal;  //  Objeto de la clase VentanaPrincipal
    
    /**
     * Constructor de la clase PanelBotones
     * @param ventanaPrincipal 
     */
    public PanelBotones(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        mapaBoton = new HashMap<String, JButton>();
        configurarPanel();
        agregarElementos();
    }
    
    /**
     * Metodo que configura el panel
     */
    public void configurarPanel(){
        setBackground(Color.WHITE);
        grilla = new GridLayout(4, 4,10,10);
        setLayout(grilla);
    }
    
    /**
     * Metodo que agrega los botones al panel
     */
    public void agregarElementos(){
        ventanaPrincipal.setSize(grilla.getColumns() * 150, grilla.getRows() * 150);
        
        EscucharBoton escucharBoton = new EscucharBoton();
        for(int i = 0; i < grilla.getRows() * grilla.getColumns(); i++){
            JButton boton = new JButton("Boton " + (i+1));
            boton.setFont(new Font("Calibri",  Font.BOLD, 20));
            boton.addActionListener(escucharBoton);
            mapaBoton.put(boton.getActionCommand(), boton);
            add(mapaBoton.get(boton.getActionCommand()));
        }
    }
    
    /**
     * Metodo que elimina los botones del panel y del mapa de botones
     */
    public void eliminarElementos(){
        for(int i = 0; i < grilla.getRows() * grilla.getColumns(); i++){
            remove(mapaBoton.get("Boton " + (i+1)));
        }
        mapaBoton.clear();
        //repaint();
    }
    
    /**
     * Clase que esta a la escucha de los botones
     */
    class EscucharBoton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evento) {
            Random random = new Random();
            mapaBoton.get(evento.getActionCommand()).setBackground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        }
    }

    /**
     * Obtener la disposicion del panel
     * @return 
     */
    public GridLayout getGrilla() {
        return grilla;
    }

    /**
     * Cambiar la disposicion del panel
     * @param grilla 
     */
    public void setGrilla(GridLayout grilla) {
        this.grilla = grilla;
    }
    
}
