/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.customerRole;

import ui.marketingRole.*;
import userbusiness.UserLogin;
import javax.swing.GroupLayout.Alignment;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import salesmodel.CustomerManagement.CustomerProfile;
import salesmodel.Data.Data;
import salesmodel.utils.DataUtil;
import ui.UserLoginJPanel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import salesmodel.MarketModel.Channel;
import salesmodel.OrderManagement.Order;
import salesmodel.Personnel.Person;
import salesmodel.ProductManagement.Product;
import salesmodel.ProductManagement.SolutionBundleAssignment;
import salesmodel.ProductManagement.SolutionItem;
import salesmodel.ProductManagement.SolutionOffer;
import ui.UiControl;
import userbusiness.Account;

/**
 *
 * @author faye
 */
public class BundleDetailScene extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L; 
    private JFrame jf;
    private Data data;
    private Account account; 
    private CustomerProfile cp;
    private SolutionBundleAssignment sa; 

    /**
     * Creates new form MarketingDashboard_new
     */
    public BundleDetailScene(JFrame jf, Data data, Account account, SolutionBundleAssignment sa) {
        setBackground(new Color(0, 128, 128));
        this.jf = jf;
        this.data = data;
        this.account = account; 
        this.cp = data.getBusiness().cd.findCustomer(account.getPerson().getPersonId());
        this.sa = sa;
        
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        top_search_panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        logout_btn = new javax.swing.JButton();
        my_account_btn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cart_btn = new javax.swing.JButton();
        order_btn = new javax.swing.JButton();
        home_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detail_table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        add_cart_bt = new javax.swing.JButton();
        buy_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 0)));
        setMaximumSize(new java.awt.Dimension(680, 800));
        setPreferredSize(new java.awt.Dimension(664, 800));
        setSize(new java.awt.Dimension(680, 800));

        top_search_panel.setBackground(new java.awt.Color(0, 0, 0));
        top_search_panel.setMaximumSize(new java.awt.Dimension(800, 800));
        top_search_panel.setPreferredSize(new java.awt.Dimension(680, 74));
        top_search_panel.setSize(new java.awt.Dimension(680, 74));

        jLabel1.setBackground(new java.awt.Color(255, 203, 168));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 163, 188));
        jLabel1.setText("Hello, "+this.account.getPerson().getName().split(" ")[0]);

        label1.setText("label1");

        logout_btn.setBackground(new java.awt.Color(204, 204, 204));
        logout_btn.setText("Log out");
        logout_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logout_btnMouseClicked(evt);
            }
        });

        my_account_btn.setBackground(new java.awt.Color(204, 204, 204));
        my_account_btn.setText("My Account");
        my_account_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                my_account_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout top_search_panelLayout = new javax.swing.GroupLayout(top_search_panel);
        top_search_panel.setLayout(top_search_panelLayout);
        top_search_panelLayout.setHorizontalGroup(
            top_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top_search_panelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(top_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(top_search_panelLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(top_search_panelLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(my_account_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        top_search_panelLayout.setVerticalGroup(
            top_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top_search_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(top_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(top_search_panelLayout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, top_search_panelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(1, 1, 1)))
                .addGroup(top_search_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout_btn)
                    .addComponent(my_account_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(236, 234, 234));

        cart_btn.setText("My Cart");
        cart_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cart_btnMouseClicked(evt);
            }
        });

        order_btn.setText("My Orders");
        order_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                order_btnMouseClicked(evt);
            }
        });

        home_btn.setText("Home");
        home_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_btnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(home_btn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cart_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(order_btn)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cart_btn)
                    .addComponent(order_btn)
                    .addComponent(home_btn)))
        );

        DefaultTableModel dtm = new DefaultTableModel(0, 0);

        String[] header = new String[]{"Prodcut","Quantity","Price"};
        dtm.setColumnIdentifiers(header);
        for(SolutionOffer offer:this.sa.getBundle().getOffers()){
            for(SolutionItem item: offer.getProducts()){
                String[] row = new String[3];
                item.getProduct().getDesc();
                row[0] = item.getProduct().getDesc();
                row[1] = String.valueOf(item.getQuantity());
                row[2] = String.valueOf(item.getActualPrice());
                dtm.addRow(row);
            }
        }
        detail_table.setModel(dtm);
        jScrollPane1.setViewportView(detail_table);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel3.setText("Bundle Details");

        add_cart_bt.setText("Add to Cart");
        add_cart_bt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_cart_btMouseClicked(evt);
            }
        });

        buy_btn.setText("Buy");
        buy_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy_btnMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel4.setText("Total Price:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel2.setText("$"+String.valueOf(this.sa.getBundle().getTotalPrice()));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Copy Right 2020 Sales.com");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(buy_btn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(add_cart_bt))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(top_search_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_search_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_cart_bt)
                    .addComponent(buy_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logout_btnMouseClicked
        // TODO add your handling code here:
        cleanPanel();
        UserLoginJPanel loginUI = new UserLoginJPanel(jf, data);
        UiControl.logout(this.jf, loginUI);
    }//GEN-LAST:event_logout_btnMouseClicked

    private void buy_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy_btnMouseClicked
        // TODO add your handling code here: 
        DataUtil.submitOrder(this.data, this.sa, this.cp);
        cleanPanel();
        OrderHistoryScene order = new OrderHistoryScene(this.jf, this.data, this.account);
        UiControl.viewCustomerOrder(this.jf, order); 
    }//GEN-LAST:event_buy_btnMouseClicked

    private void order_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_btnMouseClicked
        // TODO add your handling code here:
        cleanPanel();
        OrderHistoryScene order = new OrderHistoryScene(this.jf, this.data, this.account);
        UiControl.viewCustomerOrder(this.jf, order);
    }//GEN-LAST:event_order_btnMouseClicked

    private void add_cart_btMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_cart_btMouseClicked
        // TODO add your handling code here:
        DataUtil.addCart(this.data, this.sa, this.cp);
        JOptionPane.showMessageDialog(this.jf, "Succeed");
    }//GEN-LAST:event_add_cart_btMouseClicked

    private void cart_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cart_btnMouseClicked
        // TODO add your handling code here:
        cleanPanel();
        CustomerCartScene cart = new CustomerCartScene(this.jf, this.data, this.account);
        UiControl.viewCustomerCart(this.jf, cart);
    }//GEN-LAST:event_cart_btnMouseClicked

    private void add_cart_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseClicked

    private void home_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_btnMouseClicked
        // TODO add your handling code here:
        cleanPanel();
        CustomerDashboard dashboard = new CustomerDashboard(this.jf, this.data, this.account);
        UiControl.dashboard(this.jf, dashboard); 
    }//GEN-LAST:event_home_btnMouseClicked

    private void my_account_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_my_account_btnMouseClicked
        // TODO add your handling code here:
        cleanPanel();
        CustomerAccountScene account = new CustomerAccountScene(this.jf, this.data, this.account);
        UiControl.viewAccount(this.jf, account);
    }//GEN-LAST:event_my_account_btnMouseClicked

    private void cleanPanel(){ 
        this.setVisible(false);
        this.removeAll();
        this.jf.remove(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_cart_bt;
    private javax.swing.JButton buy_btn;
    private javax.swing.JButton cart_btn;
    private javax.swing.JTable detail_table;
    private javax.swing.JButton home_btn;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JButton logout_btn;
    private javax.swing.JButton my_account_btn;
    private javax.swing.JButton order_btn;
    private javax.swing.JPanel top_search_panel;
    // End of variables declaration//GEN-END:variables
}
