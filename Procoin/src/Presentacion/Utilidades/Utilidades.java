package Presentacion.Utilidades;

//Librerías importadas
import java.awt.Component;
import java.awt.Container;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *@author Anthony Sánchez S.
 *@author José Cedeño
 *@author Mariana Bermudez
 *@author María Fernanda Niño
 */

//Clase para componentes del formulario
public class Utilidades {
    
    //Función para habilitar el botón Aceptar
    public void habilitar_Boton(Component cmp_Component, String str_Name)
    {
        if(cmp_Component instanceof JButton)
        {
            JButton btn = (JButton) cmp_Component;
            
            btn.setEnabled(true);

        } else 
        {
            if(cmp_Component instanceof Container)
            {
                for(Component c: ((Container) cmp_Component).getComponents())
                {
                    habilitar_Boton(c, str_Name);
                }
            }
        }
    }
    
    //Función para inhabilitar el botón Aceptar
    public void inhabilitar_Boton(Component cmp_Component, String str_Name)
    {
        if(cmp_Component instanceof JButton)
        {
            JButton btn = (JButton) cmp_Component;
            
            if(btn.getText().equals(str_Name))
            {
                btn.setEnabled(false);
            }
            else
            {
                btn.setEnabled(true);
            }
        } else 
        {
            if(cmp_Component instanceof Container)
            {
                for(Component c: ((Container) cmp_Component).getComponents())
                {
                    inhabilitar_Boton(c, str_Name);
                }
            }
        }
    }
    
    //Habilitar JTextfield, JComboBox, JRadioButton.
    public void habilitar_Componentes(Component cmp_Component)
    {
        if(cmp_Component instanceof JTextField)
        {
            JTextField text = (JTextField) cmp_Component;
            text.setEditable(true);
        }
        else
        {
            if(cmp_Component instanceof JComboBox)
            {
                JComboBox cmb = (JComboBox) cmp_Component;
                cmb.setEnabled(true);
            }
            else
            {
                if(cmp_Component instanceof JRadioButton)
                {
                    JRadioButton rdb = (JRadioButton) cmp_Component;
                    rdb.setEnabled(true);
                }
                else 
                {
                    if(cmp_Component instanceof JTextArea)
                    {
                        JTextArea text = (JTextArea) cmp_Component;
                        text.setEditable(true);
                    }
                    else
                    {
                        if(cmp_Component instanceof Container)
                        {
                            for(Component c: ((Container) cmp_Component).getComponents())
                            {
                                habilitar_Componentes(c);
                            }
                        }    
                    }
                }
            }
        }
    }
    
    //Inhabilitar JTextfield, JComboBox, JRadioButton.
    public void inhabilitar_Componentes(Component cmp_Component)
    {
        if(cmp_Component instanceof JTextField)
        {
            JTextField text = (JTextField) cmp_Component;

                text.setEditable(false);
        }
        else
        {
            if(cmp_Component instanceof JComboBox)
            {
                JComboBox cmb = (JComboBox) cmp_Component;
                cmb.setEnabled(false);
            }
            else
            {
                if(cmp_Component instanceof JRadioButton)
                {
                    JRadioButton rdb = (JRadioButton) cmp_Component;
                    rdb.setEnabled(false);
                }
                else 
                {
                    if(cmp_Component instanceof JTextArea)
                    {
                        JTextArea text = (JTextArea) cmp_Component;
                        text.setEditable(false);
                    }
                    else
                    {
                        if(cmp_Component instanceof Container)
                        {
                            for(Component c: ((Container) cmp_Component).getComponents())
                            {
                                inhabilitar_Componentes(c);
                            }
                        }    
                    }
                }
            }
        }
    }
    
    //Función para limpiar todos los campos del formulario
    public void limpiar_Componentes(Component cmp_Component)
    {
        if(cmp_Component instanceof JTextField)
        {
            JTextField text = (JTextField) cmp_Component;
            text.setText("");
        } 
        else 
        {
            if(cmp_Component instanceof JComboBox)
            {
                JComboBox cmb = (JComboBox) cmp_Component;
                cmb.setSelectedItem(null);
            } 
            else 
            {
                if(cmp_Component instanceof JTextArea)
                    {
                        JTextArea text = (JTextArea) cmp_Component;
                        text.setText("");
                    }
                    else
                    {
                        if(cmp_Component instanceof Container)
                        {
                            for(Component c: ((Container) cmp_Component).getComponents())
                            {
                                limpiar_Componentes(c);
                            }
                        }    
                    }
            }    
        }
    }
    
    //Validación de moneda
    public String validar_moneda(String str_Credito)
    {
        DecimalFormat formateador = new DecimalFormat("#########.##");
        String str_Moneda = null;
        double dbl_Moneda = 0.0;
        str_Moneda = str_Credito.replace(",", "");
        dbl_Moneda = Double.parseDouble(str_Moneda);
        str_Moneda = formateador.format(dbl_Moneda);
        return str_Moneda;
    }
    
}
