package com.meridal.itunes.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.meridal.itunes.domain.Recording;
import com.meridal.itunes.domain.Song;

public class RecordingsRepository {
	
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public RecordingsRepository() {
		this.factory = Persistence.createEntityManagerFactory("recordings");
		this.manager = this.factory.createEntityManager();
	}
	
	public void deleteRecording(Recording recording) {
		this.delete(recording);
	}
	
	public void deleteSong(Song song) {
		this.delete(song);
	}
	
	public Recording findRecording(Integer id) {
		return this.find(Recording.class, id);
	}
	
	public Song findSong(Integer id) {
		return this.find(Song.class, id);
	}
	
	public List<Song> findSongsForRecording(Integer recordingId) {
		this.manager.getTransaction().begin();
		String select = "SELECT s FROM Song s WHERE s.recordingId = :recordingId";
		TypedQuery<Song> query = this.manager.createQuery(select, Song.class);
		query.setParameter("recordingId", recordingId);
		List<Song> songs = (List<Song>) query.getResultList();
		this.manager.getTransaction().commit();
		return songs;
	}
	
	public void saveRecording(Recording recording) {
		this.save(recording);
	}
		
	public void saveSong(Song song) {
		this.save(song);
	}
	
	private void delete(Object o) {
		this.manager.getTransaction().begin();
		this.manager.remove(o);
		this.manager.getTransaction().commit();
	}
	
	private <T> T find(Class<T> t, Object id) {
		this.manager.getTransaction().begin();
		T value = this.manager.find(t, id);
		this.manager.getTransaction().commit();
		return value;
	}
	
	private void save(Object o) {
		this.manager.getTransaction().begin();
		this.manager.persist(o);
		this.manager.getTransaction().commit();
	}
	
	public void close() {
		this.manager.close();
		this.factory.close();
	}
}
