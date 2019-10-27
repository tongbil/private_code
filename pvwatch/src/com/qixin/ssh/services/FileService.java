package com.qixin.ssh.services;

import com.qixin.ssh.model.Files;

public interface FileService {
	
	public Files saveFiles(Files files);
	public Files downFiles(String  id);
}
