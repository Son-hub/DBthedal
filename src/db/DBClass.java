package db;

import java.sql.*;

public class DBClass {
	public static Connection condb() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/dbdb";
		Connection conn = DriverManager.getConnection(DBconfig.DB_URL, DBconfig.DB_USER, DBconfig.DB_PW);
		System.out.println("연결 성공");
		return conn;
	}
	public static void connTest() {
		Connection conn = null;

		try {
			conn = DBClass.condb();
		}
			catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 데이터 넣기
	public static void insert(String name, int score) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBClass.condb();
			
			String sql = "INSERT INTO num_tb (name, score) VALUES (?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			// 4. 데이터 binding
			pstmt.setString(1, name);
			pstmt.setInt(2, score);

			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 데이터보기
	public static void select() {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
        	conn = DBClass.condb();

			stmt = conn.createStatement();
			String sql = "SELECT * FROM num_tb";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				int num = rs.getInt(1);
                String name = rs.getString(2);
                int score = rs.getInt(3);

                System.out.println(num + " " + name + " " + score);
			}
        }
			catch(Exception e){
                System.out.println("에러 " + e);
            }finally{
			try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	                if( stmt != null && !stmt.isClosed()){
	                    stmt.close();
	                }
	                if( rs != null && !rs.isClosed()){
	                    rs.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }

            }
	}
}
