package testdata;

import mytestpack.EnvironmentVariable;

public interface TestDatas {
	String workBookPath = EnvironmentVariable.excelPath;
	public boolean loadData();
}
