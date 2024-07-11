/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import controlador.DaoDetalleSalida;
import controlador.DaoProductos;
import controlador.DaoSalida;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import modelo.conexion;
import modelo.detalleSalida;
import modelo.productos;
import modelo.salidas;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author HELIO
 */
public class ListaSalidas extends javax.swing.JPanel {

DefaultTableModel modelo=new DefaultTableModel();
DaoSalida dao=new DaoSalida();
salidas s=new salidas();

detalleSalida ds=new detalleSalida();
DaoDetalleSalida daoDs=new DaoDetalleSalida();

productos p=new productos();
DaoProductos daoP=new DaoProductos();

static int idsalida;
static int cant;
static int idproducto;
    /**
     * Creates new form ListaSalidas
     */
    public ListaSalidas() {
        initComponents();
        listarSalidas();
    }

    private void listarSalidas(){
        List<salidas> lista=dao.Listar();
        modelo=(DefaultTableModel) tablaSalidas.getModel();
        Object[] ob=new Object[8];
        for(int i=0;i<lista.size();i++){
            ob[0]=lista.get(i).getIdSalida();
            ob[1]=lista.get(i).getNumSalida();
            ob[2]=lista.get(i).getIdCliente();
            ob[3]=lista.get(i).getFecha();
            ob[4]=lista.get(i).getSubtotal();
            ob[5]=lista.get(i).getIgv();
            ob[6]=lista.get(i).getTotal();
            ob[7]=lista.get(i).getEstado();
            modelo.addRow(ob);
        }
       tablaSalidas.setModel(modelo);
    }

