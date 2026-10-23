package sample;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ItemDao {
	//DB接続情報	
	private static final String URL;
    private static final String USER;
    private static final String PASS;
    
    static {
        Properties p = new Properties();
        try (InputStream in = ItemDao.class.getClassLoader()
                                           .getResourceAsStream("db.properties")) {
            if (in == null) {
                throw new IllegalStateException("db.properties が見つかりません");
            }
            p.load(in);
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (IOException | ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
        URL  = p.getProperty("db.url");
        USER = p.getProperty("db.user");
        PASS = p.getProperty("db.password");
    }
    
	public void insert(String name, String price, String category) throws SQLException{
		String sql = "INSERT INTO item (item_id, item_name, item_price, item_category, created_by) VALUES (item_seq.NEXTVAL, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {
            //idの自動生成、更新日と更新者を追加必要
            ps.setString(1, name);
            ps.setString(2, price);
            ps.setString(3, category);
            ps.setString(4, "app_user"); // 作成者をシステムユーザー名に設定
            ps.executeUpdate();
            System.out.println("OK");
        }
    }
}
