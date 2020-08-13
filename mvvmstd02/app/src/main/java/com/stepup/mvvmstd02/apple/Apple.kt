package com.stepup.mvvmstd02.apple

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 클래스 설명
 *
 * @author 최초작성자:
 * @date 최초작성일: 2020-08-13 오후 1:34
 *
 */

@Entity(tableName = "apple")
data class Apple(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "number")
    var number: String,

    @ColumnInfo(name = "initial")
    var initial: Char
) {
    constructor() : this(null, "", "", '\u0000')
}
