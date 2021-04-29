package com.suek.nyamnyam;

import java.util.ArrayList;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface RetrofitService_Calendar {
    /*@Multipart
    @POST("CalendarDialog/insert.php")
    Call<String> postDataFromCalendar(@PartMap Map<String,String> dataPart,
                                    @Part MultipartBody.Part filePart);*/


    @GET("CalendarDialog/load.php")
    Call<ArrayList<CalendarItem>> loadDataFromCalendar(@Query("date") String date);     //@Query("date") =키값

}
