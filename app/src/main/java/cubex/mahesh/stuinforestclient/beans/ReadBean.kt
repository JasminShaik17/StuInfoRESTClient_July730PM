package cubex.mahesh.stuinforestclient.beans

import com.google.gson.annotations.SerializedName

data class ReadBean(@SerializedName("students")
                    val students: List<StudentsItem>?)