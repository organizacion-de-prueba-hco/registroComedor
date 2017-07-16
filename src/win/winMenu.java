package win;
import dao.daoAlmuerzo;
import dao.daoCena;
import dao.daoDesayuno;
import dao.daoExpediente;
import entities.Almuerzo;
import entities.Cena;
import entities.Desayuno;
import entities.Expediente;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.Validaciones;

/**
 *
 * @author Jhon
 */
public class winMenu extends javax.swing.JFrame implements Runnable{
    static DefaultTableModel modcli=new DefaultTableModel();
    public static DefaultTableModel moda=new DefaultTableModel();
    Validaciones validaciones;
    static daoExpediente daoex;
    static daoDesayuno daod;
    static daoAlmuerzo daoa;
    static daoCena daoc;
    Thread h1;
    String hora,minutos,segundos,ampm;
    public winMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Control de asistencias al comedor");
        modcli=(DefaultTableModel) tblcli.getModel();
        moda=(DefaultTableModel) tblAs.getModel();
        mostrarCli(); MostrarAsistencia();
        validaciones=new Validaciones();
        h1 = new Thread(this);
        h1.start();
    }
  /* public static void mostrarCli(){
        modcli.setNumRows(0);
        daoper = new daoComensal();
        List<Comensal> lstcli = daoper.Mostrar();
        for (Comensal per : lstcli) {
            Object[] dto={per.getDni(),per.getNom(),per.getApe(),
                          per.getEmail(),per.getTel()};
            modcli.addRow(dto); 
        }        
    }*/
    
    public static void mostrarCli(){
        modcli.setNumRows(0);
        daoex = new daoExpediente();
        List<Expediente> lstcli = daoex.Mostrar();
        for (Expediente p : lstcli) {
            //dni, apellido, nombres, tipo_beca
            Object[] dto={p.getId(),p.getCod(),p.getDni(),p.getApe(),
                          p.getNom(),p.getBeca(),p.getFac(),p.getEp()};
            modcli.addRow(dto); 
        }        
    }    
    
    void FiltarCli(String dato){
        modcli.setNumRows(0);
        daoex = new daoExpediente();
        List<Expediente> lstcli = daoex.Filtrar(dato);
        for (Expediente p : lstcli) {
            Object[] dto={p.getId(),p.getCod(),p.getDni(),p.getApe(),
                          p.getNom(),p.getBeca(),p.getFac(),p.getEp()};
            modcli.addRow(dto); 
        }        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        lblh = new javax.swing.JLabel();
        btnNp1 = new javax.swing.JButton();
        cmbEst = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAs = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnlP = new javax.swing.JPanel();
        txtnom = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtape = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtid = new org.edisoncor.gui.textField.TextFieldRectBackground();
        txtdni = new org.edisoncor.gui.textField.TextFieldRectBackground();
        jButton5 = new javax.swing.JButton();
        btnNp = new javax.swing.JButton();
        btnEp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcli = new javax.swing.JTable();
        txtBuscarP = new org.edisoncor.gui.textField.TextFieldRectIcon();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        jButton7.setBackground(new java.awt.Color(102, 204, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Asisitencias");
        jButton7.setFocusPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        lblh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblh.setText("Hora");

        btnNp1.setBackground(new java.awt.Color(0, 153, 204));
        btnNp1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNp1.setForeground(new java.awt.Color(255, 255, 255));
        btnNp1.setText("Migrar Datos");
        btnNp1.setFocusPainted(false);
        btnNp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNp1ActionPerformed(evt);
            }
        });

        cmbEst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Amuerzo", "Cena" }));
        cmbEst.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(cmbEst, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNp1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        tblAs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Codigo", "DNI", "Comensal", "Beca", "Facultad", "E.P"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAs.setFillsViewportHeight(true);
        tblAs.setFocusable(false);
        tblAs.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblAs);
        if (tblAs.getColumnModel().getColumnCount() > 0) {
            tblAs.getColumnModel().getColumn(0).setMinWidth(30);
            tblAs.getColumnModel().getColumn(0).setMaxWidth(30);
            tblAs.getColumnModel().getColumn(1).setMinWidth(80);
            tblAs.getColumnModel().getColumn(1).setMaxWidth(80);
            tblAs.getColumnModel().getColumn(2).setMinWidth(60);
            tblAs.getColumnModel().getColumn(2).setMaxWidth(60);
            tblAs.getColumnModel().getColumn(4).setMinWidth(40);
            tblAs.getColumnModel().getColumn(4).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Asistencia", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        jPanel5.setLayout(new java.awt.GridLayout(2, 2, 2, 2));

        pnlP.setBackground(new java.awt.Color(255, 255, 255));

        txtnom.setDescripcion("Nombres");

        txtape.setDescripcion("Apellidos");

        txtid.setEditable(false);
        txtid.setDescripcion("id");

        txtdni.setDescripcion("dni");
        txtdni.setName("dni"); // NOI18N

        jButton5.setBackground(new java.awt.Color(102, 204, 0));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("HUELLA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnNp.setBackground(new java.awt.Color(0, 153, 204));
        btnNp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNp.setForeground(new java.awt.Color(255, 255, 255));
        btnNp.setText("Nuevo");
        btnNp.setFocusPainted(false);
        btnNp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNpActionPerformed(evt);
            }
        });

        btnEp.setBackground(new java.awt.Color(0, 153, 204));
        btnEp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEp.setForeground(new java.awt.Color(255, 255, 255));
        btnEp.setText("Eliminar");
        btnEp.setFocusPainted(false);
        btnEp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPLayout = new javax.swing.GroupLayout(pnlP);
        pnlP.setLayout(pnlPLayout);
        pnlPLayout.setHorizontalGroup(
            pnlPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtdni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEp, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlPLayout.setVerticalGroup(
            pnlPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPLayout.createSequentialGroup()
                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtape, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 153, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tblcli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Codigo", "DNI", "Apellidos", "Nombres", "Beca", "Facultad", "E.P"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblcli.setFillsViewportHeight(true);
        tblcli.setFocusable(false);
        tblcli.getTableHeader().setReorderingAllowed(false);
        tblcli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcli);
        if (tblcli.getColumnModel().getColumnCount() > 0) {
            tblcli.getColumnModel().getColumn(0).setMinWidth(40);
            tblcli.getColumnModel().getColumn(0).setMaxWidth(40);
            tblcli.getColumnModel().getColumn(1).setMinWidth(70);
            tblcli.getColumnModel().getColumn(1).setMaxWidth(70);
            tblcli.getColumnModel().getColumn(2).setMinWidth(60);
            tblcli.getColumnModel().getColumn(2).setMaxWidth(60);
            tblcli.getColumnModel().getColumn(4).setMinWidth(150);
            tblcli.getColumnModel().getColumn(4).setMaxWidth(150);
            tblcli.getColumnModel().getColumn(5).setMinWidth(30);
            tblcli.getColumnModel().getColumn(5).setMaxWidth(30);
        }

        txtBuscarP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtBuscarP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Buscar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(7, 7, 7)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(pnlP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Comesales", jPanel1);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 2, true));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reportes", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPKeyReleased
       FiltarCli(txtBuscarP.getText());
    }//GEN-LAST:event_txtBuscarPKeyReleased

    private void tblcliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcliMouseClicked
        try {
            txtid.setText(modcli.getValueAt(tblcli.getSelectedRow(), 0).toString());
            txtdni.setText(modcli.getValueAt(tblcli.getSelectedRow(), 1).toString());
            txtnom.setText(modcli.getValueAt(tblcli.getSelectedRow(), 3).toString());
            txtape.setText(modcli.getValueAt(tblcli.getSelectedRow(), 2).toString());
            
        } catch (Exception e) {
        }       
    }//GEN-LAST:event_tblcliMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new winFirmar(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (txtdni.getText().isEmpty()|txtnom.getText().trim().isEmpty()|txtape.getText().trim().isEmpty()) {
                validaciones.mensaje("Deve Ingresar Los Datos Requeridos", JOptionPane.INFORMATION_MESSAGE);
                return;
        }
        new winHuellas(this, rootPaneCheckingEnabled).setVisible(true);  
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnNpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNpActionPerformed
        validaciones.limpiarjTextField(pnlP);
        txtdni.requestFocus();
    }//GEN-LAST:event_btnNpActionPerformed

    private void btnEpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEpActionPerformed
