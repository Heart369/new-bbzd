package com.example.main.mvvm.network;


import com.example.main.mvvm.json.Detail_Wq;
import com.example.main.mvvm.json.Detail_mz;
import com.example.main.mvvm.json.Detail_role;
import com.example.main.raw.JsonPares.Json_Jstf;


import io.reactivex.rxjava3.core.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface HttpbinServer {
    @GET("characters")
    Call<Detail_role> getjs_base(@Query("query") String name, @Query("costs") String costs, @Query("stats") String stats);

    @GET("weapons")
    Call<Detail_Wq> getwq_base(@Query("query") String name, @Query("costs") String costs, @Query("stats") String stats);

    @GET("talents")
    Call<Json_Jstf> gettf_base(@Query("query") String name);

    @GET("constellations")
    Call<Detail_mz> getmz_base(@Query("query") String name, @Query("c") String costs);
    @POST("post")
    @FormUrlEncoded
    Call<ResponseBody> get_base(@Field("query") String name);
}
