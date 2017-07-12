package com.rev.dao;

import java.util.List;

import com.rev.bean.TrackSection;

public interface TrackSectionDao {
	public TrackSection getSectionById(int sectionId);
	public int createTrackSection(TrackSection section);
	public void updateTrackSection(TrackSection section);
	public void deleteTrackSection(TrackSection section);
}
