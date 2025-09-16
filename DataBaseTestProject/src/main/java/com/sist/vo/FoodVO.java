package com.sist.vo;

import lombok.Data;

/*
 * 이름      널? 유형             
------- -- -------------- 
FNO        NUMBER(38)     
NAME       VARCHAR2(200)  
TYPE       VARCHAR2(4000) 
PHONE      VARCHAR2(26)   
ADDRESS    VARCHAR2(4000) 
SCORE      NUMBER(38,1)   
THEME      VARCHAR2(4000) 
PRICE      VARCHAR2(50)   
TIME       VARCHAR2(4000) 
PARKING    VARCHAR2(4000) 
POSTER     VARCHAR2(4000) 
IMAGES     VARCHAR2(4000) 
CONTENT    VARCHAR2(4000) 
HIT        NUMBER(38)     
 * 
 */
@Data
public class FoodVO {
	private int fno,hit;
	private double score;
	private String name,type,phone,address,theme,price,time,parking,poster,images,content;

}
