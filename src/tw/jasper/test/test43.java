package tw.jasper.test;

import java.security.GeneralSecurityException;

public class test43 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		// 只要不是RuntimeException皆要處理
		try {
			b1.setLeg(1);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

}

class Bird {
	int leg;
	
	void setLeg(int leg) throws GeneralSecurityException {
		if (leg>=0 && leg<2) {
			this.leg = leg;
		}
		else {
			throw new GeneralSecurityException();
		}
	}
}