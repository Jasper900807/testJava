package tw.jasper.apis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
	private final Connection conn;
	
	public MemberDAOImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void addMember(Member member) {
		String sql = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
			pstmt.setString(3, member.getName());
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateMember(Member member) {
		String sql = "UPDATE member SET account = ?, name = ? WHERE id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getAccount());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, member.getId());
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delMember(int id) {
		String sql = "DELETE FROM member WHERE id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Member findById(int id) {
		String sql = "SELECT id, account, passwd, name FROM member WHERE id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Member member = new Member(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("account"),
						rs.getString("passwd")
						);
				return member;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Member> findAll() {
		List<Member> members = new ArrayList<Member>();
		String sql = "SELECT id, account, passwd, name FROM member";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Member member = new Member(
						rs.getInt("id"),
						rs.getString("account"),
						rs.getString("passwd"),
						rs.getString("name")
						);
				members.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}
}
