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

public interface RetrofitService {
    @Multipart
    @POST("/Retrofit_Board_NyamNyam/insertDB.php")
    Call<String> postDataToBoard(@PartMap Map<String, String> dataPArt,
                                 @Part MultipartBody.Part filePart);

    @GET("Retrofit_Board_NyamNyam/loadDB.php")
    Call<ArrayList<BoardItem>> loadDataFromBoard();

    //@POST()

}

