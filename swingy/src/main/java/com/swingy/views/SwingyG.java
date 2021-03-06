/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swingy.views;

import java.io.*;
import com.swingy.repository.*;
import com.swingy.controllers.*;
import com.swingy.models.*;
import java.util.*;
import java.awt.Dimension;
import javax.swing.JOptionPane;
/**
 *
 * @author R.C Maake
 */
public class SwingyG extends javax.swing.JFrame {
    private GamePlay game;
    private SwingyMap map;
    private List<HeroController> charact;
    private List<EnemyController> enemies;
    private int selectedHero;
    private HeroController newHero = new HeroController();
    /**
     * Creates new form SwingyG
     */
    public SwingyG() {
        this.setTitle("Swingy");
        initComponents();
        atStart();
        game = new GamePlay(0);
        charact = game.getHeros();
        enemies = game.getEnemies();
        map = new SwingyMap();
        newHero.setCharact(new Characters());
        newHero.getCharact().amor = new Amor();
        newHero.getCharact().cordinates = new Coordinates();
        newHero.getCharact().weapon = new Weapon();
        newHero.getCharact().helm = new Helm();
        newHero.getCharact().level = 0;
        newHero.getCharact().amor.name = new String("Force Feild");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbackButton = new javax.swing.JButton();
        gameStart = new javax.swing.JPanel();
        jwelcomeLabel = new javax.swing.JLabel();
        jmotoLabel = new javax.swing.JLabel();
        jchooseHeroBtn = new javax.swing.JButton();
        jcreateHeroBtn = new javax.swing.JButton();
        createHero = new javax.swing.JPanel();
        jcreateHeroLabel = new javax.swing.JLabel();
        jnameLabel = new javax.swing.JLabel();
        jclassLabel = new javax.swing.JLabel();
        jnameTextField = new javax.swing.JTextField();
        jcreateHeroButton = new javax.swing.JButton();
        jClassComboBox = new javax.swing.JComboBox<String>();
        jWeaponLabel = new javax.swing.JLabel();
        jWeaponComboBox = new javax.swing.JComboBox<String>();
        chooseHero = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jheroList = new javax.swing.JList<String>();
        jcaptionLabel = new javax.swing.JLabel();
        jheroListLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jheroStatsTextArea = new javax.swing.JTextArea();
        jheroStatsLabel = new javax.swing.JLabel();
        jplayButton = new javax.swing.JButton();
        gamePlay = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jMapTextArea = new javax.swing.JTextArea();
        jRunButton = new javax.swing.JButton();
        jFightButton = new javax.swing.JButton();
        jDirectionComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jArenaStatsTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbackButton.setText("Back");
        jbackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbackButtonActionPerformed(evt);
            }
        });

        jwelcomeLabel.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 2, 18)); // NOI18N
        jwelcomeLabel.setText("Welcome To Swingy");

        jmotoLabel.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        jmotoLabel.setText("A simplified WTC RPG Game");

        jchooseHeroBtn.setText("Choose Hero");
        jchooseHeroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchooseHeroBtnActionPerformed(evt);
            }
        });

        jcreateHeroBtn.setText("Create Hero");
        jcreateHeroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcreateHeroBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gameStartLayout = new javax.swing.GroupLayout(gameStart);
        gameStart.setLayout(gameStartLayout);
        gameStartLayout.setHorizontalGroup(
            gameStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameStartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jchooseHeroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcreateHeroBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gameStartLayout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addGroup(gameStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jwelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
        );
        gameStartLayout.setVerticalGroup(
            gameStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameStartLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jwelcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jmotoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                .addGroup(gameStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchooseHeroBtn)
                    .addComponent(jcreateHeroBtn))
                .addGap(89, 89, 89))
        );

        jcreateHeroLabel.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 2, 24)); // NOI18N
        jcreateHeroLabel.setText("Create a New Hero");

        jnameLabel.setText("Name:");

        jclassLabel.setText("Class:");

        jnameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jnameTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jnameTextFieldKeyReleased(evt);
            }
        });

        jcreateHeroButton.setText("Create Hero");
        jcreateHeroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcreateHeroButtonActionPerformed(evt);
            }
        });

        jClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jClassComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClassComboBoxActionPerformed(evt);
            }
        });

        jWeaponLabel.setText("Weapon:");

        jWeaponComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jWeaponComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jWeaponComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createHeroLayout = new javax.swing.GroupLayout(createHero);
        createHero.setLayout(createHeroLayout);
        createHeroLayout.setHorizontalGroup(
            createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createHeroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jcreateHeroButton)
                .addGap(67, 67, 67))
            .addGroup(createHeroLayout.createSequentialGroup()
                .addGroup(createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createHeroLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jcreateHeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(createHeroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jnameLabel)
                            .addComponent(jclassLabel)
                            .addComponent(jWeaponLabel))
                        .addGap(37, 37, 37)
                        .addGroup(createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jnameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jClassComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jWeaponComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        createHeroLayout.setVerticalGroup(
            createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createHeroLayout.createSequentialGroup()
                .addComponent(jcreateHeroLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnameLabel)
                    .addComponent(jnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jclassLabel)
                    .addComponent(jClassComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(createHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jWeaponLabel)
                    .addComponent(jWeaponComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addComponent(jcreateHeroButton)
                .addGap(0, 78, Short.MAX_VALUE))
        );

        jheroList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jheroList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jheroListMouseClicked(evt);
            }
        });
        jheroList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jheroListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jheroList);

        jcaptionLabel.setFont(new java.awt.Font("MingLiU_HKSCS-ExtB", 2, 24)); // NOI18N
        jcaptionLabel.setText("Choose your hero wisely:");

        jheroListLabel.setText("Hero's list:");

        jheroStatsTextArea.setColumns(20);
        jheroStatsTextArea.setRows(5);
        jScrollPane2.setViewportView(jheroStatsTextArea);

        jheroStatsLabel.setText("Hero Statistics:");

        jplayButton.setText("Play");
        jplayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jplayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout chooseHeroLayout = new javax.swing.GroupLayout(chooseHero);
        chooseHero.setLayout(chooseHeroLayout);
        chooseHeroLayout.setHorizontalGroup(
            chooseHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseHeroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(chooseHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(chooseHeroLayout.createSequentialGroup()
                        .addComponent(jheroListLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jheroStatsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(chooseHeroLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, chooseHeroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jplayButton)
                .addGap(245, 245, 245))
            .addGroup(chooseHeroLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jcaptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        chooseHeroLayout.setVerticalGroup(
            chooseHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chooseHeroLayout.createSequentialGroup()
                .addComponent(jcaptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(chooseHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jheroListLabel)
                    .addComponent(jheroStatsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(chooseHeroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(jplayButton)
                .addContainerGap())
        );

        jMapTextArea.setColumns(20);
        jMapTextArea.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jMapTextArea.setRows(5);
        jScrollPane3.setViewportView(jMapTextArea);

        jRunButton.setText("Run");
        jRunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRunButtonActionPerformed(evt);
            }
        });

        jFightButton.setText("Fight");
        jFightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFightButtonActionPerformed(evt);
            }
        });

        jDirectionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jDirectionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDirectionComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Move:");

        jArenaStatsTextArea.setColumns(20);
        jArenaStatsTextArea.setRows(5);
        jScrollPane4.setViewportView(jArenaStatsTextArea);

        javax.swing.GroupLayout gamePlayLayout = new javax.swing.GroupLayout(gamePlay);
        gamePlay.setLayout(gamePlayLayout);
        gamePlayLayout.setHorizontalGroup(
            gamePlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePlayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamePlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePlayLayout.createSequentialGroup()
                        .addGroup(gamePlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gamePlayLayout.createSequentialGroup()
                                .addComponent(jRunButton)
                                .addGap(18, 18, 18)
                                .addComponent(jFightButton))
                            .addComponent(jDirectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(gamePlayLayout.createSequentialGroup()
                        .addGroup(gamePlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(gamePlayLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        gamePlayLayout.setVerticalGroup(
            gamePlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePlayLayout.createSequentialGroup()
                .addGroup(gamePlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePlayLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE))
                    .addGroup(gamePlayLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)))
                .addComponent(jDirectionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(gamePlayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRunButton)
                    .addComponent(jFightButton))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(gamePlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(gameStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(createHero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(chooseHero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gamePlay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(gameStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(createHero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(chooseHero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jchooseHeroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchooseHeroBtnActionPerformed
        // TODO add your handling code here:
        final String  heros[] = new String[charact.size()];
        for(int i = 0; i < charact.size(); i++)
        {
            heros[i] = charact.get(i).getCharact().name;
        }
        jheroList = new javax.swing.JList<>();
        gameStart.setVisible(false);
        gamePlay.setVisible(false);
        createHero.setVisible(false);
        chooseHero.setVisible(true);
        jbackButton.setEnabled(true);
        jheroList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = heros;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jheroList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jheroListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jheroList);
        jheroStatsTextArea.setText("");
        jplayButton.setEnabled(false);
      
    }//GEN-LAST:event_jchooseHeroBtnActionPerformed

    private void jbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbackButtonActionPerformed
        // TODO add your handling code here:
        atStart();
    }//GEN-LAST:event_jbackButtonActionPerformed

    private void jcreateHeroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcreateHeroBtnActionPerformed
        // TODO add your handling code here:
        gameStart.setVisible(false);
        gamePlay.setVisible(false);
        createHero.setVisible(true);
        chooseHero.setVisible(false);
        jbackButton.setEnabled(true);
        newHero.setCharact(new Characters());
        newHero.getCharact().amor = new Amor();
        newHero.getCharact().amor.defence = 20;
        newHero.getCharact().hp = 100;
        newHero.getCharact().cordinates = new Coordinates();
        newHero.getCharact().weapon = new Weapon();
        newHero.getCharact().helm = new Helm();
        newHero.getCharact().helm.hitPoints = 5;
        newHero.getCharact().helm.name = "Razor";
        newHero.getCharact().level = 0;
        newHero.getCharact().exp = 0;
        newHero.getCharact().amor.name = "Force Field";
    }//GEN-LAST:event_jcreateHeroBtnActionPerformed

    private void jheroListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jheroListValueChanged
        selectedHero = jheroList.getSelectedIndex();
        CharacterController option = charact.get(jheroList.getSelectedIndex());
        String stats = "Name: " + option.getCharact().name + "\n";
        stats += "Hero Class: " + option.getCharact().type + "\n";
        stats += "Level: " + option.getCharact().level + "\n";
        stats += "Experience: " + option.getCharact().exp + "\n";
        stats += "Weapon: " + option.getCharact().weapon.name + "\n";
        stats += "Attack: " + option.getCharact().weapon.attack + "\n";
        stats += "Defense: " + option.getCharact().amor.defence + "\n";
        stats += "Hit points: " + option.getCharact().hp + "\n";
        jheroStatsTextArea.setText(stats);
        jplayButton.setEnabled(true);
    }//GEN-LAST:event_jheroListValueChanged

    private void jheroListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jheroListMouseClicked
        jheroStatsTextArea.setText("Hello");
    }//GEN-LAST:event_jheroListMouseClicked

    private void jWeaponComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jWeaponComboBoxActionPerformed
        String selected = jWeaponComboBox.getSelectedItem().toString();
        newHero.getCharact().weapon.name = new String(selected);
        newHero.getCharact().weapon.attack = 10;
        jcreateHeroButton.setEnabled(validateHero());
    }//GEN-LAST:event_jWeaponComboBoxActionPerformed

    private void jClassComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClassComboBoxActionPerformed
        newHero.getCharact().type =  jClassComboBox.getSelectedItem().toString();
        jcreateHeroButton.setEnabled(validateHero());
    }//GEN-LAST:event_jClassComboBoxActionPerformed

    private void jnameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnameTextFieldKeyPressed
      
    }//GEN-LAST:event_jnameTextFieldKeyPressed

    private void jcreateHeroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcreateHeroButtonActionPerformed
        WriteToFileController write = new WriteToFileController();
        selectedHero = charact.size();
        charact.add(newHero);
        write.update(charact);
        gameStart.setVisible(false);
        gamePlay.setVisible(true);
        createHero.setVisible(false);
        chooseHero.setVisible(false);
        jbackButton.setEnabled(false);
        newHero = charact.get(charact.size() - 1);
        arenaStats(newHero);
    }//GEN-LAST:event_jcreateHeroButtonActionPerformed

    private void jnameTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jnameTextFieldKeyReleased
         newHero.getCharact().name =jnameTextField.getText();
       jcreateHeroButton.setEnabled(validateHero());
    }//GEN-LAST:event_jnameTextFieldKeyReleased

    private void jplayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jplayButtonActionPerformed
        gameStart.setVisible(false);
        gamePlay.setVisible(true);
        createHero.setVisible(false);
        chooseHero.setVisible(false);
        jbackButton.setEnabled(false);
        newHero = charact.get(jheroList.getSelectedIndex());
        
        arenaStats(newHero);
    }//GEN-LAST:event_jplayButtonActionPerformed

    private void jDirectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDirectionComboBoxActionPerformed
        boolean move = game.moveCharacter(newHero, jDirectionComboBox.getSelectedIndex(), 0);
        String [][] tmpMap = map.getMap(newHero.getCharact().level);
        map.drawMap(newHero, enemies, tmpMap);
        jMapTextArea.setText(map.getDisplay(tmpMap));
        jScrollPane3.setViewportView(jMapTextArea);
        if (move == false)
        {
            JOptionPane.showMessageDialog(this, "Theres an enemy infront. Fight or Run?");
            jFightButton.setEnabled(true);
            jRunButton.setEnabled(true);
            jDirectionComboBox.setEnabled(false);
        }
        game.checkGameState(newHero, jDirectionComboBox.getSelectedIndex(), 0);
    }//GEN-LAST:event_jDirectionComboBoxActionPerformed

    private void jRunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRunButtonActionPerformed
        boolean run = game.getHero().run();
        if (run == true)
        {
            jDirectionComboBox.setEnabled(true);
            jFightButton.setEnabled(false);
            jRunButton.setEnabled(false);
        }
        else
        {
            jDirectionComboBox.setEnabled(false);
            jFightButton.setEnabled(true);
            jRunButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Ooops... There is no running this time... you have to fight!");
        }
    }//GEN-LAST:event_jRunButtonActionPerformed

    private void jFightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFightButtonActionPerformed
        boolean state = game.getHero().fight(game.getEnemy());
        CharacterController option = game.getHero();
        charact.get(selectedHero).getCharact().exp = game.getHero().getCharact().exp;
        charact.get(selectedHero).getCharact().level = game.getHero().getCharact().level;
       
        WriteToFileController write = new WriteToFileController();
        write.update(charact);
        String stats = "Name: " + option.getCharact().name + "\n\n";
        stats += "Hero Class: " + option.getCharact().type + "\n\n";
        stats += "Level: " + option.getCharact().level + "\n\n";
        stats += "Experience: " + option.getCharact().exp + " XP\n\n";
        stats += "Weapon: " + option.getCharact().weapon.name + "\n\n";
        stats += "Attack: " + option.getCharact().weapon.attack + "\n\n";
        stats += "Defense: " + option.getCharact().amor.defence + "\n\n";
        stats += "Hit points: " + option.getCharact().hp;
        jArenaStatsTextArea.setText(stats);
        if (state == true)
        {
            JOptionPane.showMessageDialog(null, "Congratulations... you won the battle...");
            enemies.remove(game.getEnemy());
            jFightButton.setEnabled(false);
            jRunButton.setEnabled(false);
            jDirectionComboBox.setEnabled(true);
            String [][] tmpMap = map.getMap(newHero.getCharact().level);
            map.drawMap(newHero, enemies, tmpMap);
            jMapTextArea.setText(map.getDisplay(tmpMap));
            jScrollPane3.setViewportView(jMapTextArea);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Boohahahaha... you lost the battle...");
            System.exit(1);
        }
    }//GEN-LAST:event_jFightButtonActionPerformed

    private void arenaStats(HeroController option)
    {
        String [][] tmpMap = map.getMap(option.getCharact().level);
        option.getCharact().cordinates.x =  tmpMap.length / 2;
        option.getCharact().cordinates.y =  tmpMap.length / 2;
        placeHeros(tmpMap.length);
        map.drawMap(newHero, enemies, tmpMap);
        
        jMapTextArea.setText(map.getDisplay(tmpMap));
        jScrollPane3.setViewportView(jMapTextArea);
        jMapTextArea.setEditable(false);
        String stats = "Name: " + option.getCharact().name + "\n\n";
        stats += "Hero Class: " + option.getCharact().type + "\n\n";
        stats += "Level: " + option.getCharact().level + "\n\n";
        stats += "Experience: " + option.getCharact().exp + " XP\n\n";
        stats += "Weapon: " + option.getCharact().weapon.name + "\n\n";
        stats += "Attack: " + option.getCharact().weapon.attack + "\n\n";
        stats += "Defense: " + option.getCharact().amor.defence + "\n\n";
        stats += "Hit points: " + option.getCharact().hp;
        jArenaStatsTextArea.setText(stats);
        jArenaStatsTextArea.setEditable(false);
        jDirectionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "North", "South", "West", "East" }));
        game.setHero(newHero);
        
    }
    private void placeHeros(int mapSize)
    {
        Random rand = new Random();
        int x;
        int y;
        for(int i = 0; i < enemies.size(); i++)
        {
            x = rand.nextInt(mapSize) + 1;
            y = rand.nextInt(mapSize) + 1;
            x -= 1;
            y -= 1;
            if (x != newHero.getCharact().cordinates.x && y != newHero.getCharact().cordinates.y)
            {
                enemies.get(i).getCharact().cordinates.x = x;
                enemies.get(i).getCharact().cordinates.y = y;
            }
            else
            {
                enemies.get(i).getCharact().cordinates.x = x - 1;
                enemies.get(i).getCharact().cordinates.y = y - 1;
            }
        }
        
       
    }
    private void atStart()
    {
        gameStart.setVisible(true);
        gamePlay.setVisible(false);
        createHero.setVisible(false);
        chooseHero.setVisible(false);
        jbackButton.setEnabled(false);
        jcreateHeroButton.setEnabled(false);
        jFightButton.setEnabled(false);
        jRunButton.setEnabled(false);
        newHero.getCharact().name = "";
        newHero.getCharact().weapon.name= "";
        newHero.getCharact().type = "";
        jWeaponComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "M-16 Rifle", "ChainSaw", "Axe" }));
        jClassComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Hobbit", "Elf", "Zombie", "Wizard" }));
    }
    private boolean validateHero()
    {
        if (newHero.getCharact().weapon.name == null)
            newHero.getCharact().weapon.name = "";
        if (newHero.getCharact().name == null)
            newHero.getCharact().name = "";
        if ( newHero.getCharact().type == null)
             newHero.getCharact().type = "";
        if (newHero.getCharact().name.length() < 1)
            return false;
        if (newHero.getCharact().weapon.name.length() < 1)
            return false;
        if (newHero.getCharact().type.length() < 1)
            return false;
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chooseHero;
    private javax.swing.JPanel createHero;
    private javax.swing.JPanel gamePlay;
    private javax.swing.JPanel gameStart;
    private javax.swing.JTextArea jArenaStatsTextArea;
    private javax.swing.JComboBox<String> jClassComboBox;
    private javax.swing.JComboBox jDirectionComboBox;
    private javax.swing.JButton jFightButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea jMapTextArea;
    private javax.swing.JButton jRunButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jWeaponComboBox;
    private javax.swing.JLabel jWeaponLabel;
    private javax.swing.JButton jbackButton;
    private javax.swing.JLabel jcaptionLabel;
    private javax.swing.JButton jchooseHeroBtn;
    private javax.swing.JLabel jclassLabel;
    private javax.swing.JButton jcreateHeroBtn;
    private javax.swing.JButton jcreateHeroButton;
    private javax.swing.JLabel jcreateHeroLabel;
    private javax.swing.JList<String> jheroList;
    private javax.swing.JLabel jheroListLabel;
    private javax.swing.JLabel jheroStatsLabel;
    private javax.swing.JTextArea jheroStatsTextArea;
    private javax.swing.JLabel jmotoLabel;
    private javax.swing.JLabel jnameLabel;
    private javax.swing.JTextField jnameTextField;
    private javax.swing.JButton jplayButton;
    private javax.swing.JLabel jwelcomeLabel;
    // End of variables declaration//GEN-END:variables
}
