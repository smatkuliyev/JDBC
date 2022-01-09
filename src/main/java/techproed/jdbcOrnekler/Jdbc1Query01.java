package techproed.jdbcOrnekler;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1) ilgili drive'i yuklemeliyiz		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2) baglanti olusturmaliyiz
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
		
		// 3) SQL komutlari icin bir STATEMENT nesnesi olustur
		Statement st = con.createStatement();
		
		// 4) SQL ifadeleri yazabilir ve calistirabiliriz
		
		ResultSet veri = st.executeQuery(" select isim, maas from personel where id=123456789 ");
		
		// 5) sonuclari aldik ve isledik
		while (veri.next()) {
			System.out.println(veri.getString("isim") + " "+ veri.getInt("maas"));
			System.out.println("Personel Adi:" + veri.getString(1) + ", Maas:"+ veri.getInt(2));
		}
		
		// 6) olusturulan nesneleri bellekten kaldiralim
		con.close();
		st.close();
		veri.close();
		
		
	}
}






