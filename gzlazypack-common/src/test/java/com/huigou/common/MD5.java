package com.huigou.common;

import gzlazypack.common.util.Md5FileUtil;
import gzlazypack.common.util.PwdUtil;

public class MD5 {
	
	public static void main(String[] args) {
		System.out.println(Md5FileUtil.MD5("111111"));
		System.out.println(PwdUtil.getPwd("111111"));
	}
}
