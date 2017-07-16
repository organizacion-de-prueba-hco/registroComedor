package win;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Image;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import util.Conexion;
import util.Instancias;

/**
 *
 * @author Jhon
 */
public class winFirmar extends javax.swing.JDialog implements Runnable{
    Thread h1;
    String hora,minutos,segundos,ampm;
    public static String idcm,cod,dni,nom,fac,eap,beca, ape;
    public winFirmar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);      
        txtdate.setDate(new Date());
        h1 = new Thread(this);
        h1.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCod = new javax.swing.JButton();
        txtdate = new com.toedter.calendar.JDateChooser();
        cmbEst = new javax.swing.JComboBox<>();
        txtDni = new org.edisoncor.gui.textField.TextFieldRectBackground();
        btnId = new javax.swing.JButton();
        lblHora = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImagenHuella = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        jScrollPane1.setViewportView(txtArea);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCod.setBackground(new java.awt.Color(0, 153, 204));
        btnCod.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCod.setForeground(new java.awt.Color(255, 255, 255));
        btnCod.setText("Aceptar");
        btnCod.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodActionPerformed(evt);
            }
        });

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtdate.setMinSelectableDate(new java.util.Date(-62135744283000L));

        cmbEst.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmbEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Almuerzo", "Cena" }));

        txtDni.setToolTipText("Codigo/DNI");
        txtDni.setDescripcion("Codigo/DNI");
        txtDni.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        btnId.setBackground(new java.awt.Color(0, 153, 204));
        btnId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnId.setForeground(new java.awt.Color(255, 255, 255));
        btnId.setText("Identificar");
        btnId.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIdActionPerformed(evt);
            }
        });

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("Hora");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDni, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbEst, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCod, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addComponent(btnId, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(cmbEst, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        lblImagenHuella.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagenHuella, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImagenHuella, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Iniciar();
        start();btnId.setEnabled(false);
//        btnIdentificar.setEnabled(false);
//        btnVerificar.setEnabled(false);btnFirm.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       stop();
    }//GEN-LAST:event_formWindowClosing

    private void btnCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodActionPerformed
       
            verificarHuella(txtDni.getText());
            Reclutador.clear();            
    }//GEN-LAST:event_btnCodActionPerformed

    private void btnIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIdActionPerformed
        try {
            identificarHuella();
            Reclutador.clear();btnId.setEnabled(false);
        } catch (IOException ex) {
            Logger.getLogger(winFirmar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIdActionPerformed
//Varible que permite iniciar el dispositivo de lector de huella conectado
// con sus distintos metodos.
private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

//Varible que permite establecer las capturas de la huellas, para determina sus caracteristicas
// y poder estimar la creacion de un template de la huella para luego poder guardarla
private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

//Esta variable tambien captura una huella del lector y crea sus caracteristcas para auntetificarla
// o verificarla con alguna guardada en la BD
private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

//Variable que para crear el template de la huella luego de que se hallan creado las caracteriticas
// necesarias de la huella si no ha ocurrido ningun problema
private DPFPTemplate template;
public static String TEMPLATE_PROPERTY = "template";

protected void Iniciar(){
   Lector.addDataListener(new DPFPDataAdapter() {
    @Override public void dataAcquired(final DPFPDataEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("La Huella Digital ha sido Capturada");
    btnId.setEnabled(true);    
    ProcesarCaptura(e.getSample());
    }});}
   });

   Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
    @Override public void readerConnected(final DPFPReaderStatusEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
    }});}
    @Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
    }});}
   });

   Lector.addSensorListener(new DPFPSensorAdapter() {
    @Override public void fingerTouched(final DPFPSensorEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella");   
        if (Verificador==null) {
            btnId.doClick();  
        }
                 
    }});}
    @Override public void fingerGone(final DPFPSensorEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("El dedo ha sido quitado del Lector de Huella");
            if (Verificador!=null) {
            btnId.doClick();  
        }   
    }});}
   });

   Lector.addErrorListener(new DPFPErrorAdapter(){
    public void errorReader(final DPFPErrorEvent e){
    SwingUtilities.invokeLater(new Runnable() {  public void run() {
    EnviarTexto("Error: "+e.getError());
    }});}
   });
}

 public DPFPFeatureSet featuresinscripcion;
 public DPFPFeatureSet featuresverificacion;

 public  void ProcesarCaptura(DPFPSample sample)
 {
 // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
 featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

 // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
 featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

 // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
 if (featuresinscripcion != null)
     try{
    //// System.out.println("Las Caracteristicas de la Huella han sido creada");
     Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

     // Dibuja la huella dactilar capturada.
     Image image=CrearImagenHuella(sample);
     DibujarHuella(image);

     }catch (DPFPImageQualityException ex) {
     System.err.println("Error: "+ex.getMessage());
     }

     finally {
     EstadoHuellas();
     // Comprueba si la plantilla se ha creado.
	switch(Reclutador.getTemplateStatus())
        {
            case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
	    stop();
            setTemplate(Reclutador.getTemplate());
	    EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
	   // btnId.setEnabled(true);
            break;

	    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
	    Reclutador.clear();
            stop();
	    EstadoHuellas();
	    setTemplate(null);
	    JOptionPane.showMessageDialog(winFirmar.this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
	    start();
	    break;
	}
	     }
}

 public  DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose){
     DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
     try {
      return extractor.createFeatureSet(sample, purpose);
     } catch (DPFPImageQualityException e) {
      return null;
     }
}

  public  Image CrearImagenHuella(DPFPSample sample) {
	return DPFPGlobal.getSampleConversionFactory().createImage(sample);
}

  public void DibujarHuella(Image image) {
        lblImagenHuella.setIcon(new ImageIcon(
        image.getScaledInstance(lblImagenHuella.getWidth(), lblImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
 }

public  void EstadoHuellas(){
	EnviarTexto("Muestra de Huellas Necesarias para Guardar Template "+ Reclutador.getFeaturesNeeded());
}

public void EnviarTexto(String string) {
        txtArea.append(string + "\n");
}

public  void start(){
	Lector.startCapture();
	EnviarTexto("Utilizando el Lector de Huella Dactilar ");
}

public  void stop(){
        Lector.stopCapture();
        EnviarTexto("No se está usando el Lector de Huella Dactilar ");
}

    public DPFPTemplate getTemplate() {
        return template;
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
	this.template = template;
	firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

Conexion con = Conexion.saberEstado(); 

/**
* Verifica la huella digital actual contra otra en la base de datos
     * @param dni
*/
 public void verificarHuella(String dnicod) {
    try {
    //Obtiene la plantilla correspondiente a la persona indicada
    PreparedStatement pst = con.getCon().prepareStatement("select s.user_id,s.cod_univ,u.dni,concat(u.apellido_paterno,' ',u.apellido_materno) as apellido,u.nombres,x.tipo_beca, " +
       "f.facultad,e.escuela,x.huella_a,x.estado from estudiantes s inner join expedientes x  inner join users u  inner join " +
       "escuelas e inner join facultads f on s.user_id=u.id and x.expediente=u.id and x.expediente=s.user_id " +
       "and s.escuela_id=e.id and f.id=e.facultad_id where u.dni='"+dnicod+"' or s.cod_univ='"+dnicod+"';");
    ResultSet rs = pst.executeQuery();
    //Si se encuentra el nombre en la base de datos
    if (rs.next()){
        idcm = rs.getString(1);
        cod = rs.getString(2);
        dni = rs.getString(3);
        nom = rs.getString(4);
        ape = rs.getString(5);
        beca = rs.getString(6);
        fac = rs.getString(7);
        eap = rs.getString(8);
        String est = rs.getString(9);
        if (est.equals("0")) {
            JOptionPane.showMessageDialog(null, "Acceso denegado", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (int i = 0; i < winMenu.moda.getRowCount(); i++) {
            if (winMenu.moda.getValueAt(i, 1).equals(cod)) {
                JOptionPane.showMessageDialog(null, "Ya se tomo la Asistencia", "Nota", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        new winInfo(null, rootPaneCheckingEnabled).setVisible(true);
        lblImagenHuella.setIcon(null);
        lblImagenHuella.updateUI();
        lblImagenHuella.repaint();
    } else {
    JOptionPane.showMessageDialog(null, "No existe un registro para "+dnicod, "Intentalo Nuevamente", JOptionPane.ERROR_MESSAGE);
    }
    } catch (SQLException e) {
    //Si ocurre un error lo indica en la consola
    System.err.println("Error al verificar los datos de la huella.");
    }finally{
       con.cerrarConexion();
    }
   }

 /**
  * Identifica a una persona registrada por medio de su huella digital
  */
  public void identificarHuella() throws IOException{
     try {
       //Obtiene todas las huellas de la bd
       String sql= "select s.user_id,s.cod_univ,u.dni,concat(u.apellido_paterno,' ',u.apellido_materno) as apellido,u.nombres,x.tipo_beca, " +
       "f.facultad,e.escuela,x.huella_a,x.estado from estudiantes s inner join expedientes x  inner join users u  inner join " +
       "escuelas e inner join facultads f on s.user_id=u.id and x.expediente=u.id and x.expediente=s.user_id " +
       "and s.escuela_id=e.id and f.id=e.facultad_id;";
       PreparedStatement identificarStmt = con.getCon().prepareStatement(sql);
       ResultSet rs = identificarStmt.executeQuery();
//user_id, cod_univ, dni, apellido, nombres, tipo_beca, facultad, escuela, huella_a, estado
       //Si se encuentra el nombre en la base de datos
       while(rs.next()){
       //Lee la plantilla de la base de datos
       byte templateBuffer[] = rs.getBytes("huella_a");
       idcm=rs.getString(1);
       cod=rs.getString(2);
       dni=rs.getString(3);
       nom=rs.getString(4);
       ape = rs.getString(5);
       beca=rs.getString(6);
       fac=rs.getString(7);
       eap=rs.getString(8);
       String est = rs.getString(9);
           if (est.equals("0")) {
               JOptionPane.showMessageDialog(null, "Acceso denegado", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
               return;
           }
           
       //Crea una nueva plantilla a partir de la guardada en la base de datos
       DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
       //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
       setTemplate(referenceTemplate);

       // Compara las caracteriticas de la huella recientemente capturda con la
       // alguna plantilla guardada en la base de datos que coincide con ese tipo
       DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

       //compara las plantilas (actual vs bd)
       //Si encuentra correspondencia dibuja el mapa
       //e indica el nombre de la persona que coincidió.
       if (result.isVerified()){
       //crea la imagen de los datos guardado de las huellas guardadas en la base de datos
       //JOptionPane.showMessageDialog(null, "Las huella capturada es de "+persona + ", DNI: " + dni,"Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
           for (int i = 0; i < winMenu.moda.getRowCount(); i++) {
               if (winMenu.moda.getValueAt(i, 1).equals(cod)) {
                   JOptionPane.showMessageDialog(null, "Ya se tomo la Asistencia", "Nota", JOptionPane.WARNING_MESSAGE);
                   return;
               }
           }
       txtDni.setText(dni);    
           //Instancias ins = new Instancias();
           
       new winInfo(null, rootPaneCheckingEnabled).setVisible(true);       
       lblImagenHuella.setIcon(null);
       lblImagenHuella.updateUI();  lblImagenHuella.repaint();
       return;
       }
       }
       //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
       JOptionPane.showMessageDialog(null, "No existe ningún registro que coincida con la huella", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
       setTemplate(null);
       } catch (SQLException e) {
       //Si ocurre un error lo indica en la consola
       System.err.println("Error al identificar huella dactilar."+e.getMessage());
       }finally{
       con.cerrarConexion();
       }
   }
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
            java.util.logging.Logger.getLogger(winFirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(winFirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(winFirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(winFirmar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                winFirmar dialog = new winFirmar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCod;
    public static javax.swing.JButton btnId;
    private javax.swing.JComboBox<String> cmbEst;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblImagenHuella;
    private javax.swing.JTextArea txtArea;
    private org.edisoncor.gui.textField.TextFieldRectBackground txtDni;
    private com.toedter.calendar.JDateChooser txtdate;
    // End of variables declaration//GEN-END:variables
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblHora.setText(hora + ":" + minutos + ":" + segundos +" "+ampm);            
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
}
