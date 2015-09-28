package testdata;

import java.util.ArrayList;
import java.util.List;

import testdata.CellTag.col;

public class LoadElement implements TestDatas {

	String workSheetPath;
	int sizeOfData;
	int offsetRow;
	List<elementObj> elmObj;
	List<ConfigElementObj> configElementObj;
	ReadExcel rdExl;
	
	public LoadElement(String workSheetPath, int sizeOfData, int offsetRow){
		this.workSheetPath = workSheetPath;
		this.offsetRow = offsetRow;
		this.sizeOfData = sizeOfData;
	}

	private int row(int r){
		return r + offsetRow;
	}
	
	@Override
	public boolean loadData() {
		rdExl = new ReadExcel(workBookPath, workSheetPath);
		elmObj = new ArrayList<elementObj>();
		for(int idx=1; idx<=sizeOfData; idx++){
			System.out.print(idx + " ");
			
			elementObj objTmp = new elementObj();
			System.out.print("B ");
			objTmp.nameTag 		= rdExl.getString(col.B, row(idx));
			System.out.print("C ");
			objTmp.dataTag 		= rdExl.getString(col.C, row(idx));
			System.out.print("D ");
			objTmp.inputType 	= rdExl.getIOType(col.D, row(idx));
			System.out.print("E ");
			objTmp.value 		= rdExl.getString(col.E, row(idx));
			System.out.print("F ");
			objTmp.fieldName 	= rdExl.getString(col.F, row(idx));
			System.out.print("G ");
			objTmp.filedType 	= rdExl.getFlType(col.G, row(idx));
			System.out.print("H ");
			objTmp.fieldOpnal 	= rdExl.getString(col.H, row(idx));
			System.out.print("I ");
			objTmp.jsExe 		= rdExl.getString(col.I, row(idx));
			
			System.out.print("J ");
			objTmp.run 			= rdExl.getRun(col.J, row(idx));
			elmObj.add(objTmp);
			System.out.print(objTmp.nameTag + "\t");
			System.out.println(objTmp.value);
		}		
		rdExl.closeFile();

//			System.out.println("-------------------------------------");
//		for(elementObj objTmp : elmObj){
//			System.out.println(objTmp.toString());
//			System.out.println(objTmp.nameTag);
//			System.out.println(objTmp.dataTag);
//			System.out.println(objTmp.inputType);
//			System.out.println(objTmp.value);
//			System.out.println(objTmp.fieldName);
//			System.out.println(objTmp.filedType);
//			System.out.println(objTmp.fieldOpnal);
//			System.out.println(objTmp.jsExe);
//			System.out.println(objTmp.run);
//			System.out.println("-------------------------------------");
//		}	
		return true;
	}

	public List<elementObj> getObject() {
		return elmObj;
	}

	public boolean loadConfigData() {
		rdExl = new ReadExcel(workBookPath, workSheetPath);
		configElementObj = new ArrayList<ConfigElementObj>();
		for(int idx=1; idx<=sizeOfData; idx++){
			System.out.print(idx + " ");
			
			ConfigElementObj objTmp = new ConfigElementObj();			
																		System.out.print("B ");
			objTmp.process 	= rdExl.getString(col.B, row(idx));
																		System.out.print("C ");
			objTmp.sheet 	= rdExl.getSheetType(col.C, row(idx));
																		System.out.print("D ");
			try{
				objTmp.index 	= (int)Double.parseDouble(rdExl.getString(col.D, row(idx)));
			}catch(NumberFormatException e){
				objTmp.index = 0;
			}														
																		System.out.print("E ");
			objTmp.remark 	= rdExl.getString(col.E, row(idx));

			configElementObj.add(objTmp);

			System.out.print("\t");
			System.out.print(objTmp.process + "\t");
			System.out.print(objTmp.sheet + "\t");
			System.out.print(objTmp.index + "\t");
			System.out.print(objTmp.remark + "\t");
			System.out.println();
		}		
		rdExl.closeFile();
		return true;
	}

	public List<ConfigElementObj> getConfigObject() {
		return configElementObj;
	}
}