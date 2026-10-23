package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbTest {
	public static void main(String[] args) throws Exception {
        String url = "jdbc:oracle:thin:@//localhost:1521/orcl"; // サービス名を指定
        try (Connection con = DriverManager.getConnection(url, "app_user", "qwertyuiop");
             PreparedStatement ps = con.prepareStatement(
            		 //idの自動生成、更新日と更新者を追加必要
                 "INSERT INTO item (item_id, item_name, item_price, created_by) VALUES (item_seq.NEXTVAL, ?, ?, ?)")) {
        	
            ps.setString(1, "ほうじ茶2");
            ps.setString(2, "150");
            ps.setString(3, "system");
            ps.executeUpdate();
            System.out.println("OK");
        }
    }
}