//        if (tblcli.getSelectedRow() == -1) {
//            validaciones.mensaje("Seleccionar registro a eliminar", JOptionPane.ERROR_MESSAGE);
//        } else {
//            int op = JOptionPane.showConfirmDialog(null, "Seguro que desea Eliminar registro?", "Mensage", JOptionPane.YES_NO_OPTION);
//            if (op == JOptionPane.YES_OPTION) {
//                daoper = new daoComensal();
//                daoper.Eliminar(txtdni.getText());
//                validaciones.limpiarjTextField(pnlP);
//                mostrarCli();
//            }
//        }
    }//GEN-LAST:event_btnEpActionPerformed

    private void btnNp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNp1ActionPerformed

    private void cmbEstItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstItemStateChanged
        MostrarAsistencia();
    }//GEN-LAST:event_cmbEstItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(winMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(winMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(winMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(winMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new winMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEp;
    private javax.swing.JButton btnNp;
    private javax.swing.JButton btnNp1;
    private static javax.swing.JComboBox<String> cmbEst;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblh;
    private javax.swing.JPanel pnlP;
    private javax.swing.JTable tblAs;
    private javax.swing.JTable tblcli;
    private org.edisoncor.gui.textField.TextFieldRectIcon txtBuscarP;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtape;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtdni;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtid;
    public static org.edisoncor.gui.textField.TextFieldRectBackground txtnom;
    // End of variables declaration//GEN-END:variables
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblh.setText(hora + ":" + minutos + ":" + segundos +" "+ampm);
//    lblHora.setText(hora + ":" + minutos + ":" + segundos + " "+ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
    public void calcula () {        
        Calendar calendar = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendar.setTime(fechaHoraActual);
        ampm = calendar.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";

        if(ampm.equals("PM")){
            int h = calendar.get(Calendar.HOUR_OF_DAY)-12;
        hora = h>9?""+h:"0"+h;
        }else{
         hora = calendar.get(Calendar.HOUR_OF_DAY)>9?""+calendar.get(Calendar.HOUR_OF_DAY):"0"+calendar.get(Calendar.HOUR_OF_DAY);            
        }
        minutos = calendar.get(Calendar.MINUTE)>9?""+calendar.get(Calendar.MINUTE):"0"+calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND)>9?""+calendar.get(Calendar.SECOND):"0"+calendar.get(Calendar.SECOND);
        int hh, mm;
        hh = Integer.parseInt(hora);
        mm = Integer.parseInt(minutos);
        if (ampm.equalsIgnoreCase("am")) {
            if (hh<11) {
                cmbEst.setSelectedIndex(0);
            }
            if (hh>10) {
                cmbEst.setSelectedIndex(1);
            }
        }
        if (ampm.equalsIgnoreCase("pm")) {
            if (hh<5) {
                cmbEst.setSelectedIndex(1);
            }
            if (hh>4) {
                cmbEst.setSelectedIndex(2);
            }
        }
    }
    
    public static void MostrarAsistencia(){
        
        if (cmbEst.getSelectedItem().equals("Desayuno")) {
            moda.setNumRows(0);
            daod = new daoDesayuno();
            List<Desayuno> lstcli = daod.Mostrar();
            int nmr = 1;
            for (Desayuno d : lstcli) {
                //dni, apellido, nombres, tipo_beca
                Object obj[] = {nmr, d.getCodx(), d.getDnix(), d.getApex() + ", " + d.getNomx(), d.getBecax(), d.getFacx(), d.getEpx()};
                moda.addRow(obj);
                nmr++;
            }
        }
        
        if (cmbEst.getSelectedItem().equals("Amuerzo")) {
            moda.setNumRows(0);
            daoa = new daoAlmuerzo();
            List<Almuerzo> lstcli = daoa.Mostrar();
            int nmr = 1;
            for (Almuerzo d : lstcli) {
                //dni, apellido, nombres, tipo_beca
                Object obj[] = {nmr, d.getCodx(), d.getDnix(), d.getApex() + ", " + d.getNomx(), d.getBecax(), d.getFacx(), d.getEpx()};
                moda.addRow(obj);
                nmr++;
            }
        }
        
        if (cmbEst.getSelectedItem().equals("Cena")) {
            moda.setNumRows(0);
            daoc = new daoCena();
            List<Cena> lstcli = daoc.Mostrar();
            int nmr = 1;
            for (Cena d : lstcli) {
                //dni, apellido, nombres, tipo_beca
                Object obj[] = {nmr, d.getCodx(), d.getDnix(), d.getApex() + ", " + d.getNomx(), d.getBecax(), d.getFacx(), d.getEpx()};
                moda.addRow(obj);
                nmr++;
            }
        }
              
    }
}
