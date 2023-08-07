package com.meridal.examples.recordcollection.domain;

public class SearchResult extends Entry {

	private String title;

	public SearchResult() {
		super();
	}

	public SearchResult(final Integer id, final String title) {
		super(id);
		this.setTitle(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append(this.getId())
			.append(" ").append(this.title)
			.toString();
	}
}
