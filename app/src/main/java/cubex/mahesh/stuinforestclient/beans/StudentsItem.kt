package cubex.mahesh.stuinforestclient.beans

import com.google.gson.annotations.SerializedName

data class StudentsItem(@SerializedName("gender")
                        val gender: String = "",
                        @SerializedName("name")
                        val name: String = "",
                        @SerializedName("mobileno")
                        val mobileno: String = "",
                        @SerializedName("email")
                        val email: String = "")