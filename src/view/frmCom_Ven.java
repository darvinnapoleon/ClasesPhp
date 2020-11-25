/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.Com_Ven;
import controllers.Render;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.mCaja;
import model.mCompra;
import model.mVenta;
import validaciones.Fechas;
import validaciones.Let_Num;
import validaciones.visualtabla;

/**
 *
 * @author DARVIN
 */
public class frmCom_Ven extends javax.swing.JInternalFrame {

    visualtabla v1 = new visualtabla();
    int rown = -1;
    Com_Ven comven = new Com_Ven();
    Let_Num numlet = new Let_Num();
    mCaja mcaj = new mCaja();
    mCompra mcom = new mCompra();
    mVenta mven = new mVenta();
    Fechas fec = new Fechas();

    /**
     * Creates new form frmLisCli
     */
    public frmCom_Ven() {
        initComponents();
        idpro.setVisible(false);
        lbsto.setVisible(false);
        lbpc.setVisible(false);
        iddc.setVisible(false);
        lbtot.setVisible(false);
        tfpro.setEnabled(false);
        tfcan.setEnabled(false);
        tfpre.setEnabled(false);
        lbmicaj.setVisible(false);
        v1.lis_pro(tbpro, "");
        dat_caj();

    }
    void calcular() {
        String pre;
        String can;
        double subtotal = 0;
        double precio;
        int cantidad;
        double imp = 0.0;
        for (int i = 0; i < tbpven.getRowCount(); i++) {
            can = tbpven.getValueAt(i, 4).toString();
            pre = tbpven.getValueAt(i, 5).toString();
            precio = Double.parseDouble(pre);
            cantidad = Integer.parseInt(can);
            imp = precio * cantidad;
            subtotal = subtotal + imp;
        }
        lbtot.setText("" + Math.rint(subtotal * 100) / 100);
    }

    

    void versto(String sto, String pcom) {
        if (rbven.isSelected() == true) {
            int st = Integer.parseInt(sto);
            double pc = Double.parseDouble(pcom);
            if (st < Integer.parseInt(tfcan.getText())) {
                JOptionPane.showMessageDialog(null, "Falta stock");
                tfcan.requestFocus();
                return;
            }
            if (Double.parseDouble(tfpre.getText()) <= pc) {
                JOptionPane.showMessageDialog(null, "Precio incorrecto");
                tfpre.requestFocus();
                return;
            } else {
                agr_pro(tbpven, "");
                this.lim_dat();
                tfpro.setEnabled(false);
                tfcan.setEnabled(false);
                tfpre.setEnabled(false);
                 calcular();
            }

        }
        if (rbcom.isSelected() == true) {
            agr_pro(tbpven, "");
            this.lim_dat();
            tfpro.setEnabled(false);
            tfcan.setEnabled(false);
            tfpre.setEnabled(false);
             calcular();
        }

    }

