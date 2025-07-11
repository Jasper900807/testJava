package tw.jasper.apis;

import java.util.List;

public interface MemberDAO {
	public void addMember(Member member);
	public void updateMember(Member member);
	public void delMember(int id);
	public Member findById(int id);
	public List<Member> findAll();
}
