package co.approbe.chance.cron;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Request {
	  LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
      DateTimeFormatter nowDate = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	  String dateNow = dateTime.format(nowDate);
	  LocalDate actualdate = LocalDate.parse(dateNow, nowDate);
	  
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public DateTimeFormatter getNowDate() {
		return nowDate;
	}
	public String getDateNow() {
		return dateNow;
	}
	public LocalDate getActualdate() {
		return actualdate;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public void setNowDate(DateTimeFormatter nowDate) {
		this.nowDate = nowDate;
	}
	public void setDateNow(String dateNow) {
		this.dateNow = dateNow;
	}
	public void setActualdate(LocalDate actualdate) {
		this.actualdate = actualdate;
	}
	  
	  
}
