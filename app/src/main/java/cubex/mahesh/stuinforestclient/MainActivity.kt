package cubex.mahesh.stuinforestclient

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.stuinforestclient.beans.InsertBean
import cubex.mahesh.stuinforestclient.beans.ReadBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var r  = Retrofit.Builder().
                baseUrl("http://10.0.0.3:8080/StudentInfo/rs/sinfo/").
                addConverterFactory(GsonConverterFactory.create()).
                build()
        var api = r.create(StuInfoAPI::class.java)
        b1.setOnClickListener({
       var call =  api.insert(et1.text.toString(),sp1.selectedItem.toString(),
                        et2.text.toString(),et3.text.toString())
            call.enqueue(object : Callback<InsertBean> {
                override fun onResponse(call: Call<InsertBean>?, response: Response<InsertBean>?) {
        var resp = response!!.body()
                    Toast.makeText(this@MainActivity,resp!!.status,
                            Toast.LENGTH_LONG).show()
                }
                override fun onFailure(call: Call<InsertBean>?, t: Throwable?) {
                    Toast.makeText(this@MainActivity,"Fail",
                            Toast.LENGTH_LONG).show()
                    Log.e("msg",t!!.message)

                }
            })
        })
        b2.setOnClickListener({

        var call =     api.read()
         call.enqueue(object : Callback<ReadBean> {
             override fun onFailure(call: Call<ReadBean>?, t: Throwable?) {
                 Toast.makeText(this@MainActivity,"Fail",
                         Toast.LENGTH_LONG).show()
                 Log.e("msg",t!!.message)
             }

             override fun onResponse(call: Call<ReadBean>?, response: Response<ReadBean>?) {
              var resp =      response!!.body()
             var list   = resp!!.students
             var temp_list = mutableListOf<String>()
                 for( item in list!!){
                     temp_list.add(item.name+"|"+item.gender+"|"
                             +item.email+"|"+item.mobileno)
                 }
                 var myadapter = ArrayAdapter<String>(this@MainActivity,
                         android.R.layout.simple_list_item_single_choice,temp_list)
                 lview.adapter = myadapter
            }

         })

        })

    }
}
