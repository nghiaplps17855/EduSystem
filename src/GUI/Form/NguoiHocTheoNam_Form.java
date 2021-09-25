
package GUI.Form;

import DAO.ThongKeDAO;
import GUI.Chart.BarChart.BarChart;
import GUI.Chart.BarChart.ModelChart;
import GUI.Swing.ScrollBar;
import java.awt.Color;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class NguoiHocTheoNam_Form extends javax.swing.JPanel {

    ThongKeDAO tkdao = new ThongKeDAO();
    BarChart barChart = new BarChart();
    
    public NguoiHocTheoNam_Form() {
        initComponents();
        intit();
    }

    void intit(){
        scrollPane.setVerticalScrollBar(new ScrollBar());
        fillTable();
    }
    
    void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblTKNguoiHoc.getModel();
        model.setRowCount(0);
        barChart = createChart();
        List<Object[]> list = tkdao.getLuongNguoiHoc();
        for (Object[] row : list) {
            int nam = (int) row[0];
            int snh = (int) row[1];
            model.addRow(row);
            fillDataChart(String.valueOf(nam), snh);
        }
    }
    
    void fillDataChart(String masv , double diem){
        barChart.addData(new ModelChart(masv, new double[]{diem}));
    }
    
    BarChart createChart(){
        BarChart barChart = new BarChart();
        barChart.addLegend("Lượng người học", new Color(135, 189,245));
        chartPanel.removeAll();
        chartPanel.add(barChart);
        chartPanel.repaint();
        chartPanel.revalidate();
        return barChart;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new GUI.Swing.PanelBorder();
        scrollPane = new javax.swing.JScrollPane();
        tblTKNguoiHoc = new GUI.Swing.Table();
        chartPanel = new javax.swing.JPanel();

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        tblTKNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Năm", "Số người học", "Đăng kí sớm nhất", "Đăng kí muộn nhất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(tblTKNguoiHoc);

        chartPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chartPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartPanel;
    private GUI.Swing.PanelBorder panelBorder1;
    private javax.swing.JScrollPane scrollPane;
    private GUI.Swing.Table tblTKNguoiHoc;
    // End of variables declaration//GEN-END:variables
}
