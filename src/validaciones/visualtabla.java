/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import controllers.Bidon;
import controllers.Cliente;
import controllers.Com_Ven;
import controllers.Render;
import controllers.Vales;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.mCliente;
import model.mProducto;
import model.mValacu;

/**
 *
 * @author DARVIN
 */
public class visualtabla {

    Cliente cli = new Cliente();
    Vales val = new Vales();
    Bidon bid = new Bidon();
    Com_Ven com = new Com_Ven();
public void lis_cli(JTable tabla, String valor) {
        JButton btn_edi = new JButton("Editar");
        boolean[] editable = {false, false, false, true, false, false};
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Apellidos", "Nombres", "DNI", "Telefono", "Selecciona"}, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };
        btn_edi.setName("q");
        mCliente mcli = new mCliente();
        ArrayList<mCliente> list = cli.Lis_Cli(valor);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[6];
                mcli = list.get(i);
                fila[0] = mcli.getIdcli();
                fila[1] = mcli.getApecli();
                fila[2] = mcli.getNomcli();
                fila[3] = mcli.getDnicli();
                fila[4] = mcli.getTelcli();
                fila[5] = btn_edi;
                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(20);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(7);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
    }

    public void val_acu(JTable tabla, String valor) {
        
        boolean[] editable = {false, false, false, false};
        JButton btn_quitar = new JButton("Enviar");
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Codigo", "Fecha Vale", "Seleccionar"}, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };
        btn_quitar.setName("q");
        mValacu mval = new mValacu();
        ArrayList<mValacu> list = val.Lis_Valfir(valor);
        
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                mval = list.get(i);
                fila[0] = mval.getIddetval();
                fila[1] = mval.getCod();
                fila[2] = mval.getFecvale();
                fila[3] = btn_quitar;
                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(25);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
    }

    public void val_no_fir(JTable tabla, String valor) {
        
        boolean[] editable1 = {false, false, false, false, false};
        JButton btn_quitar1 = new JButton("Firmar");
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Apellidos y Nombres", "DNI", "Codigo", "Seleccionar"}, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, 
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            public boolean isCellEditable(int row, int column) {
                return editable1[column];
            }
        };
        btn_quitar1.setName("q1");
        ArrayList<mValacu> list = val.Lis_valnofir(valor);
        mValacu mval = new mValacu();
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                mval = list.get(i);
                fila[0] = mval.getIddetval();
                fila[1] = mval.getApenom();
                fila[2] = mval.getDnicli();
                fila[3] = mval.getCod();
                if (mval.getEstdetval().equals("0")) {
                    fila[4] = btn_quitar1;
                }

                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);

    }

    public void lis_no_can(JTable tabla, String valor) {
        boolean[] editable = {false, false, false, false};
        JButton btn_enc = new JButton("Encargar");
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Apellidos", "Nombres", "Selecciona"}, 0) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };
        btn_enc.setName("q");
        mCliente mcli = new mCliente();
        ArrayList<mCliente> list = bid.Lis_Cli(valor);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                mcli = list.get(i);
                fila[0] = mcli.getIdcli();
                fila[1] = mcli.getApecli();
                fila[2] = mcli.getNomcli();
                fila[3] = btn_enc;
                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(20);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(8);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(60);
    }

    public void lis_pro(JTable tabla, String valor) {
        JButton btn_env = new JButton("Enviar");
        boolean[] editable = {false, false, false, false, false, false};
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Id1", "Producto", "Stock", "PreCompra", "Accion"}, 0) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };
        btn_env.setName("envpro");
        mProducto mpro = new mProducto();
        ArrayList<mProducto> list = com.Lis_Pro(valor);
        
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[6];
                mpro = list.get(i);
                fila[0] = mpro.getIdpro();
                fila[1] = mpro.getIddc();
                fila[2] = mpro.getNompro();
                fila[3] = mpro.getStopro();
                fila[4] = mpro.getPre0();

                fila[5] = btn_env;
                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(20);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(7);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void lis_procom(JTable tabla, String valor) {
        JButton btn_env = new JButton("Enviar");
        boolean[] editable = {false, false, false, false, false};
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Id1", "Producto", "Stock", "Accion"}, 0) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };
        btn_env.setName("envpro");
        mProducto mpro = new mProducto();
        ArrayList<mProducto> list = com.Lis_Procom(valor);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                mpro = list.get(i);
                fila[0] = mpro.getIdpro();
                fila[1] = 1;
                fila[2] = mpro.getNompro();
                fila[3] = mpro.getStopro();
                fila[4] = btn_env;
                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(20);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(7);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
    }

    public void val_agr(JTable tabla, String va1, String va2) {
        boolean[] editable1 = {false, false, false};
        JButton btn_qui = new JButton("Quitar");
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Codigo", "Fecha", "Accion"}, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable1[column];
            }
        };
        btn_qui.setName("qui");
        DefaultTableModel tabladet = (DefaultTableModel) tabla.getModel();
        Object[] dato = new Object[3];
        int c = 0;
        int j = 0;
        for (int i = 0; i < tabla.getRowCount(); i++) {
            Object com = tabla.getValueAt(i, 0);
            if (va1.equals(com)) {
                j = i;
                c = c + 1;
            }
        }
        if (c == 0) {
            dato[0] = va1;
            dato[1] = va2;
            dato[2] = btn_qui;
            tabladet.addRow(dato);
            tabla.setModel(tabladet);
        }
    }

    public void qui_fila(JTable tbpven, java.awt.event.MouseEvent evt) {
        int rown = -1;
        rown = tbpven.rowAtPoint(evt.getPoint());
        int column = tbpven.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbpven.getRowHeight();
        int po = evt.getY();
        if (row < tbpven.getRowCount() && row >= 0 && column < tbpven.getColumnCount() && column >= 0) {
            Object value = tbpven.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getName().equals("qui")) {
                    try {
                        DefaultTableModel model = (DefaultTableModel) tbpven.getModel();
                        model.removeRow(tbpven.getSelectedRow());

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }
    }

    public void lim_tabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int a = tabla.getRowCount() - 1;
        int i;
        for (i = a; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
   
}
