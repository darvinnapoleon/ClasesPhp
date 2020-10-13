/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.*;
import controllers.*;
import java.awt.Color;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;

import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DARVIN
 */
public class frmLisVal extends javax.swing.JInternalFrame {

    private final JComponent component = new JCheckBox();
    int rown = -1;
    public JButton btn_quitar = new JButton("Enviar");
    public JButton btn_quitar1 = new JButton("Firmar");

    /**
     * Creates new form frmLisCli
     */
    //Tabla t = new Tabla();
    public frmLisVal() {
        initComponents();

        txtidven.setVisible(false);
        tabmes.setVisible(false);
        lbcodcli.setVisible(false);
        txtcli.setEnabled(false);
        txtcodval.setEnabled(false);

        // visualizar(tblisbol, "");
    }

    public void limpiarTabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tbvalagr.getModel();
            int filas = tbvalagr.getRowCount();
            for (int i = 0; i <= filas; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {

        }
    }

    void mostrar(String valor) {
        try {
            DefaultTableModel modelo;
            Cliente clilis = new Cliente();
            modelo = clilis.datosvalmes(valor);
            this.tabmes.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    void mostrar1(String valor) {
        try {
            DefaultTableModel modelo;
            Cliente clilis = new Cliente();
            modelo = clilis.datosgas(valor);
            this.tbliscli.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }

    private boolean[] editable = {false, false, false, false};
    Vales dao;

    public void visualizar(JTable tabla, String valor) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Codigo", "Apellidos y Nombres", "Fecha Vale", "Seleccionar"}, 0) {

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
        btn_quitar.setName("q");

        dao = new Vales();
        mValacu vo = new mValacu();
        ArrayList<mValacu> list = dao.Listar_Valacumulado(valor);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[4];
                vo = list.get(i);
                fila[0] = vo.getIddetval();
                fila[1] = vo.getApenom();
                fila[2] = vo.getFecvale();
                fila[3] = btn_quitar;
                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(25);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
    }
    Cliente dao1;
    private boolean[] editable1 = {false, false, false, false, false};

    public void visualizar1(JTable tabla, String valor) {

        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"Id", "Apellidos y Nombres", "DNI", "Codigo", "Seleccionar"}, 0) {

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int row, int column) {
                return editable1[column];
            }
        };
        btn_quitar1.setName("q1");

        dao1 = new Cliente();
        mValacu vo = new mValacu();
        ArrayList<mValacu> list = dao1.Listar_Valfirmas(valor);
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getIddetval();
                fila[1] = vo.getApenom();
                fila[2] = vo.getDnicli();
                fila[3] = vo.getCod();
                if (vo.getFir() == 0) {
                    fila[4] = btn_quitar1;
                } else {
                    fila[4] = "ya firmo";
                }

                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
        tabla.setRowHeight(20);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
        txtvaldni.requestFocus();
        txtvaldni.setSelectionStart(0);
        txtvaldni.setSelectionEnd(txtvaldni.getText().length());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblisbol = new javax.swing.JTable();
        txtidven = new javax.swing.JLabel();
        txtvaldni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbvalagr = new javax.swing.JTable();
        btneli = new javax.swing.JButton();
        btnven = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabmes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbomes = new javax.swing.JComboBox<>();
        cboano = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtcodval = new javax.swing.JTextField();
        lbcodcli = new javax.swing.JLabel();
        btnregpro1 = new javax.swing.JButton();
        txtcli = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbliscli = new javax.swing.JTable();
        btnregpro2 = new javax.swing.JButton();
        btnregpro3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("VALES ACUMULATIVOS");

        jPanel1.setBackground(java.awt.Color.lightGray);

