package com.kryptkode.core.cache.character

import androidx.room.Dao
import androidx.room.Query
import com.kryptkode.core.cache.base.BaseDao
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CharacterDao : BaseDao<DbCharacter> {
    @Query("SELECT * FROM characters WHERE url=:url")
    abstract fun getCharacter(url: String): Flow<DbCharacter>
}
