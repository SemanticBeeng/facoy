import javax.swing.JFileChooser;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Chango
 */
public class Ventana extends javax.swing.JFrame {

    /** Creates new form Ventana */
    public Ventana() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        BtnOpenFile = new javax.swing.JButton();
        rutaOrigen = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rutaDestino = new javax.swing.JTextField();
        BtnOpenDestiny = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compresor Hoffman");
        setResizable(false);
        BtnOpenFile.setText("...");
        BtnOpenFile.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOpenFileActionPerformed(evt);
            }
        });
        jLabel1.setText("Origen");
        jLabel2.setText("Destino");
        rutaDestino.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaDestinoActionPerformed(evt);
            }
        });
        BtnOpenDestiny.setText("...");
        BtnOpenDestiny.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOpenDestinyActionPerformed(evt);
            }
        });
        jButton3.setText("Comprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton4.setText("Descomprimir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(26, 26, 26).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(jLabel1).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(jButton3).addGap(31, 31, 31).addComponent(jButton4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jButton5)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(rutaDestino, javax.swing.GroupLayout.Alignment.LEADING).addComponent(rutaOrigen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(BtnOpenFile, 0, 0, Short.MAX_VALUE).addComponent(BtnOpenDestiny, javax.swing.GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE))))).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(rutaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(BtnOpenFile)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(rutaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(BtnOpenDestiny)).addGap(47, 47, 47).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton3).addComponent(jButton5).addComponent(jButton4)).addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        pack();
    }

    private void BtnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser file = new JFileChooser();
        file.setDialogTitle("Open File");
        file.setMultiSelectionEnabled(false);
        int res = file.showOpenDialog(this);
        if (res == file.APPROVE_OPTION) {
            rootS = file.getSelectedFile().getAbsolutePath();
            rutaOrigen.setText(rootS);
            isSource = true;
        }
    }

    private void rutaDestinoActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void BtnOpenDestinyActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser file = new JFileChooser();
        file.setDialogTitle("Save File");
        file.setMultiSelectionEnabled(false);
        int res = file.showSaveDialog(this);
        if (res == file.APPROVE_OPTION) {
            rootD = file.getSelectedFile().getAbsolutePath();
            rutaDestino.setText(rootD);
            isDestiny = true;
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (isDestiny && isSource) {
            comp = new Compressor(rootS, rootD);
            try {
                comp.compress();
                JOptionPane.showMessageDialog(null, "Compression Sucessful");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        if (isDestiny && isSource) {
            decomp = new Decompressor(rootS, rootD);
            try {
                decomp.decompress();
                JOptionPane.showMessageDialog(null, "Decompression Sucessful");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    private javax.swing.JButton BtnOpenDestiny;

    private javax.swing.JButton BtnOpenFile;

    private javax.swing.JButton jButton3;

    private javax.swing.JButton jButton4;

    private javax.swing.JButton jButton5;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JTextField rutaDestino;

    private javax.swing.JTextField rutaOrigen;

    private Compressor comp;

    private Decompressor decomp;

    private String rootS, rootD;

    private boolean isSource = false, isDestiny = false;
}
