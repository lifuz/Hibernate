package com.lifuz.model;

import java.sql.Date;

/**
 * 新闻表的model类
 *
 * @作者： 李富
 * 
 * @邮箱：lifuzz@163.com @时间：2016年3月7日
 */
public class News {

	private Integer id;
	private String title;
	private String author;

	private Date mDate;

	public News() {
		super();
	}

	public News(String title, String author, Date mDate) {
		super();
		this.title = title;
		this.author = author;
		this.mDate = mDate;
	}

	public News(Integer id, String title, String author, Date mDate) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.mDate = mDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getmDate() {
		return mDate;
	}

	public void setmDate(Date mDate) {
		this.mDate = mDate;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", author=" + author + ", mDate=" + mDate + "]";
	}

}
