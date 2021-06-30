/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbctool.view.util;

import com.jdbctool.model.util.ConmentMessage;
import com.jdbctool.view.MessageDialog;
import javax.swing.ImageIcon;

/**
 *
 */
public class DialogMessage {

    /**
     * メッセージが表示され
     *
     * @param message
     * @param flg
     */
    public static void popDialog(String message, boolean flg) {

        ImageIcon oKIcon = new ImageIcon(ConmentMessage.INFOICON);
        ImageIcon attentionIcon = new ImageIcon(ConmentMessage.ATTETIONICON);
        MessageDialog dilog = new MessageDialog();
        if (flg == false) {
            //setIcon
            MessageDialog.Message.setIcon(attentionIcon);
        } else {
            //setIcon
            MessageDialog.Message.setIcon(oKIcon);
        }
        MessageDialog.Message.setText(message);

        dilog.setVisible(true);

    }

}
