package com.sinotech.modulerxjava

/**
 * @author : Jason_Sunyf
 * @date   : 2018年02月28日15时14分
 * E-mail  : jason_sunyf@163.com
 */


data class GankItem(
		val _id: String,
		val createdAt: String,
		val desc: String,
		val publishedAt: String,
		val source: String,
		val type: String,
		val url: String,
		val used: Boolean,
		val who: String
)
