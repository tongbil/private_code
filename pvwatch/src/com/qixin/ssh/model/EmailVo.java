package com.qixin.ssh.model;

import java.util.List;

public class EmailVo {
  private	Semail semail;
  private List<SemailFile> listFile;
  
public Semail getSemail() {
	return semail;
}
public void setSemail(Semail semail) {
	this.semail = semail;
}
public List<SemailFile> getListFile() {
	return listFile;
}
public void setListFile(List<SemailFile> listFile) {
	this.listFile = listFile;
}



}
