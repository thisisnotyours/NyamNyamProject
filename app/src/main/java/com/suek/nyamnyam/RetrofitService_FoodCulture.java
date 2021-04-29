package com.suek.nyamnyam;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;

public interface RetrofitService_FoodCulture {

    @POST("/FoodCulture/load.php")
    Call<ArrayList<FoodCultureItem>> loadDataFromFoodCulture();
}
