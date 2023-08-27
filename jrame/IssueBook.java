/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jrame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author thenu
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    //to fetch the book details from the database and display it to book details panel
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_bookId.setText(rs.getString("book_id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
                
            }else {
                lbl_bookerror1.setText("Invalid book ID");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //to fetch the student details from the database and display it to student details panel
    public void getStudentDetails(){
        String studentId = (txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setString(1, studentId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_studentId.setText(rs.getString("student_id"));
                lbl_studentName.setText(rs.getString("name"));
                lbl_course.setText(rs.getString("course"));
                lbl_campus.setText(rs.getString("campus"));
                
            }else {
                lbl_studenterror.setText("Invalid Student ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //insert issue book details to database
    public boolean IssueBook(){
        boolean isIssued = false;
        
        int bookId = Integer.parseInt(txt_bookId.getText());
        String studetId = lbl_studentId.getText();
        String bookName = lbl_bookName.getText();
        String studentName = lbl_studentName.getText();
        
        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();
        
        Long l1 = uIssueDate.getTime();
        long l2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sDueDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Insert into issue_book_details(book_id,book_name,student_id,"
                    + "student_name,issue_date,due_date,status) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2,bookName);
            pst.setString(3, studetId);
            pst.setString(4,studentName);
            pst.setDate(5, sIssueDate);
            pst.setDate(6, sDueDate);
            pst.setString(7,"Pending");
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isIssued = true;
            }else {
                isIssued = false;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isIssued;
    }
    
    // updating book count
    
    public void updateBookCount(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity - 1 where book_Id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1 , bookId);
            
            int rowCount = pst.executeUpdate();
            
            if (rowCount > 0) {
                JOptionPane.showMessageDialog(this,"book count updated");
                int initialCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(initialCount - 1));
                
            }else {
                JOptionPane.showMessageDialog(this,"can't update updated"); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
    }
    
    //checking whether book already alloacted or not
    
    public boolean isAlreadyIssued(){
        
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        String studetId = lbl_studentId.getText();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setString(2, studetId);
            pst.setString(3,"Pending" );
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()) {
                isAlreadyIssued = true;
            }else {
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAlreadyIssued;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        rSDateChooser3 = new rojeru_san.componentes.RSDateChooser();
        rSDateChooser4 = new rojeru_san.componentes.RSDateChooser();
        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_campus = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbl_studenterror = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lbl_bookerror1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_bookId = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_studentId = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));

        jLabel11.setBackground(new java.awt.Color(255, 51, 51));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(16, 16, 16))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("Book Details");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Quantity :");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 110, 20));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book ID :");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, 20));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Name :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 20));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author :");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, 20));
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 150, 30));
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 150, 30));
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 150, 30));
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 150, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Campus :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 110, 20));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student ID :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, 20));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, 20));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, 20));

        lbl_campus.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_campus.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_campus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 150, 30));

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 150, 30));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 150, 30));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 150, 30));

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, 2));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel7.setText("Student Details");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        lbl_studenterror.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lbl_studenterror.setForeground(new java.awt.Color(204, 204, 0));
        jPanel1.add(lbl_studenterror, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 240, 20));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 320, 770));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));

        jLabel21.setBackground(new java.awt.Color(255, 51, 51));
        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel21.setText("Back");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(16, 16, 16))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel22.setText("Book Details");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel24.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Book ID :");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, 20));

        jLabel25.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Book Name :");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 20));

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Author :");
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, 20));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 150, 30));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 150, 30));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 150, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 150, 30));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, 2));

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Quantity :");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 110, 20));

        lbl_bookerror1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        lbl_bookerror1.setForeground(new java.awt.Color(204, 204, 0));
        jPanel5.add(lbl_bookerror1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 240, 20));

        panel_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 770));

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(102, 102, 255));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        panel_main.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 80, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("Issue Details");
        panel_main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, 190, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 255));
        jLabel27.setText("Book ID :");
        panel_main.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 180, 90, 30));

        txt_bookId.setForeground(new java.awt.Color(102, 102, 255));
        txt_bookId.setText("Enter Book ID..");
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_bookId.setName(""); // NOI18N
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 310, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 255));
        jLabel28.setText("Due Date :");
        panel_main.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, 100, 30));

        txt_studentId.setForeground(new java.awt.Color(102, 102, 255));
        txt_studentId.setText("Enter Student ID..");
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_studentId.setName(""); // NOI18N
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 310, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 255));
        jLabel29.setText("Student ID :");
        panel_main.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 100, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 255));
        jLabel30.setText("Issue Date :");
        panel_main.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 100, 30));

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonRectangle2.setText("ISSUE BOOK");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonRectangle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 570, 280, 80));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_dueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_dueDate.setPlaceholder("Enter Due date");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 460, 300, -1));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_issueDate.setPlaceholder("Enter Issue date");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 360, 300, -1));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 770));

        setSize(new java.awt.Dimension(1113, 766));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals("")){
            getBookDetails();
        }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        
        if (lbl_quantity.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "book is not available");
        }else {
             if (isAlreadyIssued() == false) {
            
            if(IssueBook() == true){
            JOptionPane.showMessageDialog(this, "book issued successfully"); 
            updateBookCount();
        }else {
            JOptionPane.showMessageDialog(this, "can't issue the book");
        }
            
      }else {
           JOptionPane.showMessageDialog(this, "this student already has this book ");
        }
       }
        
                   
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel11MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_bookerror1;
    private javax.swing.JLabel lbl_campus;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JLabel lbl_studenterror;
    private javax.swing.JPanel panel_main;
    private rojeru_san.componentes.RSDateChooser rSDateChooser3;
    private rojeru_san.componentes.RSDateChooser rSDateChooser4;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private javax.swing.JTextField txt_bookId;
    private javax.swing.JTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
