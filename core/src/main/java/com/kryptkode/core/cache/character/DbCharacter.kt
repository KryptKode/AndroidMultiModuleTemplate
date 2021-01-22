package com.kryptkode.core.cache.character

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kryptkode.core.cache.character.DbCharacter.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DbCharacter(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = COLUMN_URL)
    val url: String,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_BIRTH_YEAR) val birthYear: String,
    @ColumnInfo(name = COLUMN_HEIGHT) val height: String,
    @ColumnInfo(name = COLUMN_HOME_WORLD) val homeWorld: String,
    @ColumnInfo(name = COLUMN_FILMS) val films: List<String>,
    @ColumnInfo(name = COLUMN_SPECIES) val species: List<String>,

) {
    companion object {
        const val TABLE_NAME = "characters"
        const val COLUMN_NAME = "name"
        const val COLUMN_BIRTH_YEAR = "birth_year"
        const val COLUMN_HEIGHT = "height"
        const val COLUMN_FILMS = "films"
        const val COLUMN_HOME_WORLD = "home_world"
        const val COLUMN_SPECIES = "species"
        const val COLUMN_URL = "url"
    }
}
