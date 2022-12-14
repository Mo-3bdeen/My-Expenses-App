package com.msa.myexpenses.room_db.database

import android.content.Context
import androidx.room.Room

class DatabaseClient(context: Context) {
    val appDatabase: AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "MyExpenses_db")
            .allowMainThreadQueries().build()

    companion object {
        private var mInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(context: Context?): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(context!!)
            }
            return mInstance!!
        }
    }
}