        tblisbol.setBackground(new java.awt.Color(153, 153, 153));
        tblisbol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblisbol.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tblisbol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Apellidos y Nombres", "Fecha Vale", "Accion"
            }
        ));
        tblisbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblisbolMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblisbol);

        txtidven.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        txtvaldni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtvaldniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvaldniKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel6.setText("Ingresa DNI:");

        tbvalagr.setBackground(new java.awt.Color(153, 153, 153));
        tbvalagr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbvalagr.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbvalagr.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Fecha de Vale"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbvalagr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbvalagrMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbvalagr);

        btneli.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btneli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Delete.png"))); // NOI18N
        btneli.setText("ELIMINAR");
        btneli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliActionPerformed(evt);
            }
        });

        btnven.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnven.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Save.png"))); // NOI18N
        btnven.setText("ENTREGAR");
        btnven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvenActionPerformed(evt);
            }
        });

        tabmes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Apellidos y Nombres", "DNI", "Codigo"
            }
        ));
        tabmes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabmesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabmes);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel4.setText("Fecha:");

        cbomes.setBackground(new java.awt.Color(255, 102, 0));
        cbomes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cbomes.setForeground(new java.awt.Color(255, 0, 0));
        cbomes.setMaximumRowCount(13);
        cbomes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        cbomes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbomes.setPreferredSize(new java.awt.Dimension(80, 23));

        cboano.setBackground(new java.awt.Color(255, 102, 0));
        cboano.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        cboano.setForeground(new java.awt.Color(255, 0, 0));
        cboano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "anio", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
        cboano.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboanoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Codigo de Vale:");

        txtcodval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodvalActionPerformed(evt);
            }
        });
        txtcodval.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodvalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodvalKeyTyped(evt);
            }
        });

        lbcodcli.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnregpro1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnregpro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Add.png"))); // NOI18N
        btnregpro1.setText("RegClientes");
        btnregpro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregpro1ActionPerformed(evt);
            }
        });

        txtcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcliActionPerformed(evt);
            }
        });

        tbliscli.setBackground(new java.awt.Color(204, 204, 204));
        tbliscli.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbliscli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Fecha Vale", "Fecha entrega", "Responsable"
            }
        ));
        jScrollPane4.setViewportView(tbliscli);

        btnregpro2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnregpro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Guardar1.JPG"))); // NOI18N
        btnregpro2.setText("Bidones");
        btnregpro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregpro2ActionPerformed(evt);
            }
        });

        btnregpro3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnregpro3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Imagenes/Save.png"))); // NOI18N
        btnregpro3.setText("No Canjeados");
        btnregpro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregpro3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cbomes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboano, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtcli, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnregpro1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtvaldni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtidven, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(btnven)
                                .addGap(18, 18, 18)
                                .addComponent(btneli))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtcodval, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(btnregpro2)
                                .addGap(18, 18, 18)
                                .addComponent(btnregpro3)
                                .addGap(60, 60, 60)
                                .addComponent(lbcodcli, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtvaldni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtidven, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btneli, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btnven, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnregpro1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtcodval, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbcodcli, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnregpro2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnregpro3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtvaldniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvaldniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtvaldniKeyTyped

    private void txtvaldniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvaldniKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String valor1 = this.txtvaldni.getText().trim();
            visualizar(tblisbol, valor1);
            visualizar1(tabmes, valor1);
            mostrar1(valor1);
            tabmes.setVisible(true);
            txtvaldni.requestFocus();
            txtvaldni.setSelectionStart(0);
            txtvaldni.setSelectionEnd(txtvaldni.getText().length());
            Cliente prolis = new Cliente();
            txtcli.setText(prolis.obtapenom(valor1));
            txtcli.setDisabledTextColor(Color.blue);
            lbcodcli.setText(prolis.obtacodcli(valor1));

            if (txtcli.getText().length() < 2) {
                txtvaldni.requestFocus();
                return;
            } else {
                txtcodval.requestFocus();
                txtcodval.setEnabled(true);
            }

        }
    }//GEN-LAST:event_txtvaldniKeyPressed

    private void tblisbolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblisbolMouseClicked

        rown = tblisbol.rowAtPoint(evt.getPoint());
        int column = tblisbol.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblisbol.getRowHeight();
        int po = evt.getY();
        if (row < tblisbol.getRowCount() && row >= 0 && column < tblisbol.getColumnCount() && column >= 0) {
            Object value = tblisbol.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                String va1 = "" + tblisbol.getValueAt(rown, 0);
                String va2 = "" + tblisbol.getValueAt(rown, 2);
                if (boton.getName().equals("q")) {
                    try {
                        DefaultTableModel tabladet = (DefaultTableModel) frmLisVal.tbvalagr.getModel();
                        String[] dato = new String[2];
                        int c = 0;
                        int j = 0;
                        for (int i = 0; i < frmLisVal.tbvalagr.getRowCount(); i++) {
                            Object com = frmLisVal.tbvalagr.getValueAt(i, 0);
                            if (va1.equals(com)) {
                                j = i;
                                c = c + 1;
                            }
                        }
                        if (c == 0) {
                            dato[0] = va1;
                            dato[1] = va2;
                            tabladet.addRow(dato);
                            frmLisVal.tbvalagr.setModel(tabladet);
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }

    }//GEN-LAST:event_tblisbolMouseClicked

    private void tbvalagrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbvalagrMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbvalagrMouseClicked

    private void btneliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbvalagr.getModel();
        int fila = tbvalagr.getSelectedRow();
        if (fila >= 0) {
            model.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(null, "Tabla vacia o no seleccione ninguna fila");
        }
    }//GEN-LAST:event_btneliActionPerformed

    private void btnvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvenActionPerformed
        // TODO add your handling code here:
        int conta = frmLisVal.tbvalagr.getRowCount();
        if (conta == 0) {
            JOptionPane.showMessageDialog(rootPane, "No ha agregado ningun vale");
        } else {
            String cant = JOptionPane.showInputDialog("A quien entregaras el gas");

            if ((cant == null || cant.equals(""))) {
                JOptionPane.showMessageDialog(null, "Ingresa el nombre de la persona que lleva el gas");

            } else {

                for (int i = 0; i < frmLisVal.tbvalagr.getRowCount(); i++) {
                    mDetVal Sql = new mDetVal();
                    Vales insdv = new Vales();
                    SimpleDateFormat formateador = new SimpleDateFormat(
                            "dd 'de' MMMM 'de' yyyy", new Locale("ES"));
                    Date fechaDate = new Date();
                    String fec = formateador.format(fechaDate);
                    Sql.setFecdetval(fec);
                    Sql.setEstdetval("0");
                    Sql.setResponsable(cant);
                    Sql.setFirma(1);
                    Sql.setIddetval(Integer.parseInt(tbvalagr.getValueAt(i, 0).toString()));
                    insdv.actvalacu(Sql);
                }

                DefaultTableModel modelo = (DefaultTableModel) tbvalagr.getModel();
                int a = tbvalagr.getRowCount() - 1;
                int i;
                for (i = a; i >= 0; i--) {
                    modelo.removeRow(i);
                }
                visualizar(tblisbol, txtvaldni.getText());
                mostrar1(txtvaldni.getText());
                txtvaldni.requestFocus();
                txtvaldni.setSelectionStart(0);
                txtvaldni.setSelectionEnd(txtvaldni.getText().length());
            }

        }
    }//GEN-LAST:event_btnvenActionPerformed

    private void txtcodvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodvalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodvalActionPerformed

    private void txtcodvalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodvalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtcodval.getText().length() == 0 || txtcodval.getText().equals(0) || txtcodval.getText().length() != 13) {
                JOptionPane.showMessageDialog(null, "ingresar codigo");
                txtcodval.requestFocus();
                return;
            }
            if (cbomes.getSelectedIndex() == 0 || cboano.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "ingresar fecha");
                return;
            } else {

                mDetVal sSql = new mDetVal();
                Vales insdv = new Vales();
                sSql.setMesvale(cbomes.getSelectedIndex());
                sSql.setAnovale(cboano.getSelectedItem().toString());
                sSql.setIdcli(Integer.parseInt(lbcodcli.getText()));
                if (insdv.vervale(sSql).equals("")) {
                    mDetVal Sql1 = new mDetVal();
                    Sql1.setIdcli(Integer.parseInt(lbcodcli.getText()));
                    Sql1.setCoddetval(txtcodval.getText());
                    Sql1.setEstdetval("1");
                    Sql1.setMesvale(cbomes.getSelectedIndex());
                    Sql1.setAnovale(cboano.getSelectedItem().toString());
                    insdv.insertar(Sql1);
                    txtvaldni.requestFocus();
                    txtvaldni.setSelectionStart(0);
                    txtvaldni.setSelectionEnd(txtvaldni.getText().length());
                    visualizar1(tabmes, txtvaldni.getText());
                    txtcodval.setText("");
                    txtcli.setText("");
                    txtcodval.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "El cliente ya es beneficiario");
                    txtvaldni.requestFocus();
                    txtvaldni.setSelectionStart(0);
                    txtvaldni.setSelectionEnd(txtvaldni.getText().length());
                }

            }
        }
    }//GEN-LAST:event_txtcodvalKeyPressed

    private void txtcodvalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodvalKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcodvalKeyTyped

    private void btnregpro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregpro1ActionPerformed
        // TODO add your handling code here:
        frmCliente pro = new frmCliente();
        frmPrincipal.panfer.add(pro);
        pro.toFront();
        pro.setVisible(true);
    }//GEN-LAST:event_btnregpro1ActionPerformed

    private void txtcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcliActionPerformed

    private void btnregpro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregpro2ActionPerformed
        // TODO add your handling code here:
        frmManBid pro = new frmManBid();
        frmPrincipal.panfer.add(pro);
        pro.toFront();
        pro.setVisible(true);
    }//GEN-LAST:event_btnregpro2ActionPerformed

    private void cboanoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboanoMouseClicked
        // TODO add your handling code here:
        if (cboano.getSelectedIndex() > 0) {
            txtcodval.requestFocus();
        }
    }//GEN-LAST:event_cboanoMouseClicked

    private void tabmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabmesMouseClicked
        // TODO add your handling code here:
        rown = tabmes.rowAtPoint(evt.getPoint());
        int column = tabmes.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tabmes.getRowHeight();
        int po = evt.getY();
        if (row < tabmes.getRowCount() && row >= 0 && column < tabmes.getColumnCount() && column >= 0) {
            Object value = tabmes.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                String va1 = "" + tabmes.getValueAt(rown, 0);
                String va2 = "" + tabmes.getValueAt(rown, 2);
                if (boton.getName().equals("q1")) {
                    try {
                        int YesOrNo = JOptionPane.showConfirmDialog(null, "Estas seguro que firmó", "confirma el mensaje", JOptionPane.YES_NO_OPTION);
                        if (YesOrNo == 0) {
                            mDetVal sSql = new mDetVal();
                            Vales emp = new Vales();
                            sSql.setIddetval(Integer.parseInt("" + tabmes.getValueAt(rown, 0)));
                            sSql.setFirma(1);
                            emp.actfir(sSql);
                            visualizar1(tabmes, txtvaldni.getText());
                            visualizar(tblisbol, txtvaldni.getText());
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }
    }//GEN-LAST:event_tabmesMouseClicked

    private void btnregpro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregpro3ActionPerformed
        // TODO add your handling code here:
        frmNoCan pro = new frmNoCan();
        frmPrincipal.panfer.add(pro);
        pro.toFront();
        pro.setVisible(true);
    }//GEN-LAST:event_btnregpro3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneli;
    private javax.swing.JButton btnregpro1;
    private javax.swing.JButton btnregpro2;
    private javax.swing.JButton btnregpro3;
    private javax.swing.JButton btnven;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboano;
    private javax.swing.JComboBox<String> cbomes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbcodcli;
    private javax.swing.JTable tabmes;
    public static javax.swing.JTable tblisbol;
    private javax.swing.JTable tbliscli;
    public static javax.swing.JTable tbvalagr;
    private javax.swing.JTextField txtcli;
    public static javax.swing.JTextField txtcodval;
    private javax.swing.JLabel txtidven;
    private javax.swing.JTextField txtvaldni;
    // End of variables declaration//GEN-END:variables
}
