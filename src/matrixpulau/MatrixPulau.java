/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixpulau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author lee
 */
public class MatrixPulau extends JFrame {
    
    public static void out(Object o){
        System.out.println(o);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MatrixPulau().showTime();
    }
    
    public MatrixPulau(){
        setTitle("Matrix Pulau");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponent();
    }
    
    public void showTime(){
        setMinimumSize(new Dimension(800,600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private JTextField nfield;
    private GridLayout grid;
    private JPanel boxes, body;
    private JLabel resultText;
    
    private void initComponent(){
        JPanel ip = new JPanel(new FlowLayout());
        nfield = new JTextField(5);
        nfield.setText("5");
        ip.add(new JLabel("Baris/Kolom"));
        ip.add(nfield);
        
        JButton btn = new JButton("Proses");
        btn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                MatrixPulau.this.mainkan();
            }
            
        });
        ip.add(btn);
        getContentPane().add(ip, BorderLayout.NORTH);
        
        grid = new GridLayout();
        boxes = new JPanel(grid);
        
        body = new JPanel(new BorderLayout());
        body.add(boxes, BorderLayout.CENTER);
        
        JPanel fp = new JPanel(new FlowLayout());
        fp.add(new JLabel("Jumlah Pulau"));
        resultText = new JLabel("0");
        fp.add(resultText);
        body.add(fp, BorderLayout.SOUTH);
        
        getContentPane().add(body, BorderLayout.CENTER);
        getContentPane().add(new JLabel(
                "ali LIM ( konglie@kurungkurawal.com )"
        ), BorderLayout.SOUTH);
    }
    
    private void mainkan(){
        int n = 0;
        try {
            n = Integer.parseInt(nfield.getText().trim());
        } catch(Exception e){
            e.printStackTrace();
        }
        
        int[][] matrix = genMatrix(n);
        visualize(matrix);
        int npulau = new Pulau(matrix).hitung();
        resultText.setText(npulau + "");
    }
    
    private void visualize(int[][] matrix){
        boxes.removeAll();
        int n = matrix.length;
        grid.setRows(n);
        grid.setColumns(n);
        
        int i, j;
        for(i = 0; i < n; i++){
            for(j = 0; j< n; j++){
                JPanel p = new JPanel();
                int v = matrix[i][j];
                JLabel lbl = new JLabel(v + "");
                p.add(lbl);
                if(v == 1){
                    p.setBackground(Color.RED);
                    p.setOpaque(true);
                }
                boxes.add(p);
            }
        }
        showTime();
    }
    
    private int[][] genMatrix(int n) {
        int[][] result = new int[n][n];
        int i,j;
        
        for(i = 0; i < n; i++){
            for(j = 0; j < n; j++){
                result[i][j] = (int) (Math.random() * 10000) % 2;
            }
        }
        
        return result;
    }
    
}
