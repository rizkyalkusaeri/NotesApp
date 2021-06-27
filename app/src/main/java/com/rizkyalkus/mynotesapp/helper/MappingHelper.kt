package com.rizkyalkus.mynotesapp.helper

import android.database.Cursor
import com.rizkyalkus.mynotesapp.database.DatabaseContract
import com.rizkyalkus.mynotesapp.entity.Note

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
}