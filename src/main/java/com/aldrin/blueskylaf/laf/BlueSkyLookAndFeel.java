/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.blueskylaf.laf;

import com.aldrin.blueskylaf.ui.BlueSkyButtonUI;
import com.aldrin.blueskylaf.ui.BlueSkyTextFieldUI;
import java.awt.Color;
import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 *
 * @author Java Programming with Aldrin
 */
public class BlueSkyLookAndFeel extends BasicLookAndFeel {

    @Override
    public String getName() {
        return "Hover and Click LookAndFeel";
    }

    @Override
    public String getID() {
        return "HoverClickLookAndFeel";
    }

    @Override
    public String getDescription() {
        return "A custom LookAndFeel that changes JButton background on hover and click.";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);

        // Step 3: Register the custom ButtonUI class for JButton
        table.put("ButtonUI", BlueSkyButtonUI.class.getName());
        table.put("TextFieldUI", BlueSkyTextFieldUI.class.getName());

    }

    @Override
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);

        // Set custom colors for JComboBox
        table.put("Label.foreground", new Color(0, 153, 0));
    }
}
    