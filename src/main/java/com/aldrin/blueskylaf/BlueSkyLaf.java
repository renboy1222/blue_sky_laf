/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.aldrin.blueskylaf;

import com.aldrin.blueskylaf.laf.BlueSkyLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
                String laf = "com.aldrin.blueskylaf.laf.BlueSkyLookAndFeel";
                UIManager.setLookAndFeel(laf);
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
