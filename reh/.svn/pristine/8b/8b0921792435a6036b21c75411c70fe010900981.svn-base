package com.ree.exportexcel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.List;

import com.ree.hibernate.RepEntTrainUser;

import jxl.CellView;
import jxl.Workbook;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelServiceImpl implements IExcelService {
	jxl.write.Label label;

	public InputStream getExcelInputStream(
			List<LinkedHashMap<String, Object>> list,String info) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		putDataOnOutputStream(out, list,info);
		return new ByteArrayInputStream(out.toByteArray());
	}

	@SuppressWarnings("null")
	private void putDataOnOutputStream(OutputStream os,
			List<LinkedHashMap<String, Object>> list,String info) {
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(os);
			int rowNum = 0;
			int i = 0;
			WritableSheet sheet = workbook.createSheet("Sheet1", 0);
			if (list.size() > 0) {
				Iterator<String> iter = (Iterator<String>) list.get(0).keySet()
						.iterator();
				int[] widths = new int[list.get(0).keySet().size()];
				while (iter.hasNext()) {
					String title = iter.next();
					if(widths[i]<=title.length())
						widths[i] = title.length();
					sheet.addCell(new jxl.write.Label(i++, rowNum, title));
				}
				for (LinkedHashMap<String, Object> data : list) {
					rowNum++;
					iter = data.keySet().iterator();
					i = 0;
					while (iter.hasNext()) {
						String key = iter.next();
						if(data.get(key)!=null&&widths[i]<=(data.get(key).toString()).length())
							widths[i] = ((String)data.get(key)).length();
						sheet.addCell(new jxl.write.Label(i++, rowNum,
								data.get(key)==null?"":data.get(key).toString()));
					}
				}
				for(i =0;i<widths.length;i++)
				{
					sheet.setColumnView(i, widths[i] + 5);
				}
				if(info!=null&&!info.equals("")){
					WritableCellFormat head = new WritableCellFormat(); 
					head.setBackground(jxl.format.Colour.YELLOW2);
					sheet.mergeCells(0, rowNum+2, i-1, rowNum+2);
					sheet.addCell(new jxl.write.Label(0,rowNum+2,info,head));
				}
			}
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public InputStream getExcelInputStream() {
		// TODO Auto-generated method stub
		return null;
	}

}
