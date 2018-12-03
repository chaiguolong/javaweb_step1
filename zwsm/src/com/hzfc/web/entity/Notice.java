package com.hzfc.web.entity;

public class Notice {
	private String name;
	private String nameStr;
	private String date;
	private String slbh;

	@Override
	public String toString() {
		// date":"2013-05-07","name":"童健","nameStr":"童健","slbh":"16102110-130502-10000740"
		// ****-****-0311-896582 林晋夏 2011-11-22
		if(slbh != null) {
			String[] slbhs = slbh.split("-");
			String slbh1 = "";
			for (int i = 0; i < slbhs[0].length(); i++) {
				slbh1 += "*";
			}
			String slbh_new = slbh1;
			for (int i = 1; i < slbhs.length; i++) {
				slbh_new += "-" + slbhs[i];
			}
			String str = "<td align=\"left\">" + slbh_new
					+ "</td><td align=\"left\">" + nameStr
					+ "</td><td align=\"right\">" + date + "</td>";
			return str;
		}
		return name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameStr() {
		return nameStr;
	}

	public void setNameStr(String nameStr) {
		this.nameStr = nameStr;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSlbh() {
		return slbh;
	}

	public void setSlbh(String slbh) {
		this.slbh = slbh;
	}

}