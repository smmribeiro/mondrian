/*
// This software is subject to the terms of the Eclipse Public License v1.0
// Agreement, available at the following URL:
// http://www.eclipse.org/legal/epl-v10.html.
// You must accept the terms of that agreement to use this software.
//
// Copyright (C) 2002-2005 Julian Hyde
// Copyright (C) 2005-2017 Hitachi Vantara and others
// Copyright (C) 2006-2007 Cincom Systems, Inc.
// Copyright (C) 2006-2007 JasperSoft
// All Rights Reserved.
*/

package mondrian.gui;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;


/**
 * @author sean
 */
public class PreferencesDialog extends javax.swing.JDialog {
    boolean accepted = false;

    /**
     * Creates new form PreferencesDialog
     */
    public PreferencesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        pack();
        setLocationRelativeTo(parent);
    }

    public boolean accepted() {
        return accepted;
    }

    public void setJDBCConnectionUrl(String s) {
        this.urlTextField.setText(s);
    }

    public String getJdbcConnectionUrl() {
        return urlTextField.getText();
    }

    public void setJDBCUsername(String s) {
        this.usernameTextField.setText(s);
    }

    public String getJdbcUsername() {
        return usernameTextField.getText();
    }

    public void setJDBCPassword(String s) {
        this.passwordTextField.setText(s);
    }

    public String getJdbcPassword() {
        return passwordTextField.getText();
    }

    public void setJDBCDriverClassName(String s) {
        this.driverClassTextField.setText(s);
    }

    public String getJdbcDriverClassName() {
        return driverClassTextField.getText();
    }

    public void setDatabaseSchema(String schema) {
        this.schemaTextField.setText(schema);
    }

    public String getDatabaseSchema() {
        return schemaTextField.getText();
    }

    public void setRequireSchema(boolean requireSchema) {
        requireSchemaButton.setSelected(requireSchema);
    }

    public boolean getRequireSchema() {
        return requireSchemaButton.isSelected();
    }

    /**
     * @return the workbench i18n converter
     */
    public I18n getResourceConverter() {
        if (getParent() == null && getParent().getClass() != Workbench.class) {
            return Workbench.getGlobalResourceConverter();
        }
        return ((Workbench) getParent()).getResourceConverter();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        // Set the url text field to 50 to drive the width of the dialog
        urlTextField = new javax.swing.JTextField(50);

        usernameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JTextField();
        driverClassTextField = new javax.swing.JTextField();
        schemaTextField = new javax.swing.JTextField();
        requireSchemaButton = new javax.swing.JCheckBox();
        testButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        selectSchemasButton = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setTitle(
            getResourceConverter().getString(
                "preferences.pane.title", "Database Connection"));
        addWindowListener(
            new WindowAdapter() {
                public void windowClosing(WindowEvent evt) {
                    closeDialog(evt);
                }
            });

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText(
            getResourceConverter().getString(
                "preferences.driverClassName.title", "Driver Class Name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText(
            getResourceConverter().getString(
                "preferences.connectionURL.title", "Connection URL"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText(
            getResourceConverter().getString(
                "preferences.userName.title", "User name"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setText(
            getResourceConverter().getString(
                "preferences.password.title", "Password"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(urlTextField, gridBagConstraints);

        jLabel5.setText(
            getResourceConverter().getString(
                "preferences.schema.title",
                "Schemas (Optional, comma separated)"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setText(
            getResourceConverter().getString(
                "preferences.requireschema.title",
                "Require Schema Attributes"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(jLabel6, gridBagConstraints);

        usernameTextField.setText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(usernameTextField, gridBagConstraints);

        passwordTextField.setText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(passwordTextField, gridBagConstraints);

        schemaTextField.setText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(schemaTextField, gridBagConstraints);

        selectSchemasButton.setText(
            getResourceConverter().getString(
                "preferences.selectSchemasButton.title",
                "Select Schemas"));
        selectSchemasButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    selectSchemasButtonActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 180);
        jPanel1.add(selectSchemasButton, gridBagConstraints);

        // Disable the select schemas button for now
        selectSchemasButton.setVisible(false);

        requireSchemaButton.setSelected(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(requireSchemaButton, gridBagConstraints);

        driverClassTextField.setText("com.mysql.jdbc.Driver");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel1.add(driverClassTextField, gridBagConstraints);

        jTabbedPane1.addTab(
            getResourceConverter().getString(
                "preferences.jdbcPanel.title", "JDBC"), jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jTabbedPane1, gridBagConstraints);

        testButton.setText(
            getResourceConverter().getString(
                "preferences.testButton.title", "Test Connection"));
        testButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    testButtonActionPerformed(evt);
                }
            });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 180);
        getContentPane().add(testButton, gridBagConstraints);

        cancelButton.setText(
            getResourceConverter().getString(
                "preferences.cancelButton.title",
                "Cancel"));
        cancelButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    cancelButtonActionPerformed(evt);
                }
            });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(cancelButton, gridBagConstraints);

        acceptButton.setText(
            getResourceConverter().getString(
                "preferences.acceptButton.title",
                "Accept"));
        acceptButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    acceptButtonActionPerformed(evt);
                }
            });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 80);
        getContentPane().add(acceptButton, gridBagConstraints);

        pack();
    } //GEN-END:initComponents

    private void selectSchemasButtonActionPerformed(
        ActionEvent evt)
    {
        JdbcMetaData jdbcMetaData = getTestingJdbcMetadata();
        if (jdbcMetaData.getErrMsg() != null) {
            JOptionPane.showMessageDialog(
                this,
                getResourceConverter().getFormattedString(
                    "preferences.unsuccessfulTestConnection.alert",
                    "Database connection could not be done.\n{0}",
                    jdbcMetaData.getErrMsg()),
                "",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<String> allSchemaNames = jdbcMetaData.listAllSchemas();
        if (allSchemaNames == null || allSchemaNames.size() == 0) {
            JOptionPane.showMessageDialog(
                this, getResourceConverter().getString(
                    "preferences.noSchemas.cantSetSchemas.alert",
                    "No schemas available for this database connection"),
                "",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        PreferencesSchemasDialog psd = new PreferencesSchemasDialog(
            this, jdbcMetaData);

        setVisible(false);
        setModal(false);
        psd.setVisible(true);

        if (psd.isAccepted()) {
            // update list of schemas
        }

        setModal(true);
        setVisible(true);
    }

    public JdbcMetaData getTestingJdbcMetadata() {
        return new JdbcMetaData(
            getJdbcDriverClassName(),
            getJdbcConnectionUrl(),
            getJdbcUsername(),
            getJdbcPassword());
    }

    private void testButtonActionPerformed(ActionEvent evt) {
        //GEN-FIRST:event_testButtonActionPerformed
        JdbcMetaData jdbcMetaData = getTestingJdbcMetadata();
        if (jdbcMetaData.getErrMsg() != null) {
            JOptionPane.showMessageDialog(
                this,
                getResourceConverter().getFormattedString(
                    "preferences.unsuccessfulTestConnection.alert",
                    "Database connection could not be done.\n{0}",
                    jdbcMetaData.getErrMsg()),
                "",
                JOptionPane.WARNING_MESSAGE);
            accepted = false;
            return;
        }

        List<String> allSchemaNames = jdbcMetaData.listAllSchemas();

        String currentSchemas = schemaTextField.getText();

        // If (schemas entered  or schemas required) and
        // DB does not support schemas
        // -> error
        if (allSchemaNames == null || allSchemaNames.size() == 0) {
            if (currentSchemas != null && currentSchemas.trim().length() > 0) {
                JOptionPane.showMessageDialog(
                    this, getResourceConverter().getString(
                        "preferences.noSchemas.butSchemasEntered.alert",
                        "No schemas available for this database connection, but schemas entered"),
                    "",
                    JOptionPane.WARNING_MESSAGE);
                accepted = false;
                return;
            }

            if (requireSchemaButton.isSelected()) {
                JOptionPane.showMessageDialog(
                    this, getResourceConverter().getString(
                        "preferences.noSchemas.butSchemasRequired.alert",
                        "No schemas available for this database connection, but schemas are required"),
                    "",
                    JOptionPane.WARNING_MESSAGE);
                accepted = false;
                return;
            }
        }

        // Validate entered schemas
        if (currentSchemas != null && currentSchemas.trim().length() > 0) {
            String schemasArray[] = currentSchemas.trim().split("[,;]");

            Set<String> validSchemas = new TreeSet<String>();
            StringBuffer schemasInError = new StringBuffer();

            for (int i = 0; i < schemasArray.length; i++) {
                // trim the names, removing empties
                String enteredSchemaName = schemasArray[i].trim();

                if (enteredSchemaName.length() > 0) {
                    for (String actualSchemaName : allSchemaNames) {
                        if (actualSchemaName
                            .equalsIgnoreCase(enteredSchemaName))
                        {
                            validSchemas.add(enteredSchemaName);
                            break;
                        }
                    }
                }

                if (!validSchemas.contains(enteredSchemaName)) {
                    schemasInError.append(" ").append(enteredSchemaName);
                }
            }

            if (schemasInError.length() > 0) {
                JOptionPane.showMessageDialog(
                    this,
                    getResourceConverter().getFormattedString(
                        "preferences.invalidSchemas.alert",
                        "The following entered schemas are invalid.\n{0}",
                        schemasInError.toString()),
                    "",
                    JOptionPane.WARNING_MESSAGE);
                accepted = false;
                return;
            }
        }

        JOptionPane.showMessageDialog(
            this, getResourceConverter().getString(
                "preferences.successfulTestConnection.alert",
                "Database connection successful"),
            "",
            JOptionPane.INFORMATION_MESSAGE);
        accepted = true;
    } //GEN-LAST:event_testButtonActionPerformed

    private void acceptButtonActionPerformed(ActionEvent evt) {
        //GEN-FIRST:event_acceptButtonActionPerformed
        accepted = true;
        setVisible(false);
    } //GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(ActionEvent evt) {
        //GEN-FIRST:event_cancelButtonActionPerformed
        accepted = false;
        setVisible(false);
    } //GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(WindowEvent evt) {
        //GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    } //GEN-LAST:event_closeDialog

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField driverClassTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JTextField schemaTextField;
    private javax.swing.JCheckBox requireSchemaButton;
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton testButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton selectSchemasButton;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}

// End PreferencesDialog.java
