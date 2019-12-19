/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import view.HocVienPanel;
import view.TrangChuPanel;

/**
 *
 * @author micha
 */
public class ChuyenManHinhController {
    
    private JPanel root;
    private String kindSelected = "";
    private List<DanhMucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(102,51,153));
        jlbItem.setBackground(new Color(102,51,153));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuPanel());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        for(DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener {
        private JPanel node;
        private final String kind;
        private final JPanel jpnItem;
        private final JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "TrangChinh":
                    node = new TrangChuPanel();
                    break;
                case "HocVien":
                    node = new HocVienPanel();
                    break;
                // more
                default:
                    node = new TrangChuPanel();
                    break;
           }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackground(kind);
        }
        
        @Override
        public void mousePressed(MouseEvent e) {
           kindSelected = kind;
           jpnItem.setBackground(new Color(102,51,153));
           jlbItem.setBackground(new Color(102,51,153));
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            
        }
        
        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(102,51,153));
            jlbItem.setBackground(new Color(102,51,153));
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(1,152,117));
                jlbItem.setBackground(new Color(1,152,117));
            }
        }
        
    }
    
    private void setChangeBackground(String kind) {
        for(DanhMucBean item : listItem) {
            if(item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(102,51,153));
                item.getJlb().setBackground(new Color(102,51,153));
            } else {
                item.getJpn().setBackground(new Color(1,152,117));
                item.getJlb().setBackground(new Color(1,152,117));
            }
        }
    }
    
}
