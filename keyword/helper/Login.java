package helper;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import log.LogTag.logaction;
import log.LogTag.logelement;
import log.LogTag.logexestatus;
import log.LogTag.logoperation;
import log.LogTag.logsubtab;
import log.LogTag.logtab;

public class Login implements base.KeywordsCSM {

	private String username;
	private String password;

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
		initKeywords();
	}

	public Login() {
		initKeywords();
	}

	@Override
	public void initKeywords() {
	}

	@Override
	public boolean execute() {
		sendToLogStart();
		try {
			// Fill Login Field and Submit
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_username")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("j_password")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wp-submit")));
			driver.findElement(By.id("j_username")).clear();
			driver.findElement(By.id("j_username")).sendKeys(username);
			driver.findElement(By.id("j_password")).clear();
			driver.findElement(By.id("j_password")).sendKeys(password);
			driver.findElement(By.id("wp-submit")).click();
			sendToLogCustom(logexestatus.PASS, logaction.Fill_login, username + " : " + password);
		} catch (TimeoutException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Fill_login, username + " : " + password);
			return false;
		}
		try {
			// Kick
			driver.findElement(By.id("j_password")).clear();
			driver.findElement(By.id("j_password")).sendKeys(password);
			driver.findElement(By.id("wp-submit")).click();
			sendToLogCustom(logexestatus.PASS, logaction.Fill_again, username + " : " + password);
		} catch (NoSuchElementException e) {
			sendToLogCustom(logexestatus.FAIL, logaction.Fill_again, username + " : " + password);
			//return false;
		}
		sendToLogFinish();
		return true;
	}

	@Override
	public void sendToLogStart() {
		sendToLogCustom(logexestatus.START, logaction.None);
	}

	@Override
	public void sendToLogFinish() {
		sendToLogCustom(logexestatus.FINISH, logaction.None);
	}

	public void sendToLogCustom(logexestatus logexestatus, logaction logaction) {
		logCat.sendToLog(logexestatus, logoperation.Login, logtab.None, logsubtab.None, logelement.None, logaction,
				null);
	}

	private void sendToLogCustom(logexestatus logexestatus, logaction logaction, String str) {
		logCat.sendToLog(logexestatus, logoperation.Login, logtab.None, logsubtab.None, logelement.None, logaction,
				str);
	}
}
