package cubex.mahesh.stuinforestclient

import cubex.mahesh.stuinforestclient.beans.InsertBean
import cubex.mahesh.stuinforestclient.beans.ReadBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StuInfoAPI {
    @GET("insert/{name}/{gender}/{email}/{mno}")
    fun insert(@Path("name") name:String,
               @Path("gender") gender:String,
               @Path("email") email:String,
               @Path("mno") mno:String):Call<InsertBean>

    @GET("read")
    fun read():Call<ReadBean>

}