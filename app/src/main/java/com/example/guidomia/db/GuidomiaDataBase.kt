package com.example.guidomia.db

import android.content.res.Resources
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.guidomia.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

abstract class GuidomiaDataBase: RoomDatabase() {

    class SaveCarModelsCallback @Inject constructor(
        private val database: Provider<GuidomiaDataBase>,
        private val resources: Resources
    ): RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                prePopulateTable()
            }
        }

        private fun prePopulateTable() {
            val jsonString = resources.openRawResource(R.raw.car_list).bufferedReader().use {
                it.readText()
            }
        }
    }
}