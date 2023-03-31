package com.abdullah.notesApp.repository;

import com.abdullah.notesApp.entity.Notes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Integer> {

}
