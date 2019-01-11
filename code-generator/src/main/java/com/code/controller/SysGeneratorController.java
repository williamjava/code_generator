package com.code.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.code.form.CodeGenForm;
import com.code.service.SysGeneratorService;
import com.code.utils.PageUtils;
import com.code.utils.Query;
import com.code.utils.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 代码生成器
 * 
 * @author william
 * @email wuhoujian@126.com
 * @date 2019/1/11
 */
@Controller
@RequestMapping("/sys/generator")
public class SysGeneratorController {
	@Autowired
	private SysGeneratorService sysGeneratorService;
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public Result list(@RequestParam Map<String, Object> params){
		PageUtils pageUtil = sysGeneratorService.queryList(new Query(params));
		
		return Result.ok().put("page", pageUtil);
	}
	
	/**
	 * 生成代码
	 */
	@RequestMapping("/code")
	public void code(CodeGenForm form, HttpServletResponse response) throws IOException{
		byte[] data = sysGeneratorService.generatorCode(form);
		
		response.reset();  
        response.setHeader("Content-Disposition", "attachment; filename=\"code.zip\"");  
        response.addHeader("Content-Length", "" + data.length);  
        response.setContentType("application/octet-stream; charset=UTF-8");  
  
        IOUtils.write(data, response.getOutputStream());  
	}
}
