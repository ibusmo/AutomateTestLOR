package creditanalysis;
import base.KeywordsCOM;

public class Comment extends KeywordsCOM {
	
	public Comment() {
		super.workSheetPath = "comment";
		initKeywords();
	}
	
	@Override
	public void initKeywords() {
		super.logoperation 		= log.LogTag.logoperation.Comment;
		super.logtab 			= log.LogTag.logtab.CA;
		super.logsubtab 		= log.LogTag.logsubtab.info;

		super.sizeOfData = 8;
		super.offsetRow = 2;

		loadData();
	}
}
