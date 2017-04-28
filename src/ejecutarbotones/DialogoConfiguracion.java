
package ejecutarbotones;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Anggy Arguello - Holmes Ayala
 */
public class DialogoConfiguracion extends JDialog{
    
    private JLabel etiquetaFila;    //  Etiqueta para la fila
    
    private JLabel etiquetaColumna; //  Etiqueta para la columna
    
    private JTextField textoFila;   //  Caja de texto para la fila
    
    private JTextField textoColumna;    //  Caja de texto para la columna
    
    private JButton btnAceptar; //  Boton para ingresar los cambios
    
    private VentanaPrincipal ventanaPrincipal;  //  Objeto de la clase VentanaPrincipal

    /**
     * Constructor de la clase DialogoConfiguracion
     * @param ventanaPrincipal 
     */
    public DialogoConfiguracion(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
         configurarDialogo();
    }
    
    /**
     * Metodo que configura el dialogo
     */
    public void configurarDialogo(){
        setTitle("Cambiar cantidad de botones");
        setSize(320, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setResizable(false);
        setBackground(Color.WHITE);
        
        agregarElementos();
    }
    
    /**
     * Metodo para agregar elementos al dialogo
     */
    public void agregarElementos(){
        Font fuente = new Font("Calibri",  Font.PLAIN, 30);
        
        etiquetaFila = new JLabel("Filas:");
        etiquetaFila.setBounds(10, 40, 150, 30);
        etiquetaFila.setFont(fuente);
        add(etiquetaFila);
        
        etiquetaColumna = new JLabel("Columnas:");
        etiquetaColumna.setBounds(10, 80, 150, 30);
        etiquetaColumna.setFont(fuente);
        add(etiquetaColumna);
        
        textoFila = new JTextField();
        textoFila.setBounds(160, 40, 150, 30);
        textoFila.setFont(fuente);
        add(textoFila);
        
        textoColumna = new JTextField();
        textoColumna.setBounds(160, 80, 150, 30);
        textoColumna.setFont(fuente);
        add(textoColumna);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new escucharBoton());
        btnAceptar.setBounds(100, 125, 100, 30);
        add(btnAceptar);
        
    }
    
    /**
     * Clase que esta a la escucha del boton de aceptar
     */
    class escucharBoton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(soloNumeros(textoFila.getText().trim()) && soloNumeros(textoColumna.getText().trim())){
                int filas = Integer.parseInt(textoFila.getText().trim());
                int columnas = Integer.parseInt(textoColumna.getText().trim());
                if((filas > 0 && columnas > 0) && (filas < 6 && columnas < 6)){
                    setVisible(false);
                    ventanaPrincipal.getPanelBotones().eliminarElementos();
                    ventanaPrincipal.getPanelBotones().getGrilla().setRows(filas);
                    ventanaPrincipal.getPanelBotones().getGrilla().setColumns(columnas);
                    ventanaPrincipal.getPanelBotones().agregarElementos();
                }
            }
        }
        
    }
    
    /**
     * Metodo para validar que un string solo tenga numeros
     * @param numero
     * @return 
     */
    public boolean soloNumeros(String numero){
        for(int i = 0; i < numero.length(); i++){
            if(numero.charAt(i) < '0' || numero.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
}
