package com.meridal.examples.recordcollection.domain.discogs;

import com.meridal.examples.recordcollection.domain.VersionSummary;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Master {

	private Pagination pagination;
	private List<VersionSummary> versions;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public List<VersionSummary> getVersions() {
		return versions;
	}

	public void setVersions(List<VersionSummary> versions) {
		this.versions = versions;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
