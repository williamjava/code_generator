package com.code.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class CodeGenForm implements Serializable{
	private static final long serialVersionUID = -3798739130198112568L;

	private String tables;
	
	private String path;
	
	private String mainPath;
	
	private String packageName;
	
	private String moduleName;
}