    private void listarSalidasPorFecha(String fecha1,String fecha2){
        List<salidas> lista=dao.ListarPorFecha(fecha1, fecha2);
        modelo=(DefaultTableModel) tablaSalidas.getModel();
        Object[] ob=new Object[8];
        for(int i=0;i<lista.size();i++){
            ob[0]=lista.get(i).getIdSalida();
            ob[1]=lista.get(i).getNumSalida();
            ob[2]=lista.get(i).getIdCliente();
            ob[3]=lista.get(i).getFecha();
            ob[4]=lista.get(i).getSubtotal();
            ob[5]=lista.get(i).getIgv();
            ob[6]=lista.get(i).getTotal();
            ob[7]=lista.get(i).getEstado();
            modelo.addRow(ob);
        }
       tablaSalidas.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnicono = new RSMaterialComponent.RSButtonMaterialIconDos();
        jpanelRound1 = new modelo.JpanelRound();
        jLabel2 = new javax.swing.JLabel();
        txtnumSalida = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fechainicial = new com.toedter.calendar.JDateChooser();
        fechafinal = new com.toedter.calendar.JDateChooser();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnPdf = new RSMaterialComponent.RSButtonMaterialIconDos();
        btnAnular = new RSMaterialComponent.RSButtonMaterialIconDos();
        txtidSalida = new javax.swing.JLabel();
        jpanelRound2 = new modelo.JpanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSalidas = new javax.swing.JTable();

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 20)); // NOI18N
        jLabel1.setText("Listado De Salidas");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 130, 181));
        jLabel4.setText("Imprima la indormacion de cada Salida.");

        btnicono.setBackground(new java.awt.Color(14, 76, 117));
        btnicono.setBackgroundHover(new java.awt.Color(14, 76, 117));
        btnicono.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.KEYBOARD_ARROW_UP);
        btnicono.setRound(25);
        btnicono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btniconoActionPerformed(evt);
            }
        });

        jpanelRound1.setBackground(new java.awt.Color(255, 255, 255));
        jpanelRound1.setRoundBottomLeft(20);
        jpanelRound1.setRoundBottomRight(20);
        jpanelRound1.setRoundTopLeft(20);
        jpanelRound1.setRoundTopRight(20);

        jLabel2.setText("Numero:");

        jLabel3.setText("fecha Inicial:");

        jLabel5.setText("Fecha Final:");

        btnBuscar.setBackground(new java.awt.Color(14, 76, 117));
        btnBuscar.setText("Buscar");
        btnBuscar.setBackgroundHover(new java.awt.Color(50, 130, 181));
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscar.setRound(25);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnPdf.setBackground(new java.awt.Color(213, 137, 137));
        btnPdf.setText("PDF");
        btnPdf.setBackgroundHover(new java.awt.Color(117, 13, 38));
        btnPdf.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INSERT_DRIVE_FILE);
        btnPdf.setRound(25);
        btnPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPdfActionPerformed(evt);
            }
        });

        btnAnular.setBackground(new java.awt.Color(184, 146, 52));
        btnAnular.setText("Anular");
        btnAnular.setBackgroundHover(new java.awt.Color(181, 123, 49));
        btnAnular.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnAnular.setRound(25);
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        txtidSalida.setText("idSalida");

        javax.swing.GroupLayout jpanelRound1Layout = new javax.swing.GroupLayout(jpanelRound1);
        jpanelRound1.setLayout(jpanelRound1Layout);
        jpanelRound1Layout.setHorizontalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtnumSalida)
                            .addComponent(fechainicial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fechafinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                    .addComponent(txtidSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPdf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        jpanelRound1Layout.setVerticalGroup(
            jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnumSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnPdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpanelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidSalida)
                        .addGap(18, 18, 18)
                        .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(fechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAnular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jpanelRound2.setBackground(new java.awt.Color(255, 255, 255));
        jpanelRound2.setRoundBottomLeft(20);
        jpanelRound2.setRoundBottomRight(20);
        jpanelRound2.setRoundTopLeft(20);
        jpanelRound2.setRoundTopRight(20);

        tablaSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Numero", "Id Cliente", "fecha", "subtotal", "IGV", "Total", "Estado"
            }
        ));
        tablaSalidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSalidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSalidas);

        javax.swing.GroupLayout jpanelRound2Layout = new javax.swing.GroupLayout(jpanelRound2);
        jpanelRound2.setLayout(jpanelRound2Layout);
        jpanelRound2Layout.setHorizontalGroup(
            jpanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpanelRound2Layout.setVerticalGroup(
            jpanelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelRound2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnicono, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)))
                            .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 458, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(btnicono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jpanelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btniconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btniconoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btniconoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        limpiarTabla();
        
        String fecha1=obtenerFechas(fechainicial)+"";
        String fecha2=obtenerFechas(fechafinal)+"";
        listarSalidasPorFecha(fecha1,fecha2);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPdfActionPerformed
        // TODO add your handling code here:
       if(!txtnumSalida.getText().isEmpty()){
            GenerarPDF(txtnumSalida.getText());
       }else{
            MenuPrincipal m2=new MenuPrincipal();
            m2.error("Seleccione una Salida");
        }
    }//GEN-LAST:event_btnPdfActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        // TODO add your handling code here:
        int fila=tablaSalidas.getSelectedRow();
        if(fila==-1&&txtnumSalida.getText().isEmpty()){
            MenuPrincipal m=new MenuPrincipal();
            m.advertencia("Seleccione una Salida");
        }else{
            s.setIdSalida(Integer.parseInt(txtidSalida.getText()));
            s.setEstado("Anulada");
            if(dao.anularSalida(s)){
                limpiarTabla();
                listarSalidas();
                daoP.sumarStock(idproducto, cant);
                //limpiarCampos();
                MenuPrincipal m=new MenuPrincipal();
                m.exito("Se Anulo con exito");
            }else{
                MenuPrincipal m=new MenuPrincipal();
                m.error("Erorr al Anular la Salida");
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void tablaSalidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSalidasMouseClicked
        // TODO add your handling code here:
        int fila=tablaSalidas.getSelectedRow();
        String num=tablaSalidas.getValueAt(fila, 1).toString();
        txtnumSalida.setText(num);
        txtidSalida.setText(tablaSalidas.getValueAt(fila, 0).toString());
        idsalida=Integer.parseInt(tablaSalidas.getValueAt(fila, 0).toString());

        ds.setIdSalida(idsalida);
        daoDs.buscar(ds);

        cant=ds.getCantidad();
        idproducto=ds.getIdEntrada();


    }//GEN-LAST:event_tablaSalidasMouseClicked

private Connection conection=new conexion().conectar();

    void GenerarPDF(String numSalida){
        Map p=new HashMap();
        p.put("numSalida", numSalida);
        JasperReport report;
        JasperPrint print;

        try{
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+"/src/reportes/Salida.jrxml");
            print=JasperFillManager.fillReport(report, p, conection);
            JasperViewer view=new JasperViewer(print,false);
            view.setTitle("Documento Salida N° "+numSalida);
            view.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    void limpiarTabla(){
        for(int i=0;i<modelo.getRowCount();i++){
            modelo.removeRow(i);
            i=0-1;
        }
    }

    public Date obtenerFechas(JDateChooser dch){
        Calendar cal;
        int d,m,a;
        cal=dch.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR)-1900;
        return new Date(a,m,d);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconDos btnAnular;
    private RSMaterialComponent.RSButtonMaterialIconDos btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconDos btnPdf;
    private RSMaterialComponent.RSButtonMaterialIconDos btnicono;
    private com.toedter.calendar.JDateChooser fechafinal;
    private com.toedter.calendar.JDateChooser fechainicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private modelo.JpanelRound jpanelRound1;
    private modelo.JpanelRound jpanelRound2;
    private javax.swing.JTable tablaSalidas;
    private javax.swing.JLabel txtidSalida;
    private javax.swing.JTextField txtnumSalida;
    // End of variables declaration//GEN-END:variables
}
