package Game;

import PowerUps.PowerUpType;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro
 */
public class Instructions extends javax.swing.JInternalFrame implements PowerUpType {
    MainMenu mainMenu;
    private boolean[] availablePowerUps;
    /**
     * Creates new form Instructions
     * @param mainMenu
     */
    public Instructions(MainMenu mainMenu) {
        super("", false, false, false, false);
        initComponents();
        setOpaque(true);
        setVisible(true);
        ((BasicInternalFrameUI)super.getUI()).setNorthPane(null);
        setBorder(null);
        this.mainMenu = mainMenu;
        
        availablePowerUps = new boolean[TOTAL_POWERUPS];
        for(int i=0; i<availablePowerUps.length; i++){
            availablePowerUps[i] = true;
        }
    }
    
    public void updatePowerUps(){
        availablePowerUps[SHOOTING_PADDLE] = ShootingPaddle.isSelected();
        availablePowerUps[HOLDING_PADDLE] = HoldingPaddle.isSelected();
        availablePowerUps[FIREBALL] = FireBall.isSelected();
        availablePowerUps[THROUGH_BALL] = ThroughBall.isSelected();
        availablePowerUps[SLOW_BALL] = SlowBall.isSelected();
        availablePowerUps[SCORE_MULTIPLIER] = ScoreMultiplier.isSelected();
        availablePowerUps[EXTRA_LIFE] = ExtraLife.isSelected();
        availablePowerUps[SPLIT_BALL] = SplitBall.isSelected();
        availablePowerUps[ENLARGE_PADDLE] = EnlargePaddle.isSelected();
        availablePowerUps[REDUCE_PADDLE] = ReducePaddle.isSelected();
        availablePowerUps[FAST_BALL] = FastBall.isSelected();
        availablePowerUps[DEATH] = Death.isSelected();
        availablePowerUps[FALLING_BRICKS] = FallingBricks.isSelected();
        availablePowerUps[MINIATURE_PADDLE] = MiniaturePaddle.isSelected();
        mainMenu.setAvailablePowerUps(availablePowerUps);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ShootingPaddle = new javax.swing.JToggleButton();
        HoldingPaddle = new javax.swing.JToggleButton();
        FireBall = new javax.swing.JToggleButton();
        ThroughBall = new javax.swing.JToggleButton();
        SlowBall = new javax.swing.JToggleButton();
        ScoreMultiplier = new javax.swing.JToggleButton();
        ExtraLife = new javax.swing.JToggleButton();
        FastBall = new javax.swing.JToggleButton();
        SplitBall = new javax.swing.JToggleButton();
        EnlargePaddle = new javax.swing.JToggleButton();
        ReducePaddle = new javax.swing.JToggleButton();
        Death = new javax.swing.JToggleButton();
        FallingBricks = new javax.swing.JToggleButton();
        MiniaturePaddle = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Instructions");

        jLabel3.setText("Click to release the ball.");

        jLabel4.setText("Don't let the ball fall!");

        jLabel2.setText("Move your mouse to control the paddle.");

        jLabel5.setText("Break the bricks and win the game!");

        jLabel6.setText("Press ESC to return to the main menu.");

        jLabel36.setText("Press 'P' to pause/unpause the game.");

        jLabel37.setText("Mouse is locked to window during gameplay.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(59, 59, 59))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        ShootingPaddle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/ShootingPaddle.png"))); // NOI18N
        ShootingPaddle.setSelected(true);
        ShootingPaddle.setText("Shooting Paddle");
        ShootingPaddle.setToolTipText("Click to toggle Power-Up availability!");
        ShootingPaddle.setBorderPainted(false);
        ShootingPaddle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ShootingPaddle.setDoubleBuffered(true);
        ShootingPaddle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        HoldingPaddle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/HoldingPaddle.png"))); // NOI18N
        HoldingPaddle.setSelected(true);
        HoldingPaddle.setText("Holding Paddle");
        HoldingPaddle.setToolTipText("Click to toggle Power-Up availability!");
        HoldingPaddle.setBorderPainted(false);
        HoldingPaddle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HoldingPaddle.setDoubleBuffered(true);
        HoldingPaddle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        FireBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/FireBall.png"))); // NOI18N
        FireBall.setText("Fire Ball");
        FireBall.setToolTipText("Click to toggle Power-Up availability!");
        FireBall.setBorderPainted(false);
        FireBall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FireBall.setDoubleBuffered(true);
        FireBall.setEnabled(false);
        FireBall.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ThroughBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/ThroughBall.png"))); // NOI18N
        ThroughBall.setSelected(true);
        ThroughBall.setText("Through Ball");
        ThroughBall.setToolTipText("Click to toggle Power-Up availability!");
        ThroughBall.setBorderPainted(false);
        ThroughBall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ThroughBall.setDoubleBuffered(true);
        ThroughBall.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        SlowBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/SlowBall.png"))); // NOI18N
        SlowBall.setSelected(true);
        SlowBall.setText("Slow Ball");
        SlowBall.setToolTipText("Click to toggle Power-Up availability!");
        SlowBall.setBorderPainted(false);
        SlowBall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SlowBall.setDoubleBuffered(true);
        SlowBall.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ScoreMultiplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/ScoreMultiplier.png"))); // NOI18N
        ScoreMultiplier.setSelected(true);
        ScoreMultiplier.setText("Score Multiplier");
        ScoreMultiplier.setToolTipText("Click to toggle Power-Up availability!");
        ScoreMultiplier.setBorderPainted(false);
        ScoreMultiplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ScoreMultiplier.setDoubleBuffered(true);
        ScoreMultiplier.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ExtraLife.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/ExtraLife.png"))); // NOI18N
        ExtraLife.setSelected(true);
        ExtraLife.setText("Extra Life");
        ExtraLife.setToolTipText("Click to toggle Power-Up availability!");
        ExtraLife.setBorderPainted(false);
        ExtraLife.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ExtraLife.setDoubleBuffered(true);
        ExtraLife.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        FastBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/FastBall.png"))); // NOI18N
        FastBall.setSelected(true);
        FastBall.setText("Fast Ball");
        FastBall.setToolTipText("Click to toggle Power-Up availability!");
        FastBall.setBorderPainted(false);
        FastBall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FastBall.setDoubleBuffered(true);
        FastBall.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        SplitBall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/SplitBall.png"))); // NOI18N
        SplitBall.setSelected(true);
        SplitBall.setText("Split Ball");
        SplitBall.setToolTipText("Click to toggle Power-Up availability!");
        SplitBall.setBorderPainted(false);
        SplitBall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SplitBall.setDoubleBuffered(true);
        SplitBall.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        EnlargePaddle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/LargerPaddle.png"))); // NOI18N
        EnlargePaddle.setSelected(true);
        EnlargePaddle.setText("Enlarge Paddle");
        EnlargePaddle.setToolTipText("Click to toggle Power-Up availability!");
        EnlargePaddle.setBorderPainted(false);
        EnlargePaddle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EnlargePaddle.setDoubleBuffered(true);
        EnlargePaddle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        ReducePaddle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/SmallerPaddle.png"))); // NOI18N
        ReducePaddle.setSelected(true);
        ReducePaddle.setText("Shrink Paddle");
        ReducePaddle.setToolTipText("Click to toggle Power-Up availability!");
        ReducePaddle.setBorderPainted(false);
        ReducePaddle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReducePaddle.setDoubleBuffered(true);
        ReducePaddle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        Death.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/Death.png"))); // NOI18N
        Death.setSelected(true);
        Death.setText("Death");
        Death.setToolTipText("Click to toggle Power-Up availability!");
        Death.setBorderPainted(false);
        Death.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Death.setDoubleBuffered(true);
        Death.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        FallingBricks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/FallingBricks.png"))); // NOI18N
        FallingBricks.setText("Falling Bricks");
        FallingBricks.setToolTipText("Click to toggle Power-Up availability!");
        FallingBricks.setBorderPainted(false);
        FallingBricks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        FallingBricks.setDoubleBuffered(true);
        FallingBricks.setEnabled(false);
        FallingBricks.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        MiniaturePaddle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PowerUps/Sprites/MiniaturePaddle.png"))); // NOI18N
        MiniaturePaddle.setSelected(true);
        MiniaturePaddle.setText("Miniature Paddle");
        MiniaturePaddle.setToolTipText("Click to toggle Power-Up availability!");
        MiniaturePaddle.setBorderPainted(false);
        MiniaturePaddle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MiniaturePaddle.setDoubleBuffered(true);
        MiniaturePaddle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Power-Ups");

        jToggleButton1.setSelected(true);
        jToggleButton1.setText("Active");
        jToggleButton1.setEnabled(false);

        jToggleButton2.setText("Inactive");
        jToggleButton2.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThroughBall)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(FireBall)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ExtraLife, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(HoldingPaddle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ScoreMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ShootingPaddle)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SlowBall, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(EnlargePaddle)
                                .addComponent(SplitBall)
                                .addComponent(ReducePaddle))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Death)
                                .addComponent(FastBall, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(FallingBricks)))
                        .addComponent(MiniaturePaddle, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Death, EnlargePaddle, ExtraLife, FallingBricks, FastBall, FireBall, HoldingPaddle, MiniaturePaddle, ReducePaddle, ScoreMultiplier, ShootingPaddle, SlowBall, SplitBall, ThroughBall});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShootingPaddle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FastBall, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SplitBall)
                        .addComponent(SlowBall, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HoldingPaddle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EnlargePaddle, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ScoreMultiplier, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Death, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FallingBricks, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(FireBall)
                        .addComponent(ExtraLife)
                        .addComponent(ReducePaddle)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ThroughBall)
                    .addComponent(MiniaturePaddle)))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Death, EnlargePaddle, ExtraLife, FallingBricks, FastBall, FireBall, HoldingPaddle, MiniaturePaddle, ReducePaddle, ScoreMultiplier, ShootingPaddle, SlowBall, SplitBall, ThroughBall});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        updatePowerUps();
        mainMenu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JToggleButton Death;
    private javax.swing.JToggleButton EnlargePaddle;
    private javax.swing.JToggleButton ExtraLife;
    private javax.swing.JToggleButton FallingBricks;
    private javax.swing.JToggleButton FastBall;
    private javax.swing.JToggleButton FireBall;
    private javax.swing.JToggleButton HoldingPaddle;
    private javax.swing.JToggleButton MiniaturePaddle;
    private javax.swing.JToggleButton ReducePaddle;
    private javax.swing.JToggleButton ScoreMultiplier;
    private javax.swing.JToggleButton ShootingPaddle;
    private javax.swing.JToggleButton SlowBall;
    private javax.swing.JToggleButton SplitBall;
    private javax.swing.JToggleButton ThroughBall;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
