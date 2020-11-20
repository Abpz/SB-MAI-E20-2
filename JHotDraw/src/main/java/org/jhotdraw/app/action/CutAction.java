/*
 * @(#)CutAction.java  2.0  2007-04-13
 *
 * Copyright (c) 1996-2007 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 *
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */

package org.jhotdraw.app.action;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Cuts the selected region and places its contents into the system clipboard.
 * Acts on the EditableComponent or JTextComponent which had the focus when
 * the ActionEvent was generated.
 *
 * @author Werner Randelshofer
 * @version 2.0 2007-04-13 Use javax.swing.TransferHandler instead of 
 * interface EditableComponent. 
 * <br>1.0 October 9, 2005 Created.
 */
public class CutAction extends AbstractBasicEditingAction {
    public final static String ID = "edit.cut";
   
    /** Creates a new instance. */
    public CutAction() {
        super(ID);
    }

    @Override
    protected void preformAction(ActionEvent event, Component component) {
        if (component instanceof JComponent) {
            JComponent jComponent = (JComponent) component;
            jComponent.getTransferHandler().exportToClipboard(
                    jComponent,
                    jComponent.getToolkit().getSystemClipboard(),
                    TransferHandler.MOVE
                    );
        }
    }
}
