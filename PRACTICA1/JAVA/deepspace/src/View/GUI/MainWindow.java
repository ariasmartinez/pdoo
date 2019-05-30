/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.GUI;

import controller.Controller;
import deepspace.GameState;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author celia
 */
public class MainWindow extends javax.swing.JFrame implements View.DeepSpaceView {
    private static MainWindow instance = null;
    private StationView stationView;
    private EnemyView enemyView;
    
    
    public static MainWindow getInstance(){
        if (instance == null)
            instance = new MainWindow();
        return instance;
    }
    /**
     * Creates new form MainWindow
     */
    private MainWindow() {
        initComponents();
        
        stationView = new StationView();
        enemyView = new EnemyView();
        panelSpaceStation.add(stationView);
        panelEnemy.add(enemyView);
        setTitle ("Deepspace");
        repaint();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            controller.Controller.getInstance().finish(0);
        }
});
    }

    public void updateView(){
        GameState estado = Controller.getInstance().getState();
        stationView.setStation(Controller.getInstance().getUIversion().getCurrentStation());
        enemyView.setEnemy(Controller.getInstance().getUIversion().getCurrentEnemy());
        botonDescartar.setEnabled(estado!=GameState.BEFORECOMBAT);
        botonDescartarHangar.setEnabled(estado!=GameState.BEFORECOMBAT);
        botonSiguienteTurno.setEnabled(estado!=GameState.BEFORECOMBAT);
        botonEquipar.setEnabled(estado!=GameState.BEFORECOMBAT);
        botonCombatir.setEnabled(estado!=GameState.AFTERCOMBAT);
       // jbSpendChecks.setEnabled(Controller.getInstance().getAppState() == AppState.PERSONCANSPEND);
        panelEnemy.setVisible((estado != GameState.BEFORECOMBAT) && (estado != GameState.INIT));
        //panelEnemy.setVisible(false);
        //panelSpaceStation.setVisible(false);
       
    }
    
    public void showView(){
        this.setVisible(true);
    }
    
    
    
    //HACER
    @Override
    public ArrayList<String> readNamePlayers() {
        NamesCapture namesCapt = new NamesCapture(this);
        ArrayList<String> names = namesCapt.getNames();
        return names;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSpaceStation = new javax.swing.JPanel();
        panelEnemy = new javax.swing.JPanel();
        botonDescartar = new javax.swing.JButton();
        botonDescartarHangar = new javax.swing.JButton();
        botonSiguienteTurno = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonCombatir = new javax.swing.JButton();
        botonEquipar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Deepspace");

        panelSpaceStation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estación Espacial", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        panelEnemy.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemigo"));

        botonDescartar.setText("Descartar");
        botonDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescartarActionPerformed(evt);
            }
        });

        botonDescartarHangar.setText("Descartar Hangar");
        botonDescartarHangar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDescartarHangarActionPerformed(evt);
            }
        });

        botonSiguienteTurno.setText("Siguiente Turno");
        botonSiguienteTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteTurnoActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonCombatir.setText("Combatir!");
        botonCombatir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCombatirActionPerformed(evt);
            }
        });

        botonEquipar.setText("Equipar");
        botonEquipar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEquiparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSpaceStation, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonEquipar)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonSiguienteTurno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonDescartar)
                                    .addComponent(botonDescartarHangar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCombatir, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSpaceStation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelEnemy, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonCombatir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(botonSalir))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botonEquipar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonDescartar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botonDescartarHangar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botonSiguienteTurno)))
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCombatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCombatirActionPerformed
        Controller.getInstance().combat();
        updateView();
    }//GEN-LAST:event_botonCombatirActionPerformed

    private void botonEquiparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEquiparActionPerformed
        Controller.getInstance().mount(stationView.getSelectedHangarWeapons(), stationView.getSelectedHangarShields());
        updateView();
    }//GEN-LAST:event_botonEquiparActionPerformed

    private void botonSiguienteTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteTurnoActionPerformed
        Controller.getInstance().nextTurn();
        updateView();
    }//GEN-LAST:event_botonSiguienteTurnoActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        Controller.getInstance().finish(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonDescartarHangarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescartarHangarActionPerformed
        Controller.getInstance().discardHangar();
        updateView();
    }//GEN-LAST:event_botonDescartarHangarActionPerformed

    private void botonDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDescartarActionPerformed
        ArrayList<Integer> weapons = stationView.getSelectedWeapons();
        ArrayList<Integer> shields = stationView.getSelectedShields();
        int c = (Controller.SHIELD + Controller.WEAPON);
        Controller.getInstance().discard(c, weapons, shields);
        ArrayList<Integer> hweapons = stationView.getSelectedHangarWeapons();
        ArrayList<Integer> hshields = stationView.getSelectedHangarShields();
        Controller.getInstance().discard(Controller.HANGAR, hweapons, hshields);
        updateView();
    }//GEN-LAST:event_botonDescartarActionPerformed

    
    @Override
    public boolean confirmExitMessage() {
        return (JOptionPane.showConfirmDialog(this, "¿Estás segur@ que deseas salir?", "Deepspace", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
  public void nextTurnNotAllowedMessage(){
      JOptionPane.showMessageDialog(this, "\n No puedes avanzar de turno, no has cumplido tu castigo", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
  }
  public void lostCombatMessage(){
    JOptionPane.showMessageDialog(this, "Has PERDIDO el combate. \tCumple tu castigo.", "Deepspace", JOptionPane.INFORMATION_MESSAGE);}
  public void escapeMessage(){
      JOptionPane.showMessageDialog(this, "Has logrado escapar. \tEres una Gallina Espacial.", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
  }
  public void wonCombatMessage(){
    JOptionPane.showMessageDialog(this, "Has GANADO el combate. \tDisfruta de tu botín.", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
  }
  public void wonGameMessage(){
    JOptionPane.showMessageDialog(this, "\n\tHAS GANADO LA PARTIDA", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
  }
  public void conversionMessage(){
      JOptionPane.showMessageDialog(this, "Has GANADO el combate. \nAdemás te has CONVERTIDO. \nDisfruta de tu botín", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
  }
  public void noCombatMessage(){
      JOptionPane.showMessageDialog(this, "No puedes combatir en este momento", "Deepspace", JOptionPane.INFORMATION_MESSAGE);
  }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCombatir;
    private javax.swing.JButton botonDescartar;
    private javax.swing.JButton botonDescartarHangar;
    private javax.swing.JButton botonEquipar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonSiguienteTurno;
    private javax.swing.JPanel panelEnemy;
    private javax.swing.JPanel panelSpaceStation;
    // End of variables declaration//GEN-END:variables
}
