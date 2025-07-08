package tw.jasper.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class test76 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime datetime = LocalDateTime.now();
		
		System.out.println(date);
		System.out.println(time);
		System.out.println(datetime);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String s1 = datetime.format(formatter);
		System.out.println(s1);
		
		System.out.println("------------");
		String input = "1999-01-02 10:20:30";
		LocalDateTime dt = LocalDateTime.parse(input, formatter);
		System.out.println(dt);
		
		System.out.println("------------");
		LocalDate d1 = date.plusWeeks(4);
		System.out.println(d1);
		LocalDate d2 = date.minusMonths(6);
		System.out.println(d2);
		
		System.out.println("------------");
		LocalDate birthday = LocalDate.of(1995, 5, 8);
		Period pp = Period.between(birthday, date);
		System.out.printf("%d 年 %d 月 %d 天", pp.getYears(), pp.getMonths(), pp.getDays());
				
	}

}
