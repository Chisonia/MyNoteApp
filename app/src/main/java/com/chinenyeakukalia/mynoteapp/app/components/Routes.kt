package com.chinenyeakukalia.mynoteapp.app.components

object Routes {
    val SignUpRoute = "sign-up"
    val LoginRoute = "login"
    val NoteListRoute = "note-list"
    val AddNoteRoute = "add-note"
    val ResetPasswordRoute = "reset-password"
    val ProfileRoute = "profile"
    fun noteDetails(noteId: String): String{
        return "note-details/$noteId"
    }
}