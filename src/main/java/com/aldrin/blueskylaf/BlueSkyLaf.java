/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.aldrin.blueskylaf;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Java Programming with Aldrin
 */
public class BlueSkyLaf {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            try {
                // Step 4: Set the custom LookAndFeel
//                UIManager.setLookAndFeel(new BlueSkyLookAndFeel());
                UIManager.setLookAndFeel("com.aldrin.blueskylaf.laf.BlueSkyLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            JFrameBlueSkyLaf frame = new JFrameBlueSkyLaf();
//          SwingUtilities.updateComponentTreeUI(frame);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
