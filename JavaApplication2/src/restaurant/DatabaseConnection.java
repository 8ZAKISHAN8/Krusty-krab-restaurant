package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // This is the address of the database
    private static final String URL = "jdbc:mysql://localhost:3306/krusty_krab";
    private static final String USER = "root"; 
    private static final String PASS = "Big7*Master"; 
       
    public static Connection getConnection() {
        try {
            // This line opens the "bridge"
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error: Could not connect to the Krusty Krab database.");
            e.printStackTrace();
            return null;
        }
    }
    public static int generateNewCustomerID() {
    String sql = "INSERT INTO customers () VALUES ()"; // Inserts a blank row
    try (Connection conn = getConnection();
         java.sql.PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
        
        pstmt.executeUpdate();
        java.sql.ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1); // Returns the generated ID (e.g., 1, 2, 3...)
        }
    } catch (Exception e) { e.printStackTrace(); }
    return -1;
}
public static int saveOrderSummary(int customerId, double total, String serviceType) {
    // Note: The SQL string remains similar, but the database now calls the first column 'order_id'
    String sql = "INSERT INTO orders (customer_id, order_date, total, service_type) VALUES (?, NOW(), ?, ?)";
    
    try (java.sql.Connection conn = getConnection();
         java.sql.PreparedStatement pstmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {
        
        pstmt.setInt(1, customerId);
        pstmt.setDouble(2, total);
        pstmt.setString(3, serviceType);
        
        pstmt.executeUpdate();
        
        java.sql.ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            // This still gets the value from the first column, which is now 'order_id'
            return rs.getInt(1); 
        }
    } catch (Exception e) { 
        e.printStackTrace(); 
    }
    return -1;
}
public static void saveOrderItems(int orderId, java.util.List<OrderItem> items) {
    // 5 question marks for: order_id, item_name, quantity, subtotal, is_combo
    String sql = "INSERT INTO order_items (order_id, item_name, quantity, subtotal, is_combo) VALUES (?, ?, ?, ?, ?)";
    
    try (java.sql.Connection conn = getConnection();
         java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
       for (OrderItem oi : items) {
    pstmt.setInt(1, orderId);
    pstmt.setString(2, oi.getItem().getDescription());
    pstmt.setInt(3, oi.getQuantity());
    pstmt.setDouble(4, oi.getSubtotal());
    
    
    boolean isMealDeal = (oi.getItem() instanceof Combo || 
                         (oi.getItem() instanceof Burger && ((Burger)oi.getItem()).isCombo()));
    pstmt.setBoolean(5, isMealDeal); 

    pstmt.executeUpdate();
}
        System.out.println("Order items (including combos) saved successfully!");
        
    } catch (Exception e) {
        System.out.println("CRASH: Check if 'is_combo' column exists in MySQL!");
        e.printStackTrace(); 
    }
}


public static void saveLoyaltyPoints(int customerId, int points) { // Change double to int
    String sql = "UPDATE customers SET loyalty_points = ? WHERE id = ?";
    try (Connection conn = getConnection();
         java.sql.PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, points); // Use setInt
        pstmt.setInt(2, customerId);
        pstmt.executeUpdate();
        
    } catch (Exception e) { 
        System.out.println("Error saving points: " + e.getMessage());
        e.printStackTrace(); 
    }
}
}