    public void agr_pro(JTable tabla, String valor) {
        boolean[] editable1 = {false, false, false, false, false, false, false, false};
        JButton btn_qui = new JButton("Quitar");
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Id1","Id2", "Producto", "Cantidad", "Precio", "Subtotal", "Accion"}, 0) {
            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class
                    , java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable1[column];
            }
        };
        String id = "" + idpro.getText();
        String id1 = "" + iddc.getText();
        String id2 = "" + lbpc.getText();
        String des = "" + tfpro.getText();
        String can = "" + tfcan.getText();
        double pre1 = Math.rint(Double.parseDouble(tfpre.getText()) * 100) / 100;
        String pre = "" + pre1;
        double calsub = Math.rint(Integer.parseInt(can) * pre1 * 100) / 100;
        String sub = "" + calsub;
        DefaultTableModel tabladet = (DefaultTableModel) frmCom_Ven.tbpven.getModel();
        Object dato[] = new Object[8];
        int c = 0;
        int j = 0;
        for (int i = 0; i < frmCom_Ven.tbpven.getRowCount(); i++) {
            Object com = frmCom_Ven.tbpven.getValueAt(i, 0);
            if (id.equals(com)) {
                j = i;
                c = c + 1;
            }
        }
        btn_qui.setName("qui");
        if (c == 0) {
            dato[0] = id;
            dato[1] = id1;
            dato[2] = id2;
            dato[3] = des;
            dato[4] = can;
            dato[5] = pre;
            dato[6] = sub;
            dato[7] = btn_qui;
            tabladet.addRow(dato);
            tabla.setModel(tabladet);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(10);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100);
        }
    }

    void dat_caj() {
        ArrayList<mCaja> list = comven.Dat_Caj(fec.fec_act());
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                mcaj = list.get(i);
                lbmicaj.setText(""+mcaj.getMicaj());
                lbmfin.setText("" + mcaj.getMfcaj());
                lbmov.setText("" + mcaj.getMovcaj());
            }
        }
    }

    void lim_dat() {
        idpro.setText("");
        tfpro.setText("");
        tfcan.setText("");
        tfpre.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tfmini = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbmfin = new javax.swing.JLabel();
        lbmov = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpro = new javax.swing.JTable();
        rbcom = new javax.swing.JRadioButton();
        rbven = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        tfpre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfcan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpven = new javax.swing.JTable();
        tfpro = new javax.swing.JTextField();
        breg = new javax.swing.JButton();
        btcom = new javax.swing.JButton();
        btven = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfmini1 = new javax.swing.JTextField();
        idpro = new javax.swing.JLabel();
        lbsto = new javax.swing.JLabel();
        lbpc = new javax.swing.JLabel();
        lbtot = new javax.swing.JLabel();
        iddc = new javax.swing.JLabel();
        lbmicaj = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("COMPRAS Y VENTAS");

        jPanel1.setBackground(java.awt.Color.lightGray);
        jPanel1.setToolTipText("");

        tfmini.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfminiKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfminiKeyTyped(evt);
            }
        });

        jLabel1.setText("M.Inicial:");

        jLabel2.setText("Monto Finial:");

        lbmfin.setText("                 ");

        lbmov.setText("                         ");

        jLabel5.setText("Movimiento:");

        tbpro.setBackground(new java.awt.Color(204, 204, 204));
        tbpro.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbpro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Producto", "Stock", "PreCompra", "Id1", "Accion"
            }
        ));
        tbpro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbproMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbpro);

        buttonGroup1.add(rbcom);
        rbcom.setText("Comprar");
        rbcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbcomActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbven);
        rbven.setSelected(true);
        rbven.setText("Vender");
        rbven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbvenActionPerformed(evt);
            }
        });

        jLabel3.setText("Precio:");

        tfpre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfpreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfpreKeyTyped(evt);
            }
        });

        jLabel4.setText("Cantidad:");

        tfcan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfcanKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfcanKeyTyped(evt);
            }
        });

        tbpven.setBackground(new java.awt.Color(204, 204, 204));
        tbpven.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbpven.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Id1", "Producto", "Cantidad", "Precio", "Subtotal", "Accion"
            }
        ));
        tbpven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpvenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbpven);

        tfpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfproActionPerformed(evt);
            }
        });

        breg.setText("RegVenta");
        breg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bregActionPerformed(evt);
            }
        });

        btcom.setText("HisCompras");

        btven.setText("HisVentas");

        jLabel6.setText("Confirma:");

        tfmini1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfmini1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfmini1KeyTyped(evt);
            }
        });

        idpro.setText("               ");
        idpro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbsto.setText("               ");
        lbsto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbpc.setText("               ");
        lbpc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbtot.setText("               ");
        lbtot.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        iddc.setText("               ");
        iddc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbmicaj.setText("                         ");
        lbmicaj.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(breg)
                .addGap(199, 199, 199))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfmini, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(rbcom)
                                        .addGap(18, 18, 18)
                                        .addComponent(iddc)
                                        .addGap(8, 8, 8)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(rbven)
                                        .addGap(26, 26, 26)
                                        .addComponent(idpro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbsto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbpc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbtot))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfmini1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btven)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btcom))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbmfin)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbmov)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbmicaj))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(tfpro, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfcan, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfpre, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfmini1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfmini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(btcom)
                        .addComponent(btven)))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lbmfin))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(lbmov)
                        .addComponent(lbmicaj)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbcom, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbven)
                    .addComponent(idpro)
                    .addComponent(lbsto)
                    .addComponent(lbpc)
                    .addComponent(lbtot)
                    .addComponent(iddc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfcan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfpre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(tfpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(breg)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbcomActionPerformed
        // TODO add your handling code here:
        if (rbcom.isSelected() == true) {
            breg.setText("RegCompra");
            v1.lim_tabla(tbpven);
            v1.lis_procom(tbpro, "");
            this.lim_dat();
        }
    }//GEN-LAST:event_rbcomActionPerformed

    private void tfproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfproActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfproActionPerformed

    private void tfminiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfminiKeyPressed
        // TODO add your handling code here
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tfmini1.requestFocus();
        }
    }//GEN-LAST:event_tfminiKeyPressed

    private void tfminiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfminiKeyTyped
        // TODO add your handling code here
        numlet.numdec(evt, tfmini.getText());
    }//GEN-LAST:event_tfminiKeyTyped

    private void tfmini1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfmini1KeyTyped
        // TODO add your handling code here:
        numlet.numdec(evt, tfmini1.getText());
    }//GEN-LAST:event_tfmini1KeyTyped

    private void tfmini1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfmini1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tfmini.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ingresar monto");
                tfmini.requestFocus();
                return;
            }
            if (tfmini1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Confirmar monto");
                tfmini1.requestFocus();
                return;
            } else {
                double mi1, mi2;
                mi1 = Double.parseDouble(tfmini.getText());
                mi2 = Double.parseDouble(tfmini1.getText());
                if (mi1 != mi2) {
                    JOptionPane.showMessageDialog(null, "Confirmar monto");
                    tfmini1.requestFocus();
                    return;
                }
                mcaj.setFeccaj(fec.fec_act());
                if (comven.ver_caj(mcaj).equals("")) {
                    mcaj.setFeccaj(fec.fec_act());
                    mcaj.setMicaj(mi1);
                    mcaj.setMfcaj(mi1);
                    mcaj.setMovcaj(0.0);
                    comven.ins_caj(mcaj);
                    tfmini.setText("");
                    tfmini1.setText("");
                    dat_caj();
                    return;
                }
                JOptionPane.showMessageDialog(null, "La caja ya se aperturo");
            }
        }
    }//GEN-LAST:event_tfmini1KeyPressed

    private void tbproMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbproMouseClicked
        // TODO add your handling code here:
        rown = tbpro.rowAtPoint(evt.getPoint());
        int column = tbpro.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbpro.getRowHeight();
        int po = evt.getY();
        if (row < tbpro.getRowCount() && row >= 0 && column < tbpro.getColumnCount() && column >= 0) {
            Object value = tbpro.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getName().equals("envpro")) {
                    try {
                        idpro.setText(tbpro.getModel().getValueAt(rown, 0).toString());
                        iddc.setText(tbpro.getModel().getValueAt(rown, 1).toString());
                        tfpro.setText(tbpro.getModel().getValueAt(rown, 2).toString());
                        lbsto.setText(tbpro.getModel().getValueAt(rown, 3).toString());
                        lbpc.setText(tbpro.getModel().getValueAt(rown, 4).toString());
                       
                        tfpro.setEnabled(true);
                        tfcan.setEnabled(true);
                        tfpre.setEnabled(true);
                        tfcan.requestFocus();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }
    }//GEN-LAST:event_tbproMouseClicked

    private void tfcanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.tfpre.requestFocus();
        }
    }//GEN-LAST:event_tfcanKeyPressed

    private void tfpreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpreKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (this.tfcan.getText().isEmpty() || this.tfcan.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Ingresar Cantidad");
                this.tfcan.requestFocus();
                return;
            }
            if (this.tfpre.getText().isEmpty() || this.tfpre.getText().equals("0")) {
                JOptionPane.showMessageDialog(null, "Ingresar Precio");
                this.tfpre.requestFocus();
                return;
            } else {

                versto(lbsto.getText(), lbpc.getText());

            }

        }
    }//GEN-LAST:event_tfpreKeyPressed

    private void tfcanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfcanKeyTyped
        // TODO add your handling code here:
        numlet.solonum(evt);
    }//GEN-LAST:event_tfcanKeyTyped

    private void tfpreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpreKeyTyped
        // TODO add your handling code here:
        numlet.numdec(evt, tfpre.getText());
    }//GEN-LAST:event_tfpreKeyTyped

    private void tbpvenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpvenMouseClicked
        // TODO add your handling code here:
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
                        this.lim_dat();
                         calcular();
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }
    }//GEN-LAST:event_tbpvenMouseClicked

    private void rbvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbvenActionPerformed
        // TODO add your handling code here:
        if (rbven.isSelected() == true) {
            breg.setText("RegVenta");
            v1.lim_tabla(tbpven);
            v1.lis_pro(tbpro, "");
            this.lim_dat();

        }
    }//GEN-LAST:event_rbvenActionPerformed

    private void bregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bregActionPerformed
        // TODO add your handling code here:
        mcaj.setFeccaj(fec.fec_act());
        if (comven.ver_caj(mcaj).equals("")) {
            JOptionPane.showMessageDialog(null, "Aperturar caja");
            tfmini.requestFocus();
            return;
        } else {
            if (rbven.isSelected() == true) {
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Estas seguro de realizar la venta", "confirma el mensaje", JOptionPane.YES_NO_OPTION);
                if (YesOrNo == 0) {
                    for (int i = 0; i < frmCom_Ven.tbpven.getRowCount(); i++) {
                        mven.setIdpro(Integer.parseInt(tbpven.getValueAt(i, 0).toString()));
                        mven.setFecven(fec.fec_act());
                        mven.setPrecom(Double.parseDouble(tbpven.getValueAt(i, 2).toString()));
                        mven.setCanven(Integer.parseInt(tbpven.getValueAt(i, 4).toString()));
                        mven.setPreven(Double.parseDouble(tbpven.getValueAt(i, 5).toString()));
                        mven.setNumval(0);
                        comven.ins_ven(mven);
                    }
                    for (int i = 0; i < frmCom_Ven.tbpven.getRowCount(); i++) {
                        mven.setIdpro(Integer.parseInt(tbpven.getValueAt(i, 0).toString()));
                        mven.setCanven(Integer.parseInt(tbpven.getValueAt(i, 4).toString()));
                        comven.disstock(mven);
                    }
                    
                    for (int i = 0; i < frmCom_Ven.tbpven.getRowCount(); i++) {
                        mcom.setIddc(Integer.parseInt(tbpven.getValueAt(i, 1).toString()));
                        int canven=(Integer.parseInt(tbpven.getValueAt(i, 4).toString()));
                        comven.disstodc(mcom, canven);
                    }
                    mcaj.setMfcaj(Double.parseDouble(lbtot.getText()));
                    comven.aum_mfcaj(mcaj);
                    dat_caj();
                    mcaj.setMicaj(Double.parseDouble(lbmicaj.getText()));
                    mcaj.setMfcaj(Double.parseDouble(lbmfin.getText()));
                    comven.aum_movcaj(mcaj);
                    dat_caj();
                    v1.lim_tabla(tbpven);
                    v1.lis_pro(tbpro, "");
                }

            }
            if (rbcom.isSelected() == true) {
                int YesOrNo = JOptionPane.showConfirmDialog(null, "Estas seguro de realizar la compra", "confirma el mensaje", JOptionPane.YES_NO_OPTION);
                if (YesOrNo == 0) {
                    //la compra
                    mcom.setFeccom(fec.fec_act());
                    mcom.setTotcom(Double.parseDouble(lbtot.getText()));
                    comven.ins_com(mcom);
                    //detalle compra
                    for (int i = 0; i < frmCom_Ven.tbpven.getRowCount(); i++) {
                        mcom.setIdpro(Integer.parseInt(tbpven.getValueAt(i, 0).toString()));
                        mcom.setIdcom(0);
                        mcom.setCancom(Integer.parseInt(tbpven.getValueAt(i, 4).toString()));
                        mcom.setPrecom(Double.parseDouble(tbpven.getValueAt(i, 5).toString()));
                        mcom.setSubcom(Double.parseDouble(tbpven.getValueAt(i, 6).toString()));
                        mcom.setStopro(Integer.parseInt(tbpven.getValueAt(i, 4).toString()));
                        comven.ins_detcom(mcom);
                    }
                    //aumentar stock
                    for (int i = 0; i < frmCom_Ven.tbpven.getRowCount(); i++) {
                        mcom.setIdpro(Integer.parseInt(tbpven.getValueAt(i, 0).toString()));
                        mcom.setCancom(Integer.parseInt(tbpven.getValueAt(i, 4).toString()));
                        comven.aum_stock(mcom);
                    }
                    
                    v1.lim_tabla(tbpven);
                    v1.lis_procom(tbpro, "");

                }

            }

        }

    }//GEN-LAST:event_bregActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton breg;
    private javax.swing.JButton btcom;
    private javax.swing.JButton btven;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel iddc;
    private javax.swing.JLabel idpro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbmfin;
    private javax.swing.JLabel lbmicaj;
    private javax.swing.JLabel lbmov;
    private javax.swing.JLabel lbpc;
    private javax.swing.JLabel lbsto;
    private javax.swing.JLabel lbtot;
    public javax.swing.JRadioButton rbcom;
    public javax.swing.JRadioButton rbven;
    public static javax.swing.JTable tbpro;
    public static javax.swing.JTable tbpven;
    private javax.swing.JTextField tfcan;
    private javax.swing.JTextField tfmini;
    private javax.swing.JTextField tfmini1;
    private javax.swing.JTextField tfpre;
    private javax.swing.JTextField tfpro;
    // End of variables declaration//GEN-END:variables
}
