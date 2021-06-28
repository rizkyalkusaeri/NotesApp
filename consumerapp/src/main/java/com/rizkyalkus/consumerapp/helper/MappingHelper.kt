package com.rizkyalkus.consumerapp.helper

import android.database.Cursor
import com.rizkyalkus.consumerapp.database.DatabaseContract
import com.rizkyalkus.consumerapp.entity.Note

object MappingHelper {
    fun mapCursorToArrayList(notesCursor: Cursor?):ArrayList<Note>{
        val noteList = ArrayList<Note>()
        val note = Note()
        notesCursor?.apply {
            while (moveToNext()){
                note.id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                note.title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                note.description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                note.date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                noteList.add(note)
            }
        }
        return noteList
    }

    fun mapCursorToObject(notesCursor: Cursor?):Note{
        var note = Note()

        notesCursor?.apply {
            moveToFirst()
            val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
            val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
            val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
            val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
            note = Note(id,title,description,date)
        }

        return note
    }
}