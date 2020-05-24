package com.stepup.kotlinstd2

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class TestClass() : Parcelable {

    var data10:Int = 0
    var data20:String? = null

    companion object{
        @JvmField
        val CREATOR = object : Creator<TestClass>{
            override fun createFromParcel(source: Parcel?): TestClass {
                val test = TestClass()
                test.data10 = source?.readInt()!!
                test.data20 = source?.readString()
                return test
            }

            override fun newArray(size: Int): Array<TestClass?> {
                return arrayOfNulls<TestClass>(size)
            }
        }
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeInt(data10)
        dest?.writeString(data20)
    }

    override fun describeContents(): Int {
        return 0
    }
}
