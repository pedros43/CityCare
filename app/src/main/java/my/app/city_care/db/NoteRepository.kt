package my.app.city_care.db

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import my.app.city_care.dao.NoteDao
import my.app.city_care.entities.Note


class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: LiveData<List<Note>> = noteDao.getAlphabetizedNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    fun getNoteById(id: Int): LiveData<List<Note>> {
        return noteDao.getNoteById(id)
    }
}